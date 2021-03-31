package com.sh.wm.ministry.featuers.userfile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class UserFileViewModel extends AndroidViewModel {

    private DBRepository dbRepository ;

    public UserFileViewModel(@NonNull Application application) {
        super(application);
        dbRepository = DBRepository.getInstance(application);
    }


    public LiveData<List<JobList>> getJobList(String keyword){
        return dbRepository.getJobList(keyword);
    }


    public LiveData<List<TrainingInstitute>> getTrainingInstitute(String keyword){
        return dbRepository.getAllTrainingInstitutes(keyword);
    }

    public LiveData<List<Constants>> getConstant(String parentId){
        return dbRepository.getAllConstants(parentId);
    }

    public LiveData<String> getConstantName(String constantId, String parentId){
        return dbRepository.getConstantName(constantId,parentId);
    }

    public LiveData<List<Country>> getCountry(String countryName){
        return dbRepository.getAllCountries(countryName);
    }

    public LiveData<List<Country>> getCountry(){
        return dbRepository.getAllCountries();
    }


}
