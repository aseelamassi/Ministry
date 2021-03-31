package com.sh.wm.ministry.featuers.userfile.career.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.career.repository.CareerRepository;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;


public class CareersViewModel extends AndroidViewModel {

    private CareerRepository repository;

    public CareersViewModel(@NonNull Application application) {
        super(application);
        repository = CareerRepository.getInstance(application);
    }

    public LiveData<UserCareerModel> getUserCareers(String userId) {
        return repository.getUserCareers(userId);
    }

    public LiveData<UpdateUser>addCareers(  String careerId ,
                                            String careerLicense , String skillLevelId,
                                            String trainingSideId, String certificateYear,
                                            String qualificationId){
        return repository.addCareers(careerId, careerLicense, skillLevelId, trainingSideId, certificateYear, qualificationId) ;
    }

    public LiveData<UpdateUser> updateCareers( String userCareerId, String careerId ,
                                               String careerLicense , String skillLevelId,
                                               String trainingSideId, String certificateYear,
                                               String priority){
        return repository.updateCareers(userCareerId, careerId, careerLicense, skillLevelId, trainingSideId, certificateYear, priority);
    }


//    public LiveData<ResultModel> getJob(String keyword) {
//        return repository.getJobListModel(keyword);
//    }


}
