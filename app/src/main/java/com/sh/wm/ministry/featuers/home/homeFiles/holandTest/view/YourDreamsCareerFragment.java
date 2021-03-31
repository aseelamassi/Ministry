package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentYourDreamsCareerBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.DreamJobsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandDreamJobs;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandTestJobModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.JobList;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.List;


public class YourDreamsCareerFragment extends Fragment implements DreamJobsAdapter.OnDeleteClickListener{


    private FragmentYourDreamsCareerBinding binding;
    private HollandBasicTabsModel hollandBasicTabsModel;
    private HollandViewModel viewModel;
    private String  jobId;
    private List<JobList> jobLists , dreamJobs;

    private DreamJobsAdapter adapter ;


    private EditText ed_text;
    private BottomSheetDialog bottomSheetDialog;

    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;
    private OnFragmentInteractionListener mListener;

    boolean isClick = false ;


    public YourDreamsCareerFragment() {
        // Required empty public constructor
    }


    public static YourDreamsCareerFragment newInstance() {
        YourDreamsCareerFragment fragment = new YourDreamsCareerFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HollandViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentYourDreamsCareerBinding.inflate(inflater, container, false);

        jobLists = new ArrayList<>();
        dreamJobs = new ArrayList<>();

        //setup adapter of careers
        binding.rvCareers.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DreamJobsAdapter(getContext(), dreamJobs , this);

        btnListener();


        getHollandJobList();
        getDreamJobs();

        return binding.getRoot();
    }

    private void btnListener() {

        binding.edCareer.setOnClickListener(view -> showBottomSearchSheet());

        binding.btnAddCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edCareer.getText().toString().isEmpty())
                    Toast.makeText(getContext(), getString(R.string.add_career_empty), Toast.LENGTH_SHORT).show();
                else {

                    if (adapter.getItemCount() < 8) {//check that the chosen careers less than 8
                        binding.progress.setVisibility(View.VISIBLE);
                        viewModel.addDreamJob(SharedPreferneceHelper.getTestId(getContext()), jobId).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                            @Override
                            public void onChanged(ActionModel actionModel) {
                                if (actionModel != null) {
                                    binding.edCareer.setText("");
                                    jobId = null;
                                    if (actionModel.getStatus().equals("0"))
                                        getDreamJobs();
                                }
                            }
                        });
                    }else
                        Toast.makeText(getContext(), getString(R.string.more_than_eight), Toast.LENGTH_SHORT).show();

                }

            }

        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mListener.onFragmentInteraction(181  );

            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mListener.onFragmentInteraction(183  );

            }
        });
    }







    private void showBottomSearchSheet() {

        isClick = true ;
        bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_training_program);
        ed_text = bottomSheetDialog.findViewById(R.id.search_view);
        bottomSheetSearshList = bottomSheetDialog.findViewById(R.id.recycler_view);
        imNoData = bottomSheetDialog.findViewById(R.id.image_no_data);
        progressBar = bottomSheetDialog.findViewById(R.id.progressbar);

        bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
        bottomSheetSearshList.setBottomSheetDialog(bottomSheetDialog);

        progressBar.setVisibility(View.VISIBLE);
        imNoData.setVisibility(View.GONE);
        if (!bottomSheetDialog.isShowing())
            bottomSheetDialog.show();

        getHollandJobList();

        ed_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_text.getText().toString().length() >= 3) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                    bottomSheetSearshList.setVisibility(View.GONE);


                    List<JobList> filteredJob = new ArrayList<>();
                    for (JobList jobList : jobLists) {
                        if (jobList.getJOBARNAME().contains(ed_text.getText().toString())) {
                            filteredJob.add(jobList);
                        }
                    }

                    progressBar.setVisibility(View.GONE);
                    bottomSheetSearshList.setVisibility(View.VISIBLE);
                    bottomSheetSearshList.setMyList((ArrayList<?>) filteredJob, ed_text.getText().toString());
                    bottomSheetSearshList.setAdapter(myTestAdapter);

                    if (filteredJob.size()  != 0) {
                        imNoData.setVisibility(View.GONE);
                    } else {
                        imNoData.setVisibility(View.VISIBLE);
                    }


                } else {
                    getHollandJobList();
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
            @Override
            public void MyMethod(Object job) {
                jobId = ((JobList) job).getJOBID();
                binding.edCareer.setText(((JobList) job).getJOBARNAME());
                ed_text.setText("");
                imNoData.setVisibility(View.VISIBLE);

            }
        });



        bottomSheetSearshList.setAdapter(myTestAdapter);


    }


    private void getHollandJobList() {
        if (jobLists.size() == 0) {
            viewModel.getHollandJob(SharedPreferneceHelper.getTestId(getContext())).observe(getViewLifecycleOwner(), new Observer<HollandTestJobModel>() {
                @Override
                public void onChanged(HollandTestJobModel hollandTestJobModel) {
                    if (hollandTestJobModel != null && hollandTestJobModel.getJobList() != null) {
                        jobLists.addAll(hollandTestJobModel.getJobList());

                        if (  isClick ) {
                            bottomSheetSearshList.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            imNoData.setVisibility(View.GONE);
                            bottomSheetSearshList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());
                            bottomSheetSearshList.setAdapter(myTestAdapter);
                            bottomSheetDialog.show();
                        }
                    }
                }
            });

        } else {


            if (isClick) {
                bottomSheetSearshList.setVisibility(View.VISIBLE);
                imNoData.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                bottomSheetSearshList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());
                bottomSheetSearshList.setAdapter(myTestAdapter);
                bottomSheetDialog.show();
            }
        }


    }


    private void getDreamJobs(){
        binding.progress.setVisibility(View.VISIBLE);
        viewModel.hollandDreamJobs(SharedPreferneceHelper.getTestId(getContext()) ).observe(getViewLifecycleOwner(), new Observer<HollandDreamJobs>() {
            @Override
            public void onChanged(HollandDreamJobs hollandDreamJobs) {
                if (hollandDreamJobs != null ) {
                    binding.progress.setVisibility(View.GONE ) ;
                    if (hollandDreamJobs.getJobList() != null) {
                        dreamJobs.addAll(hollandDreamJobs.getJobList());
                        binding.rvCareers.setVisibility(View.VISIBLE);
                        adapter = new DreamJobsAdapter(getContext(), hollandDreamJobs.getJobList(), YourDreamsCareerFragment.this::onDeleteClick);
                        binding.rvCareers.setAdapter(adapter);

                    }else {
                        binding.rvCareers.setVisibility(View.GONE);

                        binding.rvCareers.setAdapter(null);
                    }
                }

            }
        });
    }

    @Override
    public void onDeleteClick(JobList jobList) {

        viewModel.deleteDreamJob(SharedPreferneceHelper.getTestId(getContext()) , jobList.getJOBID() ).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
            @Override
            public void onChanged(ActionModel actionModel) {
                if (actionModel != null){
                    if (actionModel.getStatus().equals("0"))
                        getDreamJobs();

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel = null;
    }


}