package com.sh.wm.ministry.featuers.userfile.vechiels.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.featuers.userfile.vechiels.model.UserVehicleModel;
import com.sh.wm.ministry.featuers.userfile.vechiels.repository.VehicleRepository;

public class UserVehicleViewModel extends AndroidViewModel {


    private VehicleRepository repository ;

    public UserVehicleViewModel(@NonNull Application application) {
        super(application);
        repository = VehicleRepository.getInstance(application);
    }

    public LiveData<UserVehicleModel> getUserVehicle() {
        return repository.getUserVehicle();
    }



}

