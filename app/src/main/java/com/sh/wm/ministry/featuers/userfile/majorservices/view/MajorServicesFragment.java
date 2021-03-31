package com.sh.wm.ministry.featuers.userfile.majorservices.view;

import android.content.res.ColorStateList;
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
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.databinding.FragmentMajorServicesBinding;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserWorkInfo;
import com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel.MajorServicesViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;

import java.util.ArrayList;
import java.util.List;

public class MajorServicesFragment extends Fragment implements BottomSheetDialogGeneral.BottomSheetInterface , BottomSheetSearch.BottomSheetSearchInterface {

    private FragmentMajorServicesBinding binding;
    private MajorServicesViewModel mViewModel;
    private List<Country> countriesName;
    private ShMyDialog dialog;
    private String otherNationalityId;
    private String directorId;
    private UserWorkInfo info;
    private List<Director> directors;
    private String otherCountry;
    private Observer<List<Country>> countryObserver;
    private UserFileViewModel userFileViewModel;



    private String otherNationalityText;


    private BottomSheetSearch bottomSheetSearch;


    public static MajorServicesFragment newInstance() {
        return new MajorServicesFragment();
    }

    private BottomSheetDialogGeneral bottomSheetDialogGeneral;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);
        bottomSheetSearch = new BottomSheetSearch(getContext() ,this);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMajorServicesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.progress.setVisibility(View.VISIBLE);
        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        binding.btSaveMajorServices.setEnabled(false);
        directors = new ArrayList<>();

        //setup viewModels
        mViewModel = new ViewModelProvider(this).get(MajorServicesViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);


        //get user info from API
        mViewModel.getUserInfo().observe(getViewLifecycleOwner(), userWorkInfo -> {
            binding.progress.setVisibility(View.GONE);
            //enable user interaction when progress is visible
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            if (userWorkInfo != null) {


                binding.btSaveMajorServices.setEnabled(true);

                info = userWorkInfo.getUserWorkInfo();

                //setup data and  display user info in the views
                binding.etUserIdMajorServices.setText(info.getUSERSN());
                binding.etFirstNameMajorServices.setText(info.getUSERFNAMEAR());
                binding.etFatherName.setText(info.getUSERSNAMEAR());
                binding.etGrandNameMajorServices.setText(info.getUSERTNAMEAR());
                binding.etFamilyName.setText(info.getUSERLNAMEAR());
                binding.etDocumentType.setText(info.getUSERDOCSTYPE());
                binding.etDocumentNo.setText(info.getUSERSN());
                binding.etGenderMajorServices.setText(info.getUSERSEX());
                binding.etBirthPlaceMajorServices.setText(info.getBIRTHPLACE());
                binding.tvBirthDateMajorServices.setText(info.getBRITHDATE());
                binding.etMotherNameMajorServices.setText(info.getUSERMOTHERNAME());
                binding.etSocialStatusMajorServices.setText(info.getSOCIALSTATUS());
                binding.etChildNumberMajorServices.setText(info.getUSERCHIDEDNUM());
                if (info.getUSERDEATHDATE() == null)
                    binding.tvDeathDateMajorServices.setText("-");
                else
                    binding.tvDeathDateMajorServices.setText(String.valueOf(info.getUSERDEATHDATE()));

                //get country for  nationality arabic name from it's id
                mViewModel.getUserCountry(info.getUSERNATIONALITYID()).observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String country) {
                        if (country != null) {
                            otherCountry = country;
                            binding.etNationalityMajorServices.setText(country);
                        } else {
                            binding.etNationalityMajorServices.setText("-");
                        }
                    }
                });


                //get country for another nationality arabic name from it's id
                mViewModel.getUserCountry(info.getUSERNATIONALITYOTHERID()).observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String country) {
                        if (country != null) {
                            binding.etOtherNationalityIdMajorServices.setText(country);
                            otherNationalityText = country;

                        } else {
                            binding.etOtherNationalityIdMajorServices.setText("-");
                            otherNationalityText = "-";
                        }
                    }
                });
                ;


                ////////////////// setup directory if it is not null it will be enabled to update else it will be disabled
                if (info.getUSERDIRECTORATE() != null) {
                    binding.etDirectorateBelongs.setText(info.getUSERDIRECTORATE());
                    directorId = info.getUSERDIRECTORATEID();
                    binding.etDirectorateBelongs.setEnabled(false);
                    binding.etDirectorateBelongs.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_gray)));


                }
                binding.etAgeMajorServices.setText(info.getUSERAGE());
            } else {
                new ToastMsg(getContext()).toastIconError(getString(R.string.proccess_failed));

                binding.btSaveMajorServices.setEnabled(true);
            }

        });

        //observer for displaying countries and get selected country id
        countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countriesName = new ArrayList<>();
                if (countries != null) {
                    countriesName.addAll(countries);
                    bottomSheetSearch.setUpAdapter(countries , getActivity());

                } else {
                    countriesName.clear();
                   bottomSheetSearch.notifyAdapter();
                }

            }
        };


        btnListener();


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    public void showBtmSheet(int title, List<Director> directorList, TextView tv_change) {

        bottomSheetDialogGeneral.openDialog(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, directorList), title, tv_change );


    }

    public void btnListener() {

        binding.etOtherNationalityIdMajorServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(countryObserver);
            }
        });

        binding.etDirectorateBelongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDirector();
            }
        });
        binding.btSaveMajorServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        if (binding.etDirectorateBelongs.getText().toString().isEmpty()) {
                            Toast.makeText(getContext(), getString(R.string.update_nationality_empty), Toast.LENGTH_SHORT).show();

                        } else {
                            if (info.getUSERDIRECTORATE() != null && otherNationalityText != null) {
                                if (binding.etOtherNationalityIdMajorServices.getText().toString().equals(otherNationalityText))
                                    Toast.makeText(getContext(), getString(R.string.update_nationality), Toast.LENGTH_SHORT).show();
                                else {
                                    updateNationality();
                                }

                            } else if (info.getUSERDIRECTORATE() == null) {
                                updateNationality();
                            } else if (info.getUSERDIRECTORATE() != null && info.getUSERNATIONALITYOTHERID() == null) {
                                if (!binding.etOtherNationalityIdMajorServices.getText().toString().isEmpty()) {
                                    updateNationality();
                                } else {
                                    Toast.makeText(getContext(), getString(R.string.update_nationality), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        dialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        binding.etOtherNationalityIdMajorServices.setText(otherNationalityText);
                        dialog.dismiss();
                    }
                }, getString(R.string.save_nationality), getString(R.string.save), getString(R.string.cancel));
                dialog.show(getParentFragmentManager(), "dialog tag");
            }
        });


    }

    private void getDirector() {
        if (directors.size() == 0) {

            mViewModel.getDirector().observe(getViewLifecycleOwner(), new Observer<List<Director>>() {
                @Override
                public void onChanged(List<Director> directorsList) {


                    if (directorsList != null) {
                        directors.addAll(directorsList);
                        showBtmSheet(R.string.directorate, directorsList, binding.etDirectorateBelongs);

                    } else {
                        Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            showBtmSheet(R.string.directorate, directors, binding.etDirectorateBelongs);


        }

    }


    private void showBottomSearchSheet(Observer observer) {

        bottomSheetSearch.openDialog(observer);
        userFileViewModel.getCountry().observe(getViewLifecycleOwner(), observer);

    }


    private void updateNationality() {
        mViewModel.updateUserNationality(info.getUSERNATIONALITYID(), otherNationalityId, directorId).observe(getViewLifecycleOwner(), updateUser -> {
            otherNationalityText = binding.etOtherNationalityIdMajorServices.getText().toString();
            info.setUSERNATIONALITYOTHERID(otherNationalityId);
            info.setUSERDIRECTORATE(directorId);
            binding.etDirectorateBelongs.setEnabled(false);
            binding.etDirectorateBelongs.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_gray)));


        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Director director = (Director) adapterView.getItemAtPosition(i);
        directorId = director.getID();


    }

    @Override
    public void observerAction(Object object) {
        otherNationalityId = ((Country) object).getCDCDNEW();
        binding.etOtherNationalityIdMajorServices.setText(((Country) object).getCDARBTR());

    }

    @Override
    public void etLengthMoreThan3(EditText ed_text , Observer observer) {
        userFileViewModel.getCountry(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {
        userFileViewModel.getCountry().observe(getViewLifecycleOwner(), observer);
    }
}