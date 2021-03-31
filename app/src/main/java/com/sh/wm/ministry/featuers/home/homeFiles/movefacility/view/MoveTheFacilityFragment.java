package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.view;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
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
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.BottomSheetSearshList;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentMoveTheFacilityBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PostDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.viewmodel.MoveFacilityViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MoveTheFacilityFragment extends Fragment implements BottomSheetDialogGeneral.BottomSheetInterface {

    private FragmentMoveTheFacilityBinding binding;
    public static final String TAG = MoveTheFacilityFragment.class.getSimpleName();
    private ShMyDialog shMyDialog;
    private BottomSheetDialog dialog;

    private OnFragmentInteractionListener mListener;
    private MoveFacilityViewModel moveFacilityViewModel;
    private HomeViewModel homeViewModel;
    private ArrayList<Region> allRegion;
    private ArrayList<Director> directorList;
    private ArrayList<Municipality> AllMunicipal;

    private Observer<ConstructByName> constructByNameObserver;

    private BottomSheetSearshList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private EditText ed_text;
    private Observer<PostDataMoveFacility> poastDataMoveFacilityObserver;
    private BottomSheetSearshList.MyTestAdapter myTestAdapter;
    private String type, Constraction_id, municipapiity_id, region_id, mobile, directorId, streetId;
    private int count = 0;

    private BottomSheetDialogGeneral bottomSheetDialogGeneral;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this::onItemClick);
        moveFacilityViewModel = new ViewModelProvider(this).get(MoveFacilityViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        poastDataMoveFacilityObserver = new Observer<PostDataMoveFacility>() {
            @Override
            public void onChanged(PostDataMoveFacility poastDataMoveFacility) {

                binding.progressbar.setVisibility(View.GONE);

                if (poastDataMoveFacility != null) {
                    Toast.makeText(getContext(), poastDataMoveFacility.getMessageText(), Toast.LENGTH_SHORT).show();
                    mListener.onFragmentInteraction(0);

                }
                enable(true);

            }
        };

        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    bottomSheetSearshList.setMyList(constructByName.getConstructs());
                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearshList.setBottomSheetDialog(dialog);
                    myTestAdapter = new BottomSheetSearshList.MyTestAdapter(new BottomSheetSearshList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Construct constructByName) {
                            getConstructionData(constructByName.getCONSTRUCTNUM());
                            binding.cardViewSearshMoveFacility.tvOwnerName.setText("اسم المالك : " + constructByName.getCONSTRUCTIONOWNER().getOWNERNAME());
                            binding.cardViewSearshMoveFacility.tvBusinessName.setText("الاسم التجاري للمنشأة : " + constructByName.getCONSTRUCTNAMEUSING());
                            binding.cardViewSearshMoveFacility.tvOwnerId.setText("رقم هوية المالك : " + constructByName.getCONSTRUCTIONOWNER().getUSERSN());
                            Constraction_id = constructByName.getCONSTRUCTID();
                            mobile = constructByName.getCONSTRUCTMOBILE();
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                            binding.edNuFacility.setVisibility(View.GONE);

                            binding.tvNuFacility.setVisibility(View.GONE);
                            binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);

                    progressBar.setVisibility(View.GONE);
                }

            }
        };
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentMoveTheFacilityBinding.inflate(inflater, container, false);
        dialog = new BottomSheetDialog(getContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        allRegion = new ArrayList<>();
        AllMunicipal = new ArrayList<>();
        directorList = new ArrayList<>();


        binding.btnSaveMoveFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = binding.edElectronicPage.getText().toString();
                String email = binding.edEmail.getText().toString();

                if (directorId == null || municipapiity_id == null || binding.edTelephone.getText().toString().isEmpty() || binding.edPhoneNumber.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), R.string.move_facility_empty, Toast.LENGTH_LONG).show();
                } else if (!url.isEmpty() && !Patterns.WEB_URL.matcher(url).matches()) {
                    Toast.makeText(getContext(), R.string.web_page_error, Toast.LENGTH_LONG).show();
                } else if (!email.isEmpty() && !isEmailValid(email))
                    Toast.makeText(getContext(), R.string.email_error, Toast.LENGTH_LONG).show();

                else {
                    shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {


                            binding.progressbar.setVisibility(View.VISIBLE);
                            enable(false);
                            String desc = binding.edTitleDescription.getText().toString();
                            String box = binding.edMailboxNumber.getText().toString();
                            String nu_buldeing = binding.edBuldingNum.getText().toString();
                            String fax = binding.edFaxNum.getText().toString();
                            String lat = binding.edLat.getText().toString();
                            String log = binding.edLong.getText().toString();
                            String telephone = binding.edTelephone.getText().toString();
                            mobile = binding.edPhoneNumber.getText().toString();


                            moveFacilityViewModel.poastData(Constraction_id, directorId, municipapiity_id,
                                    region_id, streetId, nu_buldeing,
                                    desc, lat, log, telephone, mobile, fax, box, url, email).observe(getViewLifecycleOwner(), poastDataMoveFacilityObserver);

                            shMyDialog.dismiss();
                        }


                        @Override
                        public void edite(View view) {
                            shMyDialog.dismiss();
                        }
                    }, getString(R.string.save_enterprise_place), getString(R.string.save), getString(R.string.edit));
                    shMyDialog.show(getParentFragmentManager(), "hi their");
                }


            }
        });


        btnListener();

        binding.cardViewSearshMoveFacility.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacility.setVisibility(View.VISIBLE);
            binding.tvNuFacility.setVisibility(View.VISIBLE);
            binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            enable(true);
            binding.edNuFacility.setText("");
            dialog.show();

        });

    }


    public void enable(boolean states) {
        binding.edNuFacility.setEnabled(states);
        binding.edBuldingNum.setEnabled(states);
        binding.edElectronicPage.setEnabled(states);
        binding.edEmail.setEnabled(states);
        binding.edFaxNum.setEnabled(states);
        binding.edGovernorate.setEnabled(states);
        binding.edLat.setEnabled(states);
        binding.edLong.setEnabled(states);
        binding.edMailboxNumber.setEnabled(states);
        binding.edPhoneNumber.setEnabled(states);
        binding.edRegion.setEnabled(states);
        binding.edStreet.setEnabled(states);
        binding.edTelephone.setEnabled(states);
        binding.edTitleDescription.setEnabled(states);
        binding.edMunicipal.setEnabled(states);


    }


    public void showBtmSheet(int title, List<Municipality> list, List<Director> directors, List<Region> regions, TextView tv_change, String type) {

        this.type = type;



        switch (type) {
            case "municipality": {
                ArrayAdapter<Municipality> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

                bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);

                break;
            }
            case "director": {
                allRegion = new ArrayList<>();
                AllMunicipal = new ArrayList<>();

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

        binding.edNuFacility.setOnClickListener(view15 -> {
            dialog.setContentView(R.layout.bottom_sheet_eaarch);
            ed_text = dialog.findViewById(R.id.search_view);
            bottomSheetSearshList = dialog.findViewById(R.id.recycler_view);
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
                        moveFacilityViewModel.getConstruct(ed_text.getText().toString()).observe(getViewLifecycleOwner(), constructByNameObserver);
                    } else {
                        BottomSheetSearshList.clerList();
                        progressBar.setVisibility(View.GONE);
                        imNoData.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                    BottomSheetSearshList.clerList();
                }
            });
            dialog.show();

        });

        //"المحافظة"
        binding.edGovernorate.setOnClickListener(view15 -> {
            binding.edGovernorate.setEnabled(false);
            if (directorList.size() == 0) {
                moveFacilityViewModel.getAllDirectors().observe(getViewLifecycleOwner(), directors -> {
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
                    moveFacilityViewModel.getAllMunicipalities(directorId).observe(getViewLifecycleOwner(), municipalities -> {
                        if (municipalities != null) {
                            AllMunicipal.addAll(municipalities);
                            showBtmSheet(R.string.municipal, AllMunicipal, directorList, allRegion, binding.edMunicipal, "municipality");
                        }
                    });
            } else
                showBtmSheet(R.string.municipal, AllMunicipal, directorList, allRegion, binding.edMunicipal, "municipality");


        });

        binding.edRegion.setOnClickListener(view -> {
            if (directorId == null) {
                Toast.makeText(getContext(), R.string.director_empty, Toast.LENGTH_LONG).show();
            } else if (allRegion.size() == 0) {
                moveFacilityViewModel.getAllRegions(directorId).observe(getViewLifecycleOwner(), regions -> {
                    if (regions != null) {
                        allRegion = new ArrayList<>();
                        allRegion.addAll(regions);
                        showBtmSheet(R.string.region, AllMunicipal, directorList, allRegion, binding.edRegion, "region");
                    }
                });
            } else
                showBtmSheet(R.string.region, AllMunicipal, directorList, allRegion, binding.edRegion, "region");


        });


    }


    private void getConstructionData(String constructNumber) {
        binding.progressbar.setVisibility(View.VISIBLE);
        enable(false);
        homeViewModel.getConstructByNumber(constructNumber).observe(getViewLifecycleOwner(), new Observer<ConstructionGroup>() {
            @Override
            public void onChanged(ConstructionGroup constructionGroup) {
                if (constructionGroup != null) {
                    binding.progressbar.setVisibility(View.GONE);
                    enable(true);

                    binding.edPhoneNumber.setText(constructionGroup.getConstruction().getCONSTRUCTMOBILE());
                    binding.edTelephone.setText(constructionGroup.getConstruction().getCONSTRUCTTELEPHONE());
                    binding.edLat.setText(constructionGroup.getConstruction().getCONSTRUCTXDIMENSION());
                    binding.edLong.setText(constructionGroup.getConstruction().getCONSTRUCTYDIMENSION());
                    binding.edBuldingNum.setText(constructionGroup.getConstruction().getCONSTRUCTBULDINGNUM());
                    binding.edFaxNum.setText(constructionGroup.getConstruction().getCONSTRUCTFAX());
                    binding.edEmail.setText(constructionGroup.getConstruction().getCONSTRUCTEMAIL());
                    binding.edElectronicPage.setText(constructionGroup.getConstruction().getCONSTRUCTURLPAGE());
                    binding.edMailboxNumber.setText(constructionGroup.getConstruction().getCONSTRUCTMOB());
                    binding.edTitleDescription.setText(constructionGroup.getConstruction().getCONSTRUCTADDRESS());

                    municipapiity_id = constructionGroup.getConstruction().getCONSTRUCTMUNICIPALITYID();
                    region_id = constructionGroup.getConstruction().getCONSTRUCTREGIONID();
                    directorId = constructionGroup.getConstruction().getCONSTRUCTADDRESSID();

                    binding.edGovernorate.setText(constructionGroup.getConstruction().getDirectorate());
                    binding.edRegion.setText(constructionGroup.getConstruction().getCONSTRUCTREGION());
                    binding.edMunicipal.setText(constructionGroup.getConstruction().getCONSTRUCTMUNICIPALITY());


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

    private boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}