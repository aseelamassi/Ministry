package com.sh.wm.ministry.featuers.userfile.trainingskills.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.featuers.userfile.trainingskills.repository.TrainingSkillsRepository;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class TrainingSkillsViewModel extends AndroidViewModel {
    private TrainingSkillsRepository repository;
    private DBRepository dbRepository;

    public TrainingSkillsViewModel(@NonNull Application application) {
        super(application);
        repository = TrainingSkillsRepository.getInstance(application);
        dbRepository = DBRepository.getInstance(application);
    }

    public LiveData<TrainingSkillsModel> getTrainingSkills() {
        return repository.getTrainingSkills();
    }




//    public LiveData<ResultModel> getJobList(String keyword) {
//        return repository.getJobList(keyword);
//    }

    public LiveData<List<TrainingProgram>> getTrainingProgram(String key) {
        return dbRepository.getAllTrainingPrograms(key);
    }

    public LiveData<UpdateUser> insertTrainingSkill(String courseTypeId, String priority, String jobId, String courseId) {
        return repository.insertTrainingSkill(courseTypeId, priority, jobId, courseId);
    }

    public LiveData<UpdateUser> updateTrainingSkill(String skillId, String courseTypeId, String priority, String jobId, String courseId) {
        return repository.updateTrainingSkill(skillId, courseTypeId, priority, jobId, courseId);
    }
}
