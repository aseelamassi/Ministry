package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHollandTestActivitiesBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.ActivityAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.HollandQuestionsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.Activity;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.ActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.HashMap;


public class HollandTestActivitiesFragment extends Fragment {


    private FragmentHollandTestActivitiesBinding binding;
    private OnFragmentInteractionListener mListener;
    private HollandViewModel viewModel;

    private HashMap<String, String> questions;
    ArrayList<HashMap<String, String>> answers;


    private HollandQuestionsAdapter adapter;

    public HollandTestActivitiesFragment() {
        // Required empty public constructor
    }


    public static HollandTestActivitiesFragment newInstance(String param1, String param2) {
        HollandTestActivitiesFragment fragment = new HollandTestActivitiesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHollandTestActivitiesBinding.inflate(inflater, container, false);

        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        //setup viewModel
        viewModel = new ViewModelProvider(getActivity()).get(HollandViewModel.class);
        //get Activity holland test questions
        getActivityQuestions();

        answers = new ArrayList<>();

        btnListener();


        return binding.getRoot();

    }

    private void btnListener() {

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityModel activityModel = adapter.getActivityModel();

                for (Activity activity : activityModel.getActivity1()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);

                }


                for (Activity activity : activityModel.getActivity2()) {

                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }

                for (Activity activity : activityModel.getActivity3()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }

                for (Activity activity : activityModel.getActivity4()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }
                for (Activity activity : activityModel.getActivity5()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }
                for (Activity activity : activityModel.getActivity6()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }


                viewModel.saveActivityQuestions(SharedPreferneceHelper.getTestId(getContext()), answers).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel actionModel) {
                        if (actionModel != null)
                            Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();


                        mListener.onFragmentInteraction(184);
                    }
                });

            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mListener.onFragmentInteraction(182);

            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mListener.onFragmentInteraction(184);

            }
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


    private void getActivityQuestions() {

        binding.rvActivities.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getActivities(SharedPreferneceHelper.getTestId(getContext())).observe(getViewLifecycleOwner(), new Observer<ActivityModel>() {
            @Override
            public void onChanged(ActivityModel activityModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                if (activityModel != null) {
                    adapter = new HollandQuestionsAdapter(getContext(), activityModel);
                    binding.rvActivities.setAdapter(adapter);
                } else {
                    binding.rvActivities.setVisibility(View.GONE);
                    binding.tvNoInternet.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel = null;
    }



}