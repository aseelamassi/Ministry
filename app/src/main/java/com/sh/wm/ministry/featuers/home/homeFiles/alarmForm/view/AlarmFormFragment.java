package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentAlarmFormBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter.SubjectNumberAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.viewmodel.AlarmFormViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.model.Inspector;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class AlarmFormFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {
    private BottomSheetDialog sheetDialog;
    private FragmentAlarmFormBinding binding;
    private AlarmFormViewModel alarmFormViewModel;
    private HomeViewModel homeViewModel;

    private BottomSheetDialog dialog;
    private Observer<ConstructByName> constructByNameObserver;

    private EditText ed_text;

    private ImageView imNoData;
    private ProgressBar progressBar;
    private String Constraction_id, palLawId, inspectorSn1, inspectorSn2, inspectorSn3, type;

    private BottomSheetSearchList bottomSheetSearchList;
    private BottomSheetSearchList.MyTestAdapter myAdapter;

    private ShMyDialog shMyDialog;


    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime, startDate;
    private int mYear, mMonth, mDay;

    private int thisPosition;
    private String visitOrAlarm;
    private boolean isToday, isTodayAlarm, isBigger;

    private SubjectNumberAdapter subjectNumberAdapter;
    private Observer<PalLawModel> palLawObserver;

    private ArrayList<PalLaw> lawList;

    private HashMap<String, String> laws;

    private ArrayList<Inspector> inspectorList;

    public static final String TAG = AlarmFormFragment.class.getSimpleName();

    private BottomSheetDialogGeneral bottomSheetDialogGeneral;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);

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
                            binding.cardViewSearshAlarmForm.llSecondView.setVisibility(View.VISIBLE);
                            if (((Construct) constructByName).getCONSTRUCTIONOWNER() != null) {
                                binding.cardViewSearshAlarmForm.tvOwnerName.setText(getString(R.string.owner_name) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME());
                                binding.cardViewSearshAlarmForm.tvOwnerId.setText(getString(R.string.owner_id) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getUSERSN());

                            } else {
                                binding.cardViewSearshAlarmForm.tvOwnerName.setText(getString(R.string.owner_name));
                                binding.cardViewSearshAlarmForm.tvOwnerId.setText(getString(R.string.owner_id));
                            }

                            if (((Construct) constructByName).getCONSTRUCTTELEPHONE() != null)
                                binding.cardViewSearshAlarmForm.tvBusinessName.setText(getString(R.string.phone) + " " + ((Construct) constructByName).getCONSTRUCTTELEPHONE());
                            binding.cardViewSearshAlarmForm.tvActiveSector.setText(getString(R.string.The_business_name) + " " + ((Construct) constructByName).getCONSTRUCTNAMEUSING());
                            binding.cardViewSearshAlarmForm.tvWorkField.setText(getString(R.string.state) + " " + ((Construct) constructByName).getCONSTRUCTMAINECON());
                            binding.cardViewSearshAlarmForm.tvInstitutionName.setText(getString(R.string.address_details) + " " + ((Construct) constructByName).getCONSTRUCTADDRESS());

                            Constraction_id = ((Construct) constructByName).getCONSTRUCTID();
                            binding.tvNuFacilityAlarmFormFragment.setVisibility(View.GONE);
                            binding.edNuFacilityAlarmFormFragment.setVisibility(View.GONE);
                            binding.cardViewSearshAlarmForm.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
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
        binding = FragmentAlarmFormBinding.inflate(inflater, container, false);
        sheetDialog = new BottomSheetDialog(getContext());
        //getDate from ed_visite
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        //get time zone
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setup viewModel
        alarmFormViewModel = new ViewModelProvider(this).get(AlarmFormViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        dialog = new BottomSheetDialog(getContext());


        //add the last item null to check the item before and know that last item is not null
        lawList.add(null);
        subjectNumberAdapter = new SubjectNumberAdapter(lawList, position -> {
            thisPosition = position;
            showBottomSearchSheet(palLawObserver, "palLaw");
        });

        binding.edArticleNumberAlarmFormFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.edArticleNumberAlarmFormFragment.setAdapter(subjectNumberAdapter);


        btnListener();

    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        if (visitOrAlarm.equals("visit")) {
            startDate = chosenTime;
            isToday = DateUtils.isToday(chosenTime);
            binding.edDateVisit.setText(format.format(date));
        } else {
            isTodayAlarm = DateUtils.isToday(chosenTime);
            isBigger = startDate >= chosenTime;
            binding.edDateAlarm.setText(format.format(date));
        }
    }


    public void desapel(boolean desabel) {

        binding.edNuFacilityAlarmFormFragment.setEnabled(desabel);
        binding.edDateAlarm.setEnabled(desabel);
        binding.edDateVisit.setEnabled(desabel);
        binding.edArticleNumberAlarmFormFragment.setEnabled(desabel);
        binding.edMember1.setEnabled(desabel);
        binding.edMember2.setEnabled(desabel);
        binding.edMember3.setEnabled(desabel);


    }


    private void btnListener() {
        binding.edNuFacilityAlarmFormFragment.setOnClickListener(view15 -> {
            showBottomSearchSheet(constructByNameObserver, "constructName");
        });

        binding.cardViewSearshAlarmForm.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
            binding.tvNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
            binding.cardViewSearshAlarmForm.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            binding.edNuFacilityAlarmFormFragment.setText("");


        });

        binding.btnAdd.setOnClickListener(view1 -> {

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
            visitOrAlarm = "visit";
            dateAdder.show();
        });

        binding.edDateAlarm.setOnClickListener(view16 -> {
            visitOrAlarm = "alarm";
            dateAdder.show();
        });


        binding.cardViewSearshAlarmForm.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
            binding.tvNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
            binding.cardViewSearshAlarmForm.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);


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


        binding.btnSaveAlarmFormFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String visitDate = binding.edDateVisit.getText().toString();
                String alarmDate = binding.edDateAlarm.getText().toString();

                desapel(false);

                laws = new HashMap<>();
                for (int  i =0 ; i<lawList.size() ; i++)
                    if (lawList.get(i) != null)
                      laws.put("LAW_ARTICAL_NUM_" + (i+1), lawList.get(i).getId());


                if (Constraction_id == null || (inspectorSn1 == null & inspectorSn2 == null & inspectorSn3 == null) || visitDate.isEmpty() || alarmDate.isEmpty() || laws.size() == 0) {
                    Toast.makeText(getContext(), R.string.alarm_empty, Toast.LENGTH_LONG).show();
                    desapel(true);
                } else if (isToday) {
                    desapel(true);
                    Toast.makeText(getContext(), R.string.visit_today, Toast.LENGTH_LONG).show();
                } else if (isTodayAlarm) {
                    desapel(true);
                    Toast.makeText(getContext(), R.string.alarm_today, Toast.LENGTH_LONG).show();
                } else if (isBigger) {
                    desapel(true);
                    Toast.makeText(getContext(), R.string.alarm_bigger, Toast.LENGTH_LONG).show();
                } else {
                    shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {

                            binding.progressbar.setVisibility(View.VISIBLE);
                            //palLawId1, palLawId2 , palLawId3, palLawId4 , palLawId5

                            alarmFormViewModel.storeConstructionAlarm(Constraction_id, visitDate, alarmDate, laws, inspectorSn1, inspectorSn2, inspectorSn3, null).observe(getViewLifecycleOwner(), new Observer<UpdateUser>() {
                                @Override
                                public void onChanged(UpdateUser updateUser) {
                                    if (updateUser != null) {
                                        desapel(true);
                                        binding.progressbar.setVisibility(View.GONE);
                                    }

                                }
                            });


                            shMyDialog.dismiss();
                        }


                        @Override
                        public void edite(View view) {
                            shMyDialog.dismiss();
                        }
                    }, getString(R.string.save_alarm), getString(R.string.save), getString(R.string.cancel));
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