package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.UserData;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.repository.WorkercompilationRepository;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;

public class WorkerCompilationFormTwoViewModel extends AndroidViewModel {

    WorkercompilationRepository workercompilationRepository;


    public WorkerCompilationFormTwoViewModel(@NonNull Application application) {
        super(application);
        workercompilationRepository = WorkercompilationRepository.getInstance(application);

    }

    public LiveData<ConstructByName> getConstruct(String number) {
        return workercompilationRepository.getConstruct(number);
    }
    public LiveData<UserData> getUserData(){
        return workercompilationRepository.getUserData();
    }



    public LiveData<ActionModel> addLaborComplaint(String userSn, String haveContract,
                                                   String lateWages, String lateWagePer,
                                                   String deadLineConsideration, String deadLinePer,
                                                   String terminationReason,
                                                   String constructionId, String endWorkType,
                                                   String workPeriod, String realWorkPeriod,
                                                   String remainLeaveDays, String jobId,
                                                   String natureId, String lastPay,
                                                   String currency, String hoursType,
                                                   String cermenories, String startDate, String endDate, String mobileNum , String addressDesc){
        return workercompilationRepository.addLaborComplaint(userSn, haveContract, lateWages, lateWagePer, deadLineConsideration, deadLinePer, terminationReason, constructionId, endWorkType, workPeriod, realWorkPeriod, remainLeaveDays, jobId, natureId, lastPay, currency, hoursType, cermenories, startDate, endDate,mobileNum , addressDesc);
    }

}