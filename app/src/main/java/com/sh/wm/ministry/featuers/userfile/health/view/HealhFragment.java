package com.sh.wm.ministry.featuers.userfile.health.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentHealthStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.insertWorker.InsertWorkerFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatus;
import com.sh.wm.ministry.featuers.userfile.health.viewmodel.HealhViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerHealthModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class HealhFragment extends Fragment implements BottomSheetDialogGeneral.BottomSheetInterface, InsertWorkerFragment.HealthStatus {

    private HealhViewModel mViewModel;
    private UserFileViewModel userFileViewModel;
    private FragmentHealthStatusBinding binding;
    private List<Constants> healthStatus;
    private List<Constants> disabilitiesType;
    private String healthStatusId;
    private String disabilityTypeId, userSn, userId;
    private ShMyDialog shMyDialog;
    private boolean isSuccess;
    private MutableLiveData<Boolean> mutableLiveData;
    private InspectionVisit inspectionVisit;
    private InspectionsViewModel inspectionsViewModel;

    private OnFragmentInteractionListener mListener;
    private Bundle bundle;

    private String type;
    BottomSheetDialogGeneral bottomSheetDialogGeneral;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHealthStatusBinding.inflate(inflater, container, false);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);

        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        mutableLiveData = new MutableLiveData<>();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBundle(); //getBundle data if this fragment open from inspectionVisit update worker health status

        healthStatus = new ArrayList<>();
        disabilitiesType = new ArrayList<>();

        //setUp viewModel
        mViewModel = new ViewModelProvider(this).get(HealhViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//Check if the internet is available
            mViewModel.getUserWorkInfoLiveData().observe(getViewLifecycleOwner(), userHealthStatusModel -> {

                if (userHealthStatusModel != null && userHealthStatusModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.INVISIBLE);
                    //enable user interaction when progress is visible
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    UserHealthStatus userHealthStatus = userHealthStatusModel.getUserHealthStatus().get(0);
                    binding.etHealhStatus.setText(userHealthStatus.getHEALTHTYPE());
                    healthStatusId = userHealthStatus.getUSERHEALTHTYPEID();

                    //setup view dependent on healthStatus id
                    if (!userHealthStatus.getUSERHEALTHTYPEID().equals("130001") && !healthStatusId.equals("130003")) {
                        binding.tvHealthStatusDetails.setVisibility(View.VISIBLE);
                        binding.etHealthStatusDetails.setVisibility(View.VISIBLE);
                        binding.disabilityContainer.setVisibility(View.GONE);
                        if (userHealthStatus.getUSERHEALTHDESC() != null) {
                            String userHealthDesc = userHealthStatus.getUSERHEALTHDESC();
                            binding.etHealthStatusDetails.setText(userHealthDesc);
                        } else binding.etHealthStatusDetails.setText("-");
                    }
                    ////////الحالة الصحيى معاق
                    else if (healthStatusId.equals("130003")) {
                        binding.disabilityContainer.setVisibility(View.VISIBLE);
                        binding.etDisabilityType.setText(userHealthStatus.getDISABILITYTYPE());
                        binding.etDisabilityPlace.setText(userHealthStatus.getUSERHEALTHDISABILITYPLACE());
                        binding.etDisabilitySize.setText(userHealthStatus.getUSERHEALTHDISABILITYSIZE());
                        binding.tvHealthStatusDetails.setVisibility(View.VISIBLE);
                        binding.etHealthStatusDetails.setVisibility(View.VISIBLE);
                        disabilityTypeId = userHealthStatus.getUSERHEALTHDISABILITYTYPEID();
                        if (userHealthStatus.getUSERHEALTHDISABILITYREASON() != null)
                            binding.etDisabilityReason.setText(userHealthStatus.getUSERHEALTHDISABILITYREASON());
                        if (userHealthStatus.getUSERHEALTHDESC() != null) {
                            String userHealthDesc = userHealthStatus.getUSERHEALTHDESC();
                            binding.etHealthStatusDetails.setText(userHealthDesc);
                        } else binding.etHealthStatusDetails.setText("-");
                    } else {
                        detailsVisibility(View.GONE);

                        binding.disabilityContainer.setVisibility(View.GONE);
                    }

                } else {
                    binding.progress.setVisibility(View.INVISIBLE);
                    //enable user interaction when progress is visible
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                }
                binding.etHealhStatus.setInputType(0);


                btnListener();
            });

        } else {
            binding.progress.setVisibility(View.GONE);
            //enable user interaction when progress is visible
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            Toast.makeText(getContext(), getString(R.string.no_internet_to_show), Toast.LENGTH_SHORT).show();
        }
    }


    private void btnListener() {

        binding.etHealhStatus.setOnClickListener(view -> {
            getConstant("13");

        });

        binding.etDisabilityType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("139");
            }
        });


        binding.btnAddUserHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnAddUserHealth.setEnabled(false);
                saveButtonAction();
            }
        });
    }

    public void getConstant(String parentId) {
        if ((parentId.equals("13") && healthStatus.size() == 0) || (parentId.equals("139") && disabilitiesType.size() == 0)) {
            userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
                @Override
                public void onChanged(List<Constants> constants) {
                    healthStatus = new ArrayList<>();
                    disabilitiesType = new ArrayList<>();
                    if (constants != null) {
                        if (parentId.equals("13"))
                            healthStatus.addAll(constants);
                        else
                            disabilitiesType.addAll(constants);
                        showConstantSheet(parentId);
                    }
                }
            });
        } else
            showConstantSheet(parentId);
    }


    public void showBtmSheet(int title, List<Constants> list, TextView tv_change, String type) {


        this.type = type;
        bottomSheetDialogGeneral.openDialog(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list), title, tv_change);





    }


    private void showConstantSheet(String parentId) {
        if (parentId.equals("13")) {
            showBtmSheet(R.string.health_status, healthStatus, binding.etHealhStatus, "healthStatus");
        } else {
            showBtmSheet(R.string.disability_type, disabilitiesType, binding.etDisabilityType, "disability");

        }
    }


    private void getBundle() {
        bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
            binding.btnAddUserHealth.setVisibility(View.GONE);
            InsertWorkerFragment.healthStatus = this::saveHealth;
            userSn = bundle.getString("userSn");
            if (bundle.getString("userId") != null) {
                userId = bundle.getString("userId");
            } else {
                if (NetworkUtils.isOnline(getContext()))
                    inspectionsViewModel.getUserInfo(userSn).observe(getViewLifecycleOwner(), new Observer<UserInfoModel>() {
                        @Override
                        public void onChanged(UserInfoModel userInfoModel) {
                            if (userInfoModel != null && userInfoModel.getUserWorkInfo() != null)
                                userId = userInfoModel.getUserWorkInfo().getUSERID();
                        }
                    });
            }

        }
    }


    private void action() {
        binding.btnAddUserHealth.setEnabled(true);
        if (!NetworkUtils.isOnline(getContext()) && inspectionVisit != null) {
            AddWorkerHealthModel model = new AddWorkerHealthModel(userId, healthStatusId, binding.etHealthStatusDetails.getText().toString(), disabilityTypeId, binding.etDisabilityPlace.getText().toString(), binding.etDisabilitySize.getText().toString(), binding.etDisabilityReason.getText().toString(), userSn);
            mViewModel.storeAddWorkerHealth(model);
            Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();
            if (bundle != null)
                mListener.onFragmentInteraction(400, bundle);
        } else {
            if (!healthStatusId.equals("130003")) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                mViewModel.addUserHealthStatus(userId, healthStatusId, binding.etHealthStatusDetails.getText().toString()).observe(getViewLifecycleOwner(), addUserHealth -> {
                    if (addUserHealth != null) {
                        isSuccess = true;
                        mutableLiveData.setValue(isSuccess);
                        disabilityTypeId = null;
                        binding.etDisabilityPlace.setText("");
                        binding.etDisabilitySize.setText("");
                        binding.etDisabilityReason.setText("");
                        binding.etDisabilityType.setText("");
                        Toast.makeText(getContext(), addUserHealth.getMessageText(), Toast.LENGTH_LONG).show();
                    }
                });


            } else
                mViewModel.addUserHealthStatusWithAll(userId, healthStatusId, binding.etHealthStatusDetails.getText().toString(), disabilityTypeId, binding.etDisabilityPlace.getText().toString(), binding.etDisabilitySize.getText().toString(), binding.etDisabilityReason.getText().toString()).observe(getViewLifecycleOwner(), addUserHealth -> {
                    if (addUserHealth != null) {
                        binding.progress.setVisibility(View.GONE);
                        //enable user interaction when progress is visible
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        Toast.makeText(getContext(), addUserHealth.getMessageText(), Toast.LENGTH_LONG).show();

                    }
                });
        }


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        //setup view visibility dependent on healthStatusId
        if (type.equals("healthStatus")) {
            healthStatusId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();

            switch (healthStatusId) {
                case "130001": // سليم
                    detailsVisibility(View.GONE);

                    binding.etHealthStatusDetails.setText("");
                    binding.disabilityContainer.setVisibility(View.GONE);

                    emptyFields();

                    break;
                //مريض قادر علي العمل او غير قادر علي العمل
                case "1760226":
                case "1760225":
                    detailsVisibility(View.VISIBLE);
                    binding.disabilityContainer.setVisibility(View.GONE);
                    emptyFields();
                    break;

                case "130003"://معاق
                    detailsVisibility(View.VISIBLE);
                    binding.disabilityContainer.setVisibility(View.VISIBLE);
                    break;

            }
        } else
            disabilityTypeId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();


    }

    @Override
    public LiveData<Boolean> saveHealth() {
        saveButtonAction();
        return mutableLiveData;

    }

    private void saveButtonAction() {
        if (healthStatusId != null) {

            if (healthStatusId.equals("130003") && (binding.etDisabilitySize.getText().toString().isEmpty() || binding.etDisabilityPlace.getText().toString().isEmpty() || binding.etDisabilitySize.getText().toString().isEmpty())) {
                Toast.makeText(getContext(), getResources().getString(R.string.disability_empty_feild), Toast.LENGTH_LONG).show();

                binding.btnAddUserHealth.setEnabled(true);
            } else {

                shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        if (NetworkUtils.isOnline(getContext())) {
                            binding.progress.setVisibility(View.VISIBLE);
                            //disable user interaction when progress is visible
                            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }

                        if (userId == null && inspectionVisit == null) {
                            userId = SharedPreferneceHelper.getUserId(getContext());
                            action();
                        } else if (userId != null && inspectionVisit != null)
                            action();


                        shMyDialog.dismiss();
                    }


                    @Override
                    public void edite(View view) {
                        shMyDialog.dismiss();
                    }
                }, getString(R.string.health_save), getString(R.string.save), getString(R.string.cancel));

                shMyDialog.show(getParentFragmentManager(), "hi their");


            }


        } else {
            Toast.makeText(getContext(), R.string.health_empty, Toast.LENGTH_LONG).show();
            binding.btnAddUserHealth.setEnabled(true);
        }
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


    private void emptyFields(){
        binding.etDisabilityPlace.setText("");
        binding.etDisabilityReason.setText("");
        binding.etDisabilitySize.setText("");
        binding.etDisabilityType.setText("");
        disabilityTypeId = null;
    }

    private void detailsVisibility(int status){
        binding.tvHealthStatusDetails.setVisibility(status);
        binding.etHealthStatusDetails.setVisibility(status);
    }
}