package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;


import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.insertWorker.WorkStatusWorkerFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.insertWorker.WorkerMajorDataFragment;
import com.sh.wm.ministry.featuers.userfile.health.view.HealhFragment;

import java.util.ArrayList;
import java.util.List;


public class StepperAdapter extends FragmentPagerAdapter {


    private InspectionVisit inspectionVisit;
    private String userSn ,userId;


    public StepperAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    public InspectionVisit getInspectionVisit() {
        return inspectionVisit;
    }

    public void setInspectionVisit(InspectionVisit inspectionVisit) {
        this.inspectionVisit = inspectionVisit;
    }

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inspectionVisit", getInspectionVisit());
        switch (position) {
            case 0:
            default:
                WorkerMajorDataFragment fragment = new WorkerMajorDataFragment();
                fragment.setArguments(bundle);
                return fragment;
            case 1:
                WorkStatusWorkerFragment fragment1 = new WorkStatusWorkerFragment();
                bundle.putString("userSn" , getUserSn());
                fragment1.setArguments(bundle);
                return fragment1;
            case 2:
                HealhFragment fragment2 = new HealhFragment();
                bundle.putString("userSn" , getUserSn());
                bundle.putString("userId" , getUserId());
                fragment2.setArguments(bundle);
                return fragment2;
        }


    }



    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }
}

