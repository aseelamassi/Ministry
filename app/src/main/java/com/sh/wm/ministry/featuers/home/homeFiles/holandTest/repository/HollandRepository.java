package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.repository;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.ActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.EvaluationModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.HollandCareersModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.SkillsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandDreamJobs;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandTestJobModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.HollandResultModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;
import com.sh.wm.ministry.network.utiels.StringTypeConverter;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HollandRepository {

    private NetworkUtils networkUtils;
    private Application application;
    private static HollandRepository mInstance;
    private MutableLiveData<HollandBasicTabsModel> hollandBasicTabsModelMutableLiveData;
    private MutableLiveData<ActionModel> actionModelMutableLiveData;
    private MutableLiveData<HollandTestJobModel> hollandTestJobModelMutableLiveData;
    private MutableLiveData<HollandDreamJobs> hollandDreamJobsMutableLiveData;
    private MutableLiveData<ActivityModel> activityModelMutableLiveData;
    private MutableLiveData<SkillsModel> skillsModelMutableLiveData;
    private MutableLiveData<HollandCareersModel> hollandCareersModelMutableLiveData;
    private MutableLiveData<EvaluationModel> evaluationModelMutableLiveData;
    private MutableLiveData<HollandResultModel> hollandResultModelMutableLiveData;

    public HollandRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        hollandBasicTabsModelMutableLiveData= new MutableLiveData<>();
        actionModelMutableLiveData= new MutableLiveData<>();
        hollandTestJobModelMutableLiveData= new MutableLiveData<>();
        hollandDreamJobsMutableLiveData= new MutableLiveData<>();
        activityModelMutableLiveData= new MutableLiveData<>();
        skillsModelMutableLiveData= new MutableLiveData<>();
        hollandCareersModelMutableLiveData= new MutableLiveData<>();
        evaluationModelMutableLiveData= new MutableLiveData<>();
        hollandResultModelMutableLiveData = new MutableLiveData<>();



    }

    public static HollandRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new HollandRepository(application);
        }
        return mInstance;
    }


    public LiveData<HollandBasicTabsModel> getHollandBasicTabs() {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getHollandBasicTabs().enqueue(new Callback<HollandBasicTabsModel>() {
                @Override
                public void onResponse(Call<HollandBasicTabsModel> call, Response<HollandBasicTabsModel> response) {
                    if (response.isSuccessful() &&response.body() != null ) {
                        hollandBasicTabsModelMutableLiveData.setValue(response.body());
                    } else {
                        hollandBasicTabsModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<HollandBasicTabsModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else {

            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();

        }

        return hollandBasicTabsModelMutableLiveData;
    }



    public LiveData<ActionModel> saveBasicData(String testId, String numberOfYears ) {
        actionModelMutableLiveData= new MutableLiveData<>();
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().saveBasicDataHollandTest(testId, numberOfYears).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }


    public LiveData<HollandTestJobModel> getHollandJob(String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getHollandJobList(testId).enqueue(new Callback<HollandTestJobModel>() {
                @Override
                public void onResponse(Call<HollandTestJobModel> call, Response<HollandTestJobModel> response) {
                    if (response.isSuccessful() &&response.body() != null &&response.body().getJobList() != null) {
                        hollandTestJobModelMutableLiveData.setValue(response.body());
                    } else {
                        hollandTestJobModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<HollandTestJobModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();

        }

        return hollandTestJobModelMutableLiveData;
    }



    public LiveData<ActionModel> addDreamJob(String testId, String jobId ) {
        actionModelMutableLiveData= new MutableLiveData<>();

        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().addDreamJob(testId, jobId).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }


    public LiveData<ActionModel> deleteDreamJob(String testId, String jobId ) {
        actionModelMutableLiveData= new MutableLiveData<>();

        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().deleteDreamJob(testId, jobId).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }


    public LiveData<HollandDreamJobs> hollandDreamJobs(String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getHollandDreamJobs(testId).enqueue(new Callback<HollandDreamJobs>() {
                @Override
                public void onResponse(Call<HollandDreamJobs> call, Response<HollandDreamJobs> response) {
                    if (response.body() != null ) {
                        hollandDreamJobsMutableLiveData.setValue(response.body());
                    } else {

                        hollandDreamJobsMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<HollandDreamJobs> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return hollandDreamJobsMutableLiveData;
    }

//> getActivities(@Query("test_id") String testId)

    public LiveData<ActivityModel> getActivities(String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getActivities(testId).enqueue(new Callback<ActivityModel>() {
                @Override
                public void onResponse(Call<ActivityModel> call, Response<ActivityModel> response) {
                    if (response.body() != null ) {
                        activityModelMutableLiveData.setValue(response.body());
                    } else {
                        activityModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActivityModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return activityModelMutableLiveData;
    }


    public LiveData<ActionModel> saveActivityQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        actionModelMutableLiveData= new MutableLiveData<>();

        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().saveActivityQuestions(testId,  StringTypeConverter.fromStringMap(answers)).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }



    public LiveData<SkillsModel> getSkills(String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getSkills(testId).enqueue(new Callback<SkillsModel>() {
                @Override
                public void onResponse(Call<SkillsModel> call, Response<SkillsModel> response) {
                    if (response.body() != null ) {
                        skillsModelMutableLiveData.setValue(response.body());
                    } else {

                        skillsModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<SkillsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return skillsModelMutableLiveData;
    }


    public LiveData<ActionModel> saveSkillsQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        actionModelMutableLiveData= new MutableLiveData<>();

        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().saveSkillsQuestions(testId,  StringTypeConverter.fromStringMap(answers)).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        actionModelMutableLiveData.setValue(response.body());
                    } else {
                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }




    public LiveData<HollandCareersModel> getCareers(String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getHollandCareers(testId).enqueue(new Callback<HollandCareersModel>() {
                @Override
                public void onResponse(Call<HollandCareersModel> call, Response<HollandCareersModel> response) {
                    if (response.body() != null ) {
                        hollandCareersModelMutableLiveData.setValue(response.body());
                    } else {
                        hollandCareersModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<HollandCareersModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return hollandCareersModelMutableLiveData;
    }


    public LiveData<ActionModel> saveCareersQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        actionModelMutableLiveData= new MutableLiveData<>();

        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().saveCareerQuestions(testId,  StringTypeConverter.fromStringMap(answers)).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }


    public LiveData<EvaluationModel> getEvaluations(String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getEvaluationTest(testId).enqueue(new Callback<EvaluationModel>() {
                @Override
                public void onResponse(Call<EvaluationModel> call, Response<EvaluationModel> response) {
                    if (response.body() != null ) {
                        evaluationModelMutableLiveData.setValue(response.body());
                    } else {
                        evaluationModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<EvaluationModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return evaluationModelMutableLiveData;
    }


    public LiveData<ActionModel> saveEvaluationsQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        actionModelMutableLiveData= new MutableLiveData<>();

        Log.d("aseel" ,StringTypeConverter.fromStringMap(answers) );
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().saveEvaluationQuestions(testId,  StringTypeConverter.fromStringMap(answers)).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }


    public LiveData<HollandResultModel> getHollandResult( String testId) {
        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().getHollandResultModel(testId).enqueue(new Callback<HollandResultModel>() {
                @Override
                public void onResponse(Call<HollandResultModel> call, Response<HollandResultModel> response) {
                    if (response.isSuccessful() &&response.body() != null ) {
                        hollandResultModelMutableLiveData.setValue(response.body());
                    } else {
                        hollandResultModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<HollandResultModel> call, Throwable t) {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else {

            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();

        }

        return hollandResultModelMutableLiveData;
    }



    public LiveData<ActionModel> saveResultModel(String testId  ) {
        actionModelMutableLiveData= new MutableLiveData<>();

        if (NetworkUtils.isOnline(application)){
            networkUtils.getApiInterface().saveResultModel(testId).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null ) {
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        actionModelMutableLiveData.setValue(response.body());
                    } else {

                        actionModelMutableLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(application, application.getString(R.string.make_sure_that_you_have_internet), Toast.LENGTH_SHORT).show();


        return actionModelMutableLiveData;
    }


}
