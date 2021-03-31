package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayoutMediator;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentAdditionalServicesBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.TabAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;


public class AdditionalServicesFragment extends Fragment {


    FragmentAdditionalServicesBinding binding;
    private static final int NUM_PAGES = 4;
    private TabAdapter pagerAdapter;
    // Array of strings FOR TABS TITLES
    private String[] titles;
    private InspectionVisit inspectionVisit;


    private Construction construction;

    private HomeViewModel homeViewModel ;

    public AdditionalServicesFragment() {
        // Required empty public constructor
    }

    public static AdditionalServicesFragment newInstance() {
        AdditionalServicesFragment fragment = new AdditionalServicesFragment();

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
        binding = FragmentAdditionalServicesBinding.inflate(inflater, container, false);

        titles = new String[]{getString(R.string.major_services), getString(R.string.legal_entity), getString(R.string.license_data), getString(R.string.approver_data)};

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        getBundle();

        pagerAdapter = new TabAdapter(this);

       // getConstructionData();


        pagerAdapter.setInspectionVisit(inspectionVisit);
        pagerAdapter.setConstruction(construction);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.setUserInputEnabled(false);


        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> tab.setText(titles[position])).attach();


        return binding.getRoot();
    }

    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");

            if (bundle.getSerializable("construction") != null)
                construction = (Construction) bundle.getSerializable("construction");
        }
    }



    private void getConstructionData(){


        homeViewModel.getConstructByNumber(inspectionVisit.getCONSTRUCTNUM()).observe(getViewLifecycleOwner(), new Observer<ConstructionGroup>() {
            @Override
            public void onChanged(ConstructionGroup constructionGroup) {

                if (constructionGroup != null && constructionGroup.getConstruction() != null){
                    construction = constructionGroup.getConstruction();

                    pagerAdapter.setConstruction(construction);
                }
            }
        });

    }


}