package com.sh.wm.ministry.featuers.home.homeFiles.legalAction.view;

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
import android.widget.RadioGroup;
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
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentLegalActionBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter.SubjectNumberAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.legalAction.viewmodel.LegalActionViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.model.Inspector;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
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
import java.util.TimeZone;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public class LegalActionFragment extends Fragment implements DateAdder.Listener , BottomSheetDialogGeneral.BottomSheetInterface {
    private FragmentLegalActionBinding binding;
    private LegalActionViewModel legalActionViewModel;
    private UserFileViewModel userFileViewModel;


    private BottomSheetDialog dialog;
    private Observer<ConstructByName> constructByNameObserver;

    private EditText ed_text;
    String Constraction_id;

    private ImageView imNoData;
    private ProgressBar progressBar;
    private String type ,palLawId, inspectorSn1, inspectorSn2, inspectorSn3, legalChosen, rb1_id, rb2_id, rb3_id;

    private BottomSheetSearchList bottomSheetSearchList;
    private BottomSheetSearchList.MyTestAdapter myAdapter;

    private ShMyDialog shMyDialog;


    private SubjectNumberAdapter subjectNumberAdapter;
    private int thisPosition;

    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime, startDate;

    private boolean isToday, isTodayAction, isBigger;

    private HomeViewModel homeViewModel;

    private ArrayList<PalLaw> lawList;
    private HashMap<String, String> laws;
    private ArrayList<Constants> constantList;

    private String visitOrAction;


    private ArrayList<Inspector> inspectorList;
    private Observer<PalLawModel> palLawObserver;

    private BottomSheetDialogGeneral bottomSheetDialogGeneral;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        lawList = new ArrayList<>();
        inspectorList = new ArrayList<>();
        laws = new HashMap<>();


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
                            palLawId = ((PalLaw) palLaw).getId();
                            lawList.add((PalLaw) palLaw);
                            int position = thisPosition + 1;


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
                            binding.cardViewSearchShLegalAction.llSecondView.setVisibility(View.VISIBLE);
                            if (((Construct) constructByName).getCONSTRUCTIONOWNER() != null) {
                                binding.cardViewSearchShLegalAction.tvOwnerName.setText(getString(R.string.owner_name) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME());
                                binding.cardViewSearchShLegalAction.tvOwnerId.setText(getString(R.string.owner_id) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getUSERSN());

                            } else {
                                binding.cardViewSearchShLegalAction.tvOwnerName.setText(getString(R.string.owner_name));
                                binding.cardViewSearchShLegalAction.tvOwnerId.setText(getString(R.string.owner_id));
                            }

                            if (((Construct) constructByName).getCONSTRUCTTELEPHONE() != null)
                                binding.cardViewSearchShLegalAction.tvBusinessName.setText(getString(R.string.phone) + " " + ((Construct) constructByName).getCONSTRUCTTELEPHONE());
                            binding.cardViewSearchShLegalAction.tvActiveSector.setText(getString(R.string.The_business_name) + " " + ((Construct) constructByName).getCONSTRUCTNAMEUSING());
                            binding.cardViewSearchShLegalAction.tvWorkField.setText(getString(R.string.state) + " " + ((Construct) constructByName).getCONSTRUCTMAINECON());
                            binding.cardViewSearchShLegalAction.tvInstitutionName.setText(getString(R.string.address_details) + " " + ((Construct) constructByName).getCONSTRUCTADDRESS());

                            Constraction_id = ((Construct) constructByName).getCONSTRUCTID();
                            binding.tvNuFacilityLegalAction.setVisibility(View.GONE);
                            binding.edNuFacilityLegalAction.setVisibility(View.GONE);
                            binding.cardViewSearchShLegalAction.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLegalActionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        legalActionViewModel = new ViewModelProvider(this).get(LegalActionViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        dialog = new BottomSheetDialog(getContext());


        lawList.add(null);
        subjectNumberAdapter = new SubjectNumberAdapter(lawList, position -> {
            thisPosition = position;
            showBottomSearchSheet(palLawObserver, "palLaw");
        });

        binding.edArticleNumberLegalAction.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.edArticleNumberLegalAction.setAdapter(subjectNumberAdapter);


        getConstant();
        btnListener();


    }

    public void enabel(boolean states) {
        binding.edNuFacilityLegalAction.setEnabled(states);
        binding.edArticleNumberLegalAction.setEnabled(states);
        binding.edMember1.setEnabled(states);
        binding.edMember2.setEnabled(states);
        binding.edMember3.setEnabled(states);
        binding.btnAddLegalAction.setEnabled(states);
        binding.btnSaveLegalAction.setEnabled(states);

    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (visitOrAction.equals("visit")) {
            startDate = chosenTime;
            isToday = DateUtils.isToday(chosenTime);
            binding.edDateVisit.setText(format.format(date));
        } else {
            isTodayAction = DateUtils.isToday(chosenTime);
            isBigger = startDate > chosenTime;
            binding.edDateAction.setText(format.format(date));
        }
    }


    private void setMachineVisibility(int visibility) {
        binding.tvMachineStopWork.setVisibility(visibility);
        binding.edMachineStopWork.setVisibility(visibility);
    }


    private void btnListener() {

        binding.radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio_button_1) {
                    legalChosen = rb1_id;
                    if (rb1_id.equals("1650025")) {
                        setMachineVisibility(View.VISIBLE);
                    } else {
                        setMachineVisibility(View.GONE);
                    }
                } else if (i == R.id.radio_button_2) {
                    if (rb2_id.equals("1650025")) {
                        setMachineVisibility(View.VISIBLE);
                    } else {
                        setMachineVisibility(View.GONE);
                    }
                    legalChosen = rb2_id;
                } else {
                    if (rb3_id.equals("1650025")) {
                        setMachineVisibility(View.VISIBLE);
                    } else {
                        setMachineVisibility(View.GONE);
                    }
                    legalChosen = rb3_id;
                }
            }
        });

        binding.edNuFacilityLegalAction.setOnClickListener(view15 -> {
            showBottomSearchSheet(constructByNameObserver, "constructName");
        });


        binding.btnAddLegalAction.setOnClickListener(view1 -> {

            if (subjectNumberAdapter.getItemCount() >= 5) {
                Toast.makeText(getContext(), getString(R.string.greater_than_5), Toast.LENGTH_SHORT).show();
                return;
            }
            if (lawList.get(lawList.size() - 1) == null) {
                Toast.makeText(getContext(), getString(R.string.field_before_empty), Toast.LENGTH_SHORT).show();
                return;
            }
            subjectNumberAdapter.notifyDataSetChanged();
            lawList.add(null);
        });

        binding.edDateVisit.setOnClickListener(view15 -> {
            visitOrAction = "visit";
            dateAdder.show();
        });

        binding.edDateAction.setOnClickListener(view16 -> {
            visitOrAction = "action";
            dateAdder.show();
        });


        binding.edMember1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMemberButtonEnable(false);

                getInspector("one");
            }
        });

        binding.edMember2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setMemberButtonEnable(false);
                getInspector("two");
            }
        });

        binding.edMember3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setMemberButtonEnable(false);
                getInspector("three");
            }
        });

        binding.cardViewSearchShLegalAction.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityLegalAction.setVisibility(View.VISIBLE);
            binding.tvNuFacilityLegalAction.setVisibility(View.VISIBLE);
            binding.cardViewSearchShLegalAction.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            binding.edNuFacilityLegalAction.setText("");

        });

        binding.btnSaveLegalAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enabel(false);
                String visitDate = binding.edDateVisit.getText().toString();
                String actionDate = binding.edDateAction.getText().toString();

                laws = new HashMap<>();
                for (int  i =0 ; i<lawList.size() ; i++)
                    if (lawList.get(i) != null) {
                        laws.put("CONSTRUCT_PROC_LAW_ID_" + (i+1), lawList.get(i).getId());
                    }

                if (Constraction_id == null || (inspectorSn1 == null & inspectorSn2 == null & inspectorSn3 == null) || visitDate.isEmpty() || actionDate.isEmpty()) {
                    enabel(true);
                    Toast.makeText(getContext(), R.string.alarm_empty, Toast.LENGTH_LONG).show();
                } else if (isBigger) {
                    enabel(true);
                    Toast.makeText(getContext(), R.string.alarm_bigger, Toast.LENGTH_LONG).show();
                } else if (binding.edMachineStopWork.getVisibility() == View.VISIBLE && binding.edMachineStopWork.getText().toString().isEmpty()) {
                    enabel(true);
                    Toast.makeText(getContext(), R.string.machine_empty, Toast.LENGTH_LONG).show();
                } else {
                    shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {

                            binding.progress.setVisibility(View.VISIBLE);
                            //palLawId1, palLawId2 , palLawId3, palLawId4 , palLawId5

                            legalActionViewModel.storeConstructionLegalAction(Constraction_id, visitDate, actionDate, legalChosen, binding.edMachineStopWork.getText().toString(), laws, inspectorSn1, inspectorSn2, inspectorSn3, null).observe(getViewLifecycleOwner(), new Observer<UpdateUser>() {
                                @Override
                                public void onChanged(UpdateUser updateUser) {
                                    if (updateUser != null) {
                                        enabel(true);
                                        binding.progress.setVisibility(View.GONE);
                                    }

                                }
                            });


                            shMyDialog.dismiss();
                        }


                        @Override
                        public void edite(View view) {
                            shMyDialog.dismiss();
                        }
                    }, getString(R.string.save_legal), getString(R.string.save), getString(R.string.edit));
                    shMyDialog.show(getParentFragmentManager(), "hi their");
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

        this.type  = type;

        ArrayAdapter<Inspector> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

        bottomSheetDialogGeneral.openDialog(itemsAdapter,title,tv_change);




    }


    private void getInspector(String type) {
        if (inspectorList.size() == 0) {

            homeViewModel.getInspectors().observe(getViewLifecycleOwner(), new Observer<InspectorModel>() {
                @Override
                public void onChanged(InspectorModel inspectorModel) {
                    if (inspectorModel != null) {
                        setMemberButtonEnable(true);
                        inspectorList.addAll(inspectorModel.getInspectors());
                        inspectorShowSheet(type);
                    }
                }
            });
        } else {
            setMemberButtonEnable(true);
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


    private void setMemberButtonEnable(boolean isEnable) {
        binding.edMember1.setEnabled(isEnable);
        binding.edMember2.setEnabled(isEnable);
        binding.edMember3.setEnabled(isEnable);
    }

    private void getConstant() {
        userFileViewModel.getConstant("1650024").observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantList = new ArrayList<>();
                if (constants != null) {
                    constantList.addAll(constants);
                    for (int i = 0; i < constantList.size(); i++) {
                        Constants constants1 = constantList.get(i);
                        switch (i) {
                            case 0:
                                binding.radioButton1.setText(constants1.getCONSTANTARANAME());
                                rb1_id = constants1.getCONSTANTID();
                                break;
                            case 1:
                                binding.radioButton2.setText(constants1.getCONSTANTARANAME());
                                rb2_id = constants1.getCONSTANTID();
                                break;
                            case 2:
                                binding.radioButton3.setText(constants1.getCONSTANTARANAME());
                                rb3_id = constants1.getCONSTANTID();
                                break;
                        }
                    }

                } else
                    Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (type.equals("one"))
            inspectorSn1 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
        else if (type.equals("two"))
            inspectorSn2 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
        else
            inspectorSn3 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();


    }
}