package com.sh.wm.ministry.featuers.userfile.trainingprograms.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.ActionsTrainingProgramsModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgram;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgramModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.repository.TrainingProgramRepository;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgramsModel;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class TrainingProgramsViewModel extends AndroidViewModel {

    private TrainingProgramRepository repository;
    private DBRepository dbRepository;

    public TrainingProgramsViewModel(@NonNull Application application) {
        super(application);
        repository = TrainingProgramRepository.getInstance(application);
        dbRepository = DBRepository.getInstance(application);

    }

    public LiveData<UserTrainingProgramModel> getTrainingPrograms() {
        return repository.getUserTrainingPrograms();
    }


    public LiveData<ActionsTrainingProgramsModel> addTrainingProgram(String trainEntity, String trainProgId,
                                                                     String courseType, String institutionId, String startDate, String endDate,
                                                                     String hours, String entityAddress, String notes, String tempWork){
        return repository.addTrainingProgram(trainEntity, trainProgId, courseType, institutionId, startDate, endDate, hours, entityAddress, notes, tempWork);
    }

    public LiveData<ActionsTrainingProgramsModel> updateTrainingProgram(String userTrainProgId ,String trainEntity, String trainProgId,
                                                                        String courseType, String institutionId, String startDate, String endDate,
                                                                        String hours, String entityAddress, String notes, String tempWork){
        return repository.updateTrainingProgram(userTrainProgId, trainEntity, trainProgId, courseType, institutionId, startDate, endDate, hours, entityAddress, notes, tempWork);
    }


    public LiveData<List<TrainingProgram>> getTrainingProgram(String key){
        return dbRepository.getAllTrainingPrograms(key);
    }


    public LiveData<List<TrainingSide>> getTrainingSide(String key){
        return dbRepository.getAllTrainingSide(key);
    }






}