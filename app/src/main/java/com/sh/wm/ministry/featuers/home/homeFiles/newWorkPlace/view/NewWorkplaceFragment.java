package com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;

import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentNewWorkplaceBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.viewmodel.NewWorkPlaceViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class NewWorkplaceFragment extends Fragment implements DateAdder.Listener {

    private FragmentNewWorkplaceBinding binding;
    private ShMyDialog myDialog;
    private BottomSheetDialog dialogList;


    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;

    private NewWorkPlaceViewModel newWorkPlaceViewModel;



    private String constructionId;

    private Observer<ConstructByName> constructByNameObserver;

    private BottomSheetSearchList bottomSheetSearchList;


    private BottomSheetSearchList.MyTestAdapter myAdapter;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private BottomSheetDialog dialog;
    private EditText ed_text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentNewWorkplaceBinding.inflate(inflater, container, false);
        binding.edEmpName.setText(SharedPreferneceHelper.getUserName(getContext()));
        binding.edEmpId.setText(SharedPreferneceHelper.getUserSn(getContext()));
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();

        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newWorkPlaceViewModel = new ViewModelProvider(this).get(NewWorkPlaceViewModel.class);

        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    if (constructByName.getStatus() == 1){
                        imNoData.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }else {
                        bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                        bottomSheetSearchList.setBottomSheetDialog(dialog);
                        bottomSheetSearchList.setMyList((ArrayList<?>) constructByName.getConstructs(), ed_text.getText().toString());

                        myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                            @Override
                            public void MyMethod(Object constructByName) {
                                binding.cardViewSearchNewWorkPlace.tvOwnerName.setText(getResources().getString(R.string.owner_name) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME());
                                binding.cardViewSearchNewWorkPlace.tvBusinessName.setText(getResources().getString(R.string.The_business_name) + " " + ((Construct) constructByName).getCONSTRUCTNAMEUSING());
                                if (((Construct) constructByName).getCONSTRUCTIONOWNER() != null)
                                binding.cardViewSearchNewWorkPlace.tvOwnerId.setText(getResources().getString(R.string.owner_id) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getUSERSN());

                                else
                                    binding.cardViewSearchNewWorkPlace.tvOwnerId.setText(getResources().getString(R.string.owner_id) );


                                binding.cardViewSearchNewWorkPlace.imgEdit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        binding.cardViewSearchNewWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                                        binding.tvNuFacility.setVisibility(View.VISIBLE);
                                        binding.edNuFacilityNewWorkPlace.setVisibility(View.VISIBLE);
                                        showBottomSearchSheet(constructByNameObserver);
                                    }
                                });
                                binding.edNuFacilityNewWorkPlace.setVisibility(View.GONE);
                                binding.tvNuFacility.setVisibility(View.GONE);
                                binding.cardViewSearchNewWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                                binding.progressbar.setVisibility(View.GONE);
                                constructionId = ((Construct) constructByName).getCONSTRUCTID();
                                ed_text.setText("");
                                imNoData.setVisibility(View.VISIBLE);
                            }
                        });

                        bottomSheetSearchList.setAdapter(myAdapter);
                    }
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        binding.btnSaveNewWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (constructionId == null || binding.edDateStartWorkNewWork.getText().toString().isEmpty())
                    Toast.makeText(getContext(), R.string.empty_field, Toast.LENGTH_SHORT).show();
                else {
                    myDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {

                        binding.progressbar.setVisibility(View.VISIBLE);
                        binding.btnSaveNewWorkPlace.setEnabled(false);
                            newWorkPlaceViewModel.AddNewWorkPlaceReport(constructionId, binding.edDateStartWorkNewWork.getText().toString()).observe(getViewLifecycleOwner() , updateUser -> {
                                if (updateUser != null ) {
                                    binding.progressbar.setVisibility(View.GONE);
                                    binding.btnSaveNewWorkPlace.setEnabled(true);
                                }
                            });
                            myDialog.dismiss();
                        }

                        @Override
                        public void edite(View view) {
                            myDialog.dismiss();
                        }
                    }, getString(R.string.new_work_place), getString(R.string.save), getString(R.string.cancel));
                    myDialog.show(getParentFragmentManager(), "");
                }
            } });


        binding.edDateStartWorkNewWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateAdder.show();
            }
        });


        binding.edNuFacilityNewWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(constructByNameObserver);
            }
        });



    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"  , Locale.ENGLISH);
        chosenTime = timeChosen;
        binding.edDateStartWorkNewWork.setText(format.format(date));
    }

    public void enable(boolean states) {
        binding.edNuFacilityNewWorkPlace.setEnabled(states);
        binding.edDateStartWorkNewWork.setEnabled(states);
    }

    private void showBottomSearchSheet(Observer observer) {
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

                if (ed_text.getText().toString().length() >= 3) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                    newWorkPlaceViewModel.getConstructionData(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
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

}