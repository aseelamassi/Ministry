package com.sh.wm.ministry.featuers.userfile.trainingskills.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentAddTrainingSkillsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.ActionsTrainingProgramsModel;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkills;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.trainingskills.viewmodel.TrainingSkillsViewModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobListModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;

import java.util.ArrayList;
import java.util.List;

public class AddTrainingSkillsFragment extends Fragment implements BottomSheetDialogGeneral.BottomSheetInterface, BottomSheetSearch.BottomSheetSearchInterface{

    private TrainingSkillsViewModel mViewModel;
    private TrainingSkills trainingSkill;
    private FragmentAddTrainingSkillsBinding binding;
    private List<Constants> constantList;
    private String trainingTypeId, trainingProgramId, jobId;
    private BottomSheetDialog dialog;
    private EditText ed_text;
    private OnFragmentInteractionListener mListener;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private Observer<List<TrainingProgram>> trainingProgramObserver;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;
    private ArrayList<TrainingProgram> trainingPrograms;
    private ArrayList<JobList> jobList;
    private Observer<List<JobList>> jobObserver;
    private ShMyDialog shMyDialog;
    private String action , type ;
    private UserFileViewModel userFileViewModel;
    private BottomSheetSearch bottomSheetSearch;



    BottomSheetDialogGeneral bottomSheetDialogGeneral;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);
        bottomSheetSearch = new BottomSheetSearch(getContext() ,this);


    }

    public static AddTrainingSkillsFragment newInstance() {
        return new AddTrainingSkillsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddTrainingSkillsBinding.inflate(inflater, container, false);
        action = getContext().getString(R.string.save);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBundleData();


        mViewModel = new ViewModelProvider(this).get(TrainingSkillsViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);


        trainingProgramObserver = new Observer<List<TrainingProgram>>() {
            @Override
            public void onChanged(List<TrainingProgram> trainingProgramsModel) {
                trainingPrograms = new ArrayList<>();
                if (trainingProgramsModel != null) {
                    trainingPrograms.addAll(trainingProgramsModel);
//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList(trainingPrograms, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object trainingProgram) {
//                            binding.tvCourse.setText(((TrainingProgram) trainingProgram).getTRAININGPROGRAMARNAME());
//
//                            trainingProgramId = ((TrainingProgram) trainingProgram).getTRAININGPROGRAMID();
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
//                    imNoData.setVisibility(View.VISIBLE);
//
//                    Toast.makeText(getActivity(), getString(R.string.error), Toast.LENGTH_SHORT).show();
//                    progressBar.setVisibility(View.GONE);
//                }

                }
                bottomSheetSearch.setUpAdapter(trainingPrograms,getActivity());
            }
        };


        jobObserver = new Observer<List<JobList>>() {
            @Override
            public void onChanged(List<JobList> jobLists) {
                jobList = new ArrayList<>();
                if (jobLists != null ) {
                    jobList.addAll(jobLists);
                }
                bottomSheetSearch.setUpAdapter(jobList,getActivity());

//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object jobListModel) {
//                            binding.tvJob.setText(((JobList) jobListModel).getText());
//                            jobId = ((JobList) jobListModel).getId();
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
//                    jobLists.clear();
//                    myTestAdapter.notifyDataSetChanged();
//                    imNoData.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                }

            }
        };


        btnListener();
    }

    private void setEnabled(boolean isEnable){
        binding.tvPriority.setEnabled(isEnable);
        binding.tvCourse.setEnabled(isEnable);
        binding.tvJob.setEnabled(isEnable);
        binding.tvCourseType.setEnabled(isEnable);

    }

    public void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            action = getString(R.string.edit);
            if (bundle.getString("type").equals("view")){
                binding.btnAddTrainingSkills.setVisibility(View.GONE);
                setEnabled(false);

            }
            trainingSkill = (TrainingSkills) bundle.getSerializable("trainingSkill");
            binding.tvPriority.setText(trainingSkill.getUSERSKILLSPRIORITY());
            binding.tvCourse.setText(trainingSkill.getTRAINPROGNAME());
            trainingProgramId = trainingSkill.getUSERSKILLSNEEDCOURSEID();
            binding.tvCourseType.setText(trainingSkill.getCOURSETYPE());
            trainingTypeId = trainingSkill.getUSERSKILLSNEEDCOURSEID();
            if (trainingSkill.getJOBARNAME() != null) {
                binding.tvJob.setVisibility(View.VISIBLE);
                binding.tvJobLabel.setVisibility(View.VISIBLE);
                binding.tvJob.setText(trainingSkill.getJOBARNAME());
                jobId = trainingSkill.getUSERSKILLJOBTITLEID();
            }
        }

    }


    private void btnListener() {
        binding.tvCourseType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("240001019");
            }
        });

        binding.tvCourse.setOnClickListener(view -> {
            showBottomSearchSheet(trainingProgramObserver, "trainProgram");
        });

        binding.tvJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(jobObserver, "job");
            }
        });


        binding.btnAddTrainingSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                       if (action.equals(getString(R.string.save))) {
                           if (trainingProgramId != null && !binding.tvPriority.getText().toString().isEmpty() && trainingTypeId != null) {
                               if (trainingTypeId.equals("240001022")) {
                                   if (jobId != null) {
                                       binding.progress.setVisibility(View.VISIBLE);
                                       mViewModel.insertTrainingSkill(trainingTypeId, binding.tvPriority.getText().toString(), jobId, trainingProgramId).observe(getViewLifecycleOwner(),new Observer<UpdateUser>(){

                                           @Override
                                           public void onChanged(UpdateUser actionsTrainingProgramsModel) {
                                               if (actionsTrainingProgramsModel != null){
                                                   binding.progress.setVisibility(View.GONE);
                                                   if (actionsTrainingProgramsModel.getStatus().equals("0"))
                                                        mListener.onFragmentInteraction(12);

                                           }}
                                       } );;
                                   } else {
                                       Toast.makeText(getContext(), getResources().getString(R.string.career_empty), Toast.LENGTH_SHORT).show();
                                   }
                               } else {
                                   binding.progress.setVisibility(View.VISIBLE);
                                   mViewModel.insertTrainingSkill(trainingTypeId, binding.tvPriority.getText().toString(), jobId, trainingProgramId).observe(getViewLifecycleOwner(),new Observer<UpdateUser>(){

                                       @Override
                                       public void onChanged(UpdateUser actionsTrainingProgramsModel) {
                                           if (actionsTrainingProgramsModel != null) {
                                               binding.progress.setVisibility(View.GONE);
                                               if (actionsTrainingProgramsModel.getStatus().equals("0"))
                                                   mListener.onFragmentInteraction(12);
                                           }
                                       }
                                   } );;

                               }
                           } else {
                               Toast.makeText(getContext(),getResources().getString(R.string.edit_field), Toast.LENGTH_SHORT).show();
                           }
                       }
                           else{
                                if (binding.tvPriority.getText().toString().equals(trainingSkill.getUSERSKILLSPRIORITY())
                                        && binding.tvCourseType.getText().toString().equals(trainingSkill.getCOURSETYPE()) &&
                                        binding.tvCourse.getText().toString().equals(trainingSkill.getTRAINPROGNAME())) {
                                    if (trainingSkill.getJOBARNAME() != null ){
                                        if (binding.tvJob.getText().equals(trainingSkill.getJOBARNAME()))
                                         Toast.makeText(getContext(), getResources().getString(R.string.edit_field), Toast.LENGTH_SHORT).show();
                                        else{
                                            binding.progress.setVisibility(View.VISIBLE);
                                            mViewModel.updateTrainingSkill(trainingSkill.getUSERSKILLSNEEDSID(),trainingTypeId, binding.tvPriority.getText().toString(), jobId, trainingProgramId).observe(getViewLifecycleOwner(),new Observer<UpdateUser>(){

                                                @Override
                                                public void onChanged(UpdateUser actionsTrainingProgramsModel) {
                                                    if (actionsTrainingProgramsModel != null){
                                                        binding.progress.setVisibility(View.GONE);
                                                        if (actionsTrainingProgramsModel.getStatus().equals("0"))
                                                            mListener.onFragmentInteraction(12);

                                                }
                                                }
                                            } );;
                                    }}else
                                        Toast.makeText(getContext(), getResources().getString(R.string.edit_field), Toast.LENGTH_SHORT).show();
                                } else{
                                    binding.progress.setVisibility(View.VISIBLE);
                                    mViewModel.updateTrainingSkill(trainingSkill.getUSERSKILLSNEEDSID(),trainingTypeId, binding.tvPriority.getText().toString(), jobId, trainingProgramId).observe(getViewLifecycleOwner(),new Observer<UpdateUser>(){

                                        @Override
                                        public void onChanged(UpdateUser actionsTrainingProgramsModel) {

                                            if (actionsTrainingProgramsModel != null) {
                                                binding.progress.setVisibility(View.GONE);
                                                if (actionsTrainingProgramsModel.getStatus().equals("0"))
                                                    mListener.onFragmentInteraction(12);
                                            }
                                        }
                                    } );
                            }
                        }

                        shMyDialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        shMyDialog.dismiss();
                    }
                }, getString(R.string.save_training_skill), action, getString(R.string.cancel));
                shMyDialog.show(getParentFragmentManager(), "dialog tag");
            }
        });


    }

    private void getConstant(String parentId) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantList = new ArrayList<>();
                if (constants != null) {
                    constantList.addAll(constants);
                    showBtmSheet(R.string.train_type, constantList, binding.tvCourseType);

                } else
                    Toast.makeText(getActivity(), getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showBtmSheet(int title, List<Constants> list, TextView tv_change) {


        ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        bottomSheetDialogGeneral.openDialog(itemsAdapter , title ,tv_change);





    }


    private void showBottomSearchSheet(Observer observer, String train) {
        this.type = train;
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
//                    if (train.equals("trainProgram"))
//                        mViewModel.getTrainingProgram(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
//                    else
//                        userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
//
//                } else {
//                    bottomSheetSearshList.clerList();
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

        trainingTypeId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
        if (trainingTypeId.equals("240001022")) {
            binding.tvJob.setVisibility(View.VISIBLE);
            binding.tvJobLabel.setVisibility(View.VISIBLE);
        } else {
            jobId = null;
            binding.tvJob.setVisibility(View.INVISIBLE);
            binding.tvJobLabel.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void observerAction(Object object) {
        if (type.equals("trainProgram")){
            binding.tvCourse.setText(((TrainingProgram) object).getTRAININGPROGRAMARNAME());
            trainingProgramId = ((TrainingProgram) object).getTRAININGPROGRAMID();
        }else {
            binding.tvJob.setText(((JobList) object).getText());
            jobId = ((JobList) object).getId();
        }
    }

    @Override
    public void etLengthMoreThan3(EditText ed_text, Observer observer) {
        if (type.equals("trainProgram"))
            mViewModel.getTrainingProgram(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
        else
            userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);


    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {

    }
}