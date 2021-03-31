package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.UserData;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class WorkercompilationRepository {

    private NetworkUtils networkUtils;
    private static final String TAG = WorkercompilationRepository.class.getSimpleName();
    private MutableLiveData<ConstructByName> constructByNameMutableLiveData;
    private MutableLiveData<ActionModel> actionAddLaborComplain;
    private MutableLiveData<UserData> userInfoModelMutableLiveData;
    private static WorkercompilationRepository mInstance;
    private Application application;


    public WorkercompilationRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        constructByNameMutableLiveData = new MutableLiveData<>();
        actionAddLaborComplain = new MutableLiveData<>();
        userInfoModelMutableLiveData = new MutableLiveData<>();
        this.application = application;
    }

    public static WorkercompilationRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new WorkercompilationRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserData> getUserData() {
        networkUtils.getApiInterface().getUserData().enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body().getStatus());
                    userInfoModelMutableLiveData.setValue(response.body());
                } else {
                    Toast.makeText(application, response.message(), Toast.LENGTH_SHORT).show();
                    userInfoModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                userInfoModelMutableLiveData.setValue(null);
            }
        });

        return userInfoModelMutableLiveData;
    }


    public LiveData<ConstructByName> getConstruct(String number) {
        networkUtils.getApiInterface().getConstructByName(number).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body().getStatus());
                    constructByNameMutableLiveData.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse: " + " no data");
                    constructByNameMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructByNameMutableLiveData;
    }


    public LiveData<ActionModel> addLaborComplaint(String userSn, String haveContract,
                                                  String lateWages, String lateWagePer,
                                                  String deadLineConsideration, String deadLinePer,
                                                  String terminationReason,
                                                  String constructionId, String endWorkType,
                                                  String workPeriod, String realWorkPeriod,
                                                  String remainLeaveDays, String jobId,
                                                  String natureId, String lastPay,
                                                  String currency, String hoursType,
                                                  String cermenories, String startDate, String endDate , String mobileNum , String addressDesc) {

        networkUtils.getApiInterface().addLaborComplaint(userSn, haveContract, lateWages, lateWagePer, deadLineConsideration, deadLinePer, terminationReason, SharedPreferneceHelper.getUserSn(application), constructionId, endWorkType, workPeriod, realWorkPeriod, remainLeaveDays, jobId, natureId, lastPay, currency, hoursType, cermenories, startDate, endDate, mobileNum , addressDesc).enqueue(new Callback<ActionModel>() {
            @Override
            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                if (response.isSuccessful()) {
                    actionAddLaborComplain.setValue(response.body());
                    Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    actionAddLaborComplain.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ActionModel> call, Throwable t) {
                Toast.makeText(application, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                actionAddLaborComplain.setValue(null);
            }
        });

        return actionAddLaborComplain;

    }


}
