package com.sh.wm.ministry.featuers.userfile.workexperience.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentWorkExperienceBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.workexperience.adapter.UserWorkExperienceAdapter;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperience;
import com.sh.wm.ministry.featuers.userfile.workexperience.viewmodel.WorkExperienceViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class UserWorkExperiencesFragment extends Fragment implements UserWorkExperienceAdapter.OnEditClickListener {

    private FragmentWorkExperienceBinding binding;
    private WorkExperienceViewModel mViewModel;
    private OnFragmentInteractionListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //inflate the view
        binding = FragmentWorkExperienceBinding.inflate(inflater, container, false);

        binding.LLLayoutWorkExperience.setVisibility(View.INVISIBLE);
        binding.fabAddExperienceWorkExperience.setVisibility(View.INVISIBLE);


        binding.fabAddExperienceWorkExperience.setOnClickListener(view -> {
            mListener.onFragmentInteraction(71);
        });
        binding.btnAddExperienceWorkExperience.setOnClickListener(view -> {
            mListener.onFragmentInteraction(71);
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(WorkExperienceViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get user work experience data from API
            mViewModel.getUserWorkExperiences(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), userWorkExperienceModel -> {
                if (userWorkExperienceModel != null) {
                    if (userWorkExperienceModel.getUserWorkExperience() != null) {
                        binding.progress.setVisibility(View.GONE);

                        //setup adapter
                        List<UserWorkExperience> userWorkExperiences = userWorkExperienceModel.getUserWorkExperience();
                        UserWorkExperienceAdapter adapter = new UserWorkExperienceAdapter(userWorkExperiences, this);
                        binding.rvExperiencesWorkExperiences.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        binding.rvExperiencesWorkExperiences.setAdapter(adapter);

                        binding.LLLayoutWorkExperience.setVisibility(View.GONE);
                        binding.fabAddExperienceWorkExperience.setVisibility(View.VISIBLE);
                    } else {
                        binding.LLLayoutWorkExperience.setVisibility(View.VISIBLE);
                        binding.fabAddExperienceWorkExperience.setVisibility(View.GONE);
                        binding.progress.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }else {
            binding.tvNoExperiencesWorkExperiences.setVisibility(View.VISIBLE);
            binding.LLLayoutWorkExperience.setVisibility(View.VISIBLE);
            binding.btnAddExperienceWorkExperience.setVisibility(View.GONE);

            binding.progress.setVisibility(View.GONE);
            binding.tvNoExperiencesWorkExperiences.setText(getString(R.string.no_internet_to_show));
        }

    }

    @Override
    public void onEditClick(UserWorkExperience workExperience) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("workExp" , workExperience);
        bundle.putString("type","edit");
        mListener.onFragmentInteraction(72, bundle);
    }

    @Override
    public void onClick(UserWorkExperience workExperience) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("workExp" , workExperience);
        bundle.putString("type","view");
        mListener.onFragmentInteraction(72, bundle);
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
