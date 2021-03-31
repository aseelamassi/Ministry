package com.sh.wm.ministry.featuers.userfile.health.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.health.model.health.AddUserHealth;
import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.featuers.userfile.health.repository.HealhRepositoriy;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerHealthModel;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;


public class HealhViewModel extends AndroidViewModel {

    private HealhRepositoriy repositoriy;
    private DBRepository dbRepository;

    public HealhViewModel(@NonNull Application application) {
        super(application);
        repositoriy = HealhRepositoriy.getInstance(application);
        dbRepository = DBRepository.getInstance(application);
    }

    public LiveData<UserHealthStatusModel> getUserWorkInfoLiveData() {
        return repositoriy.getUserHealthStatus();
    }




    public LiveData<AddUserHealth> addUserHealthStatus(String userId, String healthStatusId , String healthDetails) {
        return repositoriy.addUserHealthStatus(userId ,healthStatusId,healthDetails);
    }

    public LiveData<AddUserHealth> addUserHealthStatusWithAll(String userId,String healthStatusId , String healthDetails,String disabilityId, String disabilityPlace , String disabilitySize , String disabilityReason){
        return repositoriy.addUserHealthStatusWithAll(userId,healthStatusId, healthDetails, disabilityId, disabilityPlace, disabilitySize, disabilityReason);
    }

    public void storeAddWorkerHealth(AddWorkerHealthModel model){
        dbRepository.storeAddWorkerHealth(model);
    }




}