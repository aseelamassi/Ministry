package com.sh.wm.ministry.featuers.userfile.practicalstatus.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentAddPracticalStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.UserWorkStatus;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDesc;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDesc;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.viewmodel.AddPracticalStatusViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class AddPracticalStatusFragment extends Fragment implements DateAdder.Listener {

    private AddPracticalStatusViewModel mViewModel;
    private FragmentAddPracticalStatusBinding binding;
    private List<WorkStatus> BSList;
    private ShMyDialog shMyDialog;
    private List<Constants> constantsList;
    private OnFragmentInteractionListener mListener;

    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;
    private long startDate;
    private String startOrEnd, jobId, jobOrTrainingInstitutes, workStatusDescId, workStatusId, workStatusDescDescId;
    private String currencyId, workHoursId, workNatureId;

    private BottomSheetDialog dialog;
    private EditText ed_text;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private List<JobList> jobList;
    private List<WorkStatusDesc> workStatusDescs;
    private List<WorkStatusDescDesc> workStatusDescDescs;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;

    private Observer<List<JobList>> jobObserver;

    private Observer<ConstructByName> constructByNameObserver;

    private UserFileViewModel userFileViewModel;

    private UserWorkStatus workStatus;

    private String constructId;

    private String type;

    public static AddPracticalStatusFragment newInstance() {
        return new AddPracticalStatusFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentAddPracticalStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BSList = new ArrayList<>();
        workStatusDescs = new ArrayList<>();
        workStatusDescDescs = new ArrayList<>();
        mViewModel = new ViewModelProvider(this).get(AddPracticalStatusViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);


        //date
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();


        //observers
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
                            binding.tvJob.setText(((JobList) jobListModel).getText());
                            jobId = ((JobList) jobListModel).getId();
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


        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    bottomSheetSearshList.setMyList(constructByName.getConstructs(), "construct");
                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearshList.setBottomSheetDialog(dialog);
                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(constructByName1 -> {
                        binding.tvEnterprise.setText(((Construct) constructByName1).getCONSTRUCTNAMEUSING());
                        constructId = ((Construct) constructByName1).getCONSTRUCTID();
                        ed_text.setText("");
                        imNoData.setVisibility(View.VISIBLE);
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        getBundleData();


        if (workStatus != null) {

            binding.tvPracticalStatus.setText(workStatus.getWORKSTATUS());
            binding.tvDescribePracticalStatus.setText(workStatus.getWORKSTATUSDESC());
            binding.tvDescribeDescribePracticalStatus.setText(workStatus.getWORKSTATUSDESCDESC());

            if (workStatus.getUSERWORKSTATUSID().equals("1")) {
                binding.LLPracticalStatus.setVisibility(View.VISIBLE);

                binding.tvEnterprise.setText(workStatus.getUSERWORKCONSTRUCTION());
                binding.tvWorkBeginningDate.setText(workStatus.getUSERWORKSTARTDATEOUT());
                binding.tvWorkEndingDate.setText(workStatus.getUSERWORKENDDATEOUT());
                binding.tvMonthlyWage.setText(workStatus.getUSERWORKSALARY());
                binding.tvNotesAddWorkExperience.setText(workStatus.getUSERWORKLEFTREASON());


            }


        }


        btnListener();

    }

    public void btnListener() {

        binding.btnSaveAddLanguage.setOnClickListener(view -> {


            if (workStatusId == null || workStatusDescId == null || workStatusDescDescId == null) {
                Toast.makeText(getContext(), getString(R.string.update_practical_status_empty), Toast.LENGTH_SHORT).show();
            } else {
                if (binding.LLPracticalStatus.getVisibility() == View.VISIBLE && (binding.tvNotesAddWorkExperience.getText().toString().isEmpty() || constructId == null || jobId == null || binding.tvWorkBeginningDate.getText().toString().isEmpty() || currencyId == null || workHoursId == null || workNatureId == null || binding.tvMonthlyWage.getText().toString().isEmpty())) {
                    Toast.makeText(getContext(), getString(R.string.update_practical_status_empty), Toast.LENGTH_SHORT).show();
                } else {
                    shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {

                            binding.progress.setVisibility(View.VISIBLE);
                            mViewModel.updateWorkStatus(workStatus.getUSERWORKID(), workStatusId, workStatusDescId, workStatusDescDescId, binding.tvWorkBeginningDate.getText().toString(), binding.tvWorkEndingDate.getText().toString(), binding.tvNotesAddWorkExperience.getText().toString(), binding.tvMonthlyWage.getText().toString(), currencyId, workHoursId, workNatureId, jobId, constructId).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                                @Override
                                public void onChanged(ActionModel actionModel) {
                                    if (actionModel != null){
                                        binding.progress.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();
                                        mListener.onFragmentInteraction(101);
                                    }
                                }
                            });

                            shMyDialog.dismiss();
                        }

                        @Override
                        public void edite(View view) {
                            shMyDialog.dismiss();
                        }
                    }, getString(R.string.update_practical_status_confirm), getString(R.string.save), getString(R.string.cancel));
                    shMyDialog.show(getParentFragmentManager(), "dialog tag");
                }
            }


        });


        binding.tvEnterprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEnabled(binding.tvEnterprise, false);
                showBottomSearchSheet(constructByNameObserver, "construct");
            }
        });

        binding.tvJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setEnabled(binding.tvJob, false);
                showBottomSearchSheet(jobObserver, "job");
            }
        });


        binding.tvWorkBeginningDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "start";
                dateAdder.show();
            }
        });

        binding.tvWorkEndingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "end";
                dateAdder.show();
            }
        });

        binding.tvDescribePracticalStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (workStatusId != null) {
                    setEnabled(binding.tvDescribePracticalStatus, false);
                    getWorkStatusDesc(workStatusId);
                } else
                    Toast.makeText(getContext(), getString(R.string.choose_work_status_first), Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvPracticalStatus.setOnClickListener(view -> {
            setEnabled(binding.tvPracticalStatus, false);
            getWorkStatuses();
        });

        binding.tvDescribeDescribePracticalStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (workStatusDescId != null) {
                    setEnabled(binding.tvDescribeDescribePracticalStatus, false);
                    getWorkStatusDescDesc(workStatusDescId);
                } else
                    Toast.makeText(getContext(), getString(R.string.choose_work_status_first), Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvCurrencyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEnabled(binding.tvCurrencyType, false);
                getConstant("56");
            }
        });

        binding.tvWorkHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEnabled(binding.tvWorkHours, false);
                getConstant("34");
            }
        });


        binding.tvWorkNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setEnabled(binding.tvWorkNature, false);
                getConstant("26");
            }
        });


    }


    private void getWorkStatuses() {
        if (BSList.size() == 0) {
            mViewModel.getAllWorkStatuses().observe(getViewLifecycleOwner(), workStatuses -> {
                BSList = new ArrayList<>();
                if (workStatuses != null) {
                    BSList.addAll(workStatuses);
                    showBtmSheet(R.string.practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvPracticalStatus, true, "notDesc");

                } else {
                    setEnabled(binding.tvPracticalStatus, true);

                }

            });
        } else {
            showBtmSheet(R.string.practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvPracticalStatus, true, "notDesc");

        }
    }


    private void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {

            if (bundle.getString("type") != null)
                binding.btnSaveAddLanguage.setVisibility(View.GONE);
            workStatus = (UserWorkStatus) bundle.getSerializable("workStatus");
            binding.tvPracticalStatus.setText(workStatus.getWORKSTATUS());
            workStatusId = workStatus.getUSERWORKSTATUSID();
            if (workStatus.getWORKSTATUS().equals("يعمل") || workStatus.getUSERWORKSTATUSID().equals("2")) {
                binding.LLPracticalStatus.setVisibility(View.GONE);
            }

            binding.tvDescribePracticalStatus.setText(workStatus.getWORKSTATUSDESC());
            workStatusDescId = workStatus.getUSERWORKSTATUSDESCID();
            binding.tvDescribeDescribePracticalStatus.setText(workStatus.getWORKSTATUSDESCDESC());
            workStatusDescDescId = workStatus.getUSERWORKDESCDESCID();

            binding.tvEnterprise.setText(workStatus.getUSERWORKCONSTRUCTION());
            constructId = workStatus.getUSERWORKCONSTRUCTIONID();


            binding.tvJob.setText(workStatus.getUSERWORKJOBTITLE());
            jobId = workStatus.getUSERWORKJOBTITLEID();

            binding.tvCurrencyType.setText(workStatus.getUSERWORKCURRENCYTYPE());
            binding.tvWorkNature.setText(workStatus.getUSERWORKNATURE());
            binding.tvWorkHours.setText(workStatus.getUSERWORKHOURSTYPE());




        }
    }

    private void setEnabled(View view, boolean isEnabled) {
        view.setEnabled(isEnabled);
    }

    public void showBtmSheet(int title, List<Constants> constants, List<WorkStatus> list, List<WorkStatusDesc> workStatusDescs, List<WorkStatusDescDesc> workStatusDescDescs, TextView tv_change, Boolean isWorkStatus, String type) {

        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(R.layout.bottom_sheet_view);
        BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
        MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
        titleTv.setText(title);

        if (type.equals("notDesc")) {
            ArrayAdapter<WorkStatus> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
            listView.setAdapter(itemsAdapter);
        } else if (type.equals("56") || type.equals("34") || type.equals("26")) {
            ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, constants);
            listView.setAdapter(itemsAdapter);
        } else if (type.equals("descDesc")) {
            ArrayAdapter<WorkStatusDescDesc> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, workStatusDescDescs);
            listView.setAdapter(itemsAdapter);
        } else {
            ArrayAdapter<WorkStatusDesc> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, workStatusDescs);
            listView.setAdapter(itemsAdapter);
        }

        dialog.show();

        listView.setOnItemClickListener((adapterView, view, i, l) -> {

            dialog.dismiss();
            switch (type) {
                case "notDesc":
                    workStatusId = ((WorkStatus) adapterView.getItemAtPosition(i)).getWORKSTATUSID();

                    workStatusDescDescs.clear();
                    workStatusDescs.clear();
                    binding.tvDescribePracticalStatus.setText("");
                    binding.tvDescribeDescribePracticalStatus.setText("");
                    workStatusDescDescId = null;
                    workStatusDescId = null;
                    if (isWorkStatus) {
                        if (adapterView.getItemAtPosition(i).toString().equals(getResources().getString(R.string.works))) {
                            binding.LLPracticalStatus.setVisibility(View.VISIBLE);
                        } else {
                            binding.LLPracticalStatus.setVisibility(View.INVISIBLE);
                            currencyId = null;
                            workHoursId = null;
                            workNatureId = null;
                            constructId = null;
                            jobId = null;
                            binding.tvEnterprise.setText("");
                            binding.tvNotesAddWorkExperience.setText("");
                            binding.tvWorkBeginningDate.setText("");
                            binding.tvWorkEndingDate.setText("");
                            binding.tvJob.setText("");
                            binding.tvMonthlyWage.setText("");
                            binding.tvCurrencyType.setText("");
                            binding.tvWorkHours.setText("");
                            binding.tvWorkNature.setText("");

                        }


                    }
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

            }


            tv_change.setText(adapterView.getItemAtPosition(i).toString());
            listView.setAdapter(null);

        });

        setEnabled(tv_change, true);

    }


    @Override
    public void onDateTimeChosen(long timeChosen) {

        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
        chosenTime = timeChosen;
        if (startOrEnd.equals("start")) {
            startDate = chosenTime;
            binding.tvWorkBeginningDate.setText(format.format(date));
        } else {
            binding.tvWorkEndingDate.setText(format.format(date));
        }

    }


    private void showBottomSearchSheet(Observer observer, String train) {
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
                    if (train.equals("job")) {
                        userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
                    } else {
                        mViewModel.getConstruct(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
//
                    }

                } else {
                    BottomSheetSearchList.clerList();
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


    private void getWorkStatusDesc(String workStatusId) {

        if (workStatusDescs.size() == 0) {
            mViewModel.getWorkStatusDesc(workStatusId).observe(getViewLifecycleOwner(), new Observer<WorkStatusDescModel>() {
                @Override
                public void onChanged(WorkStatusDescModel workStatusDescModel) {
                    workStatusDescs = new ArrayList<>();
                    if (workStatusDescModel != null) {
                        workStatusDescs.addAll(workStatusDescModel.getWorkStatusDescList());
                        showBtmSheet(R.string.describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvDescribePracticalStatus, false, "desc");
                        //else
                        //showBtmSheet(R.string.training_course, experienceType, binding.etTrainingAuthority,parentId);

                    } else {
                        setEnabled(binding.tvDescribePracticalStatus, true);

                    }
                }
            });
        } else {
            showBtmSheet(R.string.describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvDescribePracticalStatus, false, "desc");

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
                            showBtmSheet(R.string.describe_describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvDescribeDescribePracticalStatus, false, "descDesc");
                        }
                        //else
                        //showBtmSheet(R.string.training_course, experienceType, binding.etTrainingAuthority,parentId);

                    } else {
                        setEnabled(binding.tvDescribeDescribePracticalStatus, true);
                    }
                }
            });
        } else {
            showBtmSheet(R.string.describe_describe_practical_status, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvDescribeDescribePracticalStatus, false, "descDesc");
        }
    }


    public void getConstant(String parentId) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantsList = new ArrayList<>();
                if (constants != null) {
                    constantsList.addAll(constants);
                    if (parentId.equals("56"))
                        showBtmSheet(R.string.currency_type, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvCurrencyType, true, parentId);
                    else if (parentId.equals("34"))
                        showBtmSheet(R.string.work_hours, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvWorkHours, false, parentId);
                    else
                        showBtmSheet(R.string.work_nature, constantsList, BSList, workStatusDescs, workStatusDescDescs, binding.tvWorkNature, false, parentId);

                }
            }
        });
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




}