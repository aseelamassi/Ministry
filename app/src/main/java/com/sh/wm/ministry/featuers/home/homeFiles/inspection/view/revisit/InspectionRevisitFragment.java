package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.revisit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentInspectionRevisitBinding;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class InspectionRevisitFragment extends Fragment implements DateAdder.Listener {

    FragmentInspectionRevisitBinding binding;

    String violationId, actionId , placementId, recommendationId;
    List<Constants> violations , actions, placements , recommendations ;

    private UserFileViewModel viewModel ;
    private InspectionsViewModel inspectionsViewModel;
    private RadioButtonCreation creation ;

    private DateAdder dateAdder ;

    private boolean isBigger ;
    private InspectionVisit inspectionVisit;



    public InspectionRevisitFragment() {
        // Required empty public constructor
    }


    public static InspectionRevisitFragment newInstance() {
        InspectionRevisitFragment fragment = new InspectionRevisitFragment();

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
        binding = FragmentInspectionRevisitBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
        creation= new RadioButtonCreation(getContext());

        dateAdder =  new DateAdder(getActivity().getSupportFragmentManager(), this);



        violations = new ArrayList<>();
        recommendations = new ArrayList<>();
        actions = new ArrayList<>();
        placements= new ArrayList<>();

        getConstant("161");
        getConstant("1650020");
        getConstant("1650028");
        getConstant("1650024");

        getBundle();

        btnListener();

        return binding.getRoot();
    }


    public void getConstant(String parentId) {
        viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {

                if (constants != null) {
                    switch (parentId) {
                        case "161":
                            if (violations.size() == 0 ) {
                                violations.addAll(constants);
                                creation.addRadioButtons(binding.rgViolation, violations, "violation");
                            }
                            break;
                        case "1650020":
                            if (actions.size() == 0){
                                actions.addAll(constants);
                                creation.addRadioButtons(binding.rgAction, actions, "actions");
                            }

                            break;
                        case "1650028":
                            if (recommendations.size() == 0 ){
                                recommendations.addAll(constants);
                                creation.addRadioButtons(binding.rgRecommendation, recommendations, "recommendation");
                            }

                            break;
                        default:
                            if (placements.size() == 0 ){
                                placements.addAll(constants);
                                creation.addRadioButtons(binding.rgPlacement, placements, "placement");
                            }

                            break;
                    }
                } else {
                    Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
        isBigger = timeChosen > Calendar.getInstance().getTimeInMillis()  ;
        binding.edDate.setText(format.format(date));



    }


    private void btnListener(){
        binding.edDate.setOnClickListener(view -> dateAdder.show());

        binding.rgViolation.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)
            violationId = (String) radioButton.getTag();
        });


        binding.rgAction.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);

            if (radioButton != null && radioButton.getTag()!= null)

                actionId = (String) radioButton.getTag();

            if (actionId != null && actionId.equals("1650021")){
                creation.Disable_Or_Enable_RG_Button(binding.rgRecommendation , false);
                creation.Disable_Or_Enable_RG_Button(binding.rgPlacement , false);
            }else {
                creation.Disable_Or_Enable_RG_Button(binding.rgRecommendation , true);
                creation.Disable_Or_Enable_RG_Button(binding.rgPlacement , true);
            }
        });


        binding.rgRecommendation.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);

            if (radioButton != null && radioButton.getTag()!= null)

                recommendationId = (String) radioButton.getTag();

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


        binding.btnSave.setOnClickListener(view -> {

            if (violationId == null || actionId == null || ((actionId != null && !actionId.equals("1650021") && (placementId == null || recommendationId == null))) || binding.edDate.getText().toString().isEmpty() || (binding.etMachineName.getVisibility() == View.VISIBLE && binding.etMachineName.getText().toString().isEmpty())){
                Toast.makeText(getContext(), getString(R.string.store_inspection_result_empty), Toast.LENGTH_SHORT).show();
            }else{
                if (!isBigger)
                    Toast.makeText(getContext(), getString(R.string.bigger_than_today), Toast.LENGTH_SHORT).show();
                else{
                    inspectionsViewModel.storeInspectionRevisit(inspectionVisit.getCONSTRUCTID(), violationId , actionId , recommendationId , placementId, binding.etMachineName.getText().toString() , binding.etReasons.getText().toString() , binding.edDate.getText().toString() , inspectionVisit.getINSPECTVID());
                }

            }

        });

    }

    private void getBundle(){
        Bundle bundle = this.getArguments();
        if (bundle != null)
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
    }






}
