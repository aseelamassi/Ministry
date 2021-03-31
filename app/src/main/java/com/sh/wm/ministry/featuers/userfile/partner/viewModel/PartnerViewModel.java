package com.sh.wm.ministry.featuers.userfile.partner.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.partner.model.Partner;
import com.sh.wm.ministry.featuers.userfile.partner.model.PartnerModel;
import com.sh.wm.ministry.featuers.userfile.partner.repository.PartnerRepository;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;

public class PartnerViewModel extends AndroidViewModel {


    private PartnerRepository  repository;
    public PartnerViewModel(@NonNull Application application) {
        super(application);
        repository = PartnerRepository.getInstance(application);
    }

    public LiveData<PartnerModel> getPartners() {
        return repository.getPartners();
    }


}
