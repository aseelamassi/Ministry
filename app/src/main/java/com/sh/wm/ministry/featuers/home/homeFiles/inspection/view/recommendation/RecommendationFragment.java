package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.recommendation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentRecommendationBinding;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class RecommendationFragment extends Fragment  implements DateAdder.Listener {


    FragmentRecommendationBinding binding;

    private List<Constants> actions , recommendations , adoptings, resultRecommendations;
    private String adoptedId, actionId, recommendationId ;
    private InspectionVisit inspectionVisit;
    private UserFileViewModel viewModel ;
    private InspectionsViewModel inspectionsViewModel ;
    private DateAdder dateAdder;
    RadioButtonCreation creation ;

    public RecommendationFragment() {
        // Required empty public constructor
    }


    public static RecommendationFragment newInstance() {
        RecommendationFragment fragment = new RecommendationFragment();

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
        binding = FragmentRecommendationBinding.inflate(inflater, container, false);

        creation = new RadioButtonCreation(getContext());

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);

        actions = new ArrayList<>();
        recommendations = new ArrayList<>();
        adoptings = new ArrayList<>();
        resultRecommendations = new ArrayList<>();


        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
        getBundle();

        getConstant("1650024");
        getConstant("1650020");
        getConstant("1650038");
        getConstant("1650028");


        btnListener();

        return binding.getRoot();
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
        binding.edDate.setText(format.format(date));


    }


    public void getConstant(String parentId) {
        viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {

                if (constants != null) {
                    if (parentId.equals("1650024")) {
                        if (actions.size() == 0 ) {
                            actions.addAll(constants);
                            creation.addRadioButtons(binding.rgAction, actions, "action");
                        }
                    }
                    else if (parentId.equals("1650038")) {
                        if (recommendations.size() == 0 ){
                            recommendations.addAll(constants);
                            creation.addRadioButtons(binding.rgInspectorRecommendation ,recommendations ,"InspectorRecommendation");
                        }
                      ;
                    }else if (parentId.equals("1650020") ){
                        if (resultRecommendations.size() == 0 ){
                            resultRecommendations.addAll(constants);
                            creation.addRadioButtons(binding.rgRecommendation ,resultRecommendations ,"recommendation");
                        }


                    }else {
                        if (adoptings.size() == 0 ){
                            adoptings.addAll(constants);
                            creation.addRadioButtons(binding.rgRecommendation ,adoptings ,"recommendationL");
                        }


                    }
                } else {
                    Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }




    private void getBundle(){
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
            binding.cardViewConstructionData.llSecondView.setVisibility(View.VISIBLE);
            binding.cardViewConstructionData.imgEdit.setVisibility(View.GONE);
            binding.cardViewConstructionData.tvOwnerName.setText(getString(R.string.trade_business_name) + " " + inspectionVisit.getCONSTRUCTNAMEUSING());
            binding.cardViewConstructionData.tvOwnerId.setText(getString(R.string.id) + " " );
            binding.cardViewConstructionData.tvBusinessName.setVisibility(View.GONE);
            binding.cardViewConstructionData.tvInstitutionName.setVisibility(View.GONE);
            binding.cardViewConstructionData.tvActiveSector.setText(getString(R.string.owner_name) +" " );
            binding.cardViewConstructionData.tvWorkField.setText(getString(R.string.phone_number) + " ");
            binding.cardViewConstructionData.tvView.setText(getString(R.string.owner_data));

        }

    }


    private void btnListener(){

        binding.btnSave.setOnClickListener(view -> {
            if ((actionId == null && !recommendationId.equals("1650040") && !adoptedId.equals("1650021"))|| recommendationId == null|| binding.edDate.getText().toString().isEmpty() ||(binding.etMachineName.getVisibility() == View.VISIBLE && binding.etMachineName.getText().toString().isEmpty()) || (adoptedId == null && !recommendationId.equals("1650040")) ){
                Toast.makeText(getContext(), getString(R.string.store_inspection_result_empty), Toast.LENGTH_SHORT).show();
            }
        });

        binding.rgAction.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)
            actionId = (String) radioButton.getTag();

            if (actionId != null && actionId.equals("1650025")){
                binding.tvMachineLabel.setVisibility(View.VISIBLE);
                binding.etMachineName.setVisibility(View.VISIBLE);
            }else {
                binding.tvMachineLabel.setVisibility(View.GONE);
                binding.etMachineName.setVisibility(View.GONE);
            }
        });

        binding.rgInspectorRecommendation.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)

                recommendationId = (String) radioButton.getTag();

           if (recommendationId != null && recommendationId.equals("1650040")){
               creation.Disable_Or_Enable_RG_Button(binding.rgAction , false);
               creation.Disable_Or_Enable_RG_Button(binding.rgRecommendation , false);

           }else {
               creation.Disable_Or_Enable_RG_Button(binding.rgAction , true);
               creation.Disable_Or_Enable_RG_Button(binding.rgRecommendation , true);
           }
        });

        binding.rgRecommendation.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)
                adoptedId = (String) radioButton.getTag();
            if (adoptedId != null && adoptedId.equals("1650021")){
                creation.Disable_Or_Enable_RG_Button(binding.rgAction , false);
            }else {
                creation.Disable_Or_Enable_RG_Button(binding.rgAction , true);

            }

        });


        binding.edDate.setOnClickListener(view ->
                dateAdder.show());


        binding.btnSave.setOnClickListener(view -> {
            if (adoptedId == null || recommendationId == null || actionId==null || binding.edDate.getText().toString().isEmpty() || (binding.etMachineName.getVisibility() == View.VISIBLE && binding.etMachineName.getText().toString().isEmpty())){
                Toast.makeText(getContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
            }else {
                inspectionsViewModel.storeInspectionRecommendation(inspectionVisit.getCONSTRUCTID(), recommendationId , adoptedId,actionId,binding.etMachineName.getText().toString(),binding.edDate.getText().toString(),inspectionVisit.getINSPECTVID(), SharedPreferneceHelper.getUserId(getContext()));
            }

        });

    }
}