package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.insertWorker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentWorkStatusWorkerBinding;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDesc;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDesc;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.viewmodel.AddPracticalStatusViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class WorkStatusWorkerFragment extends Fragment implements DateAdder.Listener , InsertWorkerFragment.GetData , BottomSheetDialogGeneral.BottomSheetInterface {


    FragmentWorkStatusWorkerBinding binding;

    private AddPracticalStatusViewModel mViewModel;




    private InspectionVisit inspectionVisit;
    private UserFileViewModel viewModel ;
    private InspectionsViewModel inspectionsViewModel ;
    private DateAdder dateAdder;
    private RadioButtonCreation creation ;
    private String jobId,skillLevelId , dateType,userSn, workStatusDescId, workStatusId, workStatusDescDescId , currencyId, workHoursId , workNatureId , haveCertificate , perExam , primExam;
    private List<WorkStatus> BSList;
    private List<WorkStatusDesc> workStatusDescs;
    private List<WorkStatusDescDesc> workStatusDescDescs;
    private BottomSheetDialog dialog;
    private List<Constants> constantsList , yesOrNoConstantList;

    private String type;


    private BottomSheetDialogGeneral bottomSheetDialogGeneral;

    private EditText ed_text;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private List<JobList> jobList;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;
    private Observer<List<JobList>> jobObserver;



    public WorkStatusWorkerFragment() {
        // Required empty public constructor
    }


    public static WorkStatusWorkerFragment newInstance() {
        WorkStatusWorkerFragment fragment = new WorkStatusWorkerFragment();

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
        binding =  FragmentWorkStatusWorkerBinding.inflate(inflater, container, false);

        InsertWorkerFragment.checkUSerSn = this;

        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);

        creation= new RadioButtonCreation(getContext());

        dateAdder =  new DateAdder(getActivity().getSupportFragmentManager(), this);



        yesOrNoConstantList = new ArrayList<>();
        getConstant("53");

        jobObserver = new Observer<List<JobList>>() {
            @Override
            public void onChanged(List<JobList> jobLists) {
                jobList = new ArrayList<>();
                if (jobLists != null) {
                    jobList.addAll(jobLists);

                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearshList.setBottomSheetDialog(dialog);
                    bottomSheetSearshList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());

                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object jobListModel) {
                            jobId = ((JobList) jobListModel).getId();
                            binding.edJob.setText(((JobList) jobListModel).getText());
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);

                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    jobLists.clear();
                    myTestAdapter.notifyDataSetChanged();
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        BSList = new ArrayList<>();
        workStatusDescs = new ArrayList<>();
        workStatusDescDescs = new ArrayList<>();
        mViewModel = new ViewModelProvider(this).get(AddPracticalStatusViewModel.class);

        getBundle();

        setUpData();

        btnListener();

        return binding.getRoot();
    }

    private void setUpData(){
        binding.edConstructionNo.setText(inspectionVisit.getCONSTRUCTNUM());
        binding.edDateVisit.setText(inspectionVisit.getVISITDATE());
        binding.edTvOfficialBusinessName.setText(inspectionVisit.getCONSTRUCTNAMEUSING());
       // binding.edOwnerSn.setText(inspectionVisit.get);
    }
    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);

        if (dateType.equals("visit")){
            binding.edDateVisit.setText(format.format(date));
        }else if (dateType.equals("start")){
            binding.edStartWorkDate.setText(format.format(date));
        }else if (dateType.equals("end")){
            binding.edEndWorkDate.setText(format.format(date));
        }else if (dateType.equals("leave")){
            binding.edLeaveDate.setText(format.format(date));
        }



    }

    public void getConstant(String parentId) {
        viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantsList = new ArrayList<>();
                if (constants != null) {
                    constantsList.addAll(constants);
                    if (parentId.equals("53")) {

                        if (yesOrNoConstantList.size() == 0) {
                            yesOrNoConstantList.addAll(constants);
                            creation.addRadioButtons(binding.rgPerExam, yesOrNoConstantList, "perExam");
                            creation.addRadioButtons(binding.rgPrimExam, yesOrNoConstantList, "primExam");
                            creation.addRadioButtons(binding.rgHaveCertificate, yesOrNoConstantList, "haveCertificate");
                        }
                    }else if (parentId.equals("56")){

                        showBtmSheet(R.string.currency_type, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edCurrencyType, true, parentId);
                    }else if (parentId.equals("34"))
                        showBtmSheet(R.string.payment_type, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edPaymentType, false, parentId);

                    else if(parentId.equals("26"))
                        showBtmSheet(R.string.type_of_contract, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edContractType, false, parentId);

                    else if (parentId.equals("66"))
                        showBtmSheet(R.string.skill_level, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edSkillLevel, false, parentId);


                } else {
                    Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void getBundle(){
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
            userSn = bundle.getString("userSn");
        }
    }

    private void btnListener(){
//        binding.edDateVisit.setOnClickListener(view -> {
//            dateType = "visit";
//            dateAdder.show();
//        });

        binding.edStartWorkDate.setOnClickListener(view -> {
            dateType = "start";
            dateAdder.show();
        });

        binding.edEndWorkDate.setOnClickListener(view -> {
            dateType = "end";
            dateAdder.show();
        });


        binding.edLeaveDate.setOnClickListener(view -> {
            dateType = "leave";
            dateAdder.show();
        });


        binding.edWorkStatusDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (workStatusId != null) {
                    binding.edWorkStatusDesc.setEnabled( false);
                    getWorkStatusDesc(workStatusId);
                } else
                    Toast.makeText(getContext(), getString(R.string.choose_work_status_first), Toast.LENGTH_SHORT).show();
            }
        });

        binding.edWorkStatus.setOnClickListener(view -> {
            binding.edWorkStatus.setEnabled( false);
            getWorkStatuses();
        });

        binding.edWorkStatusDescDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (workStatusDescId != null) {
                    binding.edWorkStatusDescDesc.setEnabled(false);
                    getWorkStatusDescDesc(workStatusDescId);
                } else
                    Toast.makeText(getContext(), getString(R.string.choose_work_status_first), Toast.LENGTH_SHORT).show();
            }
        });

        binding.edCurrencyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edCurrencyType.setEnabled( false);
                getConstant("56");
            }
        });

        binding.edContractType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edContractType.setEnabled( false);
                getConstant("26");
            }
        });

        binding.edPaymentType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edPaymentType.setEnabled( false);
                getConstant("34");
            }
        });

        binding.edSkillLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edSkillLevel.setEnabled( false);
                getConstant("66");
            }
        });

        binding.rgHaveCertificate.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);

            haveCertificate = (String) radioButton.getTag();


        });

        binding.rgPerExam.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);

            perExam = (String) radioButton.getTag();
        });

        binding.rgPrimExam.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            primExam = (String) radioButton.getTag();
        });


        binding.edJob.setOnClickListener(view -> showBottomSearchSheet(jobObserver));
    }



    private void getWorkStatuses() {
        if (BSList.size() == 0) {
            mViewModel.getAllWorkStatuses().observe(getViewLifecycleOwner(), workStatuses -> {
                BSList = new ArrayList<>();
                if (workStatuses != null) {
                    BSList.addAll(workStatuses);
                    showBtmSheet(R.string.practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edWorkStatus, true, "notDesc");

                } else {
                    binding.edWorkStatus.setEnabled( true);

                }

            });
        } else {
            showBtmSheet(R.string.practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edWorkStatus, true, "notDesc");

        }
    }

    public void showBtmSheet(int title, List<Constants> constants, List<WorkStatus> list, List<WorkStatusDesc> workStatusDescs, List<WorkStatusDescDesc> workStatusDescDescs, TextView tv_change, Boolean isWorkStatus, String type) {

        bottomSheetDialogGeneral  = new BottomSheetDialogGeneral(getContext() , this::onItemClick);

        this.type= type ;


        if (type.equals("notDesc")) {
            ArrayAdapter<WorkStatus> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

            bottomSheetDialogGeneral.openDialog(itemsAdapter , title , tv_change);
        } else if (type.equals("56") || type.equals("34") || type.equals("26") || type.equals("66")) {
            ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, constants);
            bottomSheetDialogGeneral.openDialog(itemsAdapter , title , tv_change);
        } else if (type.equals("descDesc")) {
            ArrayAdapter<WorkStatusDescDesc> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, workStatusDescDescs);
            bottomSheetDialogGeneral.openDialog(itemsAdapter , title , tv_change);
        } else {
            ArrayAdapter<WorkStatusDesc> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, workStatusDescs);
            bottomSheetDialogGeneral.openDialog(itemsAdapter , title , tv_change);
        }

    }

    private void getWorkStatusDesc(String workStatusId) {

        if (workStatusDescs.size() == 0) {
            mViewModel.getWorkStatusDesc(workStatusId).observe(getViewLifecycleOwner(), new Observer<WorkStatusDescModel>() {
                @Override
                public void onChanged(WorkStatusDescModel workStatusDescModel) {
                    workStatusDescs = new ArrayList<>();
                    if (workStatusDescModel != null) {
                        workStatusDescs.addAll(workStatusDescModel.getWorkStatusDescList());
                        showBtmSheet(R.string.describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edWorkStatusDesc, false, "desc");

                    } else {
                        binding.edWorkStatusDesc.setEnabled(true);

                    }
                }
            });
        } else {
            showBtmSheet(R.string.describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edWorkStatusDesc, false, "desc");

        }
    }


    private void getWorkStatusDescDesc(String workStatusDescId) {
        if (workStatusDescDescs.size() == 0) {
            mViewModel.getWorkStatusDescDesc(workStatusDescId).observe(getViewLifecycleOwner(), new Observer<WorkStatusDescDescModel>() {
                @Override
                public void onChanged(WorkStatusDescDescModel workStatusDescModel) {
                    workStatusDescDescs = new ArrayList<>();
                    if (workStatusDescModel != null) {
                        if (workStatusDescModel.getWorkStatusDescDesc() != null) {
                            workStatusDescDescs.addAll(workStatusDescModel.getWorkStatusDescDesc());
                            showBtmSheet(R.string.describe_describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edWorkStatusDescDesc, false, "descDesc");
                        }
                        //else
                        //showBtmSheet(R.string.training_course, experienceType, binding.etTrainingAuthority,parentId);

                    } else {
                        binding.edWorkStatusDescDesc.setEnabled(true);
                    }
                }
            });
        } else {
            showBtmSheet(R.string.describe_describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.edWorkStatusDescDesc, false, "descDesc");
        }
    }



    @Override
    public AddWorkerModel getAddWorker() {
        return new AddWorkerModel(inspectionVisit.getCONSTRUCTID(), userSn ,perExam , primExam , haveCertificate, workStatusId , workStatusDescId , workStatusDescDescId , binding.edStartWorkDate.getText().toString(),binding.edEndWorkDate.getText().toString(), binding.edLeaveDate.getText().toString() , binding.edLeaveWorkReason.getText().toString() , currencyId , binding.edSalary.getText().toString(),workHoursId,jobId,skillLevelId,workNatureId,inspectionVisit.getINSPECTVID() );
    }


    private void showBottomSearchSheet(Observer observer) {
        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(R.layout.bottom_sheet_training_program);
        ed_text = dialog.findViewById(R.id.search_view);
        bottomSheetSearshList = dialog.findViewById(R.id.recycler_view);
        imNoData = dialog.findViewById(R.id.image_no_data);
        progressBar = dialog.findViewById(R.id.progressbar);

        ed_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (ed_text.getText().toString().length() >= 3) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                        viewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);



                } else {
                    bottomSheetSearshList.clerList();
                    progressBar.setVisibility(View.GONE);
                    imNoData.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                BottomSheetSearchList.clerList();
            }
        });
        dialog.show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        switch (type) {
            case "notDesc":
                workStatusId = ((WorkStatus) adapterView.getItemAtPosition(i)).getWORKSTATUSID();

                workStatusDescDescs.clear();
                workStatusDescs.clear();
                binding.edWorkStatusDesc.setText("");
                binding.edWorkStatusDescDesc.setText("");
                workStatusDescDescId = null;
                workStatusDescId = null;
                break;
            case "descDesc":
                workStatusDescDescId = ((WorkStatusDescDesc) adapterView.getItemAtPosition(i)).getWORKDESCDESCID();
                break;
            case "desc":
                workStatusDescId = ((WorkStatusDesc) adapterView.getItemAtPosition(i)).getWorkDescId();
                break;
            case "56":
                currencyId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "34":
                workHoursId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "26":
                workNatureId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "66":
                skillLevelId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;

        }


    }
}