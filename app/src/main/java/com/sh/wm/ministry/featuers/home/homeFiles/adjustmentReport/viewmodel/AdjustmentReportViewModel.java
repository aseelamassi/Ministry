package com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.repository.AdjustmentReportRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AdjustmentReportViewModel extends AndroidViewModel {
    AdjustmentReportRepository adjustmentReportRepository;

    public AdjustmentReportViewModel(@NonNull Application application) {
        super(application);
        adjustmentReportRepository = AdjustmentReportRepository.getInstance(application);

    }

    public LiveData<ActionModel> storeAdjustmentReport(HashMap<String , RequestBody> data, MultipartBody.Part file  ){
        return  adjustmentReportRepository.storeAdjustmentReport(data, file);
    }

}
