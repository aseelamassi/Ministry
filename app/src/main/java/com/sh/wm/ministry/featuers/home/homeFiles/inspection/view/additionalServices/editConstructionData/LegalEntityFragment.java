package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData;

import android.os.Bundle;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentLegalEntityBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.OwnerAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.SecondaryActivityAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.LegalEntityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner.ConstructionOwnerModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class LegalEntityFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {


    private FragmentLegalEntityBinding binding;
    private InspectionsViewModel inspectionsViewModel;
    private DateAdder dateAdder;
    private String type, sectorType, dateType, sessionId, mainEconomicId, secondaryEconomicId, constructionWorkStatusSecId, constructionTypeId, constructionLegalId, constructionOwnershipId;
    private RadioButtonCreation creation;
    private Observer<List<EconomicSector>> economicSectors;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;

    private ArrayList<EconomicSector> economicSectorList;
    private BottomSheetDialogGeneral bottomSheetDialogGeneral;


    private InspectionVisit inspectionVisit;
    private UserFileViewModel viewModel;
    private ArrayList<Constants> constantList, yesOrNoList;


    private BottomSheetDialog dialog;
    private EditText ed_text;
    private BottomSheetSearchList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private Construction construction;


    public LegalEntityFragment() {
        // Required empty public constructor
    }

    public static LegalEntityFragment newInstance() {
        LegalEntityFragment fragment = new LegalEntityFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLegalEntityBinding.inflate(inflater, container, false);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        yesOrNoList = new ArrayList<>();
        getConstant("53");

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);

        creation = new RadioButtonCreation(getContext());

        getBundle();
        getOwners();

        getLegalData();


        economicSectors = new Observer<List<EconomicSector>>() {
            @Override
            public void onChanged(List<EconomicSector> economicSectors) {
                economicSectorList = new ArrayList<>();
                if (economicSectors != null) {
                    economicSectorList.addAll(economicSectors);

                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearshList.setBottomSheetDialog(dialog);
                    bottomSheetSearshList.setMyList((ArrayList<?>) economicSectorList, ed_text.getText().toString());

                    myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object object) {
                            if (sectorType.equals("mainSector")) {
                                binding.edMainActive.setText(((EconomicSector) object).getText());
                                mainEconomicId = ((EconomicSector) object).getId();
                            } else {
                                binding.edSecondaryActive.setText(((EconomicSector) object).getText());
                                secondaryEconomicId = ((EconomicSector) object).getId();
                            }

                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);

                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    economicSectorList.clear();
                    myTestAdapter.notifyDataSetChanged();
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        btnListener();
        return binding.getRoot();
    }


    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
            construction = (Construction) bundle.getSerializable("construct");
        }
    }

    private boolean isEnabled = true;

    private void saveAction(String submit){
        if (!isEnabled){
            Toast.makeText(getContext(), getString(R.string.can_not_change), Toast.LENGTH_SHORT).show();
        }

        else if (binding.edManagerSn.getText().toString().isEmpty() || mainEconomicId == null || constructionTypeId == null || constructionLegalId == null || constructionOwnershipId == null || sessionId == null || constructionWorkStatusSecId == null || binding.edPracticingYear.getText().toString().isEmpty() || binding.edWorkerNumberCurrently.getText().toString().isEmpty() || binding.edWorkerNumberWhenEstablishing.getText().toString().isEmpty() || (binding.edStartDate.getVisibility() == View.VISIBLE && binding.edStartDate.getText().toString().isEmpty()) || (binding.edEndDate.getVisibility() == View.VISIBLE && binding.edEndDate.getText().toString().isEmpty())) {
            Toast.makeText(getContext(), getString(R.string.legal_entity_empty), Toast.LENGTH_SHORT).show();
        } else {
            if (submit.equals("submit_approve"))
                isEnabled = false;
            inspectionsViewModel.storeLegalEntityData("update", inspectionVisit.getCONSTRUCTID(), binding.edManagerSn.getText().toString(), "", "0", constructionLegalId, constructionTypeId, constructionOwnershipId, mainEconomicId, binding.edActiveDescription.getText().toString(), sessionId, binding.edPracticingYear.getText().toString(), constructionWorkStatusSecId, binding.edWorkerNumberWhenEstablishing.getText().toString(), binding.edWorkerNumberCurrently.getText().toString(), binding.edStartDate.getText().toString(), binding.edEndDate.getText().toString(), inspectionVisit.getINSPECTVID(), submit);
        }
    }
    private void btnListener() {


        binding.btnSave.setOnClickListener(view -> {
            if (!NetworkUtils.isOnline(getContext()))
                Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();

            saveAction("submit");

        });

        binding.btnSaveWithApprove.setOnClickListener(view -> {


            if (!NetworkUtils.isOnline(getContext()))
                Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();
            saveAction("submit_approve");
        });


        binding.edMainActive.setOnClickListener(view -> {
            sectorType = "mainSector";
            showBottomSearchSheet(economicSectors, "mainSector");
        });


        binding.edSecondaryActive.setOnClickListener(view -> {
            sectorType = "secondary";
            showBottomSearchSheet(economicSectors, "secondary");
        });
        binding.btnAdaOwner.setOnClickListener(view -> {
            if (binding.edStartWorkDate.getText().toString().isEmpty() || binding.etSn.getText().toString().isEmpty())
                Toast.makeText(getContext(), getString(R.string.owner_empty), Toast.LENGTH_SHORT).show();
            else
                inspectionsViewModel.storeAddOwner(inspectionVisit.getCONSTRUCTID(), binding.etSn.getText().toString(), SharedPreferneceHelper.getUserId(getContext()), binding.edStartWorkDate.getText().toString(), inspectionVisit.getINSPECTVID(), "0");
        });


        binding.btnAddSecondarySector.setOnClickListener(view -> {
            if (secondaryEconomicId == null)
                Toast.makeText(getContext(), getString(R.string.secondary_sector_empty), Toast.LENGTH_SHORT).show();
            else
                inspectionsViewModel.storeSecondarySector(inspectionVisit.getCONSTRUCTID(), secondaryEconomicId, binding.edSecondaryActiveDescription.getText().toString());
        });


        binding.edStartWorkDate.setOnClickListener(view -> {
                    dateType = "ownerStartDate";
                    dateAdder.show();
                }
        );
        binding.btnGetData.setOnClickListener(view -> {
            if (binding.etSn.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), getString(R.string.dependent_empty), Toast.LENGTH_SHORT).show();
            } else if (binding.etSn.getText().toString().length()<9)
                Toast.makeText(getContext(), getString(R.string.sn_must_be_9), Toast.LENGTH_SHORT).show();
            else {


                if (!NetworkUtils.isOnline(getContext()))
                    Toast.makeText(getContext(), getString(R.string.usersn_no_internet), Toast.LENGTH_SHORT).show();
                else {

                    getName(binding.etSn.getText().toString(),binding.edOwnerName );
                }
            }

        });


        binding.btnGetManagerData.setOnClickListener(view -> {
            if (binding.edManagerSn.getText().toString().isEmpty() ) {
                Toast.makeText(getContext(), getString(R.string.dependent_empty), Toast.LENGTH_SHORT).show();
            }else if (binding.edManagerSn.getText().toString().length()<9)
                Toast.makeText(getContext(), getString(R.string.sn_must_be_9), Toast.LENGTH_SHORT).show();


            else {


                if (!NetworkUtils.isOnline(getContext()))
                    Toast.makeText(getContext(), getString(R.string.usersn_no_internet), Toast.LENGTH_SHORT).show();
                else {

                    getName(binding.etSn.getText().toString() ,binding.edManagerName);

                }
            }

        });


        binding.edConstructionPermanence.setOnClickListener(view -> {
            binding.edConstructionPermanence.setEnabled(false);
            getConstant("32");
        });


        binding.rgSecondaryActive.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                if (radioButton != null && radioButton.getTag() != null)
                    constructionWorkStatusSecId = (String) radioButton.getTag();
                if (constructionWorkStatusSecId != null && constructionWorkStatusSecId.equals("530002")) {
                    binding.edSecondaryActive.setEnabled(false);
                    binding.edSecondaryActiveDescription.setEnabled(false);
                    binding.btnAddSecondarySector.setVisibility(View.GONE);
                } else {
                    binding.edSecondaryActive.setEnabled(true);
                    binding.edSecondaryActiveDescription.setEnabled(true);
                    binding.btnAddSecondarySector.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.edTvConstructionType.setOnClickListener(view -> {
            binding.edTvConstructionType.setEnabled(false);
            getConstant("1650411");
        });


        binding.edLegalEntity.setOnClickListener(view -> {
            binding.edLegalEntity.setEnabled(false);
            getConstant("48");
        });

        binding.edConstructionOwnership.setOnClickListener(view -> {
            binding.edConstructionOwnership.setEnabled(false);
            getConstant("44");
        });

        binding.edStartDate.setOnClickListener(view -> {
            dateType = "start";
            dateAdder.show();
        });

        binding.edEndDate.setOnClickListener(view -> {
            dateType = "end";
            dateAdder.show();
        });


    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        if (dateType.equals("ownerStartDate")) {
            binding.edStartWorkDate.setText(format.format(date));
        } else if (dateType.equals("start"))
            binding.edStartDate.setText(format.format(date));
        else
            binding.edEndDate.setText(format.format(date));


    }


    public void getConstant(String parentId) {
        viewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                constantList = new ArrayList<>();

                if (constants != null) {
                    constantList.addAll(constants);
                    switch (parentId) {
                        case "32":
                            showBtmSheet(R.string.construction_permanence, constantList, binding.edConstructionPermanence, "session");
                            break;
                        case "53":
                            if (yesOrNoList.size() == 0) {
                                yesOrNoList.addAll(constants);
                                creation.addRadioButtons(binding.rgSecondaryActive, constantList, "workSecondary");
                            }
                            break;
                        case "1650411":
                            showBtmSheet(R.string.construction_type, constantList, binding.edTvConstructionType, "constructionType");
                            break;
                        case "48":
                            showBtmSheet(R.string.legal_entity, constantList, binding.edLegalEntity, "legalEntity");
                            break;
                        case "44":
                            showBtmSheet(R.string.construction_ownership, constantList, binding.edConstructionOwnership, "ownership");
                            break;
                    }


                } else {

                    switch (parentId) {
                        case "32":
                            binding.edConstructionPermanence.setEnabled(true);
                            break;
                        case "1650411":
                            binding.edTvConstructionType.setEnabled(true);
                            break;
                        case "48":
                            binding.edLegalEntity.setEnabled(true);
                            break;
                        case "44":
                            binding.edConstructionOwnership.setEnabled(true);
                            break;
                    }

                    Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void showBtmSheet(int title, List<Constants> constants, TextView tv_change, String type) {

        this.type = type;
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);
        ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, constants);
        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);


    }

    private void getOwners() {
        if (NetworkUtils.isOnline(getContext())) {
            inspectionsViewModel.getConstructionOwner(inspectionVisit.getCONSTRUCTID()).observe(getViewLifecycleOwner(), new Observer<ConstructionOwnerModel>() {
                @Override
                public void onChanged(ConstructionOwnerModel constructionOwnerModel) {
                    if (constructionOwnerModel != null) {
                        binding.rvOwner.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.rvOwner.setAdapter(new OwnerAdapter(getContext(), constructionOwnerModel.getConstructOwner()));
                    }
                }
            });
        }
    }


    private void getLegalData() {
        inspectionsViewModel.getLegalEntity(inspectionVisit.getCONSTRUCTID()).observe(getViewLifecycleOwner(), new Observer<LegalEntityModel>() {
            @Override
            public void onChanged(LegalEntityModel legalEntityModel) {
                if (legalEntityModel != null) {

                    if (legalEntityModel.getGetSeconWork() != null && legalEntityModel.getGetSeconWork().size() != 0) {
                        binding.rvSecondaryActive.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.rvSecondaryActive.setAdapter(new SecondaryActivityAdapter(getContext(), legalEntityModel.getGetSeconWork()));
                    }
                    binding.edWorkerNumberWhenEstablishing.setText(legalEntityModel.getConstructData().get(0).getCONSTRUCTWORKFOUNDATIONN());
                    binding.edWorkerNumberCurrently.setText(legalEntityModel.getConstructData().get(0).getCONSTRUCTWORKEMPLOYEENUM());
                    binding.edPracticingYear.setText(legalEntityModel.getConstructData().get(0).getCONSTRUCTYEARACTIVITMAIN());


                }
            }
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

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (ed_text.getText().toString().length() >= 3) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                    inspectionsViewModel.getEconomicSector(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);


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


    private void enable(boolean b) {
        binding.btnSaveWithApprove.setEnabled(b);
        binding.btnSave.setEnabled(b);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (type) {
            case "session":
                sessionId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                if (sessionId.equals("320002")) {
                    binding.tvStartDate.setVisibility(View.VISIBLE);
                    binding.edStartDate.setVisibility(View.VISIBLE);
                    binding.tvEndDate.setVisibility(View.VISIBLE);
                    binding.edEndDate.setVisibility(View.VISIBLE);
                } else {
                    binding.tvStartDate.setVisibility(View.GONE);
                    binding.edStartDate.setVisibility(View.GONE);
                    binding.tvEndDate.setVisibility(View.GONE);
                    binding.edEndDate.setVisibility(View.GONE);
                }

                break;
            case "constructionType":
                constructionTypeId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "legalEntity":
                constructionLegalId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "ownership":
                constructionOwnershipId = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
        }


    }


    private void  getName(String sn , TextView textView){
        inspectionsViewModel.getUserInfo(sn).observe(getViewLifecycleOwner(), new Observer<UserInfoModel>() {
            @Override
            public void onChanged(UserInfoModel userInfoModel) {
                if (userInfoModel != null) {
                    textView.setText(userInfoModel.getUserWorkInfo().getwORKERNAME());


                }
            }
        });

    }
}