package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.secondaryActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecondActivityModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("second_activities")
    @Expose
    private List<SecondActivity> secondActivities = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SecondActivity> getSecondActivities() {
        return secondActivities;
    }

    public void setSecondActivities(List<SecondActivity> secondActivities) {
        this.secondActivities = secondActivities;
    }

}
