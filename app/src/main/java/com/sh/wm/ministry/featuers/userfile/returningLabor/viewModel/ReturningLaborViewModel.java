package com.sh.wm.ministry.featuers.userfile.returningLabor.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborAction;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborModel;
import com.sh.wm.ministry.featuers.userfile.returningLabor.repository.ReturningLaborRepository;

public class ReturningLaborViewModel extends AndroidViewModel {

    ReturningLaborRepository repository;

    public ReturningLaborViewModel(@NonNull Application application) {
        super(application);
        repository = ReturningLaborRepository.getInstance(application);
    }


    public LiveData<ReturningLaborModel> getReturningLabor() {
        return repository.getReturningLabor();
    }

    public LiveData<ReturningLaborAction> addReturningLabor(String countryId, String returningReason, String startDate, String endDate, String lastJob, String skillLevelId) {
        return repository.addReturningLabor(countryId, returningReason, startDate, endDate, lastJob, skillLevelId);
    }


    public LiveData<ReturningLaborAction> updateReturningLabor(String userLaborId,String countryId, String returningReason, String startDate, String endDate, String lastJob, String skillLevelId) {
        return repository.updateReturningLabor(userLaborId,countryId, returningReason, startDate, endDate, lastJob, skillLevelId);
    }
}
