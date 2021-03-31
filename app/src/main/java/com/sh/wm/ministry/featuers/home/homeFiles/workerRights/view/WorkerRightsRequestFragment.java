package com.sh.wm.ministry.featuers.home.homeFiles.workerRights.view;

import android.app.Dialog;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentWorkerRightsRequestBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.workerRights.model.ComplaintRightsCalculation;
import com.sh.wm.ministry.featuers.home.homeFiles.workerRights.viewmodel.ComplaintRightCalculationViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class WorkerRightsRequestFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {
    FragmentWorkerRightsRequestBinding binding;

    ComplaintRightCalculationViewModel viewModel;

    private Observer<ConstructByName> constructByNameObserver;

    private BottomSheetSearchList bottomSheetSearchList;

    private ShMyDialog shMyDialog;

    private BottomSheetSearchList.MyTestAdapter myAdapter;
    private ImageView imNoData;
    private ProgressBar progressBar;

    String Constraction_id;
    private BottomSheetDialog dialog;
    private EditText ed_text;
    private String mobile, addressId, type;
    private String hoursType, yesOrNoDeadline, natureId, jobId, startOrEnd;
    private UserFileViewModel userFileViewModel;
    private ArrayList<Constants> constantsList;

    private DateAdder dateAdder;
    private long chosenTime;
    private long startDate;


    private Date startingDate, endingDate;
    private List<JobList> jobList;
    private Observer<List<JobList>> jobObserver;
    BottomSheetDialogGeneral bottomSheetDialogGeneral;

    public WorkerRightsRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWorkerRightsRequestBinding.inflate(inflater, container, false);
       //setup viewModel
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        viewModel = new ViewModelProvider(this).get(ComplaintRightCalculationViewModel.class);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);


        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearchList.setBottomSheetDialog(dialog);
                    bottomSheetSearchList.setMyList((ArrayList<?>) constructByName.getConstructs(), ed_text.getText().toString());

                    myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object constructByName) {

                            if (((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME() != null) {
                                binding.cardViewSearshMoveFacility.tvOwnerId.append(" " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getUSERSN());

                                binding.cardViewSearshMoveFacility.tvOwnerName.setText(getString(R.string.owner_name) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME());
                            } else {
                                binding.cardViewSearshMoveFacility.tvOwnerName.setText(getString(R.string.owner_name));


                            }
                            binding.cardViewSearshMoveFacility.tvBusinessName.append(" " + ((Construct) constructByName).getCONSTRUCTNAMEUSING());

                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                            binding.tvInstitutionName.setVisibility(View.GONE);
                            binding.edInstitutionName.setVisibility(View.GONE);
                            binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);

                        }

                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearchList.setAdapter(myAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        jobObserver = new Observer<List<JobList>>() {
            @Override
            public void onChanged(List<JobList> jobLists) {
                jobList = new ArrayList<>();
                if (jobLists != null) {
                    jobList.addAll(jobLists);

                    bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearchList.setBottomSheetDialog(dialog);
                    bottomSheetSearchList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());

                    myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object jobListModel) {
                            jobId = ((JobList) jobListModel).getId();
                            binding.tvJob.setText(((JobList) jobListModel).getText());
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);

                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearchList.setAdapter(myAdapter);
                } else {
                    jobLists.clear();
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };

        btnListener();

    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (startOrEnd.equals("start")) {
            startDate = chosenTime;
            startingDate = date;
            binding.etStartDate.setText(format.format(date));


        } else {
            endingDate = date;

            binding.etEndDate.setText(format.format(date));

        }

    }

    private String getCheckedItem() {
        int checkedItem = binding.radioGroup.getCheckedRadioButtonId();
        if (checkedItem == -1)
            Toast.makeText(getContext(), getString(R.string.ending_work_select), Toast.LENGTH_SHORT).show();
        if (checkedItem == R.id.radio_button_1)
            return "1";
        if (checkedItem == R.id.radio_button_2)
            return "2";
        if (checkedItem == R.id.radio_button_3)
            return "3";
        else
            return "4";
    }


    public void getConstant(String parentId, String type) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantsList = new ArrayList<>();
                if (constants != null) {
                    constantsList.addAll(constants);
                    if (type.equals("nature"))
                        showBtmSheet(R.string.type_of_contract, constantsList, binding.tvWorkNature, type);
                    else if (type.equals("hoursType"))
                        showBtmSheet(R.string.pay_type, constantsList, binding.tvHoursType, type);
                    else if (type.equals("deadLine"))
                        showBtmSheet(R.string.legal_period_ending_work, constantsList, binding.tvDeadLine, type);


                } else {
                    Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void showBtmSheet(int title, List<Constants> list, TextView tv_change, String type) {

        this.type = type;


        ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);



    }

    private void btnListener() {

        binding.cardViewSearshMoveFacility.imgEdit.setOnClickListener(view -> {
            binding.tvInstitutionName.setVisibility(View.VISIBLE);
            binding.edInstitutionName.setVisibility(View.VISIBLE);
        });

        binding.btnCalcRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String salary = binding.etLastPay.getText().toString();
                String startDate = binding.etStartDate.getText().toString();
                String endDate = binding.etEndDate.getText().toString();
                String remainingLeaveDays = binding.edRemainingAnnualLeavesDays.getText().toString();
                String lateBenefit = binding.edLateWages.getText().toString();

                if (salary.isEmpty() || startDate.isEmpty() || endDate.isEmpty()
                        || remainingLeaveDays.isEmpty() || yesOrNoDeadline == null || (binding.etPeriodNotObserved.isEnabled() && binding.etPeriodNotObserved.getText().toString().isEmpty())) {
                    Toast.makeText(getContext(), getString(R.string.rights_empty), Toast.LENGTH_LONG).show();

                } else if (getYear(startingDate, endingDate) < 1) {
                    Toast.makeText(getContext(), getString(R.string.work_period_less_than_1), Toast.LENGTH_SHORT).show();
                } else {
                    viewModel.complaintRightCalculation(hoursType, salary, String.valueOf(getYear(startingDate, endingDate)), remainingLeaveDays, binding.etPeriodNotObserved.getText().toString(), lateBenefit, binding.edCermonies.getText().toString(), getCheckedItem()).observe(getViewLifecycleOwner(), new Observer<ComplaintRightsCalculation>() {
                        @Override
                        public void onChanged(ComplaintRightsCalculation complaintRightsCalculation) {
                            binding.progressbar.setVisibility(View.VISIBLE);
                            if (complaintRightsCalculation != null) {
                                binding.progressbar.setVisibility(View.GONE);
                                Dialog dialog = new Dialog(getContext());
                                dialog.setContentView(R.layout.dialog_layout_labor_rights);

                                TextView indemnity = dialog.findViewById(R.id.tv_indemnity);
                                indemnity.setText(String.valueOf(complaintRightsCalculation.getRIGHTSENDWORKBENEFITSOUT()));

                                TextView annualDays = dialog.findViewById(R.id.tv_annual_vacation_days_allowance);
                                annualDays.setText(String.valueOf(complaintRightsCalculation.getRIGHTSYEARLYLEAVESBENEFITSOUT()));

                                TextView legalTime = dialog.findViewById(R.id.tv_compensation_for_legal_time_limit);
                                legalTime.setText(String.valueOf(complaintRightsCalculation.getRIGHTSLEGALTIMEBENEFITSOUT()));

                                TextView dismissal = dialog.findViewById(R.id.tv_compensation_for_unfair_dismissal);
                                dismissal.setText(String.valueOf(complaintRightsCalculation.getRIGHTSDISMISSALBENEFITSOUT()));

                                TextView cermonies = dialog.findViewById(R.id.tv_religious_holidays);
                                cermonies.setText(String.valueOf(complaintRightsCalculation.getRIGHTCOMPLAINTCERMONIESOUT()));

                                TextView lateWages = dialog.findViewById(R.id.tv_late_wages);
                                lateWages.setText(String.valueOf(complaintRightsCalculation.getCOMPLAINTLATEWAGESOUT()));


                                TextView total = dialog.findViewById(R.id.tv_total);
                                total.setText(String.valueOf(complaintRightsCalculation.getRIGHTSTOTALSOUT()));

                                TextView tvSave = dialog.findViewById(R.id.tv_save);
                                tvSave.setOnClickListener(view1 -> dialog.dismiss());


                                dialog.show();
                            }
                        }
                    });
                }
            }
        });

        binding.edInstitutionName.setOnClickListener(view15 -> {
            showBottomSearchSheet(constructByNameObserver, "construction");
        });

        binding.tvJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(jobObserver, "job");
            }
        });

        binding.tvWorkNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("26", "nature");
            }
        });

        binding.tvHoursType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("34", "hoursType");
            }
        });

        binding.etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "start";
                dateAdder.show();
            }
        });

        binding.etEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "end";
                dateAdder.show();
            }
        });


        binding.tvDeadLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("53", "deadLine");
            }
        });

    }

    private void showBottomSearchSheet(Observer observer, String type) {
        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(R.layout.bottom_sheet_training_program);
        ed_text = dialog.findViewById(R.id.search_view);
        bottomSheetSearchList = dialog.findViewById(R.id.recycler_view);
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
                    if (type.equals("job"))
                        userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
                    else
                        viewModel.getConstruct(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
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


    private double getYear(Date startDate, Date endDate) {

        double diffYear = ((endDate.getTime() - startDate.getTime()) / 1000f) / (60 * 60 * 24f);
        double year = Math.abs(diffYear / 365.25);
        BigDecimal bigDecimal = new BigDecimal(Double.toString(year));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getItemAtPosition(i) instanceof Constants) {
            switch (type) {
                case "nature":
                    natureId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    break;

                case "hoursType":
                    hoursType = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    break;

                case "deadLine":
                    yesOrNoDeadline = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    binding.etPeriodNotObserved.setEnabled(!yesOrNoDeadline.equals("530001"));
                    break;
            }
        }

    }
}