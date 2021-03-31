package com.sh.wm.ministry.network.database.dbModels.jobList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultModel {

    @SerializedName("status")
    @Expose
    private int status ;

    @SerializedName("result")
    @Expose
    private List<Result> results ;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
