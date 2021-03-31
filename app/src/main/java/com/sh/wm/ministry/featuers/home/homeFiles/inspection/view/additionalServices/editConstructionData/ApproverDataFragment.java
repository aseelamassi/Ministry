package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData;

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
import com.sh.wm.ministry.databinding.FragmentApproverDataBinding;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class ApproverDataFragment extends Fragment {


    FragmentApproverDataBinding binding;

    String informativeId, informativeTypeId;
    List<Constants> informativeList, informativeTypeList;
    private UserFileViewModel viewModel;

    private boolean isEnabled = true ;

    private InspectionsViewModel inspectionsViewModel;
    private RadioButtonCreation creation;
    private InspectionVisit inspectionVisit;


    public ApproverDataFragment() {
        // Required empty public constructor
    }


    public static ApproverDataFragment newInstance() {
        ApproverDataFragment fragment = new ApproverDataFragment();

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
        binding = FragmentApproverDataBinding.inflate(inflater, container, false);


        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
        creation = new RadioButtonCreation(getContext());


        informativeList = new ArrayList<>();
        informativeTypeList = new ArrayList<>();


        getConstant("1654611");
        getConstant("1650049");


        getBundle();

        btnListener();


        return binding.getRoot();
    }


    public void getConstant(String parentId) {
        viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {

                if (constants != null) {
                    if (parentId.equals("1654611")) {
                        if (informativeList.size() == 0) {
                            informativeList.addAll(constants);
                            creation.addRadioButtons(binding.rgInformative, informativeList, "informative");
                        }

                    } else {
                        if (informativeTypeList.size() == 0) {
                            informativeTypeList.addAll(constants);
                            creation.addRadioButtons(binding.rgInterviewResult, informativeTypeList, "informativeType");
                        }


                    }

                } else {
                    Toast.makeText(getContext(), getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void btnListener() {


        binding.btnGetBossName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edApproverSn.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), getString(R.string.dependent_empty), Toast.LENGTH_SHORT).show();
                } else if (binding.edApproverSn.getText().toString().length()<9)
                    Toast.makeText(getContext(), getString(R.string.sn_must_be_9), Toast.LENGTH_SHORT).show();

                else {

                    inspectionsViewModel.getUserInfo(binding.edApproverSn.getText().toString()).observe(getViewLifecycleOwner(), new Observer<UserInfoModel>() {
                        @Override
                        public void onChanged(UserInfoModel userInfoModel) {
                            if (userInfoModel != null)
                                binding.edApproverName.setText(userInfoModel.getUserWorkInfo().getwORKERNAME());
                        }
                    });
                }

            }
        });


        binding.rgInformative.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            if (radioButton != null && radioButton.getTag()!= null)
                informativeId = (String) radioButton.getTag();

            if (informativeId != null && (informativeId.equals("1654613") || informativeId.equals("1654612")) ){
                binding.edApproverSn.setEnabled(false);
                binding.btnGetBossName.setEnabled(false);
                binding.edApproverSn.setText("");
                binding.edApproverName.setText("");
                binding.edApproverSn.setBackgroundColor(getResources().getColor(R.color.dark_gray));
            } else {
                binding.edApproverSn.setEnabled(true);
                binding.btnGetBossName.setEnabled(true);
                binding.edApproverSn.setBackgroundColor(getResources().getColor(R.color.mercury));
            }


        });

        binding.rgInterviewResult.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);

            if (radioButton != null && radioButton.getTag()!= null)

                informativeTypeId = (String) radioButton.getTag();

            if (informativeTypeId != null && informativeTypeId.equals("1650051")) {
                binding.edUnCompleteReason.setEnabled(false);
                binding.edUnCompleteReason.setBackgroundColor(getResources().getColor(R.color.dark_gray));
            } else {
                binding.edUnCompleteReason.setEnabled(true);
                binding.edUnCompleteReason.setBackgroundColor(getResources().getColor(R.color.mercury));

            }


        });

        binding.btnSave.setOnClickListener(view -> {
            if (!NetworkUtils.isOnline(getContext()))
                Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();

            saveAction("submit");

        });


        binding.btnSaveWithApprove.setOnClickListener(view -> {
            if (!NetworkUtils.isOnline(getContext()))
                Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();

            saveAction("submit_approve");

        });


    }
    private void saveAction(String submit){
        if (!isEnabled){
            Toast.makeText(getContext(), getString(R.string.can_not_change), Toast.LENGTH_SHORT).show();
        }
        else if (informativeId == null || informativeTypeId == null || (binding.edApproverSn.isEnabled() && binding.edApproverSn.getText().toString().isEmpty()))
            Toast.makeText(getContext(), getString(R.string.boss_empty), Toast.LENGTH_SHORT).show();
        else {
            if (submit.equals("submit_approve"))
                isEnabled = false;
            inspectionsViewModel.storeBossModel(inspectionVisit.getCONSTRUCTID(), informativeId, binding.edApproverSn.getText().toString(), informativeTypeId, binding.edUnCompleteReason.getText().toString(), inspectionVisit.getINSPECTVID(), "0", submit);
        }
    }

    private void enable(boolean b) {
        binding.btnSaveWithApprove.setEnabled(b);
        binding.btnSave.setEnabled(b);

    }


    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null)
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
    }


}