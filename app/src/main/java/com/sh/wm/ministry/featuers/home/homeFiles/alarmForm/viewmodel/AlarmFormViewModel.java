package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.repository.AlarmFormRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

import java.util.HashMap;

public class AlarmFormViewModel extends AndroidViewModel {

    public static final String TAG = AlarmFormViewModel.class.getSimpleName();
    AlarmFormRepository alarmFormRepository;

    public AlarmFormViewModel(@NonNull Application application) {
        super(application);
        alarmFormRepository = AlarmFormRepository.getInstance(application);
    }



    public LiveData<UpdateUser> storeConstructionAlarm(String constructId, String visitDate, String alarmDate, HashMap<String, String> laws, String inspector1, String inspector2, String inspector3, String visitId) {
        return alarmFormRepository.storeConstructionAlarm(constructId, visitDate, alarmDate, laws, inspector1, inspector2, inspector3, visitId);
    }
}
