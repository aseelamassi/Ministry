package com.sh.wm.ministry.featuers.home.homeFiles.workerRights.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.workerRights.model.ComplaintRightsCalculation;
import com.sh.wm.ministry.featuers.home.homeFiles.workerRights.repository.ComplaintRightCalculationRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.partner.repository.PartnerRepository;

public class ComplaintRightCalculationViewModel extends AndroidViewModel {

    private ComplaintRightCalculationRepository repository;

    public ComplaintRightCalculationViewModel(@NonNull Application application) {
        super(application);
        repository = ComplaintRightCalculationRepository.getInstance(application);
    }

    public LiveData<ComplaintRightsCalculation> complaintRightCalculation(String hoursType , String salary,
                                                                          String realWorkPeriod , String remainingLeaveDays,
                                                                          String periodNotConsidered, String lastBenefit,
                                                                          String cermonies , String endWorkType)
    {
        return repository.complaintRightCalculation(hoursType, salary, realWorkPeriod, remainingLeaveDays, periodNotConsidered, lastBenefit, cermonies, endWorkType);
    }

    public LiveData<ConstructByName> getConstruct(String number) {
        return repository.getConstruct(number);
    }
}
