package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.FileUtils;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentLicenseDataBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.ConstructRegisterSideAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.ConstructLicenceInfo.ConstructLicenceInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo.ConstructRegisterInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class LicenseDataFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {


    private FragmentLicenseDataBinding binding;
    private InspectionVisit inspectionVisit;

    private ArrayList<InsuranceCompany> insuranceCompanies;
    private UserFileViewModel viewModel;
    private HomeViewModel homeViewModel;
    private InspectionsViewModel inspectionsViewModel;
    private ArrayList<Constants> constantList, yesOrNoList, workTimeList;
    private RadioButtonCreation creation;
    private String sideType, fileType;

    private ShMyDialog shMyDialog;
    private Uri fileUri;
    private String filePath;
    private MultipartBody.Part image, registerFile, insuranceFile;
    private File file;

    private DateAdder dateAdder;
    private ArrayList<Constants> licenseSides, insuranceSide;
    private String parentId, isLicensed, isRegistered, isPolicy, isInternalSys, isCertificatedYN, inComeId, workTimeId, registeredSideId, licensedSideId, policyId, submitAction;

    private Construction construction;
    private BottomSheetDialogGeneral bottomSheetDialogGeneral;


    public LicenseDataFragment() {
        // Required empty public constructor
    }

    public static LicenseDataFragment newInstance() {
        LicenseDataFragment fragment = new LicenseDataFragment();

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
        binding = FragmentLicenseDataBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        licenseSides = new ArrayList<>();
        insuranceCompanies = new ArrayList<>();


        getBundle();

        getLicensedDate();


        creation = new RadioButtonCreation(getContext());


        yesOrNoList = new ArrayList<>();
        workTimeList = new ArrayList<>();
        getConstant("53");
        getConstant("1650056");


        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);


        getConstructionLicenseSide();
        getConstructionRegisterSide();

        btnListener();
        return binding.getRoot();
    }

    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
            construction = (Construction) bundle.getSerializable("construct");
        }
    }

    public void getConstant(String parentId) {
        if (parentId.equals("1750000") && licenseSides.size() != 0) {
            if (sideType.equals("registration")) {
                binding.edRegistrationSide.setEnabled(false);
                showBtmSheet(R.string.registration_side, licenseSides, insuranceCompanies, binding.edRegistrationSide, "registration");
            } else {
                binding.edLicensedSide.setEnabled(false);
                showBtmSheet(R.string.licensed_side, licenseSides, insuranceCompanies, binding.edLicensedSide, "license");
            }
        } else if (parentId.equals("1650424") && insuranceSide.size() != 0) {
            binding.edInsuranceCompany.setEnabled(false);
            showBtmSheet(R.string.insurance_company, insuranceSide, insuranceCompanies, binding.edInsuranceCompany, "insurance");

        } else {
            constantList = new ArrayList<>();
            viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
                @Override
                public void onChanged(List<Constants> constants) {

                    if (constants != null) {
                        constantList.clear();
                        constantList.addAll(constants);
                        switch (parentId) {

                            case "53":
                                if (yesOrNoList.size() == 0) {
                                    yesOrNoList.addAll(constants);

                                    if (isLicensed == null)
                                        isLicensed = "";

                                    if (isRegistered == null)
                                        isRegistered = "";

                                    if (isPolicy == null)
                                        isPolicy = "";

                                    if (isInternalSys == null)
                                        isInternalSys = "";
                                    if (isCertificatedYN == null)
                                        isCertificatedYN = "";
                                    creation.addRadioButtons(binding.rgIsLicensed, yesOrNoList, isLicensed);
                                    creation.addRadioButtons(binding.rgIsRegistration, yesOrNoList, isRegistered);
                                    creation.addRadioButtons(binding.rgInsurance, yesOrNoList, isPolicy);
                                    creation.addRadioButtons(binding.rgInternalSystem, yesOrNoList, isInternalSys);
                                    creation.addRadioButtons(binding.rgInternalSystemConfirm, yesOrNoList, isCertificatedYN);
                                }
                                break;

                            case "1650056":
                                if (workTimeList.size() == 0) {
                                    workTimeList.addAll(constants);
                                    creation.addRadioButtons(binding.rgConstructionWorkTime, workTimeList, workTimeId);
                                }
                                break;

                            case "67":
                                binding.edIncomeLevel.setEnabled(false);
                                showBtmSheet(R.string.construction_income_level, constantList, insuranceCompanies, binding.edIncomeLevel, "income");
                                break;

                            case "1750000":
                                licenseSides.addAll(constants);
                                if (sideType.equals("registration")) {
                                    binding.edRegistrationSide.setEnabled(false);
                                    showBtmSheet(R.string.registration_side, licenseSides, insuranceCompanies, binding.edRegistrationSide, "registration");
                                } else {
                                    binding.edLicensedSide.setEnabled(false);
                                    showBtmSheet(R.string.licensed_side, licenseSides, insuranceCompanies, binding.edLicensedSide, "license");
                                }
                                break;

                            case "1650424":
                                insuranceSide.addAll(constants);
                                binding.edInsuranceCompany.setEnabled(false);
                                showBtmSheet(R.string.insurance_company, insuranceSide, insuranceCompanies, binding.edInsuranceCompany, "insurance");

                                break;


                        }


                    } else {

                        Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }
    private boolean isEnabled = true;
    private void saveAction(String submit) {
        if (!isEnabled){
            Toast.makeText(getContext(), getString(R.string.can_not_change), Toast.LENGTH_SHORT).show();
        }
        else if (isLicensed == null || isRegistered == null || isPolicy == null || isInternalSys == null || workTimeId == null) {
            Toast.makeText(getContext(), getString(R.string.license_info_empty), Toast.LENGTH_SHORT).show();
        } else {
            if (isPolicy.equals("530001") && (policyId == null || binding.edInsuranceEndDate.getText().toString().isEmpty() || binding.edInsuranceNumber.getText().toString().isEmpty())) {
                Toast.makeText(getContext(), getString(R.string.insurance_empty), Toast.LENGTH_SHORT).show();

            } else {
                shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        if (submit.equals("submit_approve"))
                            isEnabled = false;
                        inspectionsViewModel.storeLicenseInfo("update", inspectionVisit.getCONSTRUCTID(), isPolicy, isRegistered, isLicensed,
                                binding.edInsuranceEndDate.getText().toString(), binding.edConstructionCapital.getText().toString(), "0", policyId, binding.edInsuranceNumber.getText().toString(), isInternalSys, isCertificatedYN, binding.edTotalWorkHour.getText().toString(), workTimeId, inComeId, inspectionVisit.getINSPECTVID(), submit);
                    }

                    @Override
                    public void edite(View view) {
                        shMyDialog.dismiss();

                    }
                }, getString(R.string.save_licensed_info), getString(R.string.save), getString(R.string.cancel));
                shMyDialog.show(getParentFragmentManager(), "dialog tag");
            }


        }
    }


    private void btnListener() {

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


        binding.btnSaveLicensed.setOnClickListener(view -> {
            if (licensedSideId == null) {
                Toast.makeText(getContext(), getString(R.string.license_side_empty), Toast.LENGTH_SHORT).show();
            } else
                inspectionsViewModel.storeLicenseSide(inspectionVisit.getCONSTRUCTID(), licensedSideId, binding.edLicensedNumber.getText().toString(), inspectionVisit.getINSPECTVID(), image);

        });


        binding.btnSaveRegistration.setOnClickListener(view -> {
            if (registeredSideId == null) {
                Toast.makeText(getContext(), getString(R.string.license_side_empty), Toast.LENGTH_SHORT).show();
            } else
                inspectionsViewModel.storeRegisteredSide(inspectionVisit.getCONSTRUCTID(), registeredSideId, binding.edRegistrationNumber.getText().toString(), inspectionVisit.getINSPECTVID(), registerFile);

        });
        binding.rgIsLicensed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)
                    isLicensed = (String) radioButton.getTag();


                if (isLicensed != null && isLicensed.equals("530002")) {
                    binding.edLicensedSide.setEnabled(false);
                    binding.edLicensedNumber.setEnabled(false);
                    binding.btnAddFile.setVisibility(View.GONE);
                    binding.btnSaveLicensed.setVisibility(View.GONE);
                } else {
                    binding.edLicensedSide.setEnabled(true);
                    binding.edLicensedNumber.setEnabled(true);
                    binding.btnAddFile.setVisibility(View.VISIBLE);
                    binding.btnSaveLicensed.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.btnAddFile.setOnClickListener(view -> {
                    fileType = "license";
                    if (NetworkUtils.isOnline(getContext()))
                        requestStoragePermission();
                    else
                        Toast.makeText(getContext(), getString(R.string.file_no_internet), Toast.LENGTH_SHORT).show();
                }
        );

        binding.btnAddFileInsurance.setOnClickListener(view -> {
                    fileType = "insurance";
                    if (NetworkUtils.isOnline(getContext()))
                        requestStoragePermission();
                    else
                        Toast.makeText(getContext(), getString(R.string.file_no_internet), Toast.LENGTH_SHORT).show();
                }
        );


        binding.btnAddFileRegistration.setOnClickListener(view -> {
                    fileType = "register";
                    if (NetworkUtils.isOnline(getContext()))
                        requestStoragePermission();
                    else
                        Toast.makeText(getContext(), getString(R.string.file_no_internet), Toast.LENGTH_SHORT).show();
                }
        );

        binding.rgIsRegistration.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)
                    isRegistered = (String) radioButton.getTag();


                if (isRegistered != null && isRegistered.equals("530002")) {
                    binding.edRegistrationSide.setEnabled(false);
                    binding.edRegistrationNumber.setEnabled(false);
                    binding.btnAddFileRegistration.setVisibility(View.GONE);
                    binding.btnSaveRegistration.setVisibility(View.GONE);
                } else {
                    binding.edRegistrationSide.setEnabled(true);
                    binding.edRegistrationNumber.setEnabled(true);
                    binding.btnAddFileRegistration.setVisibility(View.VISIBLE);
                    binding.btnSaveRegistration.setVisibility(View.VISIBLE);
                    binding.btnAddFileRegistration.setEnabled(NetworkUtils.isOnline(getContext()));

                }
            }
        });
        binding.rgInsurance.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)

                    isPolicy = (String) radioButton.getTag();

                if (isPolicy != null && isPolicy.equals("530002")) {
                    binding.edInsuranceCompany.setEnabled(false);
                    binding.edInsuranceEndDate.setEnabled(false);
                    binding.edInsuranceNumber.setEnabled(false);
                    binding.btnAddFileInsurance.setEnabled(false);
                } else {
                    binding.edInsuranceCompany.setEnabled(true);
                    binding.edInsuranceEndDate.setEnabled(true);
                    binding.edInsuranceNumber.setEnabled(true);
                    binding.btnAddFileInsurance.setEnabled(true);
                }

            }
        });


        binding.rgInternalSystem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)
                    isInternalSys = (String) radioButton.getTag();
                if (isInternalSys != null)
                    creation.Disable_Or_Enable_RG_Button(binding.rgInternalSystemConfirm, isInternalSys.equals("530001"));


            }
        });

        binding.rgInternalSystemConfirm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)
                    isCertificatedYN = (String) radioButton.getTag();

            }
        });


        binding.rgConstructionWorkTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)

                    workTimeId = (String) radioButton.getTag();

            }
        });

        binding.edInsuranceCompany.setOnClickListener(view -> {
            binding.edInsuranceCompany.setEnabled(false);
            getInsuranceCompanies();
        });

        binding.edIncomeLevel.setOnClickListener(view -> {
            getConstant("67");
        });

        binding.edLicensedSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sideType = "license";
                getConstant("1750000");
            }
        });


        binding.edRegistrationSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sideType = "registration";
                getConstant("1750000");
            }
        });
        binding.edInsuranceEndDate.setOnClickListener(view -> dateAdder.show());


    }


    public void showBtmSheet(int title, List<Constants> constants, List<InsuranceCompany> insuranceCompaniesList, TextView tv_change, String parentId) {

        this.parentId = parentId;

        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);


        if (parentId.equals("insurance")) {
            ArrayAdapter<InsuranceCompany> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, insuranceCompanies);
            bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
        } else {
            ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, constants);
            bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
        }

    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        binding.edInsuranceEndDate.setText(format.format(date));
    }

    private void requestStoragePermission() {

        Dexter.withContext(getContext())
                .withPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        // permission is granted
                        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                        chooseFile.setType("*/*");
                        chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                        startActivityForResult(chooseFile, 1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        // check for permanent denial of permission
                        if (response.isPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .check();
    }


    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {


                    fileUri = data.getData();

                    filePath = fileUri.getPath();
                    // file = new File(FileUtil.getPath(fileUri , getContext()));


                    String displayName = null;

                    if (fileUri.toString().startsWith("content://")) {
                        Cursor cursor = null;
                        try {
                            cursor = getActivity().getContentResolver().query(fileUri, null, null, null, null);
                            if (cursor != null && cursor.moveToFirst()) {
                                displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                            }
                        } finally {
                            cursor.close();
                        }
                    } else if (fileUri.toString().startsWith("file://")) {
                        displayName = file.getName();
                    }

//                    File file = new File(filePath);
//                    RequestBody requestFile =
//                            RequestBody.create(file, MediaType.parse("multipart/form-data"));
//                    image = MultipartBody.Part.createFormData("language_certificate", displayName, requestFile);

//                    file = new File(FileUtil.getPath(fileUri,getActivity()));

                    //file = FileUtil.getFile(getActivity(), fileUri);


                    // file = FileUtils.getFile(getContext() , fileUri);
                    file = new File(FileUtils.getPath(getActivity(), fileUri));

                    RequestBody requestFile = RequestBody.create(file, MediaType.parse("multipart/*"));

//                    requestFile =RequestBody.create(file,
//                            MediaType.parse(getActivity().getContentResolver().getType(fileUri))
//
//                    );
//                  image = new  MultipartBody.Builder()
//                            .addFormDataPart( "language_certificate",file.getName(), RequestBody.create(file,MediaType.parse("multipart/*")))
//
//                    .build();

                    int file_size = Integer.parseInt(String.valueOf((file.length() / 1024) / 1024));
                    if (file_size <= 2) {

                        if (fileType.equals("license"))
                            image = MultipartBody.Part.createFormData("license_file", file.getName(), requestFile);
                        else if (fileType.equals("register"))
                            registerFile = MultipartBody.Part.createFormData("register_file", file.getName(), requestFile);
                        else if (fileType.equals("insurance"))
                            insuranceFile = MultipartBody.Part.createFormData("register_file", file.getName(), requestFile);
                    } else
                        Toast.makeText(getContext(), getString(R.string.file_is_large), Toast.LENGTH_SHORT).show();


                    break;
                }
        }


    }

    private void getInsuranceCompanies() {
        if (insuranceCompanies.size() != 0) {
            showBtmSheet(R.string.insurance_company, constantList, insuranceCompanies, binding.edInsuranceCompany, "insurance");

        } else {
            inspectionsViewModel.getInsuranceCompanies().observe(getViewLifecycleOwner(), new Observer<List<InsuranceCompany>>() {
                @Override
                public void onChanged(List<InsuranceCompany> insuranceCompaniesList) {
                    if (insuranceCompaniesList != null) {
                        insuranceCompanies.addAll(insuranceCompaniesList);
                        showBtmSheet(R.string.insurance_company, constantList, insuranceCompanies, binding.edInsuranceCompany, "insurance");

                    }
                }
            });
        }
    }


    private void getConstructionLicenseSide() {
        if (NetworkUtils.isOnline(getContext())) {
            inspectionsViewModel.getConstructLicenseSide(inspectionVisit.getCONSTRUCTID()).observe(getViewLifecycleOwner(), new Observer<ConstructLicenceInfoModel>() {
                @Override
                public void onChanged(ConstructLicenceInfoModel constructLicenceInfoModel) {
                    if (constructLicenceInfoModel != null && constructLicenceInfoModel.getStatus() == 0) {
                        binding.tvConstructionLicenseSideEmpty.setVisibility(View.GONE);
                        ConstructRegisterSideAdapter constructRegisterSideAdapter = new ConstructRegisterSideAdapter(getContext(), null, constructLicenceInfoModel.getConstructLicenceInfo(), "license");
                        binding.rvLicenseSide.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.rvLicenseSide.setAdapter(constructRegisterSideAdapter);
                    } else
                        binding.rvLicenseSide.setVisibility(View.GONE);
                }
            });
        } else
            binding.tvConstructionLicenseSideEmpty.setText(getString(R.string.no_internet_to_show));

    }

    private void getConstructionRegisterSide() {
        if (NetworkUtils.isOnline(getContext())) {
            inspectionsViewModel.getConstructRegisterSide(inspectionVisit.getCONSTRUCTID()).observe(getViewLifecycleOwner(), new Observer<ConstructRegisterInfoModel>() {
                @Override
                public void onChanged(ConstructRegisterInfoModel constructRegisterInfoModel) {
                    if (constructRegisterInfoModel != null && constructRegisterInfoModel.getStatus() == 0) {
                        binding.tvConstructionRegistrationSideEmpty.setVisibility(View.GONE);
                        ConstructRegisterSideAdapter constructRegisterSideAdapter = new ConstructRegisterSideAdapter(getContext(), constructRegisterInfoModel.getConstructRegisterInfo(), null, "register");
                        binding.rvRegistrationSide.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.rvRegistrationSide.setAdapter(constructRegisterSideAdapter);
                    } else {
                        binding.rvRegistrationSide.setVisibility(View.GONE);
                    }
                }
            });
        } else
            binding.tvConstructionRegistrationSideEmpty.setText(getString(R.string.no_internet_to_show));
    }


    private void getLicensedDate() {

        if (construction != null) {
            if (construction.getCONSTRUCTISLICENCEID() != null)
                isLicensed = construction.getCONSTRUCTISLICENCEID();
            if (construction.getCONSTRUCTISREGISTERID() != null)

                isRegistered = construction.getCONSTRUCTISREGISTERID();
            if (construction.getCONSTRUCTHAVEPOLICYID() != null)

                isPolicy = construction.getCONSTRUCTHAVEPOLICYID();
            if (construction.getCONSTRUCTHAVEINTERNALSYS() != null)


                isInternalSys = construction.getCONSTRUCTHAVEINTERNALSYS();
            if (construction.getCONSTRUCTHAVEWORKAGREEID() != null)

                isCertificatedYN = construction.getCONSTRUCTHAVEWORKAGREEID();


            if (construction.getCONSTRUCTCAPITALBYDOLLAR() != null)

                binding.edConstructionCapital.setText(construction.getCONSTRUCTCAPITALBYDOLLAR());
            if (construction.getCONSTRUCTWORKTIMEID() != null)

                workTimeId = construction.getCONSTRUCTWORKTIMEID();

            if (construction.getCONSTRUCTINCOMELEVELID() != null)

                inComeId = construction.getCONSTRUCTINCOMELEVELID();
            if (inComeId != null)
                viewModel.getConstantName(inComeId, "67").observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s != null)
                            binding.edIncomeLevel.setText(s);
                    }
                });

        }

    }

    private void enable(boolean b) {
        binding.btnSaveWithApprove.setEnabled(b);
        binding.btnSave.setEnabled(b);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (parentId.equals("registration")) {
            registeredSideId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
        } else if (parentId.equals("license")) {
            licensedSideId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
        } else if (parentId.equals("insurance"))
            policyId = ((InsuranceCompany) adapterView.getItemAtPosition(i)).getPOLICYCD();

        else
            inComeId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();


    }
}



