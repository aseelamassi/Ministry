package com.sh.wm.ministry.featuers.userfile.trainingskills.repository;

import android.app.Application;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class TrainingSkillsRepository {

    private static TrainingSkillsRepository mInstance;
    private final String TAG = TrainingSkillsRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<TrainingSkillsModel> mutableLiveData;
    private MutableLiveData<ResultModel> resultMutableLiveData;
    private MutableLiveData<UpdateUser> actionTrainingSkills;
    Application application;


    public TrainingSkillsRepository(Application application) {
        this.application =application;
        networkUtils = NetworkUtils.getInstance(true, application);
        mutableLiveData = new MutableLiveData<>();
        resultMutableLiveData = new MutableLiveData<>();
        actionTrainingSkills = new MutableLiveData<>();
    }

    public static TrainingSkillsRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new TrainingSkillsRepository(application);
        }
        return mInstance;
    }

    public LiveData<TrainingSkillsModel> getTrainingSkills() {//SharedPreferneceHelper.getUserId(application) 831504
        networkUtils.getApiInterface().getTrainingSkills(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<TrainingSkillsModel>() {
            @Override
            public void onResponse(Call<TrainingSkillsModel> call, Response<TrainingSkillsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        mutableLiveData.setValue(response.body());
                    }
                } else {
                    mutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();                }
            }

            @Override
            public void onFailure(Call<TrainingSkillsModel> call, Throwable t) {
                mutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();


        }
        });
        return mutableLiveData;
    }

//    public LiveData<ResultModel> getJobList(String keyword){
//        networkUtils.getApiInterface().getJobList(keyword).enqueue(new Callback<ResultModel>() {
//            @Override
//            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
//                if (response.body() != null) {
//                    if (response.isSuccessful()) {
//                        resultMutableLiveData.setValue(response.body());
//                    }
//                } else {
//                    resultMutableLiveData.setValue(null);
//                    Log.d(TAG, "Training Programs Empty Response!");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultModel> call, Throwable t) {
//                resultMutableLiveData.setValue(null);
//                Log.e(TAG, "Training Programs request has failed!");
//            }
//        });
//        return resultMutableLiveData;
//    }


    public  LiveData<UpdateUser> insertTrainingSkill(  String courseTypeId, String priority ,  String jobId , String courseId){
        networkUtils.getApiInterface().insertTrainingSkill("insert" , SharedPreferneceHelper.getUserId(application) , courseTypeId , priority,jobId,courseId).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionTrainingSkills.setValue(response.body());
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    actionTrainingSkills.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                actionTrainingSkills.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return actionTrainingSkills;
    }

    public  LiveData<UpdateUser> updateTrainingSkill(  String skillId,String courseTypeId, String priority ,  String jobId , String courseId){
        networkUtils.getApiInterface().updateTrainingSkill("update" ,skillId, SharedPreferneceHelper.getUserId(application) , courseTypeId , priority,jobId,courseId).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionTrainingSkills.setValue(response.body());
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    actionTrainingSkills.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                actionTrainingSkills.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return actionTrainingSkills;
    }



}
