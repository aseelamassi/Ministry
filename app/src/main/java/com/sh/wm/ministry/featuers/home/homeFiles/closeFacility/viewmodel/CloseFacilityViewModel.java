package com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.model.CloseFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.repository.CloseFacilityRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

import java.util.HashMap;

public class CloseFacilityViewModel extends AndroidViewModel {
    CloseFacilityRepository closeFacilityRepository;

    public CloseFacilityViewModel(@NonNull Application application) {
        super(application);
        closeFacilityRepository = CloseFacilityRepository.getInstance(application);
    }





    public LiveData<ActionModel> storeConstructionClose(String constructId , String closeDate ,
                                                        String typeId, String machineName ,
                                                        HashMap<String, String> laws, String visitId,
                                                        HashMap<String, String> inspectors , String visitDate){
        return closeFacilityRepository.storeConstructionClose(constructId, closeDate, typeId, machineName, laws, visitId, inspectors, visitDate);
    }

}
