package com.sh.wm.ministry.featuers.userfile.career.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentCareersBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.career.adapter.UserCareersAdapter;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareer;
import com.sh.wm.ministry.featuers.userfile.career.viewmodel.CareersViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class CareersFragment extends Fragment implements UserCareersAdapter.OnEditClickListener {

    private FragmentCareersBinding binding;
    private OnFragmentInteractionListener mListener;

    public static CareersFragment newInstance() {
        return new CareersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCareersBinding.inflate(inflater, container, false);
        binding.tvNoCareer.setVisibility(View.INVISIBLE);
        binding.rvCareer.setVisibility(View.INVISIBLE);

        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setup viewModel
        CareersViewModel mViewModel = new ViewModelProvider(this).get(CareersViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available or not

            ///get user career from API
            mViewModel.getUserCareers(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), userCareerModel -> {//SharedPreferneceHelper.getUserId(getContext())
                if (userCareerModel != null) {
                    if (userCareerModel.getUserCareer() != null) {
                        binding.progress.setVisibility(View.GONE);
                        //enable user interaction when progress is visible
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        List<UserCareer> userCareers = userCareerModel.getUserCareer();
                        //set data to adapter
                        UserCareersAdapter adapter = new UserCareersAdapter(getContext(), userCareers, this);
                        binding.rvCareer.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        binding.rvCareer.setAdapter(adapter);
                        binding.rvCareer.setVisibility(View.VISIBLE);
                        binding.tvNoCareer.setVisibility(View.GONE);

                    } else {
                        binding.rvCareer.setVisibility(View.GONE);
                        binding.tvNoCareer.setVisibility(View.VISIBLE);

                        binding.progress.setVisibility(View.GONE);
                        //enable user interaction when progress is visible
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                }
            });

        } else {
            binding.progress.setVisibility(View.GONE);
            binding.LLLayoutUserCareers.setVisibility(View.VISIBLE);

            binding.tvNoCareer.setText(getString(R.string.no_internet_to_show));
        }


    }


    @Override
    public void onEditClick(UserCareer userCareer) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("userCareer", userCareer);
        mListener.onFragmentInteraction(13, bundle);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

}

