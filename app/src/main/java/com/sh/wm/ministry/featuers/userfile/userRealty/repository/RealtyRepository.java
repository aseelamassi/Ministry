package com.sh.wm.ministry.featuers.userfile.userRealty.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.featuers.userfile.userRealty.model.UserRealtyModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RealtyRepository {

    private static RealtyRepository mInstance;
    private final String TAG = TravelRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserRealtyModel> userRealtyModelMutableLiveData;
    private Application application ;

    private RealtyRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userRealtyModelMutableLiveData = new MutableLiveData<>();
    }

    public static RealtyRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new RealtyRepository(application);
        }
        return mInstance;
    }


    public LiveData<UserRealtyModel> getUserRealty() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getUserRealty(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserRealtyModel>() {
            @Override
            public void onResponse(Call<UserRealtyModel> call, Response<UserRealtyModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userRealtyModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userRealtyModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserRealtyModel> call, Throwable t) {
                userRealtyModelMutableLiveData.setValue(null);
            }
        });
        return userRealtyModelMutableLiveData;
    }

}
