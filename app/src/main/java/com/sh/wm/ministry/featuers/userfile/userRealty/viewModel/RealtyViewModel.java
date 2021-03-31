package com.sh.wm.ministry.featuers.userfile.userRealty.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.userRealty.model.UserRealtyModel;
import com.sh.wm.ministry.featuers.userfile.userRealty.repository.RealtyRepository;

public class RealtyViewModel extends AndroidViewModel {

    RealtyRepository repository ;
    public RealtyViewModel(@NonNull Application application) {
        super(application);
        repository = RealtyRepository.getInstance(application);
    }


    public LiveData<UserRealtyModel> getUserRealty(){
        return repository.getUserRealty();
    }
}
