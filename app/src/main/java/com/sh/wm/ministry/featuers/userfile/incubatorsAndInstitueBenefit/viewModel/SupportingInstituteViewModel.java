package com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstituteModel;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.repository.SupportingInstituteRepository;
import com.sh.wm.ministry.featuers.userfile.partner.model.PartnerModel;
import com.sh.wm.ministry.featuers.userfile.partner.repository.PartnerRepository;

public class SupportingInstituteViewModel extends AndroidViewModel {


    private SupportingInstituteRepository repository;

    public SupportingInstituteViewModel(@NonNull Application application) {
        super(application);
        repository = SupportingInstituteRepository.getInstance(application);
    }

    public LiveData<SupportingInstituteModel> getSupportingInstitutes() {
        return repository.getSupportingInstitutes();
    }
}
