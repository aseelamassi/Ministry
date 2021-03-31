package com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.model.CloseFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;

public class CloseFacilityRepository {
    private static final String TAG = CloseFacilityRepository.class.getSimpleName();
    private NetworkUtils networkUtils;
    MutableLiveData<Construction> constructionMutableLiveData;
    MutableLiveData<PalLawModel> palLawMutableLiveData;
    MutableLiveData<ActionModel> closeFacilityModelMutableLiveData;
    static CloseFacilityRepository mInstance;
    private Application application;

    public CloseFacilityRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);

        closeFacilityModelMutableLiveData = new MutableLiveData<>();
    }

    public static CloseFacilityRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new CloseFacilityRepository(application);
        }
        return mInstance;
    }


    public LiveData<ActionModel> storeConstructionClose(String constructId , String closeDate ,
                          String typeId, String machineName ,
                           HashMap<String, String> laws,  String visitId,
                           HashMap<String, String> inspectors ,  String visitDate){
        networkUtils.getApiInterface().storeConstructionClose(constructId, closeDate, typeId, machineName, laws, visitId, inspectors, visitDate).enqueue(new Callback<ActionModel>() {
            @Override
            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                if (response.body() != null){
                    closeFacilityModelMutableLiveData.setValue(response.body());
                    Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onFailure(Call<ActionModel> call, Throwable t) {

            }
        });

        return closeFacilityModelMutableLiveData;
    }



}
