package com.sh.wm.ministry.featuers.userfile.socialAid.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAidModel;
import com.sh.wm.ministry.featuers.userfile.socialAid.repository.SocialAidRepository;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;

public class SocialAidViewModel extends AndroidViewModel {

    private SocialAidRepository repository ;

    public SocialAidViewModel(@NonNull Application application) {
        super(application);
        repository = SocialAidRepository.getInstance(application);
    }

    public LiveData<SocialAidModel> getSocialAid() {
        return repository.getSocialAid();
    }

}
