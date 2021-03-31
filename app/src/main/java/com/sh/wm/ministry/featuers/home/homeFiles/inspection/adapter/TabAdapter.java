package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData.ApproverDataFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData.LegalEntityFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData.LicenseDataFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.editConstructionData.MainConstructionDataFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

import java.util.ArrayList;
import java.util.List;
public class TabAdapter extends FragmentStateAdapter {

    public TabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inspectionVisit",getInspectionVisit());
        bundle.putSerializable("construct" , getConstruction());
        switch (position) {
            case 0 :
            default:
                MainConstructionDataFragment fragment = new MainConstructionDataFragment();
                fragment.setArguments(bundle);
                return fragment;
            case 1:
                LegalEntityFragment fragment1 = new LegalEntityFragment();
                fragment1.setArguments(bundle);
                return fragment1;
            case 2:
                LicenseDataFragment fragment2 = new LicenseDataFragment() ;
                fragment2.setArguments(bundle);
                return fragment2;
            case 3:
                ApproverDataFragment fragment3 = new ApproverDataFragment();
                fragment3.setArguments(bundle);
                return fragment3;


        }
    }




    @Override
    public int getItemCount() {
        return 4 ;
    }


    private InspectionVisit inspectionVisit ;

    public InspectionVisit getInspectionVisit(){
        return  inspectionVisit;
    }

    public void setInspectionVisit(InspectionVisit inspectionVisit){
        this.inspectionVisit = inspectionVisit;
    }


    private Construction construction;

    public Construction getConstruction() {
        return construction;
    }

    public void setConstruction(Construction construction) {
        this.construction = construction;
    }
}
