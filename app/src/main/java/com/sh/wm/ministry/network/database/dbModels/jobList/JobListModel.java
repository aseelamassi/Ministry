package com.sh.wm.ministry.network.database.dbModels.jobList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JobListModel {

    @SerializedName("status")
    @Expose
    private int status ;

    @SerializedName("result")
    @Expose
    private List<JobList> results ;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<JobList> getResults() {
        return results;
    }

    public void setResults(List<JobList> results) {
        this.results = results;
    }
}
