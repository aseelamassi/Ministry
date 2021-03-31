package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentMainConstructionDataBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainConstructionDataFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {


    FragmentMainConstructionDataBinding binding;

    private ArrayList<Region> allRegion;
    private ArrayList<Director> directorList;

    private ArrayList<Municipality> AllMunicipal;

    private Construction construction;

    private String type, municipapiity_id, region_id, mobile, directorId, streetId;


    private boolean isEnabled = true ;
    private ShMyDialog shMyDialog;
    private BottomSheetDialog dialog;

    private DateAdder dateAdder;


    private InspectionVisit inspectionVisit;


    private HomeViewModel viewModel;
    private InspectionsViewModel inspectionsViewModel;


    private BottomSheetDialogGeneral bottomSheetDialogGeneral ;
    public MainConstructionDataFragment() {
        // Required empty public constructor
    }


    public static MainConstructionDataFragment newInstance() {
        MainConstructionDataFragment fragment = new MainConstructionDataFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //construct
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainConstructionDataBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        inspectionsViewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);


        getBundle();

        dialog = new BottomSheetDialog(getContext());

        allRegion = new ArrayList<>();
        AllMunicipal = new ArrayList<>();
        directorList = new ArrayList<>();

        btnListener();

        return binding.getRoot();
    }


    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
            binding.edDateVisit.setText(inspectionVisit.getVISITDATE());
            binding.edConstructionNo.setText(inspectionVisit.getCONSTRUCTNUM());
            binding.edTvTradeBusinessName.setText(inspectionVisit.getCONSTRUCTNAMEUSING());
            binding.edGovernorate.setText(inspectionVisit.getDIRECTORATENAME());
            directorId = inspectionVisit.getCONSTRUCTADDRESSID();

            construction = (Construction) bundle.getSerializable("construct");

            if (construction != null) {
                if (construction.getCONSTRUCTTELEPHONE() != null)
                    binding.edPhoneNumber.setText(construction.getCONSTRUCTTELEPHONE());
                if (construction.getCONSTRUCTNAMEUSINGPRIMAR() != null)
                    binding.edTvOfficialBusinessName.setText(construction.getCONSTRUCTNAMEUSINGPRIMAR());

                if (construction.getCONSTRUCTXDIMENSION() != null)
                    binding.edLat.setText(construction.getCONSTRUCTXDIMENSION());

                if (construction.getCONSTRUCTYDIMENSION() != null)
                    binding.edLong.setText(construction.getCONSTRUCTYDIMENSION());
                if (construction.getCONSTRUCTTELEPHONE() != null)
                    binding.edTelephone.setText(construction.getCONSTRUCTTELEPHONE());
                if (construction.getCONSTRUCTMOB() != null)
                    binding.edMailboxNumber.setText(construction.getCONSTRUCTMOB());

                if (construction.getCONSTRUCTFAX() != null)
                    binding.edFaxNum.setText(construction.getCONSTRUCTFAX());
                if (construction.getCONSTRUCTURLPAGE() != null)
                    binding.edElectronicPage.setText(construction.getCONSTRUCTURLPAGE());
                if (construction.getCONSTRUCTEMAIL() != null)
                    binding.edEmail.setText(construction.getCONSTRUCTEMAIL());

                if (construction.getCONSTRUCTBULDINGNUM() != null)

                    binding.edBuildingNum.setText(construction.getCONSTRUCTBULDINGNUM());
                if (construction.getCONSTRUCTADDRESS() != null)

                    binding.edStreetDetail.setText(construction.getCONSTRUCTADDRESS());

                if (construction.getCONSTRUCTIONOWNER() != null)
                    binding.edSnNumber.setText(construction.getCONSTRUCTIONOWNER().getUSERSN());
                if (construction.getDirectorate() != null)


                    binding.edGovernorate.setText(construction.getDirectorate());
                if (construction.getCONSTRUCTREGION() != null)

                    region_id = construction.getCONSTRUCTREGIONID();
                    binding.edRegion.setText(construction.getCONSTRUCTREGION());
                if (construction.getCONSTRUCTMUNICIPALITY() != null)
                    municipapiity_id = construction.getCONSTRUCTMUNICIPALITYID();
                    binding.edMunicipal.setText(construction.getCONSTRUCTMUNICIPALITY());
            }


        }
    }



    public void showBtmSheet(int title, List<Municipality> list, List<Director> directors, List<Region> regions, TextView tv_change, String type) {


        this.type = type;

        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext() , this);


        switch (type) {
            case "municipality": {
                ArrayAdapter<Municipality> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
                break;
            }
            case "director": {
                allRegion.clear();
                AllMunicipal.clear();
                binding.edMunicipal.setText("");
                binding.edRegion.setText("");

                ArrayAdapter<Director> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, directors);
                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);
                break;
            }
            case "region": {
                ArrayAdapter<Region> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, regions);
                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);

                break;
            }
        }


    }


    private void btnListener() {

        //"المحافظة"
        binding.edGovernorate.setOnClickListener(view15 -> {
            binding.edGovernorate.setEnabled(false);
            if (directorList.size() == 0) {
                viewModel.getAllDirectors().observe(getViewLifecycleOwner(), directors -> {
                    if (directors != null) {
                        directorList.addAll(directors);
                        showBtmSheet(R.string.governorate, AllMunicipal, directorList, allRegion, binding.edGovernorate, "director");
                    }

                });
            } else
                showBtmSheet(R.string.governorate, AllMunicipal, directorList, allRegion, binding.edGovernorate, "director");


        });
//البلدية
        binding.edMunicipal.setOnClickListener(view13 -> {
            binding.edMunicipal.setEnabled(false);
            if (AllMunicipal.size() == 0) {
                if (directorId == null) {
                    binding.edMunicipal.setEnabled(true);
                    Toast.makeText(getContext(), R.string.director_empty, Toast.LENGTH_LONG).show();
                } else
                    viewModel.getAllMunicipalities(directorId).observe(getViewLifecycleOwner(), municipalities -> {
                        if (municipalities != null) {
                            AllMunicipal.addAll(municipalities);
                            showBtmSheet(R.string.municipal, AllMunicipal, directorList, allRegion, binding.edMunicipal, "municipality");
                        }
                    });
            } else
                showBtmSheet(R.string.municipal, AllMunicipal, directorList, allRegion, binding.edMunicipal, "municipality");


        });

        binding.edRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.edRegion.setEnabled(false);
                if (allRegion.size() == 0) {

                    if (directorId == null) {
                        binding.edRegion.setEnabled(true);
                        Toast.makeText(getContext(), R.string.director_empty, Toast.LENGTH_LONG).show();
                    } else
                        viewModel.getAllRegions(directorId).observe(getViewLifecycleOwner(), regions -> {
                            if (regions != null) {
                                allRegion.addAll(regions);
                                showBtmSheet(R.string.region, AllMunicipal, directorList, allRegion, binding.edRegion, "region");
                            }
                        });
                } else
                    showBtmSheet(R.string.region, AllMunicipal, directorList, allRegion, binding.edRegion, "region");


            }
        });


        binding.btnSaveMoveFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!NetworkUtils.isOnline(getContext()))
                    Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();
                saveAction("submit");
            }
        });


        binding.btnSaveWithApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!NetworkUtils.isOnline(getContext()))
                    Toast.makeText(getContext(), getString(R.string.worker_health_no_internet), Toast.LENGTH_SHORT).show();

                saveAction("submit_approve");

            }
        });

        binding.edDateVisit.setOnClickListener(view -> dateAdder.show());
    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        binding.edDateVisit.setText(format.format(date));

    }


    private boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void saveAction(String save) {

        if (!isEnabled){
            Toast.makeText(getContext(), getString(R.string.can_not_change), Toast.LENGTH_SHORT).show();
        }
        else if (binding.edDateVisit.getText().toString().isEmpty() || binding.edTvTradeBusinessName.getText().toString().isEmpty() || binding.edTvOfficialBusinessName.getText().toString().isEmpty() || directorId == null ||
                municipapiity_id == null || binding.edTelephone.getText().toString().isEmpty() || binding.edPhoneNumber.getText().toString().isEmpty())
            Toast.makeText(getContext(), getString(R.string.main_data_construct_empty), Toast.LENGTH_SHORT).show();
        else if (binding.edPhoneNumber.getText().toString().length() < 10)
            Toast.makeText(getContext(), getString(R.string.phone_less_than_10), Toast.LENGTH_SHORT).show();

        else if (!binding.edEmail.getText().toString().isEmpty() && !isEmailValid(binding.edEmail.getText().toString())) {
            Toast.makeText(getContext(), getString(R.string.wrong_email), Toast.LENGTH_SHORT).show();
        } else if (!binding.edElectronicPage.getText().toString().isEmpty() && !Patterns.WEB_URL.matcher(binding.edElectronicPage.getText().toString()).matches()) {
            Toast.makeText(getContext(), getString(R.string.wrong_url), Toast.LENGTH_SHORT).show();

        } else {
            if (save.equals("submit_approve")) {
                if (save.equals("submit_approve"))
                    isEnabled = false;
            }
            inspectionsViewModel.storeConstructionBasicInfo("update", inspectionVisit.getCONSTRUCTID(), directorId, inspectionVisit.getCONSTRUCTNUM(), binding.edDateVisit.getText().toString(), binding.edTvTradeBusinessName.getText().toString(), binding.edTvOfficialBusinessName.getText().toString(), municipapiity_id, region_id, streetId, binding.edStreetDetail.getText().toString(), binding.edBuildingNum.getText().toString(), binding.edTitleDescription.getText().toString(), binding.edLong.getText().toString(), binding.edLat.getText().toString(), binding.edTelephone.getText().toString(), binding.edPhoneNumber.getText().toString(),
                    binding.edFaxNum.getText().toString(), binding.edMailboxNumber.getText().toString(), binding.edElectronicPage.getText().toString(), binding.edEmail.getText().toString(), "", inspectionVisit.getINSPECTVID(), save);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (type) {
            case "municipality":
                municipapiity_id = ((Municipality) adapterView.getItemAtPosition(i)).getMUNICIPALITYID();
                break;
            case "director":
                directorId = ((Director) adapterView.getItemAtPosition(i)).getID();
                break;
            case "region":
                region_id = ((Region) adapterView.getItemAtPosition(i)).getREGIONID();
                break;
        }

    }
}