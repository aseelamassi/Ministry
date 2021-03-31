package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sh.wm.ministry.databinding.FragmentHollandSkillsTestBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.HollandSkillsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.Activity;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.SkillsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.HashMap;


public class HollandSkillsTestFragment extends Fragment {


    private FragmentHollandSkillsTestBinding binding;
    private OnFragmentInteractionListener mListener;
    private HollandViewModel viewModel;
    private HashMap<String, String> questions;
    private ArrayList<HashMap<String, String>> answers;

    private HollandSkillsAdapter adapter;


    public HollandSkillsTestFragment() {
        // Required empty public constructor
    }


    public static HollandSkillsTestFragment newInstance() {
        HollandSkillsTestFragment fragment = new HollandSkillsTestFragment();

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
        binding = FragmentHollandSkillsTestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setup viewModel
        viewModel = new ViewModelProvider(getActivity()).get(HollandViewModel.class);

        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        answers = new ArrayList<>();



        getSkillsQuestions();

        btnListener();
    }

    private void btnListener() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkillsModel skillsModel = adapter.getSkillsModel();

                for (Activity activity : skillsModel.getSkills1()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);

                }


                for (Activity activity : skillsModel.getSkills2()) {

                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }

                for (Activity activity : skillsModel.getSkills3()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }

                for (Activity activity : skillsModel.getSkills4()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }
                for (Activity activity : skillsModel.getSkills5()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");
                    answers.add(questions);
                }
                for (Activity activity : skillsModel.getSkills6()) {
                    questions = new HashMap<>();
                    questions.put("question_id", activity.getQUESTIONID());
                    if (activity.getANSWERVALUE() != null)
                        questions.put("answer", activity.getANSWERVALUE());
                    else
                        questions.put("answer", "0");

                    answers.add(questions);
                }


                viewModel.saveSkillsQuestions(SharedPreferneceHelper.getTestId(getContext()), answers).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel actionModel) {
                        if (actionModel != null) {

                            mListener.onFragmentInteraction(185);
                            Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.onFragmentInteraction(183);

            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mListener.onFragmentInteraction(185);

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




    private void getSkillsQuestions() {
        binding.rvSkills.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getSkills(SharedPreferneceHelper.getTestId(getContext())).observe(getViewLifecycleOwner(), new Observer<SkillsModel>() {
            @Override
            public void onChanged(SkillsModel activityModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                if (activityModel != null) {
                    adapter = new HollandSkillsAdapter(getContext(), activityModel);
                    binding.rvSkills.setAdapter(adapter);
                }else{
                    binding.rvSkills.setVisibility(View.GONE);
                    binding.tvNoInternet.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    /**
     * Called when the fragment is no longer attached to its activity.  This
     * is called after {@link #onDestroy()}.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        binding = null ;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel = null;
    }


}