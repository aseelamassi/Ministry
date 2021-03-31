package com.sh.wm.ministry.featuers.userfile.workexperience.view;

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
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentAddWorkExperienceBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.ActionsTrainingProgramsModel;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperience;
import com.sh.wm.ministry.featuers.userfile.workexperience.viewmodel.WorkExperienceViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class AddWorkExperienceFragment extends Fragment implements DateAdder.Listener , BottomSheetDialogGeneral.BottomSheetInterface, BottomSheetSearch.BottomSheetSearchInterface {

    private FragmentAddWorkExperienceBinding binding;
    private UserWorkExperience userWorkExperience;
    private WorkExperienceViewModel mViewModel;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;
    private long startDate, endDate;
    private String startOrEnd, jobOrTrainingInstitutes;
    private ShMyDialog shMyDialog;
    private String action;
    private OnFragmentInteractionListener mListener;
    private boolean isBigger = false;
    private BottomSheetDialog dialog;
    private EditText ed_text;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private List<Constants> experienceType;
    private List<JobList> jobList;
    private List<TrainingInstitute> trainingInstitutesList;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;
    private String type, jobId, institutesId, experienceTypeID, placeWorkId, userExpId , parentId;

    private Observer<List<JobList>> jobObserver;
    private Observer<List<TrainingInstitute>> trainingObserver;


    private UserFileViewModel userFileViewModel;


    private BottomSheetDialogGeneral bottomSheetDialogGeneral;

    private BottomSheetSearch bottomSheetSearch;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);
        bottomSheetSearch = new BottomSheetSearch(getContext() ,this);


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddWorkExperienceBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WorkExperienceViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        action = getResources().getString(R.string.save);

        ///get Data
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            action = getResources().getString(R.string.edit);
            if (bundle.getString("type").equals("view")) {
                binding.btnSaveAddExperience.setVisibility(View.GONE);
                setEnabled(false);
            }
            userWorkExperience = (UserWorkExperience) bundle.getSerializable("workExp");
            binding.tvExperienceTypeAddWorkExperience.setText(userWorkExperience.getEXPTYPE());
            //binding.tvWorkPlaceAddWorkExperience.setText(userWorkExperience.getEXPTYPE());
            binding.tvJobTitleAddWorkExperience.setText(userWorkExperience.getJOBTITL());
            binding.tvInstitutionNameAddWorkExperience.setText(userWorkExperience.getEXPINSTIT());


            binding.tvWorkBeginningDateAddWorkExperience.setText(userWorkExperience.getUSERWORKEXPSTARTWORKOUT());
            binding.tvWorkEndingDateAddWorkExperience.setText(userWorkExperience.getUSERWORKEXPENDWORKOUT());
            binding.tvNotesAddWorkExperience.setText(userWorkExperience.getUSERWORKEXPLEAVINGREASON());

            experienceTypeID = userWorkExperience.getUSERWORKEXPEXPTYPEID();
            jobId = userWorkExperience.getUSERWORKEXPJOBTITLEID();
            institutesId = userWorkExperience.getUSERWORKEXPINSTITID();
            //placeWorkId = userWorkExperience.getE
            userExpId = userWorkExperience.getUSERWORKEXPID();

        }


        //date

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();


        trainingObserver = new Observer<List<TrainingInstitute>>() {
            @Override
            public void onChanged(List<TrainingInstitute> trainingInstitutes) {
                trainingInstitutesList = new ArrayList<>();
                if (trainingInstitutes != null) {
                    trainingInstitutesList.addAll(trainingInstitutes);
                }
                bottomSheetSearch.setUpAdapter(trainingInstitutesList , getActivity());
//
//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList((ArrayList<?>) trainingInstitutesList, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object jobListModel) {
//                            institutesId = ((TrainingInstitute) jobListModel).getId();
//                            binding.tvInstitutionNameAddWorkExperience.setText(((TrainingInstitute) jobListModel).getText());
//                            ed_text.setText("");
//                            imNoData.setVisibility(View.VISIBLE);
//                        }
//                    });
//
//                    progressBar.setVisibility(View.GONE);
//
//                    bottomSheetSearshList.setAdapter(myTestAdapter);
//                } else {
//                    trainingInstitutesList.clear();
//                    BottomSheetSearchList.clerList();
//                    imNoData.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                }

            }
        };


        jobObserver = new Observer<List<JobList>>() {
            @Override
            public void onChanged(List<JobList> jobLists) {
                jobList = new ArrayList<>();
                if (jobLists != null) {
                    jobList.addAll(jobLists);
                }
//                bottomSheetSearch.setUpAdapter(jobList , getActivity());
//
//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object jobListModel) {
//                            jobId = ((JobList) jobListModel).getId();
//                            binding.tvJobTitleAddWorkExperience.setText(((JobList) jobListModel).getText());
//                            ed_text.setText("");
//                            imNoData.setVisibility(View.VISIBLE);
//
//                        }
//                    });
//
//                    progressBar.setVisibility(View.GONE);
//
//                    bottomSheetSearshList.setAdapter(myTestAdapter);
//                } else {
//
//                    BottomSheetSearchList.clerList();
//                    imNoData.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                }

            }
        };


        btnListener();


    }

    private void setEnabled(boolean isEnabled) {
        binding.tvExperienceTypeAddWorkExperience.setEnabled(isEnabled);
        binding.tvWorkPlaceAddWorkExperience.setEnabled(isEnabled);
        binding.tvJobTitleAddWorkExperience.setEnabled(isEnabled);
        binding.tvInstitutionNameAddWorkExperience.setEnabled(isEnabled);


        binding.tvWorkBeginningDateAddWorkExperience.setEnabled(isEnabled);
        binding.tvWorkEndingDateAddWorkExperience.setEnabled(isEnabled);
        binding.tvNotesAddWorkExperience.setEnabled(isEnabled);


    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
        chosenTime = timeChosen;
        if (startOrEnd.equals("start")) {
            startDate = chosenTime;
            isBigger = chosenTime > endDate;
            binding.tvWorkBeginningDateAddWorkExperience.setText(format.format(date));
        } else {
            endDate = chosenTime;
            isBigger = startDate > chosenTime;
            binding.tvWorkEndingDateAddWorkExperience.setText(format.format(date));
        }


    }

    private void showBottomSearchSheet(Observer observer, String train) {
        this.type = train ;
        bottomSheetSearch.openDialog(observer);

//        dialog = new BottomSheetDialog(getContext());
//        dialog.setContentView(R.layout.bottom_sheet_training_program);
//        ed_text = dialog.findViewById(R.id.search_view);
//        bottomSheetSearshList = dialog.findViewById(R.id.recycler_view);
//        imNoData = dialog.findViewById(R.id.image_no_data);
//        progressBar = dialog.findViewById(R.id.progressbar);
//        ed_text.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (ed_text.getText().toString().length() >= 3) {
//                    progressBar.setVisibility(View.VISIBLE);
//                    imNoData.setVisibility(View.GONE);
//
//                    if (train.equals("jobList")) {
//                        jobOrTrainingInstitutes = "job";
//                        userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
//
//                    } else {
//                        jobOrTrainingInstitutes = "training";
//                        userFileViewModel.getTrainingInstitute(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
//
//                    }
//
//                } else {
//                    BottomSheetSearchList.clerList();
//                    progressBar.setVisibility(View.GONE);
//                    imNoData.setVisibility(View.VISIBLE);
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//                BottomSheetSearchList.clerList();
//            }
//        });
//        dialog.show();

    }


    public void showBtmSheet(int title, List<Constants> list, TextView tv_change, String parentId) {

        this.parentId = parentId;



        if (parentId.equals("116")) {
            ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

            bottomSheetDialogGeneral.openDialog(itemsAdapter , title ,tv_change);

        } else {
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Arrays.asList(getResources().getStringArray(R.array.bottomsheet_spinner_work_place)));
            bottomSheetDialogGeneral.openDialog(itemsAdapter , title ,tv_change);

        }




    }


    public void getConstant(String parentId) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                experienceType = new ArrayList<>();
                if (constants != null) {
                    experienceType.addAll(constants);
                    if (parentId.equals("116"))
                        showBtmSheet(R.string.experience_type, experienceType, binding.tvExperienceTypeAddWorkExperience, parentId);
                    //else
                    //showBtmSheet(R.string.training_course, experienceType, binding.etTrainingAuthority,parentId);

                } else {
                    Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void btnListener() {
        binding.tvExperienceTypeAddWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("116");
            }
        });

        binding.tvWorkPlaceAddWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtmSheet(R.string.work_place, experienceType, binding.tvWorkPlaceAddWorkExperience, "0");
            }
        });


        binding.tvJobTitleAddWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(jobObserver, "jobList");
            }
        });

        binding.tvInstitutionNameAddWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(trainingObserver, "trainingInstitutes");
            }
        });


        binding.tvWorkBeginningDateAddWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "start";
                dateAdder.show();
            }
        });

        binding.tvWorkEndingDateAddWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "end";
                dateAdder.show();
            }
        });

        binding.btnSaveAddExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        binding.progress.setVisibility(View.VISIBLE);

                        //check that all fields are not empty
                        if (binding.tvWorkBeginningDateAddWorkExperience.getText().toString().isEmpty() || binding.tvExperienceTypeAddWorkExperience.getText().toString().isEmpty()
                                || binding.tvJobTitleAddWorkExperience.getText().toString().isEmpty() || binding.tvInstitutionNameAddWorkExperience.getText().toString().isEmpty())
                            Toast.makeText(getContext(), getResources().getString(R.string.work_exp_empty), Toast.LENGTH_SHORT).show();

                        else {
                             if (isBigger)
                                Toast.makeText(getContext(), getResources().getString(R.string.is_bigger), Toast.LENGTH_SHORT).show();
                            else if (action.equals(getString(R.string.save))) {
                                mViewModel.addUserWorkExperience(experienceTypeID, jobId, institutesId, binding.tvWorkBeginningDateAddWorkExperience.getText().toString(), binding.tvWorkEndingDateAddWorkExperience.getText().toString(), binding.tvNotesAddWorkExperience.getText().toString()).observe(getViewLifecycleOwner(), new Observer<UpdateUser>() {
                                    @Override
                                    public void onChanged(UpdateUser actionsTrainingProgramsModel1) {
                                        binding.progress.setVisibility(View.GONE);
                                        if (actionsTrainingProgramsModel1 != null && actionsTrainingProgramsModel1.getStatus().equals("0")) {
                                            Toast.makeText(getContext(), actionsTrainingProgramsModel1.getMessageText(), Toast.LENGTH_SHORT).show();
                                            mListener.onFragmentInteraction(70);
                                        }

                                    }
                                });

                            } else {
                                mViewModel.updateUserWorkExperience(userExpId , experienceTypeID,jobId,institutesId,binding.tvWorkBeginningDateAddWorkExperience.getText().toString(), binding.tvWorkEndingDateAddWorkExperience.getText().toString(), binding.tvNotesAddWorkExperience.getText().toString()).observe(getViewLifecycleOwner(), new Observer<UpdateUser>() {
                                    @Override
                                    public void onChanged(UpdateUser actionsTrainingProgramsModel1) {
                                        binding.progress.setVisibility(View.GONE);
                                        if (actionsTrainingProgramsModel1 != null && actionsTrainingProgramsModel1.getStatus().equals("0")) {
                                            Toast.makeText(getContext(), actionsTrainingProgramsModel1.getMessageText(), Toast.LENGTH_SHORT).show();

                                            mListener.onFragmentInteraction(70);
                                        }

                                    }
                                });


                            }
                        }


                        shMyDialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        shMyDialog.dismiss();
                    }
                }, getString(R.string.save_work_exp), action, getString(R.string.cancel));
                shMyDialog.show(getParentFragmentManager(), "dialog tag");


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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (parentId.equals("116"))
            experienceTypeID = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
        else if (parentId.equals("0")) {
            placeWorkId = Integer.toString(i + 1);
        }

    }

    @Override
    public void observerAction(Object object) {
        if (type.equals("jobList")){
            jobId = ((JobList) object).getId();
            binding.tvJobTitleAddWorkExperience.setText(((JobList) object).getText());
        }else{
            institutesId = ((TrainingInstitute) object).getId();
            binding.tvInstitutionNameAddWorkExperience.setText(((TrainingInstitute) object).getText());
        }
    }

    @Override
    public void etLengthMoreThan3(EditText ed_text, Observer observer) {

        if (type.equals("jobList")) {
            jobOrTrainingInstitutes = "job";
            userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

        } else {
            jobOrTrainingInstitutes = "training";
            userFileViewModel.getTrainingInstitute(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

        }
    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {

    }
}

