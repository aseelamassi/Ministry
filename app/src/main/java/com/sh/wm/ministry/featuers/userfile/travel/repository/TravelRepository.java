package com.sh.wm.ministry.featuers.userfile.travel.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelRepository {
    private static TravelRepository mInstance;
    private final String TAG = TravelRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserTravelDataModel> userTravelDataModelMutableLiveData;
    private Application application ;

    private TravelRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userTravelDataModelMutableLiveData = new MutableLiveData<>();
    }

    public static TravelRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new TravelRepository(application);
        }
        return mInstance;
    }


    public LiveData<UserTravelDataModel> getTravelData() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getTravelData(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserTravelDataModel>() {
            @Override
            public void onResponse(Call<UserTravelDataModel> call, Response<UserTravelDataModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userTravelDataModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userTravelDataModelMutableLiveData.setValue(null);
                    Log.d(TAG, "User Travels Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserTravelDataModel> call, Throwable t) {
                userTravelDataModelMutableLiveData.setValue(null);
                Log.e(TAG, "User Travels Empty Response!");
            }
        });
        return userTravelDataModelMutableLiveData;
    }


}
