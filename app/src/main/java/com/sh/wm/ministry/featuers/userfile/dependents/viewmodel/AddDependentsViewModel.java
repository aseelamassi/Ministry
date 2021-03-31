package com.sh.wm.ministry.featuers.userfile.dependents.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.dependents.model.DependentModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.featuers.userfile.dependents.repository.DependentsRepository;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;


public class AddDependentsViewModel extends AndroidViewModel {
    private DependentsRepository dependentsRepository;

    public AddDependentsViewModel(@NonNull Application application) {
        super(application);
        dependentsRepository = DependentsRepository.getInstance(application);
    }

    public LiveData<UserWorkerInsertModel> addDependent( String dependentSn) {
        return dependentsRepository.addDependent( dependentSn);
    }

    public LiveData<DependentModel> getDependentData(String userSn, String dependentSn) {
        return dependentsRepository.getDependentData(userSn, dependentSn);
    }


}
