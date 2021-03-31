package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.databinding.FragmentAdditionalServicesFirstBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.network.utiels.NetworkUtils;


public class AdditionalServicesFirstFragment extends Fragment {

    private FragmentAdditionalServicesFirstBinding binding;
    private InspectionVisit inspectionVisit;

    private OnFragmentInteractionListener mListener;


    private Construction construction;


    public AdditionalServicesFirstFragment() {
        // Required empty public constructor
    }

    public static AdditionalServicesFirstFragment newInstance() {
        AdditionalServicesFirstFragment fragment = new AdditionalServicesFirstFragment();

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
        binding = FragmentAdditionalServicesFirstBinding.inflate(inflater, container, false);


        enable(false);

        getBundle();

        getConstructionData();

        btnListener();

        return binding.getRoot();
    }

    private void btnListener() {
        binding.btnEditConstructionData.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("inspectionVisit", inspectionVisit);
            bundle.putSerializable("construction", construction);
            mListener.onFragmentInteraction(405, bundle);
        });

        binding.btnOccupationalSafetyAndHealth.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("inspectionVisit", inspectionVisit);
            mListener.onFragmentInteraction(406, bundle);
        });

        binding.btnWorkerInfo.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("inspectionVisit", inspectionVisit);
            mListener.onFragmentInteraction(407, bundle);
        });
    }


    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null)
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
    }


    private void getConstructionData() {


        if (NetworkUtils.isOnline(getContext())) {
            HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
            homeViewModel.getConstructByNumber(inspectionVisit.getCONSTRUCTNUM()).observe(getViewLifecycleOwner(), new Observer<ConstructionGroup>() {
                @Override
                public void onChanged(ConstructionGroup constructionGroup) {

                    binding.progress.setVisibility(View.GONE);
                    enable(true);
                    if (constructionGroup != null && constructionGroup.getConstruction() != null) {
                        construction = constructionGroup.getConstruction();


                    }
                }
            });
        }else {
            enable(true);
            binding.progress.setVisibility(View.GONE);
        }

    }


    private void enable(boolean isEnabled) {
        binding.btnEditConstructionData.setEnabled(isEnabled);
        binding.btnWorkerInfo.setEnabled(isEnabled);
        binding.btnOccupationalSafetyAndHealth.setEnabled(isEnabled);
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


}