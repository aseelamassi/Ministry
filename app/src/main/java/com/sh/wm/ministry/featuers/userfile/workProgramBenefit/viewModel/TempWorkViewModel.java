package com.sh.wm.ministry.featuers.userfile.workProgramBenefit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model.TempWorkModel;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.repository.TempWorkRepository;

public class TempWorkViewModel extends AndroidViewModel {

    private TempWorkRepository repository ;

    public TempWorkViewModel(@NonNull Application application) {
        super(application);
        repository = TempWorkRepository.getInstance(application);
    }

    public LiveData<TempWorkModel> getTempWorks() {
        return repository.getTempWorks();
    }

}
