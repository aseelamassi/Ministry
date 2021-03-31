package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.repository;

import android.app.Application;
import android.media.AsyncPlayer;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.ConstructModel;
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

public class LeavingWorkplaceRepository {

    private MutableLiveData<ConstructByName> constructionMutableLiveData;
    private MutableLiveData<ConstructModel> constructionModelMutableLiveData;
    private MutableLiveData<UpdateUser> leavingWorkPlaceMutableLiveData;
    private NetworkUtils networkUtils;
    private Application application;
    private static LeavingWorkplaceRepository mInstance;
    public static final String TAG = LeavingWorkplaceRepository.class.getSimpleName();

    public LeavingWorkplaceRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData = new MutableLiveData<>();
        constructionModelMutableLiveData = new MutableLiveData<>();
        leavingWorkPlaceMutableLiveData = new MutableLiveData<>();


    }

    public static LeavingWorkplaceRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new LeavingWorkplaceRepository(application);
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
                constructionMutableLiveData.setValue(null);
            }
        });

        return constructionMutableLiveData;
    }


    public LiveData<ConstructModel> getWorkerConstruct() {
        networkUtils.getApiInterface().getWorkerConstruction().enqueue(new Callback<ConstructModel>() {
            @Override
            public void onResponse(Call<ConstructModel> call, Response<ConstructModel> response) {
                if (response.isSuccessful()) {
                    constructionModelMutableLiveData.setValue(response.body());
                } else {
                    constructionModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructModel> call, Throwable t) {
                constructionModelMutableLiveData.setValue(null);
            }
        });

        return constructionModelMutableLiveData;
    }




    public LiveData<UpdateUser> AddLeavingWorkPlaceReport(String constructionId ,
                                         String leavingReason, String endDate  ){

        networkUtils.getApiInterface().AddLeavingWorkPlaceReport(constructionId, SharedPreferneceHelper.getUserSn(application) , leavingReason , endDate , SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();
                        leavingWorkPlaceMutableLiveData.setValue(response.body());
                    }
                } else {
                    leavingWorkPlaceMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                leavingWorkPlaceMutableLiveData.setValue(null);

            }
        });
        return leavingWorkPlaceMutableLiveData;

    }



}
