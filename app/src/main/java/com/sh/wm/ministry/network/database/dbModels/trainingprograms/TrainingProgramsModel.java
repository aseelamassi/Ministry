
package com.sh.wm.ministry.network.database.dbModels.trainingprograms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgram;

public class TrainingProgramsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("result")
    @Expose
    private List<TrainingProgram> trainingPrograms;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TrainingProgram> getTrainingPrograms() {
        return trainingPrograms;
    }

    public void setTrainingPrograms(List<TrainingProgram> trainingPrograms) {
        this.trainingPrograms = trainingPrograms;
    }

}
