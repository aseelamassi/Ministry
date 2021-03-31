package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HollandCareersModel {

    @SerializedName("jobs_1")
    @Expose
    private List<Activity> jobs1 = null;
    @SerializedName("jobs_2")
    @Expose
    private List<Activity> jobs2 = null;
    @SerializedName("jobs_3")
    @Expose
    private List<Activity> jobs3 = null;
    @SerializedName("jobs_4")
    @Expose
    private List<Activity> jobs4 = null;
    @SerializedName("jobs_5")
    @Expose
    private List<Activity> jobs5 = null;
    @SerializedName("jobs_6")
    @Expose
    private List<Activity> jobs6 = null;

    public List<Activity> getJobs1() {
        return jobs1;
    }

    public void setJobs1(List<Activity> jobs1) {
        this.jobs1 = jobs1;
    }

    public List<Activity> getJobs2() {
        return jobs2;
    }

    public void setJobs2(List<Activity> jobs2) {
        this.jobs2 = jobs2;
    }

    public List<Activity> getJobs3() {
        return jobs3;
    }

    public void setJobs3(List<Activity> jobs3) {
        this.jobs3 = jobs3;
    }

    public List<Activity> getJobs4() {
        return jobs4;
    }

    public void setJobs4(List<Activity> jobs4) {
        this.jobs4 = jobs4;
    }

    public List<Activity> getJobs5() {
        return jobs5;
    }

    public void setJobs5(List<Activity> jobs5) {
        this.jobs5 = jobs5;
    }

    public List<Activity> getJobs6() {
        return jobs6;
    }

    public void setJobs6(List<Activity> jobs6) {
        this.jobs6 = jobs6;
    }

}
