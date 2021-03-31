package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.databinding.FragmentLeavingAWorkplaceBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.ConstructModel;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.viewmodel.LeavingWorkPlaceViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class LeavingAWorkplaceFragment extends Fragment implements DateAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {

    private FragmentLeavingAWorkplaceBinding binding;
    private DateAdder dateAdder;
    private ShMyDialog myDialog;
    private TimeZone timeZone;
    private long chosenTime;

    private LeavingWorkPlaceViewModel leavingWorkPlaceViewModel;
    private HomeViewModel homeViewModel;

    private String constructionId;


    private OnFragmentInteractionListener mListener;


    BottomSheetDialogGeneral bottomSheetDialogGeneral;
    private List<com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct> constructs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLeavingAWorkplaceBinding.inflate(inflater, container, false);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        binding.edEmpName.setText(SharedPreferneceHelper.getUserName(getContext()));
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        leavingWorkPlaceViewModel = new ViewModelProvider(this).get(LeavingWorkPlaceViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        constructs = new ArrayList<>();


        binding.btnSaveLeavingWorkPlace.setOnClickListener(view1 -> {
            if (constructionId == null || binding.edDateEndWork.getText().toString().isEmpty() || binding.edReasonLiving.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), R.string.empty_field, Toast.LENGTH_SHORT).show();
            } else if (chosenTime > System.currentTimeMillis())
                Toast.makeText(getContext(), getString(R.string.end_today), Toast.LENGTH_SHORT).show();

            else {
                myDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view1) {
                        binding.progressbar.setVisibility(View.VISIBLE);
                        binding.btnSaveLeavingWorkPlace.setEnabled(false);
                        leavingWorkPlaceViewModel.AddLeavingWorkPlaceReport(constructionId, binding.edReasonLiving.getText().toString(), binding.edDateEndWork.getText().toString()).observe(getViewLifecycleOwner(), updateUser -> {
                            binding.progressbar.setVisibility(View.GONE);
                            binding.btnSaveLeavingWorkPlace.setEnabled(true);
                            if (updateUser != null && updateUser.getStatus().equals("0")) {
                                mListener.onFragmentInteraction(0);
                            }
                        });

                        myDialog.dismiss();
                    }

                    @Override
                    public void edite(View view1) {
                        myDialog.dismiss();
                    }
                }, getString(R.string.leaving_work_place), getString(R.string.save), getString(R.string.cancel));
                myDialog.show(getParentFragmentManager(), "");
            }


        });


        binding.edDateEndWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateAdder.show();
            }
        });
        binding.edNuFacilityLeavingWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.edNuFacilityLeavingWorkPlace.setEnabled(false);
                getWorkerConstruct();
            }
        });


    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        chosenTime = timeChosen;
        binding.edDateEndWork.setText(format.format(date));
    }

    public void enabel(boolean states) {

        binding.edNuFacilityLeavingWorkPlace.setEnabled(states);
        binding.edDateEndWork.setEnabled(states);
        binding.edEmpName.setEnabled(states);
        binding.edReasonLiving.setEnabled(states);
    }


    private void getWorkerConstruct() {
        if (constructs.size() == 0 ) {
            binding.progressbar.setVisibility(View.VISIBLE);
            homeViewModel.getWorkerConstruct().observe(getViewLifecycleOwner(), new Observer<ConstructModel>() {
                @Override
                public void onChanged(ConstructModel constructModel) {

                    binding.progressbar.setVisibility(View.GONE);
                    if (constructModel != null) {
                        if (constructs.size() == 0)
                        constructs.addAll(constructModel.getConstructs());
                        showBtmSheet(R.string.facility_name, constructs, binding.edNuFacilityLeavingWorkPlace);

                    } else {
                        Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else
            showBtmSheet(R.string.facility_name, constructs, binding.edNuFacilityLeavingWorkPlace);

    }


    public void showBtmSheet(int title, List<com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct> constructs, TextView tv_change) {


        ArrayAdapter<com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, constructs);
        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);


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

        com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct construct = (com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.Construct) adapterView.getItemAtPosition(i);
        constructionId = construct.getCONSTRUCTID();
    }
}