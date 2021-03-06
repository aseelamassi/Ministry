package com.sh.wm.ministry.featuers.userfile.practicalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.practicalstatus.repository.PracticalStatusRepository;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;

import okhttp3.ResponseBody;

public class PracticalStatusViewModel extends AndroidViewModel {
    private PracticalStatusRepository repository;

    public PracticalStatusViewModel(@NonNull Application application) {
        super(application);
        repository=PracticalStatusRepository.getInstance(application);
    }

    public LiveData<PracticalStatusModel> getUserPracticalStatus() {
        return repository.getUserPracticalStatus();
    }

    public LiveData<ResponseBody>  getUnemployedFile(){
        return repository.getUnemployedFile();
    }



}