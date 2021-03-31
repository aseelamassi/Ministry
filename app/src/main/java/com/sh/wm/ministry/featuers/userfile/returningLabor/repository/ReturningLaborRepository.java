package com.sh.wm.ministry.featuers.userfile.returningLabor.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborAction;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborModel;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class ReturningLaborRepository {
    private static ReturningLaborRepository mInstance;
    private final String TAG = ReturningLaborRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<ReturningLaborModel> returningLaborModelMutableLiveData;
    private MutableLiveData<ReturningLaborAction> returningLaborActionMutableLiveData;
    private Application application ;

    private ReturningLaborRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        returningLaborModelMutableLiveData = new MutableLiveData<>();
        returningLaborActionMutableLiveData = new MutableLiveData<>();
    }

    public static ReturningLaborRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new ReturningLaborRepository(application);
        }
        return mInstance;
    }


    public LiveData<ReturningLaborModel> getReturningLabor() {//SharedPreferneceHelper.getUserId(application) "831504"
        networkUtils.getApiInterface().getReturningLabor(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<ReturningLaborModel>() {
            @Override
            public void onResponse(Call<ReturningLaborModel> call, Response<ReturningLaborModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        returningLaborModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    returningLaborModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ReturningLaborModel> call, Throwable t) {
                returningLaborModelMutableLiveData.setValue(null);
            }
        });
        return returningLaborModelMutableLiveData;
    }


    public LiveData<ReturningLaborAction> addReturningLabor( String countryId, String returningReason,  String startDate , String endDate,  String lastJob , String skillLevelId)
    {
        networkUtils.getApiInterface().addReturningLabor("insert", countryId, returningReason, startDate, endDate, lastJob, skillLevelId).enqueue(new Callback<ReturningLaborAction>() {
        @Override
        public void onResponse(Call<ReturningLaborAction> call, Response<ReturningLaborAction> response) {
            if (response.body() != null) {
                if (response.isSuccessful()) {
                    returningLaborActionMutableLiveData.setValue(response.body());
                }
            } else {
                returningLaborActionMutableLiveData.setValue(null);
            }
        }

        @Override
        public void onFailure(Call<ReturningLaborAction> call, Throwable t) {
            returningLaborActionMutableLiveData.setValue(null);

        }
    });
        return returningLaborActionMutableLiveData;

    }


    public LiveData<ReturningLaborAction> updateReturningLabor( String userLaborId , String countryId, String returningReason,  String startDate , String endDate,  String lastJob , String skillLevelId)
    {
        networkUtils.getApiInterface().updateReturningLabor("update",userLaborId, countryId, returningReason, startDate, endDate, lastJob, skillLevelId).enqueue(new Callback<ReturningLaborAction>() {
            @Override
            public void onResponse(Call<ReturningLaborAction> call, Response<ReturningLaborAction> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        returningLaborActionMutableLiveData.setValue(response.body());
                    }
                } else {
                    returningLaborActionMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ReturningLaborAction> call, Throwable t) {
                returningLaborActionMutableLiveData.setValue(null);

            }
        });
        return returningLaborActionMutableLiveData;

    }
}
