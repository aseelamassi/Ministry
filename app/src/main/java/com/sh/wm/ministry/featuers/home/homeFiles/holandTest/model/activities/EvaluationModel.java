package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EvaluationModel {

    @SerializedName("evaluation_1")
    @Expose
    private List<Activity> evaluation1 = null;
    @SerializedName("evaluation_2")
    @Expose
    private List<Activity> evaluation2 = null;

    public List<Activity> getEvaluation1() {
        return evaluation1;
    }

    public void setEvaluation1(List<Activity> evaluation1) {
        this.evaluation1 = evaluation1;
    }

    public List<Activity> getEvaluation2() {
        return evaluation2;
    }

    public void setEvaluation2(List<Activity> evaluation2) {
        this.evaluation2 = evaluation2;
    }

}
