package com.sh.wm.ministry.featuers.home.homeFiles.legalAction.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.legalAction.repository.LegalActionRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

import java.util.HashMap;

public class LegalActionViewModel extends AndroidViewModel {

    LegalActionRepository legalActionRepository;

    public LegalActionViewModel(@NonNull Application application) {
        super(application);
        legalActionRepository = LegalActionRepository.getInstance(application);
    }


    public LiveData<UpdateUser> storeConstructionLegalAction(String constructId, String visitDate, String actionDate, String legalChosen, String machineName, HashMap<String, String> laws, String inspector1, String inspector2, String inspector3, String visitId) {
        return legalActionRepository.storeConstructionLegalAction(constructId, visitDate, actionDate, legalChosen, machineName, laws, inspector1, inspector2, inspector3, visitId);

    }
}
