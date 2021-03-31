package com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.repository.NewWorkPlaceRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

public class NewWorkPlaceViewModel extends AndroidViewModel {

    NewWorkPlaceRepository newWorkPlaceRepository;

    public NewWorkPlaceViewModel(@NonNull Application application) {
        super(application);
        newWorkPlaceRepository=NewWorkPlaceRepository.getmInstance(application);
    }

    public LiveData<ConstructByName> getConstructionData(String num_construction) {
        return newWorkPlaceRepository.getConstruct(num_construction);
    }



    public LiveData<UpdateUser>  AddNewWorkPlaceReport(String constructionId , String startDate  ){
        return newWorkPlaceRepository.AddNewWorkPlaceReport(constructionId,startDate);
    }
}
