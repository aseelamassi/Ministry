package com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class NewWorkPlaceRepository {
    private static NewWorkPlaceRepository mInstance;
    private NetworkUtils networkUtils;
    private Application application;
    private MutableLiveData<ConstructByName> constructionMutableLiveData;
    private MutableLiveData<UpdateUser> newWorkPlaceMutableLiveData;
    public static final String TAG = NewWorkPlaceRepository.class.getSimpleName();



    public NewWorkPlaceRepository(Application application) {

        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData=new MutableLiveData<>();
        newWorkPlaceMutableLiveData=new MutableLiveData<>();
    }

    public static NewWorkPlaceRepository getmInstance(Application application){
        if (mInstance==null){
            mInstance=new NewWorkPlaceRepository(application);
        }
       return mInstance;
    }


    public LiveData<ConstructByName> getConstruct(String number) {
        networkUtils.getApiInterface().getConstructByName(number).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    constructionMutableLiveData.setValue(response.body());
                } else {
                    constructionMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructionMutableLiveData.setValue(null);
            }
        });

        return constructionMutableLiveData;
    }




    public LiveData<UpdateUser>  AddNewWorkPlaceReport(String constructionId , String startDate  ){

        networkUtils.getApiInterface().AddNewWorkPlaceReport(constructionId, SharedPreferneceHelper.getUserSn(application) , startDate).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();
                        newWorkPlaceMutableLiveData.setValue(response.body());
                    }
                } else {
                    newWorkPlaceMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                newWorkPlaceMutableLiveData.setValue(null);
                Log.d(TAG , t.getMessage());
            }
        });
        return newWorkPlaceMutableLiveData;

    }


}
