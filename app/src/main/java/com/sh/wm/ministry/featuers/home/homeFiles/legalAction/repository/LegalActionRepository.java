package com.sh.wm.ministry.featuers.home.homeFiles.legalAction.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
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

public class LegalActionRepository {


    private Application application;
    private NetworkUtils networkUtils;
    private MutableLiveData<UpdateUser> actionMutableLiveData;

    private static final String TAG = LegalActionRepository.class.getSimpleName();
    static LegalActionRepository mInstance;

    public LegalActionRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        actionMutableLiveData = new MutableLiveData<>();
    }

    public static LegalActionRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new LegalActionRepository(application);
        }
        return mInstance;
    }


     public LiveData<UpdateUser> storeConstructionLegalAction( String constructId ,  String visitDate, String actionDate ,  String legalChosen , String machineName,  HashMap<String, String> laws, String inspector1 ,  String inspector2, String inspector3 , String visitId){
         networkUtils.getApiInterface().storeConstructionLegalAction(constructId , visitDate,actionDate,legalChosen,machineName, laws,inspector1,inspector2,inspector3, visitId, SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UpdateUser>() {
             @Override
             public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {


                 if (response.isSuccessful()) {
                     Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();
                     actionMutableLiveData.setValue(response.body());
                 } else {

                     actionMutableLiveData.setValue(null);
                 }
             }

             @Override
             public void onFailure(Call<UpdateUser> call, Throwable t) {
                 actionMutableLiveData.setValue(null);
             }
         });
         return actionMutableLiveData;
     }
}
