package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobList {

    @SerializedName("JOB_ID")
    @Expose
    private String jOBID;
    @SerializedName("JOB_AR_NAME")
    @Expose
    private String jOBARNAME;

    public String getJOBID() {
        return jOBID;
    }

    public void setJOBID(String jOBID) {
        this.jOBID = jOBID;
    }

    public String getJOBARNAME() {
        return jOBARNAME;
    }

    public void setJOBARNAME(String jOBARNAME) {
        this.jOBARNAME = jOBARNAME;
    }


    @NonNull
    @Override
    public String toString() {
        return getJOBARNAME();
    }
}