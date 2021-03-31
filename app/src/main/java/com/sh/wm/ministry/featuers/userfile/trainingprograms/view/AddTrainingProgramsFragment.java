package com.sh.wm.ministry.featuers.userfile.trainingprograms.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.google.android.material.textfield.TextInputEditText;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentAddTrainingProgramsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.ActionsTrainingProgramsModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgram;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.viewmodel.TrainingProgramsViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class AddTrainingProgramsFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface, BottomSheetSearch.BottomSheetSearchInterface {

    private TrainingProgramsViewModel mViewModel;
    private UserFileViewModel userFileViewModel;
    private FragmentAddTrainingProgramsBinding binding;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;
    private long endChosenTime;
    private UserTrainingProgram trainingProgram;
    private BottomSheetDialog dialog;
    private long startDate, endDate;

    private Observer<List<TrainingProgram>> trainingProgramObserver;
    private Observer<List<TrainingSide>> trainingSideObserver;
    private List<Constants> trainingProgramType;
    private String trainEntity, trainingProgramId, courseType, institutionId, tempWork;
    private ShMyDialog shMyDialog;
    private String action;
    private String message, parentId;
    private boolean isBigger;

    private ArrayList<TrainingProgram> trainingPrograms;
    private ArrayList<TrainingSide> trainingSides;
    private String startOrEnd, userTrainId;
    private OnFragmentInteractionListener mListener;

    private BottomSheetSearch bottomSheetSearch;
    private String type;


    public static AddTrainingProgramsFragment newInstance() {
        return new AddTrainingProgramsFragment();

    }

    BottomSheetDialogGeneral bottomSheetDialogGeneral;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);
        bottomSheetSearch = new BottomSheetSearch(getContext(), this);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//inflate the view using binding
        binding = FragmentAddTrainingProgramsBinding.inflate(inflater, container, false);


        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(TrainingProgramsViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);


        action = getResources().getString(R.string.save);
        message = getResources().getString(R.string.save_training_program);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();

        getBundle();


        trainingProgramObserver = new Observer<List<TrainingProgram>>() {
            @Override
            public void onChanged(List<TrainingProgram> trainingProgramsModel) {

                trainingPrograms = new ArrayList<>();
                if (trainingProgramsModel != null) {
                    trainingPrograms.addAll(trainingProgramsModel);
                }
                bottomSheetSearch.setUpAdapter(trainingPrograms, getActivity());
            }
        };


        trainingSideObserver = new Observer<List<TrainingSide>>() {
            @Override
            public void onChanged(List<TrainingSide> trainingSide) {

                trainingSides = new ArrayList<>();
                if (trainingSide != null) {
                    trainingSides.addAll(trainingSide);

                }
                bottomSheetSearch.setUpAdapter(trainingSides , getActivity());
            }
        };

        btnListener();


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TrainingProgramsViewModel.class);

    }

    private void setEnabled(boolean isEnabled) {
        binding.etTrainingAuthority.setEnabled(isEnabled);
        binding.etTrainningProgramEdu.setEnabled(isEnabled);
        binding.etNotes.setEnabled(isEnabled);
        binding.tvCourseEndDateTrainingPrograms.setEnabled(isEnabled);
        binding.etTrainingSideAddress.setEnabled(isEnabled);
        binding.etTrainingHours.setEnabled(isEnabled);
        binding.tvTrainingProgramsType.setEnabled(isEnabled);
        binding.tvCourseStartDateTrainingPrograms.setEnabled(isEnabled);
        binding.etTrainingSide.setEnabled(isEnabled);
    }

    private void getBundle() {
        //trainEntity, trainingProgramId, courseType, institutionId
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            if (bundle.getString("type").equals("view")) {
                binding.btnSaveTrainingProgram.setVisibility(View.GONE);
                setEnabled(false);
            }
            action = getResources().getString(R.string.edit);
            message = getResources().getString(R.string.edit_training_program);
            trainingProgram = (UserTrainingProgram) bundle.getSerializable("trainingProgram");
            userTrainId = trainingProgram.getUSERTRAINPROGID();
            institutionId = trainingProgram.getUSERTRAINPROGINSTITUTIONID();
            courseType = trainingProgram.getUSERTRAINPROGCOURSETYPE();
            trainingProgramId = trainingProgram.getUSERTRAINPROGTRAININGID();
            trainEntity = trainingProgram.getUSERTRAINPROGTRAINENTITY();

            if (trainingProgram.getTRAINENTITY() != null) {
                binding.etTrainingAuthority.setText(trainingProgram.getTRAINENTITY());

            }
            binding.etTrainningProgramEdu.setText(trainingProgram.getTRAINPROGNAME());
            binding.tvTrainingProgramsType.setText(trainingProgram.getCOURSETYPE());
            binding.etTrainingSide.setText(trainingProgram.getINSTITUTIONID());
            if (trainingProgram.getUSERTRAINPROGNOTES() != null)
                binding.etNotes.setText(trainingProgram.getUSERTRAINPROGNOTES());
            if (trainingProgram.getUSERTRAINPROGENDDATE() != null)
                binding.tvCourseEndDateTrainingPrograms.setText(trainingProgram.getUSERTRAINPROGENDDATE());
            binding.tvCourseStartDateTrainingPrograms.setText(trainingProgram.getUSERTRAINPROGSTARTDATE());
            if (trainingProgram.getUSERTRAINPROGTRAININGHOURS() != null)
                binding.etTrainingHours.setText(trainingProgram.getUSERTRAINPROGTRAININGHOURS());
            if (trainingProgram.getUSERTRAINPROGENTITYADDRESS() != null)
                binding.etTrainingSideAddress.setText(trainingProgram.getUSERTRAINPROGENTITYADDRESS());

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

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (startOrEnd.equals("start")) {
            startDate = chosenTime;
            isBigger = startDate > endDate;
            binding.tvCourseStartDateTrainingPrograms.setText(format.format(date));

        } else {
            endDate = chosenTime;
            isBigger = startDate > chosenTime;
            binding.tvCourseEndDateTrainingPrograms.setText(format.format(date));
        }


    }

    public void getConstant(String parentId) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                trainingProgramType = new ArrayList<>();
                if (constants != null) {
                    trainingProgramType.addAll(constants);
                    if (parentId.equals("115"))
                        showBtmSheet(R.string.training_course, trainingProgramType, binding.tvTrainingProgramsType, parentId);
                    else
                        showBtmSheet(R.string.training_course, trainingProgramType, binding.etTrainingAuthority, parentId);

                } else {
                    Toast.makeText(getActivity(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void btnListener() {
        binding.tvCourseStartDateTrainingPrograms.setOnClickListener(view -> {
            startOrEnd = "start";
            dateAdder.show();


        });

        binding.tvCourseEndDateTrainingPrograms.setOnClickListener(view -> {
            startOrEnd = "end";
            dateAdder.show();

        });

        binding.etTrainningProgramEdu.setOnClickListener(view -> {
            showBottomSearchSheet(trainingProgramObserver, "trainProgram");
        });

        binding.etTrainingSide.setOnClickListener(view -> {
            showBottomSearchSheet(trainingSideObserver, "trainSide");
        });


        binding.tvTrainingProgramsType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("115");
            }
        });

        binding.etTrainingAuthority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("140");
            }
        });

        binding.btnSaveTrainingProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etTrainingAuthority.getText().toString().isEmpty() || binding.etTrainningProgramEdu.getText().toString().isEmpty()
                        || binding.tvTrainingProgramsType.getText().toString().isEmpty() || binding.etTrainingSide.getText().toString().isEmpty()
                        || binding.tvCourseStartDateTrainingPrograms.getText().toString().isEmpty() || binding.tvCourseEndDateTrainingPrograms.getText().toString().isEmpty()
                        || binding.etTrainingHours.getText().toString().isEmpty() || binding.etTrainingSideAddress.getText().toString().isEmpty() || binding.etNotes.getText().toString().isEmpty()) {
                    binding.progress.setVisibility(View.GONE);
                    //enable user interaction when progress is visible
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    Toast.makeText(getContext(), getString(R.string.empty), Toast.LENGTH_LONG).show();

                } else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDate = null;
                    Date endDate = null;
                    long start = 0, end = 0;
                    try {
                        startDate = (Date) format.parse(binding.tvCourseStartDateTrainingPrograms.getText().toString());
                        start = startDate.getTime();
                        endDate = (Date) format.parse(binding.tvCourseEndDateTrainingPrograms.getText().toString());
                        end = endDate.getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if (start > end)
                        Toast.makeText(getContext(), getResources().getString(R.string.is_bigger), Toast.LENGTH_SHORT).show();
                    else if (start == end)
                        Toast.makeText(getContext(), getString(R.string.is_equal), Toast.LENGTH_LONG).show();

                    else if ((endDate != null && endDate.after(new Date())) || (startDate.after(new Date())))
                        Toast.makeText(getContext(), getString(R.string.is_bigger_today), Toast.LENGTH_SHORT).show();
                    else {

                        shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                            @Override
                            public void sase(View view) {
                                binding.progress.setVisibility(View.VISIBLE);
                                //disable user interaction when progress is visible
                                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                if (action.equals(getString(R.string.save))) {
                                    mViewModel.addTrainingProgram(trainEntity, trainingProgramId, courseType, institutionId, binding.tvCourseStartDateTrainingPrograms.getText().toString(), binding.tvCourseEndDateTrainingPrograms.getText().toString(), binding.etTrainingHours.getText().toString(), binding.etTrainingSideAddress.getText().toString(), binding.etNotes.getText().toString(), "66").observe(getViewLifecycleOwner(), new Observer<ActionsTrainingProgramsModel>() {
                                        @Override
                                        public void onChanged(ActionsTrainingProgramsModel actionsTrainingProgramsModel1) {
                                            binding.progress.setVisibility(View.GONE);
                                            //enable user interaction when progress is visible
                                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                            if (actionsTrainingProgramsModel1 != null && actionsTrainingProgramsModel1.getStatus().equals("0")) {
                                                mListener.onFragmentInteraction(62);
                                            }

                                        }
                                    });

                                } else {
                                    mViewModel.updateTrainingProgram(userTrainId, trainEntity, trainingProgramId, courseType, institutionId, binding.tvCourseStartDateTrainingPrograms.getText().toString(), binding.tvCourseEndDateTrainingPrograms.getText().toString(), binding.etTrainingHours.getText().toString(), binding.etTrainingSideAddress.getText().toString(), binding.etNotes.getText().toString(), "66").observe(getViewLifecycleOwner(), new Observer<ActionsTrainingProgramsModel>() {
                                        @Override
                                        public void onChanged(ActionsTrainingProgramsModel actionsTrainingProgramsModel1) {
                                            binding.progress.setVisibility(View.GONE);
                                            //enable user interaction when progress is visible
                                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                            if (actionsTrainingProgramsModel1 != null && actionsTrainingProgramsModel1.getStatus().equals("0")) {
                                                mListener.onFragmentInteraction(62);
                                            }

                                        }
                                    });


                                }


                                shMyDialog.dismiss();
                            }

                            @Override
                            public void edite(View view) {
                                shMyDialog.dismiss();
                            }
                        }, message, action, getString(R.string.cancel));
                        shMyDialog.show(getParentFragmentManager(), "dialog tag");

                    }
                }
            }
        });
    }


    private void showBottomSearchSheet(Observer observer, String train) {
        this.type = train ;
        bottomSheetSearch.openDialog(observer);

    }


    public void showBtmSheet(int title, List<Constants> list, TextView tv_change, String parentId) {

        this.parentId = parentId;

        ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (parentId.equals("115"))
            courseType = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
        else if (parentId.equals("140"))
            trainEntity = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
    }

    @Override
    public void observerAction(Object object) {
        if (type.equals("trainProgram")){
            binding.etTrainningProgramEdu.setText(((TrainingProgram) object).getTRAININGPROGRAMARNAME());
            trainingProgramId = ((TrainingProgram) object).getTRAININGPROGRAMID();
        }else{
            binding.etTrainingSide.setText(((TrainingSide) object).getTRAININGPROGRAMARNAME());
            institutionId = ((TrainingSide) object).getTRAININGPROGRAMID();
        }

    }

    @Override
    public void etLengthMoreThan3(EditText ed_text, Observer observer) {
        if (type.equals("trainProgram"))
            mViewModel.getTrainingProgram(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
        else
            mViewModel.getTrainingSide(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {

    }
}
