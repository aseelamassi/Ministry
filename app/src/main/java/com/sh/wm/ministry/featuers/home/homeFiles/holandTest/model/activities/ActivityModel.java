package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActivityModel {

    @SerializedName("activity_1")
    @Expose
    private List<Activity> activity1 = null;
    @SerializedName("activity_2")
    @Expose
    private List<Activity> activity2 = null;
    @SerializedName("activity_3")
    @Expose
    private List<Activity> activity3 = null;
    @SerializedName("activity_4")
    @Expose
    private List<Activity> activity4 = null;
    @SerializedName("activity_5")
    @Expose
    private List<Activity> activity5 = null;
    @SerializedName("activity_6")
    @Expose
    private List<Activity> activity6 = null;

    public List<Activity> getActivity1() {
        return activity1;
    }

    public void setActivity1(List<Activity> activity1) {
        this.activity1 = activity1;
    }

    public List<Activity> getActivity2() {
        return activity2;
    }

    public void setActivity2(List<Activity> activity2) {
        this.activity2 = activity2;
    }

    public List<Activity> getActivity3() {
        return activity3;
    }

    public void setActivity3(List<Activity> activity3) {
        this.activity3 = activity3;
    }

    public List<Activity> getActivity4() {
        return activity4;
    }

    public void setActivity4(List<Activity> activity4) {
        this.activity4 = activity4;
    }

    public List<Activity> getActivity5() {
        return activity5;
    }

    public void setActivity5(List<Activity> activity5) {
        this.activity5 = activity5;
    }

    public List<Activity> getActivity6() {
        return activity6;
    }

    public void setActivity6(List<Activity> activity6) {
        this.activity6 = activity6;
    }

}
