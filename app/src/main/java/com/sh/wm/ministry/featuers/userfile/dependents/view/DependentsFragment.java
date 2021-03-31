package com.sh.wm.ministry.featuers.userfile.dependents.view;

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



import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentDependentsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.dependents.adapter.DependentsAdapter;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependent;
import com.sh.wm.ministry.featuers.userfile.dependents.viewmodel.DependentsViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class DependentsFragment extends Fragment implements DependentsAdapter.OnEditClickListener{

    private DependentsViewModel mViewModel;
    private FragmentDependentsBinding binding;
    private List<UserDependent> userDependentsList;
    private OnFragmentInteractionListener mListener;




    public static DependentsFragment newInstance() {
        return new DependentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDependentsBinding.inflate(inflater, container, false);


        binding.tvNoDependents.setVisibility(View.GONE);
        binding.btnAddDependents.setVisibility(View.GONE);
        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(DependentsViewModel.class);

        if (NetworkUtils.isOnline(getContext())){//check if the internet is available
            //get user career and observe it
            mViewModel.getUserDependents().observe(getViewLifecycleOwner(), userDependentsModel -> {
                if ( userDependentsModel != null &&userDependentsModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.GONE);
                    //enable user interaction when progress is visible
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                    binding.rvDependents.setVisibility(View.VISIBLE);

                    binding.fabAddNewDependents.setVisibility(View.VISIBLE);
                   //hide the view displayed when no data
                    binding.tvNoDependents.setVisibility(View.GONE);
                    binding.btnAddDependents.setVisibility(View.GONE);

                    userDependentsList = userDependentsModel.getUserDependents();

                    //set returned data to adapter
                    DependentsAdapter dependentsAdapter = new DependentsAdapter(userDependentsList,this);
                    binding.rvDependents.setAdapter(dependentsAdapter);
                }else {
                    binding.progress.setVisibility(View.GONE);
                    //enable user interaction when progress is visible
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    //display the view  when no data
                    binding.tvNoDependents.setVisibility(View.VISIBLE);
                    binding.btnAddDependents.setVisibility(View.VISIBLE);
                }


            });

        }else {
            binding.progress.setVisibility(View.GONE);
            binding.tvNoDependents.setVisibility(View.VISIBLE);

            binding.tvNoDependents.setText(R.string.no_internet_to_show);
        }

        btnListener();



    }

    private void  btnListener(){
        //add buttons clickListener
        binding.btnAddDependents.setOnClickListener(view -> {
            mListener.onFragmentInteraction(41);
        });
        binding.fabAddNewDependents.setOnClickListener(view -> {
            mListener.onFragmentInteraction(41);
        });

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onEditClick(UserDependent userDependent) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("dependent", userDependent);
        mListener.onFragmentInteraction(41,bundle);
    }
}