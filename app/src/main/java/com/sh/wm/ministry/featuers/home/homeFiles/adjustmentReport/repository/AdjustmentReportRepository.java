package com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;

import com.sh.wm.ministry.network.utiels.NetworkUtils;


import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdjustmentReportRepository {

    public static final String TAG = AdjustmentReportRepository.class.getSimpleName();
    private NetworkUtils networkUtils;

    private MutableLiveData<ActionModel> actionMutableLiveData;
    static AdjustmentReportRepository mInstance;
    private Application application;

    public AdjustmentReportRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        actionMutableLiveData = new MutableLiveData<>();
        this.application = application;

    }

    public static AdjustmentReportRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new AdjustmentReportRepository(application);

        }
        return mInstance;
    }


    public LiveData<ActionModel> storeAdjustmentReport(HashMap<String , RequestBody> data, MultipartBody.Part file  ){
        networkUtils.getApiInterface().storeAdjustmentReport(data,file).enqueue(new Callback<ActionModel>() {
            @Override
            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {


                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    actionMutableLiveData.setValue(response.body());
                } else {

                    actionMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ActionModel> call, Throwable t) {
                actionMutableLiveData.setValue(null);
            }
        });
        return actionMutableLiveData;
    }


}
