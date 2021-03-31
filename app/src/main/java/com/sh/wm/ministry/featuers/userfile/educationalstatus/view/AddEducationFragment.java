package com.sh.wm.ministry.featuers.userfile.educationalstatus.view;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.ConfirmDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.MonthYearPicker;
import com.sh.wm.ministry.databinding.FragmentAddEducationBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.UserEducationalStatus;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.viewmodel.AddEducationViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram.EduDepartmentsAndProgram;
import com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram.EduDepartmentsAndProgramModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddEducationFragment extends Fragment implements ConfirmDialog.Listener, DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface, BottomSheetSearch.BottomSheetSearchInterface{
    private AddEducationViewModel mViewModel;
    private FragmentAddEducationBinding binding;
    private ConfirmDialog confirmDialog;
    private OnFragmentInteractionListener mListener;

    private boolean isText, isGraduate, isCertificate = true;


    private String type , parentId, action, userEduId, countryId, educationalStatusId, eduTypeId, rateId, haveCertificate, institutesId, bottomSearchType, sepcId, qualificationId, qualificationDetailsId, programId, departmentId;
    private List<Constants> constantsList;
    private List<Country> countriesName;
    private List<EduQualification> eduQualificationsList;
    private List<EduQualificationDetail> eduQualificationDetailsList;
    private List<EduProgram> eduProgramsList;
    private List<Result> results;
    private Observer<ResultModel> resultModelObserver;
    private List<EduDepartmentsAndProgram> eduDepartments, eduPrograms;

    private DateAdder dateAdder;
    private Observer<List<Country>> countryObserver;
    private UserFileViewModel userFileViewModel;



    BottomSheetDialogGeneral bottomSheetDialogGeneral;
    BottomSheetSearch bottomSheetSearch;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);
        bottomSheetSearch = new BottomSheetSearch(getContext() ,this);


        mViewModel = new ViewModelProvider(this).get(AddEducationViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddEducationBinding.inflate(inflater, container, false);


        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        confirmDialog = new ConfirmDialog(this, getContext(), "");
        eduDepartments = new ArrayList<>();
        eduPrograms = new ArrayList<>();

        return binding.getRoot();
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        eduQualificationDetailsList = new ArrayList<>();
        eduQualificationsList = new ArrayList<>();
        getBundleData();

        btnListener();


        binding.btnSaveNewEducationAddEducation.setOnClickListener(view -> {
            confirmDialog.presentForList(getString(R.string.do_want_to_add_new_education));
        });


        resultModelObserver = resultModel -> {
            Log.d("aseel" , "onChange");
            results = new ArrayList<>();
            if (resultModel != null) {
                results.addAll(resultModel.getResults());
            }
            bottomSheetSearch.setUpAdapter(results , getActivity());
        };

        countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countriesName = new ArrayList<>();
                if (countries != null) {
                    countriesName.addAll(countries);
                    bottomSheetSearch.setUpAdapter(countriesName , getActivity());
                } else {
                    countriesName.clear();
                    bottomSheetSearch.notifyAdapter();
                }

            }
        };


    }


    private void setViewsVisibility(int status) {

        binding.tvEduStatus.setVisibility(status);
        binding.etEducationStatusEducatinalStatus.setVisibility(status);
        binding.tvQulification.setVisibility(status);
        binding.etQualification.setVisibility(status);
        binding.tvQualificationDetail.setVisibility(status);
        binding.etQualificationDetail.setVisibility(status);
        qualificationId = null;
        qualificationDetailsId = null;
        educationalStatusId = null;
        binding.etQualificationDetail.setText("");
        binding.etQualification.setText("");
        binding.etEducationStatusEducatinalStatus.setText("");



    }

    private void setAcademicVisibility(int status) {

        binding.etEducationalInstitution.setVisibility(status);
        binding.etEducationalInstitution.setText("");
        institutesId = null;

        binding.etTrainingProgramEdu.setVisibility(status);
        binding.etTrainingProgramEdu.setText("");
        programId = null;

        binding.etEducationSpecialization.setVisibility(status);
        binding.etEducationSpecialization.setText("");
        sepcId = null;


        binding.etEducationDepartment.setVisibility(status);
        binding.etEducationDepartment.setText("");
        departmentId = null;


        binding.etAvg.setVisibility(status);
        binding.etAvg.setText("");


        binding.etRating.setVisibility(status);
        binding.etRating.setText("");
        rateId = null;


        binding.etPracticingCertificate.setVisibility(status);

        binding.etPracticingCertificate.setText("");
        haveCertificate = null;

        binding.tvEducationalInstitution.setVisibility(status);
        binding.tvTrainningProgramEdu.setVisibility(status);
        binding.tvEducationSpecialization.setVisibility(status);
        binding.tvEducationDepartment.setVisibility(status);
        binding.tvAvg.setVisibility(status);
        binding.tvRating.setVisibility(status);

        binding.tvPracticingCertificate.setVisibility(status);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }

    @Override
    public void onOk() {

        if (eduTypeId != null) {
            switch (eduTypeId) {
                case "1370001":
                    isText = true;
                    isGraduate = true;
                    educationalStatusId = null;
                    institutesId = null;
                    qualificationId = null;
                    qualificationDetailsId = null;
                    programId = null;
                    departmentId = null;
                    sepcId = null;
                    binding.etGraduationYearEdu.setText("");
                    countryId = null;
                    binding.etAvg.setText("");
                    rateId = null;
                    haveCertificate = null;
                    binding.etCertificateNo.setText("");
                    binding.etCertificateYear.setText("");
                    break;

                case "1370002":
                    isText = educationalStatusId != null && qualificationId != null && qualificationDetailsId != null;

                    if (educationalStatusId != null && educationalStatusId.equals("1360001"))
                        isGraduate = countryId != null && !binding.etGraduationYearEdu.getText().toString().isEmpty();
                    else
                        isGraduate = true;

                    institutesId = null;
                    programId = null;
                    departmentId = null;
                    sepcId = null;
                    binding.etAvg.setText("");
                    rateId = null;
                    haveCertificate = null;
                    binding.etCertificateNo.setText("");
                    binding.etCertificateYear.setText("");
                    break;

                case "1370003":
                    isText = educationalStatusId != null && qualificationId != null && qualificationDetailsId != null;

                    if (educationalStatusId != null && educationalStatusId.equals("1360001"))
                        isGraduate = countryId != null && !binding.etGraduationYearEdu.getText().toString().isEmpty() && (rateId != null || !binding.etAvg.getText().toString().isEmpty());
                    else
                        isGraduate = true;
                    institutesId = null;
                    programId = null;
                    departmentId = null;
                    sepcId = null;
                    haveCertificate = null;
                    binding.etCertificateNo.setText("");
                    binding.etCertificateYear.setText("");
                    break;
                case "1370004":
                    isText = educationalStatusId != null && qualificationId != null && qualificationDetailsId != null && institutesId != null
                            && programId != null && departmentId != null && sepcId != null && (binding.etPracticingCertificate.getVisibility() == View.VISIBLE &&haveCertificate != null);

                    if (educationalStatusId != null && educationalStatusId.equals("1360001"))
                        isGraduate = countryId != null && !binding.etGraduationYearEdu.getText().toString().isEmpty();
                    else
                        isGraduate = true;
                    if (haveCertificate != null && haveCertificate.equals("530001"))
                        isCertificate = !binding.etCertificateNo.getText().toString().isEmpty() && !binding.etCertificateYear.getText().toString().isEmpty();

                    break;

                case "1370005":
                    isText = educationalStatusId != null && qualificationId != null && qualificationDetailsId != null && institutesId != null
                            && programId != null && departmentId != null && sepcId != null && haveCertificate != null;

                    if (educationalStatusId != null && educationalStatusId.equals("1360001"))
                        isGraduate = countryId != null && !binding.etGraduationYearEdu.getText().toString().isEmpty() && (rateId != null || !binding.etAvg.getText().toString().isEmpty());
                    else
                        isGraduate = true;

                    if (haveCertificate != null && haveCertificate.equals("530001"))
                        isCertificate = !binding.etCertificateNo.getText().toString().isEmpty() && !binding.etCertificateYear.getText().toString().isEmpty();

                    break;


            }


            if (rateId != null && !binding.etAvg.getText().toString().isEmpty())
                Toast.makeText(getContext(), getString(R.string.choose_avg_or_rating), Toast.LENGTH_SHORT).show();
            else if (isText && isGraduate && isCertificate) {
                binding.progress.setVisibility(View.VISIBLE);
                //disable user interaction when progress is visible
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                mViewModel.educationalStatusAction(action, SharedPreferneceHelper.getUserId(getContext()), userEduId, eduTypeId, educationalStatusId, institutesId, qualificationId, qualificationDetailsId, programId, departmentId, sepcId, binding.etGraduationYearEdu.getText().toString(), countryId, binding.etAvg.getText().toString(), rateId, haveCertificate, binding.etCertificateNo.getText().toString(), binding.etCertificateYear.getText().toString()).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel updateUser) {
                        binding.progress.setVisibility(View.GONE);
                        //enable user interaction when progress is visible
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                        if (updateUser != null) {

                            Toast.makeText(getContext(), updateUser.getMessage(), Toast.LENGTH_LONG).show();
                            if (updateUser.getStatus() != null && updateUser.getStatus().equals("0"))
                                mListener.onFragmentInteraction(50);
                        }
                    }
                });

            } else
                Toast.makeText(getContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();


        } else
            Toast.makeText(getContext(), getString(R.string.edu_type_empty), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onCancel() {

    }


    private void btnListener() {


        binding.etCertificateYear.setOnClickListener(view -> dateAdder.show());

        binding.etEducationTypeEducatinalStatus.setOnClickListener(view -> {
            getConstant("137");
        });


        binding.etQualificationDetail.setOnClickListener(view -> {
            if (eduTypeId != null)
                getEduQualificationDetails(eduTypeId, qualificationId);
            else
                Toast.makeText(getContext(), getString(R.string.edu_type_empty), Toast.LENGTH_SHORT).show();

        });

        binding.etEducationStatusEducatinalStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("136");
            }
        });

        binding.etRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("138");
            }
        });

        binding.etEducationalInstitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(resultModelObserver, "eduInstitute");
            }
        });

        binding.etGraduationCountryEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(countryObserver, "country");

            }
        });

        binding.etEducationSpecialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(resultModelObserver, "spec");
            }
        });
        binding.etQualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eduTypeId != null)
                    getEduQualification(eduTypeId);
                else
                    Toast.makeText(getContext(), getString(R.string.edu_type_empty), Toast.LENGTH_SHORT).show();
            }
        });


        binding.etPracticingCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("53");
            }
        });


        binding.etTrainingProgramEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sepcId == null)
                    Toast.makeText(getContext(), getString(R.string.edu_department_empty), Toast.LENGTH_SHORT).show();
                else
                    showBtmSheet(R.string.acadmic_programs, constantsList, eduQualificationsList, eduQualificationDetailsList, eduPrograms, eduProgramsList, binding.etEducationDepartment, "Program");
            }
        });

        binding.etEducationDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sepcId == null)
                    Toast.makeText(getContext(), getString(R.string.edu_department_empty), Toast.LENGTH_SHORT).show();
                else
                    showBtmSheet(R.string.department, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etEducationDepartment, "department");
            }
        });


    }


    public void getConstant(String parentId) {
        constantsList = new ArrayList<>();
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                if (constants != null) {
                    constantsList = new ArrayList<>();
                    constantsList.addAll(constants);
                    switch (parentId) {
                        case "137":
                            showBtmSheet(R.string.kind_of_education, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etEducationTypeEducatinalStatus, parentId);
                            break;
                        case "138":
                            showBtmSheet(R.string.rating, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etRating, parentId);
                            break;
                        case "53":
                            showBtmSheet(R.string.have_certificate, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etPracticingCertificate, parentId);
                            break;
                        default:
                            showBtmSheet(R.string.educational_status, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etEducationStatusEducatinalStatus, parentId);
                            break;
                    }


                }
            }
        });
    }


    public void getEduQualification(String educationalStatusId) {

        eduQualificationsList = new ArrayList<>();

        mViewModel.getEduQualification(educationalStatusId).observe(getViewLifecycleOwner(), new Observer<List<EduQualification>>() {
            @Override
            public void onChanged(List<EduQualification> eduQualifications) {
                if (eduQualifications != null) {
                    if (bottomSheetDialogGeneral.getCount() == 0){
                        eduQualificationsList.addAll(eduQualifications);
                        showBtmSheet(R.string.qualification, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etQualification, "eduQualification");
                    }

                }
            }
        });
    }


    public void getEduQualificationDetails(String educationalStatusId, String qualificationId) {
        eduQualificationDetailsList = new ArrayList<>();
        mViewModel.getAllEduQualificationDetail(educationalStatusId).observe(getViewLifecycleOwner(), new Observer<List<EduQualificationDetail>>() {
            @Override
            public void onChanged(List<EduQualificationDetail> eduQualifications) {


                if (bottomSheetDialogGeneral.getCount() == 0){
                if (eduQualifications != null) {
                    eduQualificationDetailsList.clear();

                    if (qualificationId != null) {


                        for (EduQualificationDetail eduQualificationDetail : eduQualifications) {
                            if (eduQualificationDetail.getQUALID().equals(qualificationId)) {
                                eduQualificationDetailsList.add(eduQualificationDetail);
                            }
                        }
                        if (eduQualificationDetailsList.size() == 0)
                            eduQualificationDetailsList.addAll(eduQualifications);

                    } else
                        eduQualificationDetailsList.addAll(eduQualifications);
                    showBtmSheet(R.string.qualification_detail, constantsList, eduQualificationsList, eduQualificationDetailsList, eduDepartments, eduProgramsList, binding.etQualificationDetail, "eduQualificationDetails");
                }

                } else {
                    //Toast.makeText(getContext(), getString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void showBtmSheet(int title, List<Constants> list, List<EduQualification> eduQualifications, List<EduQualificationDetail> eduQualificationDetailsList, List<EduDepartmentsAndProgram> eduDepartments, List<EduProgram> eduPrograms, TextView tv_change, String parentId) {



        this.parentId = parentId;


        switch (parentId) {
            case "eduQualification": {
                ArrayAdapter<EduQualification> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, eduQualifications);
                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);

                break;
            }
            case "eduProgram": {
                ArrayAdapter<EduProgram> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, eduPrograms);
                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
                break;
            }
            case "eduQualificationDetails": {

                ArrayAdapter<EduQualificationDetail> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, eduQualificationDetailsList);
                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);


                break;
            }
            case "department": {
                ArrayAdapter<EduDepartmentsAndProgram> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, eduDepartments);

                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
                break;
            }
            case "Program":{
                ArrayAdapter<EduDepartmentsAndProgram> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, this.eduPrograms);

                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
                break;
            }


            case "136":
            case "138" :
            case "137":
            case "53": {


                if (parentId.equals("138")) {
                    Constants constants1 = new Constants();
                    constants1.setCONSTANTARANAME(getString(R.string.choose_rate));
                    list.add(constants1);
                }


                ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
                break;
            }
        }


    }

    private void setAvgRatingVisibility(int status) {
        binding.tvAvg.setVisibility(status);
        binding.etAvg.setVisibility(status);
        binding.tvRating.setVisibility(status);
        binding.etRating.setVisibility(status);
    }

    private void showBottomSearchSheet(Observer observer, String train) {

        this.type = train;
        results = new ArrayList<>();
        bottomSheetSearch.openDialog(observer);

        if (train.equals("country")) {
            bottomSearchType = "country";
            userFileViewModel.getCountry().observe(getViewLifecycleOwner(), observer);
        }
    }

    private void getBundleData() {
        Bundle bundle = this.getArguments();

        if (bundle != null) {

            if (bundle.getSerializable("type") !=null && bundle.getSerializable("type").equals("view")){
                binding.btnSaveNewEducationAddEducation.setVisibility(View.GONE);
                binding.etEducationTypeEducatinalStatus.setEnabled(false);
                binding.etEducationStatusEducatinalStatus.setEnabled(false);
                binding.etQualification.setEnabled(false);
                binding.etQualificationDetail.setEnabled(false);
                binding.etEducationalInstitution.setEnabled(false);
                binding.etTrainingProgramEdu.setEnabled(false);
                binding.etEducationSpecialization.setEnabled(false);
                binding.etEducationDepartment.setEnabled(false);
                binding.etAvg.setEnabled(false);
                binding.etRating.setEnabled(false);
                binding.etGraduationYearEdu.setEnabled(false);
                binding.etGraduationCountryEdu.setEnabled(false);
                binding.etPracticingCertificate.setEnabled(false);
                binding.etCertificateNo.setEnabled(false);
                binding.etCertificateYear.setEnabled(false);

            }

            UserEducationalStatus userEducationalStatus = (UserEducationalStatus) bundle.getSerializable("eduStatus");

            action = "update";
            userEduId = userEducationalStatus.getUSEREDUID();

            eduTypeId = userEducationalStatus.getUSEREDUTYPEID();
            binding.etEducationTypeEducatinalStatus.setText(userEducationalStatus.getEDUTYPE());

            setEduTypeAction(eduTypeId);


            binding.etEducationStatusEducatinalStatus.setText(userEducationalStatus.getEDUSTATUS());
            educationalStatusId = userEducationalStatus.getUSEREDUSTATUSID();

            if (educationalStatusId.equals("1360001")) {
                setGraduationVisibility(View.VISIBLE);

            }

            binding.etQualification.setText(userEducationalStatus.getQULNAME());
            qualificationId = userEducationalStatus.getUSEREDUQUALIFICATIONID();

            binding.etQualificationDetail.setText(userEducationalStatus.getQULDETAILSNAME());
            qualificationDetailsId = userEducationalStatus.getUSEREDUQUALIFICATIONDESC();

            binding.etEducationalInstitution.setText(userEducationalStatus.getUSEREDUINSTITUTION());
            institutesId = userEducationalStatus.getUSEREDUINSTITUTIONID();

            binding.etTrainingProgramEdu.setText(userEducationalStatus.getUSEREDUPROGRAM());
            programId = userEducationalStatus.getUSEREDUPROGRAMID();

            binding.etEducationSpecialization.setText(userEducationalStatus.getSPECILIZATIONNAME());
            sepcId = userEducationalStatus.getUSEREDUSPECILIZATIONID();



            binding.etEducationDepartment.setText(userEducationalStatus.getUSEREDUDEPARTMENT());
            departmentId = userEducationalStatus.getUSEREDUDEPARTMENTID();

            if (sepcId != null ) {
                if (departmentId != null) {
                    eduDepartments.add(new EduDepartmentsAndProgram(departmentId, userEducationalStatus.getUSEREDUDEPARTMENT()));
                }
                if (programId != null)
                    eduPrograms.add(new EduDepartmentsAndProgram(programId, userEducationalStatus.getUSEREDUPROGRAM()));

            }


            binding.etAvg.setText(userEducationalStatus.getUSEREDUAVERAGE());

            binding.etRating.setText(userEducationalStatus.getUSEREDURATE());
            rateId = userEducationalStatus.getUSEREDURATEID();

            binding.etGraduationYearEdu.setText(userEducationalStatus.getUSEREDUGRADUATIONYEAR());

            binding.etGraduationCountryEdu.setText(userEducationalStatus.getUSEREDUGRADUATIONCOUNTRY());
            countryId = userEducationalStatus.getUSEREDUGRADUATIONCOUNTRYID();

            haveCertificate = userEducationalStatus.getUSEREDULICENSEYESNO();
            if (haveCertificate != null) {
                switch (haveCertificate) {
                    case "530001":
                        binding.etPracticingCertificate.setText(getString(R.string.yes));
                        binding.bottomContainer.setVisibility(View.VISIBLE);
                        break;
                    case "530002":
                        binding.etPracticingCertificate.setText(getString(R.string.no));
                        binding.bottomContainer.setVisibility(View.GONE);
                        break;
                }
            }


            binding.etCertificateNo.setText(userEducationalStatus.getUSEREDULICENSECERTIFICATIONNO());


            if (userEducationalStatus.getUSEREDULICENSECERTIFICATIONDATE() != null) {
                try {
                    String date = userEducationalStatus.getUSEREDULICENSECERTIFICATIONDATE();
                    SimpleDateFormat spf = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
                    Date newDate = spf.parse(date);
                    spf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    date = spf.format(newDate);

                    binding.etCertificateYear.setText(date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


        } else {
            action = "insert";
            setAcademicVisibility(View.GONE);
        }
    }



    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        binding.etCertificateYear.setText(format.format(date));
    }


    private void setEduTypeAction(String eduTypeId) {
        switch (eduTypeId) {
            case "1370001":/// بدون
                setViewsVisibility(View.GONE);
                setAcademicVisibility(View.GONE);
                binding.bottomContainer.setVisibility(View.GONE);
                setGraduationVisibility(View.GONE);

                break;
            case "1370003": //tawjihi
                setViewsVisibility(View.VISIBLE);
                setAcademicVisibility(View.GONE);
                binding.bottomContainer.setVisibility(View.GONE);
                setAvgRatingVisibility(View.VISIBLE);
                setGraduationVisibility(View.GONE);

                break;
            case "1370002":  // basics
                setViewsVisibility(View.VISIBLE);
                setAcademicVisibility(View.GONE);
                binding.bottomContainer.setVisibility(View.GONE);
                binding.bottomContainer.setVisibility(View.GONE);
                setGraduationVisibility(View.GONE);
                break;
            case "1370005":  // academic
                setViewsVisibility(View.VISIBLE);
                setAcademicVisibility(View.VISIBLE);
                setAvgRatingVisibility(View.VISIBLE);
                break;
            default:
                setViewsVisibility(View.VISIBLE);
                setAcademicVisibility(View.VISIBLE);
                binding.etPracticingCertificate.setVisibility(View.VISIBLE);
                binding.tvPracticingCertificate.setVisibility(View.VISIBLE);
                setAvgRatingVisibility(View.GONE);
                break;
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

    private void setGraduationVisibility(int status) {
        binding.tvGraduationYearEdu.setVisibility(status);
        binding.etGraduationYearEdu.setVisibility(status);
        binding.tvGraduationCountryEdu.setVisibility(status);
        binding.etGraduationCountryEdu.setVisibility(status);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (parentId.equals("137")) {
            eduTypeId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
            setEduTypeAction(eduTypeId);
            eduQualificationDetailsList.clear();
            eduQualificationsList.clear();
        } else if (parentId.equals("136")) {
            educationalStatusId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
            if (educationalStatusId.equals("1360002")) {
                binding.etAvg.setEnabled(false);
                binding.etRating.setEnabled(false);

                binding.etPracticingCertificate.setVisibility(View.GONE);
                binding.tvPracticingCertificate.setVisibility(View.GONE);
                binding.bottomContainer.setVisibility(View.GONE);
                binding.etGraduationYearEdu.setText("");
                countryId = null;

                setGraduationVisibility(View.GONE);
                binding.etGraduationCountryEdu.setText("");
            } else {
                binding.etAvg.setEnabled(true);
                binding.etRating.setEnabled(true);
                if (eduTypeId != null && (eduTypeId.equals("1370004") || eduTypeId.equals("1370005"))) {
                    binding.etPracticingCertificate.setVisibility(View.VISIBLE);
                    binding.tvPracticingCertificate.setVisibility(View.VISIBLE);

                    if (haveCertificate != null && haveCertificate.equals("530001"))
                        binding.bottomContainer.setVisibility(View.VISIBLE);

                }
                setGraduationVisibility(View.VISIBLE);
            }


        } else if (parentId.equals("53")) {
            haveCertificate = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
            switch (haveCertificate) {
                case "530001":
                    binding.bottomContainer.setVisibility(View.VISIBLE);
                    break;
                case "530002":
                    binding.bottomContainer.setVisibility(View.GONE);
                    break;
            }
        } else if (parentId.equals("country")) {
            countryId = ((Country) adapterView.getItemAtPosition(i)).getCDCDNEW();

        } else if (parentId.equals("eduQualificationDetails")) {

            qualificationDetailsId = ((EduQualificationDetail) adapterView.getItemAtPosition(i)).getQUALDETAILSID();

        } else if (parentId.equals("eduQualification")) {
            qualificationId = ((EduQualification) adapterView.getItemAtPosition(i)).getqUALIFICATIONID();
            qualificationDetailsId  = null;
            eduQualificationsList.clear();


        } else if (parentId.equals("138")) {
            if (((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID() != null)
                rateId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
            else {
                rateId = null;
                binding.etRating.setText("");
            }
        }


    }


    @Override
    public void observerAction(Object object) {
        if (type.equals("spec")) {
            sepcId = ((Result) object).getId();
            eduPrograms = new ArrayList<>();
            eduDepartments = new ArrayList<>();
            binding.etEducationSpecialization.setText(((Result) object).getText());
            mViewModel.getEduDepartmentsAndProgram(sepcId).observe(getViewLifecycleOwner(), new Observer<EduDepartmentsAndProgramModel>() {
                @Override
                public void onChanged(EduDepartmentsAndProgramModel eduDepartmentsAndProgramModel) {

                    if (eduDepartmentsAndProgramModel != null) {
                        departmentId = eduDepartmentsAndProgramModel.getEduDepartmentsAndProgram().get(1).getDEPCD();
                        binding.etEducationDepartment.setText(eduDepartmentsAndProgramModel.getEduDepartmentsAndProgram().get(1).getDEPDESC());
                        eduDepartments.add(eduDepartmentsAndProgramModel.getEduDepartmentsAndProgram().get(1));

                        programId = eduDepartmentsAndProgramModel.getEduDepartmentsAndProgram().get(0).getDEPCD();
                        binding.etTrainingProgramEdu.setText(eduDepartmentsAndProgramModel.getEduDepartmentsAndProgram().get(0).getDEPDESC());
                        eduPrograms.add(eduDepartmentsAndProgramModel.getEduDepartmentsAndProgram().get(0));

                    }
                }
            });


        }else if(type.equals("country")){
            countryId = ((Country) object).getCDCDNEW();
            binding.etGraduationCountryEdu.setText(((Country) object).getCDARBTR());
        }
        else {
            institutesId = ((Result) object).getId();
            binding.etEducationalInstitution.setText(((Result) object).getText());

        }

    }

    @Override
    public void etLengthMoreThan3(EditText ed_text, Observer observer) {
        if (type.equals("eduInstitute")) {
            bottomSearchType = "eduInstitute";
            mViewModel.getEducationalInstitute(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

        } else if (type.equals("country")) {
            bottomSearchType = "country";
            userFileViewModel.getCountry(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
        } else {
            bottomSearchType = "spec";
            mViewModel.getEducationalSpec(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

        }

    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {
        if (ed_text.getText().toString().isEmpty()){
            results.clear();
            bottomSheetSearch.setViewVisibility();
        }


    }
}


