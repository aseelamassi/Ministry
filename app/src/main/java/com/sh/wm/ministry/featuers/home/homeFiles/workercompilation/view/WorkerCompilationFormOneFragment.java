package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
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
import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentFileComplaintForm1Binding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.ConstructModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.viewmodel.WorkerCompilationFormTwoViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserWorkInfo;
import com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel.MajorServicesViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class WorkerCompilationFormOneFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {

    private FragmentFileComplaintForm1Binding binding;
    private OnFragmentInteractionListener mListener;
    private WorkerCompilationFormTwoViewModel workerCompilationFormTwoViewModel;
    private MajorServicesViewModel viewModel;

    private BottomSheetSearchList bottomSheetSearchList;

    Date startingDate, endingDate;
    private ShMyDialog shMyDialog;

    private BottomSheetSearchList.MyTestAdapter myAdapter;
    private ImageView imNoData;
    private ProgressBar progressBar;

    String Constraction_id;
    private BottomSheetDialog dialog;
    private EditText ed_text;
    private String mobile, addressId;
    private String type, currency, hoursType, yesOrNoContract, yesOrNoDeadline, natureId, jobId, startOrEnd;
    private UserFileViewModel userFileViewModel;
    private HomeViewModel homeViewModel;
    private ArrayList<Constants> constantsList;
    private ArrayList<com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct> constructs;



    private DateAdder dateAdder;
    private long chosenTime;
    private long startDate, endDate;
    boolean isBigger, isToday, isBiggerThanToday;


    private List<JobList> jobList;
    private Observer<List<JobList>> jobObserver;
    BottomSheetDialogGeneral bottomSheetDialogGeneral;

    private static final String TAG = WorkerCompilationFormOneFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);
        //setup viewModel
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        workerCompilationFormTwoViewModel = new ViewModelProvider(this).get(WorkerCompilationFormTwoViewModel.class);
        viewModel = new ViewModelProvider(this).get(MajorServicesViewModel.class);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout
        binding = FragmentFileComplaintForm1Binding.inflate(inflater, container, false);



        constructs = new ArrayList<>();

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

        getUserData();


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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }


    public void getConstant(String parentId, String type) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantsList = new ArrayList<>();
                if (constants != null) {
                    constantsList.addAll(constants);
                    if (type.equals("nature"))
                        showBtmSheet(R.string.type_of_contract, constantsList, constructs, binding.tvWorkNature, type);
                    else if (type.equals("hoursType"))
                        showBtmSheet(R.string.pay_type, constantsList, constructs, binding.tvHoursType, type);
                    else if (type.equals("currency"))
                        showBtmSheet(R.string.currency_type, constantsList, constructs, binding.tvCurrencyType, type);
                    else if (type.equals("deadLine"))
                        showBtmSheet(R.string.legal_period_ending_work, constantsList, constructs, binding.tvDeadLine, type);
                    else if (type.equals("haveContract"))
                        showBtmSheet(R.string.contract, constantsList, constructs, binding.tvHaveContract, type);


                } else {
                    Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void showBtmSheet(int title, List<Constants> list, List<com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct> constructs, TextView tv_change, String type) {

        this.type = type;

        if (type.equals("construct")) {
            ArrayAdapter<com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, constructs);
            bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
        } else {

            ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
            bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
        }


    }

    private void getUserData() {
        viewModel.getUserInfo().observe(getViewLifecycleOwner(), new Observer<UserInfoModel>() {
            @Override
            public void onChanged(UserInfoModel userInfoModel) {
                if (userInfoModel != null) {
                    UserWorkInfo userWorkInfo = userInfoModel.getUserWorkInfo();
                    binding.edId.setText(SharedPreferneceHelper.getUserSn(getContext()));
                    binding.edWorkerName.setText(userWorkInfo.getWORKERFULLNAME());

                    binding.edPhone.setText(userWorkInfo.getMobile());
                    binding.edResidencePlace.setText(userWorkInfo.getUserAddressDesc());

                } else {
                    new ToastMsg(getContext()).toastIconError(getString(R.string.no_internet));

                }
            }
        });
    }

    private void btnListener() {


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


        binding.btnComplaintNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                String lateWages = binding.etLatePayments.getText().toString();
                String deadLinePer = binding.etPeriodNotObserved.getText().toString();
                String terminationReason = binding.edReasonEndWork.getText().toString();
                String realWorkPeriod = binding.etRealWorkDuration.getText().toString();
                String lateWagesPer = binding.etDurationPay.getText().toString();
                String lastPay = binding.etLastPay.getText().toString();
                String endWorkType = getCheckedItem();

                String startDate = binding.etStartDate.getText().toString();
                String endDate = binding.etEndDate.getText().toString();
                String ceremenios = binding.etCermonies.getText().toString();
                String remainLeaveDays = binding.etYearlyVacationDuration.getText().toString();
                if (yesOrNoContract == null || lastPay.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || yesOrNoDeadline == null || Constraction_id == null || binding.edReasonEndWork.getText().toString().isEmpty())
                    Toast.makeText(getContext(), getResources().getString(R.string.complaint_error), Toast.LENGTH_LONG).show();
                else if (isBigger)
                    Toast.makeText(getContext(), getString(R.string.is_bigger), Toast.LENGTH_SHORT).show();
                else if (isToday)
                    Toast.makeText(getContext(), getString(R.string.is_today), Toast.LENGTH_SHORT).show();
                else if (isBiggerThanToday)
                    Toast.makeText(getContext(), getString(R.string.is_bigger_today), Toast.LENGTH_SHORT).show();
                else if (binding.edPhone.getText().toString().length() < 10)
                    Toast.makeText(getContext(), getString(R.string.phone_less_than_10), Toast.LENGTH_SHORT).show();


                else {
                    shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {
                            binding.progressbar.setVisibility(View.VISIBLE);
                            enable(false);

                            String workPeriod = String.valueOf(getYear(startingDate, endingDate));
                            workerCompilationFormTwoViewModel.addLaborComplaint(SharedPreferneceHelper.getUserSn(getContext()), yesOrNoContract, lateWages, lateWagesPer, yesOrNoDeadline, deadLinePer, terminationReason, Constraction_id, endWorkType, workPeriod, realWorkPeriod, remainLeaveDays, jobId, natureId, lastPay, currency, hoursType, ceremenios, startDate, endDate, binding.edPhone.getText().toString(), binding.edResidencePlace.getText().toString()).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                                @Override
                                public void onChanged(ActionModel actionModel) {
                                    binding.progressbar.setVisibility(View.GONE);
                                    enable(true);
                                    if (actionModel != null) {
                                        mListener.onFragmentInteraction(1);
                                    }
                                }
                            });


//                        }

                            shMyDialog.dismiss();
                        }

                        @Override
                        public void edite(View view) {
                            shMyDialog.dismiss();
                        }
                    }, getString(R.string.save_complaint), getString(R.string.save), getString(R.string.cancel));
                    shMyDialog.show(getParentFragmentManager(), "dialog tag");
                }
            }
        });


        binding.edNuFacility.setOnClickListener(view15 -> {
            binding.edNuFacility.setEnabled(false);
            getWorkerConstruct();
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

        binding.tvHaveContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("53", "haveContract");
            }
        });

        binding.tvCurrencyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("56", "currency");
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

                    userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

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


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (startOrEnd.equals("start")) {
            startingDate = date;
            startDate = chosenTime;
            isBigger = startDate >= endDate;
            binding.etStartDate.setText(format.format(date));
        } else {
            endingDate = date;
            endDate = chosenTime;
            isBigger = startDate >= endDate;
            isBiggerThanToday = date.after(Calendar.getInstance().getTime());
            isToday = DateUtils.isToday(endDate);
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


    private void getWorkerConstruct() {
        if (constructs.size() == 0) {
            homeViewModel.getWorkerConstruct().observe(getViewLifecycleOwner(), new Observer<ConstructModel>() {
                @Override
                public void onChanged(ConstructModel constructModel) {

                    if (constructModel != null) {
                        binding.edNuFacility.setEnabled(true);
                        constructs.addAll(constructModel.getConstructs());
                        showBtmSheet(R.string.facility_name, constantsList, constructs, binding.edNuFacility, "construct");

                    } else {
                        Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else
            showBtmSheet(R.string.facility_name, constantsList, constructs, binding.edNuFacility, "construct");

    }

    private double getYear(Date startDate, Date endDate) {

        double diffYear = ((endDate.getTime() - startDate.getTime()) / 1000f) / (60 * 60 * 24f);
        double year = Math.abs(diffYear / 365.25);
        BigDecimal bigDecimal = new BigDecimal(Double.toString(year));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();


    }


    private void enable(boolean status) {
        binding.edNuFacility.setEnabled(status);
        binding.etPeriodNotObserved.setEnabled(status);
        binding.etEndDate.setEnabled(status);
        binding.etStartDate.setEnabled(status);
        binding.etCermonies.setEnabled(status);
        binding.etLastPay.setEnabled(status);
        binding.etDurationPay.setEnabled(status);
        binding.etYearlyVacationDuration.setEnabled(status);
        binding.edReasonEndWork.setEnabled(status);
        binding.tvCurrencyType.setEnabled(status);
        binding.tvHaveContract.setEnabled(status);
        binding.tvHoursType.setEnabled(status);
        binding.tvDeadLine.setEnabled(status);
        binding.tvJob.setEnabled(status);
        binding.etRealWorkDuration.setEnabled(status);
        binding.tvTypeOfContract.setEnabled(status);
        binding.tvWorkNature.setEnabled(status);


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (adapterView.getItemAtPosition(i) instanceof Constants) {
            switch (type) {
                case "nature":
                    natureId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    break;
                case "haveContract":
                    yesOrNoContract = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    break;
                case "hoursType":
                    hoursType = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    break;
                case "currency":
                    currency = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    break;
                case "deadLine":
                    yesOrNoDeadline = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                    binding.etPeriodNotObserved.setEnabled(!yesOrNoDeadline.equals("530001"));
                    break;


            }

        } else {
            Constraction_id = ((com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct) adapterView.getItemAtPosition(i)).getCONSTRUCTID();

        }

    }
}