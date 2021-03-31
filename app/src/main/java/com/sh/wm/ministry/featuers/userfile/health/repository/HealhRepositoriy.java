package com.sh.wm.ministry.featuers.userfile.health.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.userfile.health.model.health.AddUserHealth;
import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealhRepositoriy {
    private static final String TAG = HealhRepositoriy.class.getName();
    private static HealhRepositoriy mInstance;
    private NetworkUtils networkUtils;
    private Application application;
    private MutableLiveData<UserHealthStatusModel> userWorkInfoMutableLiveData;
    private MutableLiveData<AddUserHealth> addUserHealthMutableLiveData;

    private HealhRepositoriy(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkInfoMutableLiveData = new MutableLiveData<>();
        addUserHealthMutableLiveData = new MutableLiveData<>();
    }

    public static HealhRepositoriy getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new HealhRepositoriy(application);
        }
        return mInstance;
    }

    public LiveData<UserHealthStatusModel> getUserHealthStatus() {
        networkUtils.getApiInterface().getUserHealthStauts(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserHealthStatusModel>() {
            @Override
            public void onResponse(Call<UserHealthStatusModel> call, Response<UserHealthStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkInfoMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkInfoMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserHealthStatusModel> call, Throwable t) {
                userWorkInfoMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userWorkInfoMutableLiveData;
    }



    public LiveData<AddUserHealth> addUserHealthStatus(String userId,String healthStatusId , String healthDetails) {
        networkUtils.getApiInterface().addUserHealthStatus(userId,healthStatusId,healthDetails).enqueue(new Callback<AddUserHealth>() {
            @Override
            public void onResponse(Call<AddUserHealth> call, Response<AddUserHealth> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        addUserHealthMutableLiveData.setValue(response.body());
                    }
                } else {
                    addUserHealthMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<AddUserHealth> call, Throwable t) {
                addUserHealthMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return addUserHealthMutableLiveData;
    }


    public LiveData<AddUserHealth> addUserHealthStatusWithAll(String userId,String healthStatusId , String healthDetails,String disabilityId, String disabilityPlace , String disabilitySize , String disabilityReason) {
        networkUtils.getApiInterface().addUserHealthStatusWithAll(userId,healthStatusId,healthDetails,disabilityId,disabilityPlace,disabilitySize , disabilityReason).enqueue(new Callback<AddUserHealth>() {
            @Override
            public void onResponse(Call<AddUserHealth> call, Response<AddUserHealth> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        addUserHealthMutableLiveData.setValue(response.body());
                    }
                } else {
                    addUserHealthMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<AddUserHealth> call, Throwable t) {
                addUserHealthMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return addUserHealthMutableLiveData;
    }


}
