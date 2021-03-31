package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
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
import com.sh.wm.ministry.databinding.FragmentEvaluationBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.EvaluationAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.HollandSkillsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.Activity;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.EvaluationModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.SkillsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class EvaluationFragment extends Fragment {


    private FragmentEvaluationBinding binding ;

    private OnFragmentInteractionListener mListener;
    private HollandViewModel viewModel;
    private HashMap<String, String> questions;
    private ArrayList<HashMap<String, String>> answers;

    private EvaluationAdapter adapter;

    private EvaluationModel evaluationModel ;


    public EvaluationFragment() {
        // Required empty public constructor
    }


    public static EvaluationFragment newInstance() {
        EvaluationFragment fragment = new EvaluationFragment();

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
        binding =  FragmentEvaluationBinding.inflate(inflater, container, false);


        //setup viewModel
        viewModel = new ViewModelProvider(getActivity()).get(HollandViewModel.class);

        answers = new ArrayList<>();

        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        getEvaluationQuestions();


        btnListener();
        return binding.getRoot();
    }





    private void btnListener(){
        binding.btnGeneral.setOnClickListener(view -> {
            evaluationModel = adapter.getModel();
            adapter = new EvaluationAdapter(getContext(), evaluationModel, "0");
            binding.rvEvaluation.setAdapter(adapter);

            binding.btnGeneral.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.colorPrimary));
            binding.btnGeneral.setTextColor(getContext().getResources().getColor(R.color.white));

            binding.btnPrivate.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.white));
            binding.btnPrivate.setTextColor(getContext().getResources().getColor(R.color.black));



        });

         binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mListener.onFragmentInteraction(185);

            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.onFragmentInteraction(187);

            }
        });


        binding.btnPrivate.setOnClickListener(view -> {
            evaluationModel = adapter.getModel();
            adapter = new EvaluationAdapter(getContext(), evaluationModel, "1");
            binding.rvEvaluation.setAdapter(adapter);
            binding.btnPrivate.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.colorPrimary));
            binding.btnPrivate.setTextColor(getContext().getResources().getColor(R.color.white));

            binding.btnGeneral.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.white));
            binding.btnGeneral.setTextColor(getContext().getResources().getColor(R.color.black));





        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter != null && adapter.getModel() != null ) {
                    EvaluationModel evaluationModel = adapter.getModel();

                    for (Activity activity : evaluationModel.getEvaluation1()) {
                        Log.d("aseel" , activity.getQUESTIONID() + activity.getANSWERVALUE());
                        questions = new HashMap<>();
                        questions.put("question_id", activity.getQUESTIONID());
                        if (activity.getANSWERVALUE() != null) {
                            questions.put("answer", activity.getANSWERVALUE());
                        }else
                            questions.put("answer", "0");
                        answers.add(questions);

                    }


                    for (Activity activity : evaluationModel.getEvaluation2()) {

                        questions = new HashMap<>();
                        questions.put("question_id", activity.getQUESTIONID());
                        if (activity.getANSWERVALUE() != null)
                            questions.put("answer", activity.getANSWERVALUE());
                        else
                            questions.put("answer", "0");
                        answers.add(questions);
                    }


                    viewModel.saveEvaluationsQuestions(SharedPreferneceHelper.getTestId(getContext()
                    ), answers).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                        @Override
                        public void onChanged(ActionModel actionModel) {
                            if (actionModel != null) {
                                Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();

                                mListener.onFragmentInteraction(187);
                            }
                        }
                    });

                }
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



    private void getEvaluationQuestions() {
        binding.rvEvaluation.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getEvaluations(SharedPreferneceHelper.getTestId(getContext())).observe(getViewLifecycleOwner(), new Observer<EvaluationModel>() {
            @Override
            public void onChanged(EvaluationModel activityModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                if (activityModel != null) {


                    binding.btnPrivate.setEnabled(true);
                    binding.btnGeneral.setEnabled(true);
                    adapter = new EvaluationAdapter(getContext(), activityModel, "0");
                    binding.rvEvaluation.setAdapter(adapter);

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