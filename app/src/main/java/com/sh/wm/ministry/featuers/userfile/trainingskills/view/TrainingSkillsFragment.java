package com.sh.wm.ministry.featuers.userfile.trainingskills.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentTrainingSkillsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.trainingskills.adapter.TrainingSkillAdapter;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkills;
import com.sh.wm.ministry.featuers.userfile.trainingskills.viewmodel.TrainingSkillsViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class TrainingSkillsFragment extends Fragment implements TrainingSkillAdapter.OnEditClickListener {

    private TrainingSkillsViewModel mViewModel;
    private FragmentTrainingSkillsBinding binding;
    private OnFragmentInteractionListener mListener;

    public static TrainingSkillsFragment newInstance() {
        return new TrainingSkillsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTrainingSkillsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.LLLayoutTrainingSkills.setVisibility(View.GONE);
        binding.fabAddTrainingSkills.setVisibility(View.GONE);
        binding.fabAddTrainingSkills.setOnClickListener(view -> {
            mListener.onFragmentInteraction(112);
        });
        binding.btnAddTrainingSkills.setOnClickListener(view -> {
            mListener.onFragmentInteraction(112);
        });

        mViewModel = new ViewModelProvider(this).get(TrainingSkillsViewModel.class);
        if (NetworkUtils.isOnline(getContext()) ){


            mViewModel.getTrainingSkills().observe(getViewLifecycleOwner(), trainingSkillsModel -> {
                if (trainingSkillsModel != null) {
                    binding.progress.setVisibility(View.GONE);
                    if (trainingSkillsModel.getTrainingSkillsWorkStatuses() != null) {
                        List<TrainingSkills> skills = trainingSkillsModel.getTrainingSkillsWorkStatuses();
                        TrainingSkillAdapter adapter = new TrainingSkillAdapter(skills, this);
                        binding.rvTrainingSkills.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        binding.rvTrainingSkills.setAdapter(adapter);
                        binding.LLLayoutTrainingSkills.setVisibility(View.GONE);
                        binding.fabAddTrainingSkills.setVisibility(View.VISIBLE);
                    } else {
                        binding.LLLayoutTrainingSkills.setVisibility(View.VISIBLE);
                        binding.fabAddTrainingSkills.setVisibility(View.GONE);
                    }
                }
            });
        } else {
            binding.LLLayoutTrainingSkills.setVisibility(View.VISIBLE);
            binding.btnAddTrainingSkills.setVisibility(View.GONE );
            binding.progress.setVisibility(View.GONE);
            binding.tvNoTrainingSkills.setText(getString(R.string.no_internet_to_show));
            binding.tvNoTrainingSkills.setVisibility(View.VISIBLE);
        }

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
    public void onEditClick(TrainingSkills trainingSkills) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("trainingSkill", trainingSkills);
        bundle.putString("type", "edit");
        mListener.onFragmentInteraction(112, bundle);
    }


    @Override
    public void onClick(TrainingSkills trainingSkills) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("trainingSkill", trainingSkills);
        bundle.putString("type", "view");
        mListener.onFragmentInteraction(112, bundle);
    }
}