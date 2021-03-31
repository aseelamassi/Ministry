package com.sh.wm.ministry.featuers.userfile.trainingprograms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserTrainingProgramModel {

    @SerializedName("status")
    @Expose
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserTrainingProgram> getUserTrainingPrograms() {
        return userTrainingPrograms;
    }

    public void setUserTrainingPrograms(List<UserTrainingProgram> userTrainingPrograms) {
        this.userTrainingPrograms = userTrainingPrograms;
    }

    @SerializedName("user_training_programs")
    @Expose
    private List<UserTrainingProgram> userTrainingPrograms;

}
