package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.ConstructModel;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.repository.LeavingWorkplaceRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.view.LeavingAWorkplaceFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

public class LeavingWorkPlaceViewModel extends AndroidViewModel {

    private LeavingWorkplaceRepository leavingWorkplaceRepository;
    public LeavingWorkPlaceViewModel(@NonNull Application application) {
        super(application);
        leavingWorkplaceRepository=LeavingWorkplaceRepository.getInstance(application);
    }



    public LiveData<ConstructByName> getConstructionData(String num_construction) {
        return leavingWorkplaceRepository.getConstruct(num_construction);
    }

    public LiveData<UpdateUser> AddLeavingWorkPlaceReport(String constructionId ,
                                                          String leavingReason, String endDate  ){
        return leavingWorkplaceRepository.AddLeavingWorkPlaceReport(constructionId,leavingReason,endDate);
    }


}
