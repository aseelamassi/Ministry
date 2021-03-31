package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HollandTestJobModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("job_list")
    @Expose
    private List<JobList> jobList = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<JobList> getJobList() {
        return jobList;
    }

    public void setJobList(List<JobList> jobList) {
        this.jobList = jobList;
    }
}
