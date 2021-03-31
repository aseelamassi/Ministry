package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.storeInspectionResult;

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
import com.sh.wm.ministry.databinding.FragmentStoreInspectionResultBinding;
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


public class StoreInspectionResultFragment extends Fragment implements DateAdder.Listener  {



    FragmentStoreInspectionResultBinding binding ;
    private String placementId, actionId, recommendationId ;
    private InspectionVisit inspectionVisit;
    private UserFileViewModel viewModel ;
    private InspectionsViewModel inspectionsViewModel ;
    private DateAdder dateAdder;

    private RadioButtonCreation creation;


    private List<Constants> placement , recommendations , actions;
    public StoreInspectionResultFragment() {
        // Required empty public constructor
    }

    public static StoreInspectionResultFragment newInstance() {
        StoreInspectionResultFragment fragment = new StoreInspectionResultFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        placement = new ArrayList<>();
        recommendations = new ArrayList<>();
        actions = new ArrayList<>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStoreInspectionResultBinding.inflate(inflater, container, false);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);


        creation =  new RadioButtonCreation(getContext());
        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
       inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
       getBundle();

        getConstant("1650024");
        getConstant("1650020");
        getConstant("1650028");


        btnListener();

        return binding.getRoot();
    }



    private void btnListener(){


        binding.edDate.setOnClickListener(view ->
                dateAdder.show() );


        binding.btnSave.setOnClickListener(view -> {
            if (actionId == null || ((actionId!= null && !actionId.equals("1650021"))&&(placementId == null || recommendationId == null) )|| binding.edDate.getText().toString().isEmpty() ||(binding.etMachineName.getVisibility() == View.VISIBLE && binding.etMachineName.getText().toString().isEmpty()) ){
                Toast.makeText(getContext(), getString(R.string.store_inspection_result_empty), Toast.LENGTH_SHORT).show();
            }else
                inspectionsViewModel.storeInspection(inspectionVisit.getCONSTRUCTID(),actionId,recommendationId,placementId,binding.edDate.getText().toString(), binding.etReasons.getText().toString(),binding.etMachineName.getText().toString(),inspectionVisit.getINSPECTVID() , SharedPreferneceHelper.getUserId(getContext()));

        });



        binding.rgPlacement.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)

                placementId = (String) radioButton.getTag();
            if (placementId != null && placementId.equals("1650025")){
                binding.tvMachineLabel.setVisibility(View.VISIBLE);
                binding.etMachineName.setVisibility(View.VISIBLE);
            }else {
                binding.tvMachineLabel.setVisibility(View.GONE);
                binding.etMachineName.setVisibility(View.GONE);
            }




        });

        binding.rgAction.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)

                actionId = (String) radioButton.getTag();
            if (actionId != null && actionId.equals("1650021")){
                creation.Disable_Or_Enable_RG_Button(binding.rgRecommendation,false);
                creation.Disable_Or_Enable_RG_Button(binding.rgPlacement,false);
                placementId = null ;
                recommendationId = null;
            }else {
                creation.Disable_Or_Enable_RG_Button(binding.rgRecommendation,true);
                creation.Disable_Or_Enable_RG_Button(binding.rgPlacement,true);
            }
        });

        binding.rgRecommendation.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)
                recommendationId = (String) radioButton.getTag();
        });
    }


    public void getConstant(String parentId) {
            viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
                @Override
                public void onChanged(List<Constants> constants) {

                    if (constants != null) {
                        if (parentId.equals("1650020")) {
                            if (actions.size() == 0 ){
                                actions.addAll(constants);
                                creation.addRadioButtons(binding.rgAction , actions,"action");
                            }

                        }
                        else if (parentId.equals("1650024")) {
                            if (placement.size() == 0){
                                placement.addAll(constants);
                                creation.addRadioButtons(binding.rgPlacement ,placement ,"placement");
                            }

                        }else {
                            if (recommendations.size() == 0 ){
                                recommendations.addAll(constants);
                                creation.addRadioButtons(binding.rgRecommendation ,recommendations ,"recommendation");
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
        if (bundle != null)
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
        binding.edDate.setText(format.format(date));
    }
}