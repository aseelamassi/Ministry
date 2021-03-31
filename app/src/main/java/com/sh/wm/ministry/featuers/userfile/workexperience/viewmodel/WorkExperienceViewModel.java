package com.sh.wm.ministry.featuers.userfile.workexperience.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperienceModel;
import com.sh.wm.ministry.featuers.userfile.workexperience.repository.WorkExperienceRepository;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class WorkExperienceViewModel extends AndroidViewModel {
    private WorkExperienceRepository repository;
    private DBRepository dbRepository;


    public WorkExperienceViewModel(@NonNull Application application) {
        super(application);
        repository = WorkExperienceRepository.getInstance(application);
        dbRepository = DBRepository.getInstance(application);
    }

    public LiveData<UserWorkExperienceModel> getUserWorkExperiences(String userId) {
        return repository.getUserWorkExperiences(userId);
    }

    public LiveData<UpdateUser> addUserWorkExperience(String expTypeId ,String jobTitleId, String insistId ,  String startWork , String endWork ,String leavingReason ) {
        return repository.addUserWorkExperience(expTypeId, jobTitleId, insistId, startWork, endWork, leavingReason);
    }

    public LiveData<UpdateUser> updateUserWorkExperience(String expId, String expTypeId ,String jobTitleId, String insistId ,  String startWork , String endWork ,String leavingReason ){
        return repository.updateUserWorkExperience(expId , expTypeId, jobTitleId, insistId, startWork, endWork, leavingReason);
    }



//
//    public LiveData<ResultModel> getJobList(String keyword) {
//        return repository.getJobListModel(keyword);
//    }

//    public LiveData<ResultModel> getTrainingInstitutes(String keyword) {
//        return repository.getTrainingInstitutes(keyword);
//    }



}
