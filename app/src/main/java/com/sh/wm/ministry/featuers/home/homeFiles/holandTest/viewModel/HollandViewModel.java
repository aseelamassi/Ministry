package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel;

import android.app.Application;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.ActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.EvaluationModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.HollandCareersModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.SkillsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandDreamJobs;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandTestJobModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.HollandResultModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.repository.HollandRepository;
import com.sh.wm.ministry.featuers.home.model.ActionModel;

import java.util.ArrayList;
import java.util.HashMap;

public class HollandViewModel  extends AndroidViewModel {

    private HollandRepository hollandRepository;

    public HollandViewModel(@NonNull Application application) {
        super(application);

        hollandRepository = HollandRepository.getInstance(application);
    }


    public LiveData<HollandBasicTabsModel> getHollandBasicTabs(){
        return hollandRepository.getHollandBasicTabs();
    }

    public LiveData<ActionModel> saveBasicData(String testId, String numberOfYears ) {
        return hollandRepository.saveBasicData(testId , numberOfYears);
    }

    public LiveData<HollandTestJobModel> getHollandJob( String testId){
        return hollandRepository.getHollandJob(testId);
    }

    public LiveData<ActionModel> addDreamJob(String testId, String jobId) {
        return hollandRepository.addDreamJob(testId, jobId) ;}

    public LiveData<ActionModel> deleteDreamJob(String testId, String jobId ){
        return hollandRepository.deleteDreamJob(testId, jobId);
    }


    public LiveData<HollandDreamJobs> hollandDreamJobs(String testId){
        return hollandRepository.hollandDreamJobs(testId);
    }

    public LiveData<ActivityModel> getActivities(String testId) {
        return hollandRepository.getActivities(testId);
    }

    public LiveData<ActionModel> saveActivityQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        return hollandRepository.saveActivityQuestions(testId , answers );
    }


    public LiveData<SkillsModel> getSkills(String testId) {
        return hollandRepository.getSkills(testId);
    }

    public LiveData<ActionModel> saveSkillsQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        return hollandRepository.saveSkillsQuestions(testId , answers );
    }


    public LiveData<HollandCareersModel> getCareers(String testId) {
        return hollandRepository.getCareers(testId);
    }

    public LiveData<ActionModel> saveCareersQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        return hollandRepository.saveCareersQuestions(testId , answers );
    }



    public LiveData<EvaluationModel> getEvaluations(String testId) {
        return hollandRepository.getEvaluations(testId);
    }

    public LiveData<ActionModel> saveEvaluationsQuestions(String testId, ArrayList<HashMap<String, String>> answers) {
        return hollandRepository.saveEvaluationsQuestions(testId , answers );
    }


    public LiveData<HollandResultModel> getHollandResult( String testId) {

        return hollandRepository.getHollandResult(testId);
    }


    public LiveData<ActionModel> saveResultModel(String testId  ) {

        return hollandRepository.saveResultModel(testId);
    }




    }
