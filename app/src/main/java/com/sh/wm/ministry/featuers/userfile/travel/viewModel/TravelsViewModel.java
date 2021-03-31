package com.sh.wm.ministry.featuers.userfile.travel.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;

public class TravelsViewModel extends AndroidViewModel {

    private TravelRepository repository ;

    public TravelsViewModel(@NonNull Application application) {
        super(application);
        repository = TravelRepository.getInstance(application);
    }

    public LiveData<UserTravelDataModel> getTravelData() {
        return repository.getTravelData();
    }


}
