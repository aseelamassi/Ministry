package com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.view;

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
import android.widget.RadioButton;
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
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentCloseFacilityBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter.SubjectNumberAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.viewmodel.CloseFacilityViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.model.Inspector;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class CloseFacilityFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {

    private CloseFacilityViewModel closeFacilityViewModel;

    private FragmentCloseFacilityBinding binding;

    private ShMyDialog sh;

    private RadioButtonCreation creation;


    private String visitOrClose, construction_id, inspectorSn1, inspectorSn2, inspectorSn3, palLawId, legalChosen, type;


    private ArrayList<Inspector> inspectorList;

    private HomeViewModel homeViewModel;
    private UserFileViewModel userFileViewModel;
    private BottomSheetDialogGeneral bottomSheetDialogGeneral;


    /////For bottom Search
    private BottomSheetDialog dialog;
    private BottomSheetSearchList bottomSheetSearchList;
    private BottomSheetSearchList.MyTestAdapter myAdapter;
    private EditText ed_text;
    private ImageView imNoData;
    private ProgressBar progressBar;


    ////observers
    private Observer<ConstructByName> constructByNameObserver;
    private Observer<PalLawModel> palLawObserver;


    //for pal law
    private ArrayList<PalLaw> lawList;
    private HashMap<String, String> laws;
    private HashMap<String, String> inspectors;
    private int thisPosition;
    private SubjectNumberAdapter subjectNumberAdapter;


    ////for calender
    private DateAdder dateAdder;
    private long chosenTime, startDate;

    private boolean isToday, isTodayAction, isBigger;


    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        lawList = new ArrayList<>();
        laws = new HashMap<>();
        inspectorList = new ArrayList<>();
        inspectors = new HashMap<>();

        creation = new RadioButtonCreation(getContext());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCloseFacilityBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setup viewModel
        closeFacilityViewModel = new ViewModelProvider(this).get(CloseFacilityViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        //get data to display in radio buttons
        getConstant("1650024");

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
                            binding.cardViewSearshCloseForm.llSecondView.setVisibility(View.VISIBLE);
                            if (((Construct) constructByName).getCONSTRUCTIONOWNER() != null) {
                                binding.cardViewSearshCloseForm.tvOwnerName.setText(getString(R.string.owner_name) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME());
                                binding.cardViewSearshCloseForm.tvOwnerId.setText(getString(R.string.owner_id) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getUSERSN());

                            } else {
                                binding.cardViewSearshCloseForm.tvOwnerName.setText(getString(R.string.owner_name));
                                binding.cardViewSearshCloseForm.tvOwnerId.setText(getString(R.string.owner_id));
                            }

                            if (((Construct) constructByName).getCONSTRUCTTELEPHONE() != null)
                                binding.cardViewSearshCloseForm.tvBusinessName.setText(getString(R.string.phone) + " " + ((Construct) constructByName).getCONSTRUCTTELEPHONE());
                            binding.cardViewSearshCloseForm.tvActiveSector.setText(getString(R.string.The_business_name) + " " + ((Construct) constructByName).getCONSTRUCTNAMEUSING());
                            binding.cardViewSearshCloseForm.tvWorkField.setText(getString(R.string.state) + " " + ((Construct) constructByName).getCONSTRUCTMAINECON());
                            binding.cardViewSearshCloseForm.tvInstitutionName.setText(getString(R.string.address_details) + " " + ((Construct) constructByName).getCONSTRUCTADDRESS());

                            construction_id = ((Construct) constructByName).getCONSTRUCTNUM();
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                            binding.tvNuFacilityCloseFormFragment.setVisibility(View.GONE);
                            binding.edNuFacilityCloseFormFragment.setVisibility(View.GONE);
                            binding.cardViewSearshCloseForm.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                        }
                    });
                   
                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearchList.setAdapter(myAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };

        palLawObserver = new Observer<PalLawModel>() {
            @Override
            public void onChanged(PalLawModel palLawModel) {

                if (palLawModel != null) {
                    bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearchList.setBottomSheetDialog(dialog);
                    bottomSheetSearchList.setMyList((ArrayList<?>) palLawModel.getPalLaws(), ed_text.getText().toString());

                    myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object palLaw) {

                            lawList.remove(thisPosition);

                            lawList.add((PalLaw) palLaw);




                            subjectNumberAdapter.notifyDataSetChanged();


                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                        }
                    });

                    progressBar.setVisibility(View.GONE);
                    imNoData.setVisibility(View.GONE);

                    bottomSheetSearchList.setAdapter(myAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        };

        lawList.add(null);
        subjectNumberAdapter = new SubjectNumberAdapter(lawList, position -> {
            thisPosition = position;
            showBottomSearchSheet(palLawObserver, "palLaw");
        });

        binding.edArticleNumberCloseFormFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.edArticleNumberCloseFormFragment.setAdapter(subjectNumberAdapter);


        btnListener();
    }


    private void btnListener() {
        binding.cardViewSearshCloseForm.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityCloseFormFragment.setVisibility(View.VISIBLE);
            binding.tvNuFacilityCloseFormFragment.setVisibility(View.VISIBLE);
            binding.cardViewSearshCloseForm.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            binding.edNuFacilityCloseFormFragment.setText("");

        });

        binding.edNuFacilityCloseFormFragment.setOnClickListener(view15 -> {
            showBottomSearchSheet(constructByNameObserver, "constructName");
        });


        binding.edMember1.setOnClickListener(view -> getInspector("one"));

        binding.edMember2.setOnClickListener(view -> getInspector("two"));

        binding.edMember3.setOnClickListener(view -> getInspector("three"));


        binding.edDateVisit.setOnClickListener(view15 -> {
            visitOrClose = "visit";
            dateAdder.show();
        });

        binding.edDateClose.setOnClickListener(view16 -> {
            visitOrClose = "close";
            dateAdder.show();
        });

        binding.radio.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            legalChosen = (String) radioButton.getTag();
            if (legalChosen.equals("1650025")) {
                binding.tvMachineStopWork.setVisibility(View.VISIBLE);
                binding.edMachineStopWork.setVisibility(View.VISIBLE);
            } else {
                binding.tvMachineStopWork.setVisibility(View.GONE);
                binding.edMachineStopWork.setVisibility(View.GONE);
            }


        });


        binding.btnAdd.setOnClickListener(view1 -> {

            if (subjectNumberAdapter.getItemCount() >= 5) {
                Toast.makeText(getContext(), "بيكفي يا وحش لعند 5 وبس وشكرا من وجدان", Toast.LENGTH_SHORT).show();
                return;
            }
            if (lawList.get(lawList.size() - 1) == null) {
                Toast.makeText(getContext(), "أرجو منك تعبأت الحقل الذي سبق قبل إضافة حقل جديد", Toast.LENGTH_SHORT).show();
                return;
            }
            subjectNumberAdapter.notifyDataSetChanged();
            lawList.add(null);
        });


        binding.btnSaveCloseFormFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                laws = new HashMap<>();
                for (int  i =0 ; i<lawList.size() ; i++)
                    if (lawList.get(i) != null) {
                        laws.put("LAW_ARTICAL_NUM_" + (i+1), lawList.get(i).getId());
                    }
                if (construction_id == null || laws.size() == 0 || inspectors.size() == 0 || binding.edDateVisit.getText().toString().isEmpty() || binding.edDateClose.getText().toString().isEmpty() || legalChosen == null || (binding.edMachineStopWork.getVisibility() == View.VISIBLE && binding.edMachineStopWork.getText().toString().isEmpty())) {
                    Toast.makeText(getActivity(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                } else if (true) {
                    sh = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {
                            closeFacilityViewModel.storeConstructionClose(construction_id, binding.edDateClose.getText().toString(), legalChosen, binding.edMachineStopWork.getText().toString(), laws, null, inspectors, binding.edDateVisit.getText().toString()).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                                @Override
                                public void onChanged(ActionModel updateUser) {
                                }
                            });
                            sh.dismiss();

                        }

                        @Override
                        public void edite(View view) {
                            sh.dismiss();
                        }
                    }, getString(R.string.cloase_facility_Dialog_save), getString(R.string.save), getString(R.string.edit));
                    sh.show(getParentFragmentManager(), "hi thir");

                }
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
                if (ed_text.getText().toString().length() >= 3 && type.equals("constructName")) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);
                    homeViewModel.getConstruct(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
                } else if (ed_text.getText().toString().length() >= 1 && type.equals("palLaw")) {
                    homeViewModel.getPalLaw(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

                } else {
                    bottomSheetSearchList.clerList();
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


    public void showBtmSheet(int title, List<Inspector> list, TextView tv_change, String type) {

        this.type = type;

        ArrayAdapter<Inspector> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);


    }

    private void getInspector(String type) {
        if (inspectorList.size() == 0) {

            homeViewModel.getInspectors().observe(getViewLifecycleOwner(), new Observer<InspectorModel>() {
                @Override
                public void onChanged(InspectorModel inspectorModel) {
                    if (inspectorModel != null) {
                        inspectorList.addAll(inspectorModel.getInspectors());
                        inspectorShowSheet(type);
                    } else {
                        Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            inspectorShowSheet(type);

        }
    }

    private void inspectorShowSheet(String type) {
        if (type.equals("one"))
            showBtmSheet(R.string.inspector_members, inspectorList, binding.edMember1, type);
        else if (type.equals("two"))
            showBtmSheet(R.string.inspector_members, inspectorList, binding.edMember2, type);
        else
            showBtmSheet(R.string.inspector_members, inspectorList, binding.edMember3, type);
    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (visitOrClose.equals("visit")) {
            startDate = chosenTime;
            isToday = DateUtils.isToday(chosenTime);
            binding.edDateVisit.setText(format.format(date));
        } else {
            isTodayAction = DateUtils.isToday(chosenTime);
            isBigger = startDate > chosenTime;
            binding.edDateClose.setText(format.format(date));
        }

    }


    public void getConstant(String parentId) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {

                if (constants != null) {
                    creation.addRadioButtons(binding.radio, constants, "action");

                } else {
                    Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (type.equals("one")) {
            inspectorSn1 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
            inspectors.put("INSPECT_USERID_1", inspectorSn1);
        } else if (type.equals("two")) {
            inspectorSn2 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
            inspectors.put("INSPECT_USERID_2", inspectorSn2);
        } else {
            inspectorSn3 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
            inspectors.put("INSPECT_USERID_3", inspectorSn3);
        }

    }
}