package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.insertWorker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentWorkerMajorDataBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel.MajorServicesViewModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;


public class WorkerMajorDataFragment extends Fragment  implements InsertWorkerFragment.CheckUserSn  {


    FragmentWorkerMajorDataBinding binding;
    private UserFileViewModel viewModel ;
    private InspectionsViewModel inspectionsViewModel ;
    private MajorServicesViewModel mViewModel;



    InsertWorkerFragment.GetData checkUSerSn ;
    private String userSn , userId ;
    

    public WorkerMajorDataFragment() {
        // Required empty public constructor
    }


    public static WorkerMajorDataFragment newInstance() {
        WorkerMajorDataFragment fragment = new WorkerMajorDataFragment();

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
        binding =  FragmentWorkerMajorDataBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);

        InsertWorkerFragment.sn = this;

        btnListener();


        
        return binding.getRoot();
    }

    private void btnListener() {

        binding.btnGetData.setOnClickListener(view -> {
            if (binding.etSn.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), getString(R.string.dependent_empty), Toast.LENGTH_SHORT).show();
            } else {


                if (!NetworkUtils.isOnline(getContext()))
                    Toast.makeText(getContext(), getString(R.string.usersn_no_internet), Toast.LENGTH_SHORT).show();
                else {

                    binding.progress.setVisibility(View.VISIBLE);
                    inspectionsViewModel.getUserInfo(binding.etSn.getText().toString()).observe(getViewLifecycleOwner(), new Observer<UserInfoModel>() {
                        @Override
                        public void onChanged(UserInfoModel userInfoModel) {
                            if (userInfoModel != null) {
                                binding.progress.setVisibility(View.GONE);
                                userId= userInfoModel.getUserWorkInfo().getUSERID();
                                binding.etFirstNameMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERFNAMEAR());
                                binding.etFatherName.setText(userInfoModel.getUserWorkInfo().getUSERSNAMEAR());
                                binding.etGrandNameMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERTNAMEAR());
                                binding.etFamilyName.setText(userInfoModel.getUserWorkInfo().getUSERLNAMEAR());
                                binding.etGenderMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERSEX());
                                binding.etBirthPlaceMajorServices.setText(userInfoModel.getUserWorkInfo().getBIRTHPLACE());
                                binding.tvBirthDateMajorServices.setText(userInfoModel.getUserWorkInfo().getBRITHDATE());
                                binding.etMotherNameMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERMOTHERNAME());
                                binding.etSocialStatusMajorServices.setText(userInfoModel.getUserWorkInfo().getSOCIALSTATUS());
                                binding.etChildNumberMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERCHIDEDNUM());
                                binding.tvDeathDateMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERDEATHDATE());
                                getCountryName(userInfoModel.getUserWorkInfo().getUSERNATIONALITYOTHERID() , binding.etOtherNationalityIdMajorServices);
                                getCountryName(userInfoModel.getUserWorkInfo().getUSERNATIONALITYID() , binding.etNationalityMajorServices);
                                binding.etCity.setText(userInfoModel.getUserWorkContact().getUSERCITYDESC());
                                binding.etPhone.setText(userInfoModel.getUserWorkContact().getUSERMOBILE1());
                                binding.etAgeMajorServices.setText(userInfoModel.getUserWorkInfo().getUSERAGE());


                            }
                        }
                    });
                }
            }

        });

    }


    @Override
    public String getUSerSn() {
        return binding.etSn.getText().toString();
    }

    @Override
    public String getUserId() {
        return userId;
    }


    private void getCountryName(String id , TextView textView ){

        mViewModel = new ViewModelProvider(this).get(MajorServicesViewModel.class);
        if (NetworkUtils.isOnline(getContext())) {
            mViewModel.getUserCountry(id).observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String country) {
                    if (country != null) {
                       textView.setText(country);
                    } else {
                        textView.setText("-");
                    }
                }
            });
        }
    }


}