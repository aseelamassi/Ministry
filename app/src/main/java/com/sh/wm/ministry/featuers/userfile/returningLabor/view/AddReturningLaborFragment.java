package com.sh.wm.ministry.featuers.userfile.returningLabor.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentAddReturningLaborBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLabor;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborAction;
import com.sh.wm.ministry.featuers.userfile.returningLabor.viewModel.ReturningLaborViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AddReturningLaborFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface, BottomSheetSearch.BottomSheetSearchInterface {

    private FragmentAddReturningLaborBinding binding;
    private ReturningLabor returningLabor;
    private UserFileViewModel userFileViewModel;
    private BottomSheetDialog dialog;
    private EditText ed_text;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private List<Constants> experienceType;
    private List<JobList> jobList;
    private List<Country> countriesList;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;
    private String jobId, skillLevelId, startOrEnd, countryId, userLaborId;
    private DateAdder dateAdder;
    private Observer<List<JobList>> jobObserver;
    private Observer<List<Country>> countryObserver;
    private long chosenTime, startDate, endDate;
    private ReturningLaborViewModel viewModel;
    private boolean isBigger;
    private OnFragmentInteractionListener mListener;

    private ShMyDialog shMyDialog;

    private BottomSheetSearch bottomSheetSearch;
    private String bottomSearchType;


    public AddReturningLaborFragment() {
        // Required empty public constructor
    }

    public static AddReturningLaborFragment newInstance() {
        AddReturningLaborFragment fragment = new AddReturningLaborFragment();

        return fragment;
    }

    BottomSheetDialogGeneral bottomSheetDialogGeneral;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);
        bottomSheetSearch = new BottomSheetSearch(getContext(), this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddReturningLaborBinding.inflate(inflater, container, false);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        viewModel = new ViewModelProvider(this).get(ReturningLaborViewModel.class);

        //
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        chosenTime = System.currentTimeMillis();


        experienceType = new ArrayList<>();

        getBundle();

        jobObserver = new Observer<List<JobList>>() {
            @Override
            public void onChanged(List<JobList> jobLists) {
                jobList = new ArrayList<>();
                if (jobLists != null) {
                    jobList.addAll(jobLists);
                }

                bottomSheetSearch.setUpAdapter(jobList, getActivity());
//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList((ArrayList<?>) jobLists, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object jobListModel) {
//                            jobId = ((JobList) jobListModel).getId();
//                            binding.etLastJob.setText(((JobList) jobListModel).getText());
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

        countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countriesList = new ArrayList<>();
                if (countries != null) {
                    // imNoData.setVisibility(View.INVISIBLE);
                    countriesList.addAll(countries);
                }
                bottomSheetSearch.setUpAdapter(countriesList, getActivity());
//                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    bottomSheetSearshList.setBottomSheetDialog(dialog);
//                    bottomSheetSearshList.setMyList((ArrayList<?>) countriesList, ed_text.getText().toString());
//
//                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
//                        @Override
//                        public void MyMethod(Object country) {
//                            countryId = ((Country) country).getCDCDNEW();
//                            binding.etReturnedCountry.setText(((Country) country).getCDARBTR());
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
//                    countriesList.clear();
//                    myTestAdapter.notifyDataSetChanged();
//                    imNoData.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                }

            }
        };


        btnListener();

        return binding.getRoot();
    }

    private void btnListener() {
        binding.etLastJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(jobObserver, "jobList");
            }
        });

        binding.etReturnedCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(countryObserver, "country");
            }
        });


        binding.etSkillLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("142");
            }
        });


        binding.etStartWorkDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "start";
                dateAdder.show();
            }
        });

        binding.etWorkEndingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOrEnd = "end";
                dateAdder.show();
            }
        });


        binding.btnAddReturningLabor.setOnClickListener(view -> {
            String startDate = binding.etStartWorkDate.getText().toString();
            String endDate = binding.etWorkEndingDate.getText().toString();
            String returningReason = binding.tvNotes.getText().toString();


            if (countryId == null || startDate.isEmpty() || endDate.isEmpty() || jobId == null || skillLevelId == null) {
                Toast.makeText(getContext(), getString(R.string.returning_labor_empty), Toast.LENGTH_SHORT).show();
            } else if (isBigger) {
                Toast.makeText(getContext(), getString(R.string.is_bigger), Toast.LENGTH_SHORT).show();
            } else {
                shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        if (userLaborId == null) {
                            viewModel.addReturningLabor(countryId, returningReason, startDate, endDate, jobId, skillLevelId).observe(getViewLifecycleOwner(), (ReturningLaborAction returningLaborAction) -> {
                                if (returningLaborAction != null) {
                                    Toast.makeText(getContext(), returningLaborAction.getMessage(), Toast.LENGTH_LONG).show();
                                    if (returningLaborAction.getStatus().equals("0"))
                                        mListener.onFragmentInteraction(171);
                                }
                            });
                        } else {
                            viewModel.updateReturningLabor(userLaborId, countryId, returningReason, startDate, endDate, jobId, skillLevelId).observe(getViewLifecycleOwner(), (ReturningLaborAction returningLaborAction) -> {
                                if (returningLaborAction != null) {
                                    Toast.makeText(getContext(), returningLaborAction.getMessage(), Toast.LENGTH_LONG).show();
                                    if (returningLaborAction.getStatus().equals("0"))
                                        mListener.onFragmentInteraction(171);
                                }
                            });
                        }

                        shMyDialog.dismiss();
                    }


                    @Override
                    public void edite(View view) {
                        shMyDialog.dismiss();
                    }
                }, getString(R.string.health_save), getString(R.string.save), getString(R.string.cancel));

                shMyDialog.show(getParentFragmentManager(), "hi their");

            }
        });

    }

    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            returningLabor = (ReturningLabor) bundle.getSerializable("returningLabor");
            if (bundle.getString("action").equals("view")) {
                binding.btnAddReturningLabor.setVisibility(View.GONE);
                binding.etLastJob.setEnabled(false);
                binding.etWorkEndingDate.setEnabled(false);
                binding.etStartWorkDate.setEnabled(false);
                binding.etSkillLevel.setEnabled(false);
                binding.etReturnedCountry.setEnabled(false);
                binding.etNotes.setEnabled(false);
            }
            userLaborId = returningLabor.getUSERRELABORID();
            binding.etLastJob.setText(returningLabor.getLASTJOB());
                binding.etWorkEndingDate.setText(returningLabor.getUSERRELABORENDDATE());

                binding.etStartWorkDate.setText(returningLabor.getUSERRELABORSTARTDATE());

            binding.etSkillLevel.setText(returningLabor.getUSERRELABORSKILLLEVEL());
            binding.etReturnedCountry.setText(returningLabor.getCOUNTRYNAME());
            binding.etSkillLevel.setText(bundle.getString("skill"));
            binding.etNotes.setText(returningLabor.getUSERRELABORREASON());
            countryId = returningLabor.getUSERRELABORCOUNTRYID();
            jobId = returningLabor.getUSERRELABORLASTJOB();
            skillLevelId = returningLabor.getUSERRELABORSKILLLEVEL();

        }
    }



    private void showBottomSearchSheet(Observer observer, String train) {
        this.bottomSearchType = train;

        bottomSheetSearch.openDialog(observer);
        if (train.equals("country")) {
            userFileViewModel.getCountry().observe(getViewLifecycleOwner(), observer);
        }

    }

    public void showBtmSheet(int title, List<Constants> list, TextView tv_change) {
        //show the constant data in the bottom sheet using the general one
        ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);

    }


    public void getConstant(String parentId) {
        if (experienceType.size() == 0) {
            userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
                @Override
                public void onChanged(List<Constants> constants) {
                    if (constants != null) {
                        experienceType.addAll(constants);
                        if (parentId.equals("142"))
                            showBtmSheet(R.string.skill_level, experienceType, binding.etSkillLevel);


                    } else {
                        Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } else
            showBtmSheet(R.string.skill_level, experienceType, binding.etSkillLevel);

    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (startOrEnd.equals("start")) {
            startDate = chosenTime;
            binding.etStartWorkDate.setText(format.format(date));
        } else {
            endDate = chosenTime;
            binding.etWorkEndingDate.setText(format.format(date));
        }

        //check if the start date is bigger than end date to display an error message
        isBigger = startDate >= endDate;


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

        skillLevelId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();

    }

    @Override
    public void observerAction(Object object) {
        if (bottomSearchType.equals("jobList")) {
            jobId = ((JobList) object).getId();
            binding.etLastJob.setText(((JobList) object).getText());
        } else {
            countryId = ((Country) object).getCDCDNEW();
            binding.etReturnedCountry.setText(((Country) object).getCDARBTR());
        }

    }

    @Override
    public void etLengthMoreThan3(EditText ed_text, Observer observer) {
        if (bottomSearchType.equals("jobList")) {
            userFileViewModel.getJobList(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
        } else {
            userFileViewModel.getCountry(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
        }

    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {

        if (bottomSearchType.equals("country")) {
            userFileViewModel.getCountry().observe(getViewLifecycleOwner(), observer);
        }
    }
}