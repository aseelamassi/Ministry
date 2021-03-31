package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.occupationalSafetyAndHealth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentOccupationalSafetyAndHealthBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.SafetyQuestionsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestion;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OccupationalSafetyAndHealthFragment extends Fragment {


    private FragmentOccupationalSafetyAndHealthBinding binding ;
    private InspectionsViewModel viewModel;
    private int counter =  0 ;
    private SafetyQuestionsAdapter adapter ;

    private InspectionVisit inspectionVisit;


    public OccupationalSafetyAndHealthFragment() {
        // Required empty public constructor
    }



    public static OccupationalSafetyAndHealthFragment newInstance() {
        OccupationalSafetyAndHealthFragment fragment = new OccupationalSafetyAndHealthFragment();

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
        binding =  FragmentOccupationalSafetyAndHealthBinding.inflate(inflater, container, false);
        viewModel  = new ViewModelProvider(this).get(InspectionsViewModel.class);
        binding.rvSafetyQuestions.setLayoutManager(new LinearLayoutManager(getContext()));


        getBundle();
        getSafetyQuestions();


        btnListener();
        return binding.getRoot();
    }

    List<SafetyQuestion> safetyQuestions;



    private List<SafetyQuestion> getSafetyQuestions(){

        binding.progress.setVisibility(View.VISIBLE);
        safetyQuestions = new ArrayList();
        viewModel.safetyQuestions().observe(getViewLifecycleOwner(), new Observer<SafetyQuestionArray>() {
            @Override
            public void onChanged(SafetyQuestionArray safetyQuestionsModel) {
                if (safetyQuestionsModel != null){
                    switch (counter){
                        case 0 : safetyQuestions.addAll(safetyQuestionsModel.getSafetyQuestions1());
                            break;
                        case 1:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions2();
                            break;
                        case 2:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions3();
                            break;
                        case 3:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions4();
                            break;
                        case 4:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions5();
                            break;
                        case 5:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions6();
                            break;
                        case 6:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions7();
                            break;
                        case 7:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions8();
                            break;
                        case 8:safetyQuestions = safetyQuestionsModel.getSafetyQuestions9();
                            break;
                        case 9:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions10();
                            break;
                        case 10:safetyQuestions = safetyQuestionsModel.getSafetyQuestions11();
                            break;
                        case 11:safetyQuestions = safetyQuestionsModel.getSafetyQuestions12();
                            break;
                        case 12:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions13();
                            break;
                        case 13:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions14();
                            break;
                        case 14:safetyQuestions =  safetyQuestionsModel.getSafetyQuestions15();

                            binding.btnNext.setVisibility(View.GONE);
                            break;




                    }
                }
                binding.progress.setVisibility(View.GONE);
                binding.btnNext.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.VISIBLE);
                adapter = new SafetyQuestionsAdapter(getContext() , safetyQuestions , binding.btnNext);
                binding.rvSafetyQuestions.setAdapter(adapter);
            }
        });


        return safetyQuestions;
    }


    private void getBundle(){
        Bundle bundle = this.getArguments();
        if (bundle != null)
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
    }


    private void btnListener(){

        binding.btnNext.setOnClickListener(view -> {
            counter++;
            getSafetyQuestions();
        });



        binding.btnSave.setOnClickListener(view -> {
            HashMap<String , ArrayList> map = new HashMap<>();
            if (adapter.getList().size() != safetyQuestions.size())
                Toast.makeText(getContext(), getText(R.string.answer_all_questions), Toast.LENGTH_SHORT).show();
            else {
                map.put("ANSWERS", adapter.getList());


                viewModel.storeQuestionsAnswer(inspectionVisit.getCONSTRUCTID() , inspectionVisit.getINSPECTVID() ,adapter.getList() , SharedPreferneceHelper.getUserId(getContext()));

            }
        });

    }
}