package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHollandCareersBinding;
import com.sh.wm.ministry.databinding.FragmentHollandSkillsTestBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.HollandCareersAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.HollandSkillsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.Activity;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.HollandCareersModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.SkillsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class HollandCareersFragment extends Fragment {


    private FragmentHollandCareersBinding binding;
    private OnFragmentInteractionListener mListener;
    private HollandViewModel viewModel;
    private String testId;
    private HashMap<String, String> questions;
    private ArrayList<HashMap<String, String>> answers;

    private HollandCareersAdapter adapter;

    public HollandCareersFragment() {
        // Required empty public constructor
    }


    public static HollandCareersFragment newInstance() {
        HollandCareersFragment fragment = new HollandCareersFragment();

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
        binding = FragmentHollandCareersBinding.inflate(inflater, container, false);
        return binding.getRoot();    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //setup viewModel
        viewModel = new ViewModelProvider(getActivity()).get(HollandViewModel.class);

        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        answers = new ArrayList<>();

        getCareersQuestions();

        btnListener();
    }


    private void btnListener() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HollandCareersModel careers = adapter.getCareers();

                for (Activity activity : careers.getJobs1()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);

                }


                for (Activity activity : careers.getJobs2()) {

                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }

                for (Activity activity : careers.getJobs3()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }

                for (Activity activity : careers.getJobs4()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }
                for (Activity activity : careers.getJobs5()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }
                for (Activity activity : careers.getJobs6()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");

                    answers.add(questions);
                }


                viewModel.saveCareersQuestions(SharedPreferneceHelper.getTestId(getContext()), answers).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel actionModel) {
                        if (actionModel != null) {
                            Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();



                            mListener.onFragmentInteraction(186);


                        }
                    }
                });

            }
        });


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mListener.onFragmentInteraction(184);


            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mListener.onFragmentInteraction(186);


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



    private void getCareersQuestions() {
        binding.rvCareers.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getCareers(testId).observe(getViewLifecycleOwner(), new Observer<HollandCareersModel>() {
            @Override
            public void onChanged(HollandCareersModel activityModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                if (activityModel != null) {
                    adapter = new HollandCareersAdapter(getContext(), activityModel);
                    binding.rvCareers.setAdapter(adapter);
                }else{
                    binding.rvCareers.setVisibility(View.GONE);
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


