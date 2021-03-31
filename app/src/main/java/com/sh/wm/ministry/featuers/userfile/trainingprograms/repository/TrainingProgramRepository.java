package com.sh.wm.ministry.featuers.userfile.trainingprograms.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.ActionsTrainingProgramsModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgramModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  TrainingProgramRepository {

    private static TrainingProgramRepository mInstance;
    private final String TAG = TrainingProgramRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserTrainingProgramModel> trainingProgramsModelMutableLiveData;
    private MutableLiveData<ActionsTrainingProgramsModel> actionTrainingProgramsModelMutableLiveData;
    Application application;


    private TrainingProgramRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
    }

    public static TrainingProgramRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new TrainingProgramRepository(application);
        }
        return mInstance;
    }


    //get user training program
    public LiveData<UserTrainingProgramModel> getUserTrainingPrograms() {//SharedPreferneceHelper.getUserId(application) "831504"
        trainingProgramsModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().getUserTrainingPrograms(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserTrainingProgramModel>() {
            @Override
            public void onResponse(Call<UserTrainingProgramModel> call, Response<UserTrainingProgramModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        trainingProgramsModelMutableLiveData.setValue(response.body());

                    }
                } else {
                    trainingProgramsModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();                }
            }

            @Override
            public void onFailure(Call<UserTrainingProgramModel> call, Throwable t) {
                trainingProgramsModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();            }
        });
        return trainingProgramsModelMutableLiveData;
    }


    public LiveData<ActionsTrainingProgramsModel> addTrainingProgram(String trainEntity, String trainProgId,
                                                                     String courseType, String institutionId, String startDate, String endDate,
                                                                     String hours, String entityAddress, String notes, String tempWork){
        actionTrainingProgramsModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().addTrainingProgramsModel("insert",SharedPreferneceHelper.getUserId(application),trainEntity,trainProgId,courseType,institutionId,startDate,endDate,hours,entityAddress,notes,SharedPreferneceHelper.getUserSn(application),tempWork).enqueue(new Callback<ActionsTrainingProgramsModel>() {
            @Override
            public void onResponse(Call<ActionsTrainingProgramsModel> call, Response<ActionsTrainingProgramsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionTrainingProgramsModelMutableLiveData.setValue(response.body());
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                  //  actionTrainingProgramsModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();                }
            }

            @Override
            public void onFailure(Call<ActionsTrainingProgramsModel> call, Throwable t) {
                actionTrainingProgramsModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return actionTrainingProgramsModelMutableLiveData;
    }




    public LiveData<ActionsTrainingProgramsModel> updateTrainingProgram(String userTrainProgId ,String trainEntity, String trainProgId,
                                                                     String courseType, String institutionId, String startDate, String endDate,
                                                                     String hours, String entityAddress, String notes, String tempWork){
        actionTrainingProgramsModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().updateTrainingProgramsModel("update",userTrainProgId,SharedPreferneceHelper.getUserId(application),trainEntity,trainProgId,courseType,institutionId,startDate,endDate,hours,entityAddress,notes,SharedPreferneceHelper.getUserSn(application),tempWork).enqueue(new Callback<ActionsTrainingProgramsModel>() {
            @Override
            public void onResponse(Call<ActionsTrainingProgramsModel> call, Response<ActionsTrainingProgramsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionTrainingProgramsModelMutableLiveData.setValue(response.body());
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //  actionTrainingProgramsModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();                }
            }

            @Override
            public void onFailure(Call<ActionsTrainingProgramsModel> call, Throwable t) {
                actionTrainingProgramsModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return actionTrainingProgramsModelMutableLiveData;
    }





}
