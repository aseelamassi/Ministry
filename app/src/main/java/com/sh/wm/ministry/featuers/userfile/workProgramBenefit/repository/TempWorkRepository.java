package com.sh.wm.ministry.featuers.userfile.workProgramBenefit.repository;

import android.app.Application;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;

import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model.TempWorkModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TempWorkRepository {
    private static TempWorkRepository mInstance;
    private final String TAG = TempWorkRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<TempWorkModel> tempWorkModelMutableLiveData;
    private Application application ;

    private TempWorkRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        tempWorkModelMutableLiveData = new MutableLiveData<>();
    }

    public static TempWorkRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new TempWorkRepository(application);
        }
        return mInstance;
    }


    public LiveData<TempWorkModel> getTempWorks() {
        networkUtils.getApiInterface().getTempWorks().enqueue(new Callback<TempWorkModel>() {
            @Override
            public void onResponse(Call<TempWorkModel> call, Response<TempWorkModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        tempWorkModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    tempWorkModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TempWorkModel> call, Throwable t) {
                tempWorkModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return tempWorkModelMutableLiveData;
    }

}
