package com.sh.wm.ministry.featuers.userfile.practicalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.repository.PracticalStatusRepository;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class AddPracticalStatusViewModel extends AndroidViewModel {
    private DBRepository dbRepository;
    private PracticalStatusRepository repository;


    public AddPracticalStatusViewModel(@NonNull Application application) {
        super(application);
        dbRepository = DBRepository.getInstance(application);
        repository = PracticalStatusRepository.getInstance(application);
    }

    public LiveData<List<WorkStatus>> getAllWorkStatuses() {
        return dbRepository.getAllWorkStatuses();
    }


//    public LiveData<ResultModel> getJob(String keyword) {
//        return repository.getJobListModel(keyword);
//    }


    public LiveData<WorkStatusDescModel> getWorkStatusDesc(String workStatusId) {
        return repository.getWorkStatusDesc(workStatusId);
    }


    public LiveData<WorkStatusDescDescModel> getWorkStatusDescDesc(String workStatusDescId) {
        return repository.getWorkStatusDescDesc(workStatusDescId);
    }


    public LiveData<ConstructByName> getConstruct(String name) {
        return repository.getConstruct(name);
    }

    public LiveData<ActionModel> updateWorkStatus(String userWorkId, String userWorkStatusId, String userWorkDescId, String userWorkDescDescId, String startDate, String endDate, String reason, String salary, String currencyId, String hoursId, String natureId, String jobTitleId, String constructId) {

        return repository.updateWorkStatus(userWorkId, userWorkStatusId, userWorkDescId, userWorkDescDescId, startDate, endDate, reason, salary, currencyId, hoursId, natureId, jobTitleId, constructId);
    }

}