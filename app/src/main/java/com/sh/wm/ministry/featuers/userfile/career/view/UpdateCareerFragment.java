package com.sh.wm.ministry.featuers.userfile.career.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ConfirmDialog;
import com.sh.wm.ministry.databinding.FragmentAddCareerBinding;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareer;
import com.sh.wm.ministry.featuers.userfile.career.viewmodel.CareersViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;

import java.util.ArrayList;
import java.util.List;


public class UpdateCareerFragment extends Fragment implements ConfirmDialog.Listener {

    private FragmentAddCareerBinding binding;
    private CareersViewModel mViewModel;
    private UserFileViewModel userFileViewModel;

    private ConfirmDialog confirmDialog;

    private UserCareer userCareer;

    private BottomSheetDialog dialog;
    private EditText ed_text;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private List<Result> results;
    private List<JobList> jobList;
    private List<TrainingInstitute> trainingInstitutesList;

    private BottomSheetSearchList.MyTestAdapter myTestAdapter;

    private Observer<List<TrainingInstitute>> trainingObserver;
    private Observer<List<JobList>> jobObserver;


    private String jobId, jobOrTrainingInstitutes, institutesId;

    public UpdateCareerFragment() {
        // Required empty public constructor
    }


    public static UpdateCareerFragment newInstance() {
        return new UpdateCareerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBundleData();
        if (userCareer != null) {
            binding.edStatus.setText(userCareer.getCAREERLICENSED());
            binding.edCareerName.setText(userCareer.getCAREERNAME());
            binding.edTrainingInstitution.setText(userCareer.getINSTITUTIONID());
            binding.edExperienceYear.setText(userCareer.getUSERCAREERSKILLLEVELID());
            binding.edCertificateYear.setText(userCareer.getUSERCAREERCERTIFICATEYEAR());
            binding.edPrioritySpecification.setText(userCareer.getUSERCAREERPRIORITY());

        }

        confirmDialog = new ConfirmDialog(this, getContext(), "");


        //observers
//        trainingObserver = new Observer<ResultModel>() {
//            @Override
//            public void onChanged(ResultModel jobListModel) {
//                results = new ArrayList<>();
//                if (jobListModel != null && jobListModel.getResults() != null) {
//                    results.addAll(jobListModel.getResults());
//
//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList((ArrayList<?>) results, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object jobListModel) {
//
//                            institutesId = ((Result) jobListModel).getId();
//                            binding.edTrainingInstitution.setText(((Result) jobListModel).getText());
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
//                    results.clear();
//                    imNoData.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                }
//
//            }
//        };


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
                            jobId = ((JobList) jobListModel).getId();
                            binding.edCareerName.setText(((JobList) jobListModel).getText());
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);

                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    jobLists.clear();
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };

        trainingObserver = new Observer<List<TrainingInstitute>>() {
            @Override
            public void onChanged(List<TrainingInstitute> trainingInstitutes) {
                trainingInstitutesList = new ArrayList<>();
                if (trainingInstitutes != null) {
                    trainingInstitutesList.addAll(trainingInstitutes);

                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearshList.setBottomSheetDialog(dialog);
                    bottomSheetSearshList.setMyList((ArrayList<?>) trainingInstitutesList, ed_text.getText().toString());

                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object jobListModel) {
                            institutesId = ((TrainingInstitute) jobListModel).getId();
                            binding.edTrainingInstitution.setText(((Result) jobListModel).getText());
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    results.clear();
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        btnListener();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddCareerBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(CareersViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);


        return binding.getRoot();
    }


    public void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null)
            userCareer = (UserCareer) bundle.getSerializable("userCareer");
    }


    private void btnListener() {
        binding.edCareerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobOrTrainingInstitutes = "job";
                showBottomSearchSheet(jobObserver, "job");
            }
        });


        binding.edTrainingInstitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobOrTrainingInstitutes = "trainingInstitute";

                showBottomSearchSheet(trainingObserver, "trainingInstitute");
            }
        });


        binding.btnUpdateCareer.setOnClickListener(view -> {
            confirmDialog.presentForList(getString(R.string.do_want_to_update_career));
        });

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
                Toast.makeText(getActivity(), "beforeTextChanged", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getActivity(), "onTextChanged", Toast.LENGTH_SHORT).show();
                if (i2 >= 3) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "=> " + i2, Toast.LENGTH_SHORT).show();
                    if (train.equals("job")) {
                        userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
                    } else {
                        userFileViewModel.getTrainingInstitute(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
//
                    }

                } else {
                    bottomSheetSearshList.clerList();
                    progressBar.setVisibility(View.GONE);
                    imNoData.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(getActivity(), "afterTextChanged", Toast.LENGTH_SHORT).show();
                BottomSheetSearchList.clerList();
            }
        });
        dialog.show();

    }

    @Override
    public void onOk() {

        if (binding.edCareerName.getText().toString().isEmpty() || binding.edTrainingInstitution.getText().toString().isEmpty() ||
                binding.edStatus.getText().toString().isEmpty() || binding.edExperienceYear.getText().toString().isEmpty() ||
                binding.edPrioritySpecification.getText().toString().isEmpty() || binding.edCertificateYear.getText().toString().isEmpty())
            Toast.makeText(getContext(), "يجب عليك تعبئة جميع الخقول", Toast.LENGTH_SHORT).show();

        else
            mViewModel.updateCareers(userCareer.getUSERCAREERID(), jobId, userCareer.getCAREERLICENSED(), binding.edExperienceYear.getText().toString(), institutesId, binding.edCertificateYear.getText().toString(), binding.edPrioritySpecification.getText().toString());
    }

    @Override
    public void onCancel() {

    }
}