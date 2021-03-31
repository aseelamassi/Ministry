package com.sh.wm.ministry.featuers.userfile.workexperience.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperienceModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkExperienceRepository {

    private static WorkExperienceRepository mInstance;
    private final String TAG = WorkExperienceRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserWorkExperienceModel> userWorkExperienceModelMutableLiveData;
    private MutableLiveData<UpdateUser> actionUserWorkExperienceModelMutableLiveData;
    private Application application ;

    private MutableLiveData<ResultModel> jobListModelMutableLiveData ;

    private WorkExperienceRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkExperienceModelMutableLiveData = new MutableLiveData<>();
        actionUserWorkExperienceModelMutableLiveData = new MutableLiveData<>();
        jobListModelMutableLiveData = new MutableLiveData<>();
    }

    public static WorkExperienceRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new WorkExperienceRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserWorkExperienceModel> getUserWorkExperiences(String userId) {
        networkUtils.getApiInterface().getUserWorkExperiences(userId).enqueue(new Callback<UserWorkExperienceModel>() {
            @Override
            public void onResponse(Call<UserWorkExperienceModel> call, Response<UserWorkExperienceModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkExperienceModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkExperienceModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserWorkExperienceModel> call, Throwable t) {
                userWorkExperienceModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return userWorkExperienceModelMutableLiveData;
    }

    public LiveData<UpdateUser> addUserWorkExperience(String expTypeId ,String jobTitleId, String insistId ,  String startWork , String endWork ,String leavingReason ){
        networkUtils.getApiInterface().addUserWorkExperience("insert", SharedPreferneceHelper.getUserId(application), expTypeId, jobTitleId, insistId, startWork, endWork, leavingReason, SharedPreferneceHelper.getUserSn(application)).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionUserWorkExperienceModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    actionUserWorkExperienceModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                actionUserWorkExperienceModelMutableLiveData.setValue(null);
                Log.e(TAG, "User Work Experience Empty Response!");
            }
        });
        return actionUserWorkExperienceModelMutableLiveData;

    }

    public LiveData<UpdateUser> updateUserWorkExperience(String expId , String expTypeId ,String jobTitleId, String insistId ,  String startWork , String endWork ,String leavingReason ){
        networkUtils.getApiInterface().updateUserWorkExperience("update",expId, SharedPreferneceHelper.getUserId(application), expTypeId, jobTitleId, insistId, startWork, endWork, leavingReason, SharedPreferneceHelper.getUserSn(application)).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionUserWorkExperienceModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    actionUserWorkExperienceModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                actionUserWorkExperienceModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
        return actionUserWorkExperienceModelMutableLiveData;

    }




//
//    public LiveData<ResultModel> getTrainingInstitutes(String keyword) {
//        networkUtils.getApiInterface().getTrainingInstitutes(keyword).enqueue(new Callback<ResultModel>() {
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


}
