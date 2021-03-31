package com.sh.wm.ministry.featuers.userfile.practicalstatus.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDesc;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class PracticalStatusRepository {
    private static PracticalStatusRepository mInstance;
    private final String TAG = PracticalStatusRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<PracticalStatusModel> practicalStatusModellMutableLiveData;
    private MutableLiveData<ResultModel> jobListModelMutableLiveData;
    private MutableLiveData<ConstructByName> constructByNameMutableLiveData;
    private MutableLiveData<WorkStatusDescModel> workStatusDescModelMutableLiveData;
    private MutableLiveData<WorkStatusDescDescModel> workStatusDescDescModelMutableLiveData;
    private MutableLiveData<ActionModel> actionModelMutableLiveData;
    private MutableLiveData<ResponseBody> inputStreamMutableLiveData;


    private Application application;
    public PracticalStatusRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        this.application = application;
        practicalStatusModellMutableLiveData = new MutableLiveData<>();
        jobListModelMutableLiveData = new MutableLiveData<>();
        constructByNameMutableLiveData = new MutableLiveData<>();
        workStatusDescModelMutableLiveData = new MutableLiveData<>();
        workStatusDescDescModelMutableLiveData = new MutableLiveData<>();
        actionModelMutableLiveData = new MutableLiveData<>();
        inputStreamMutableLiveData = new MutableLiveData<>();
    }

    public static PracticalStatusRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new PracticalStatusRepository(application);
        }
        return mInstance;
    }


    public LiveData<PracticalStatusModel> getUserPracticalStatus() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getUserPracticalStatus(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<PracticalStatusModel>() {
            @Override
            public void onResponse(Call<PracticalStatusModel> call, Response<PracticalStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        practicalStatusModellMutableLiveData.setValue(response.body());
                    }
                } else {
                    practicalStatusModellMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PracticalStatusModel> call, Throwable t) {
                practicalStatusModellMutableLiveData.setValue(null);
            }
        });
        return practicalStatusModellMutableLiveData;
    }



//    public LiveData<ResultModel> getJobListModel(String keyword) {
//        networkUtils.getApiInterface().getJobList(keyword).enqueue(new Callback<ResultModel>() {
//            @Override
//            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
//                if (response.body() != null) {
//                    if (response.isSuccessful()) {
//                        jobListModelMutableLiveData.setValue(response.body());
//                    }
//                } else {
//                    jobListModelMutableLiveData.setValue(null);
//                    Log.d(TAG, "User Work Experience Empty Response!");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultModel> call, Throwable t) {
//                jobListModelMutableLiveData.setValue(null);
//                Log.e(TAG, "User Work Experience Empty Response!");
//            }
//        });
//        return jobListModelMutableLiveData;
//    }

    public LiveData<ConstructByName> getConstruct(String name) {
        networkUtils.getApiInterface().getConstructByName(name).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    constructByNameMutableLiveData.setValue(response.body());
                } else {
                    constructByNameMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {

                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructByNameMutableLiveData;
    }

    public LiveData<WorkStatusDescModel> getWorkStatusDesc(String workStatusId) {
        networkUtils.getApiInterface().getWorkDescMode(workStatusId).enqueue(new Callback<WorkStatusDescModel>() {
            @Override
            public void onResponse(Call<WorkStatusDescModel> call, Response<WorkStatusDescModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        workStatusDescModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    workStatusDescModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<WorkStatusDescModel> call, Throwable t) {
                workStatusDescModelMutableLiveData.setValue(null);
            }
        });
        return workStatusDescModelMutableLiveData;
    }


    public LiveData<WorkStatusDescDescModel> getWorkStatusDescDesc(String workStatusDescId) {
        networkUtils.getApiInterface().getWorkStatusDescDesc(workStatusDescId).enqueue(new Callback<WorkStatusDescDescModel>() {
            @Override
            public void onResponse(Call<WorkStatusDescDescModel> call, Response<WorkStatusDescDescModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        workStatusDescDescModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    workStatusDescDescModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<WorkStatusDescDescModel> call, Throwable t) {
                workStatusDescDescModelMutableLiveData.setValue(null);
            }
        });
        return workStatusDescDescModelMutableLiveData;
    }

    public LiveData<ActionModel> updateWorkStatus( String userWorkId , String userWorkStatusId , String userWorkDescId, String userWorkDescDescId, String startDate ,  String endDate, String reason , String salary , String currencyId,  String hoursId, String natureId , String jobTitleId, String constructId){
        networkUtils.getApiInterface().updateWorkStatus(userWorkId, userWorkStatusId, userWorkDescId, userWorkDescDescId, startDate, endDate, reason, salary, currencyId, hoursId, natureId, jobTitleId, constructId).enqueue(new Callback<ActionModel>() {
            @Override
            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {

                        actionModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    actionModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ActionModel> call, Throwable t) {
                actionModelMutableLiveData.setValue(null);
            }
        });
        return actionModelMutableLiveData;
    }


    public LiveData<ResponseBody> getUnemployedFile(){
        networkUtils.getApiInterface().getUnemployedFile().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    inputStreamMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        return inputStreamMutableLiveData;
    }

}
