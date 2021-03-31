package com.sh.wm.ministry.network.database.dbModels.trainingSide;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;

import java.util.List;

public class TrainingSideModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("result")
    @Expose
    private List<TrainingSide> trainingSides;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TrainingSide> getTrainingPrograms() {
        return trainingSides;
    }

    public void setTrainingPrograms(List<TrainingSide> trainingSides) {
        this.trainingSides = trainingSides;
    }
}
