package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Construct {

    @SerializedName("CONSTRUCT_NAME_USING")
    @Expose
    private String cONSTRUCTNAMEUSING;
    @SerializedName("CONSTRUCT_ID")
    @Expose
    private String cONSTRUCTID;
    @SerializedName("CONSTRUCT_WORKER_ID")
    @Expose
    private String cONSTRUCTWORKERID;



    public String getCONSTRUCTNAMEUSING() {
        return cONSTRUCTNAMEUSING;
    }

    public void setCONSTRUCTNAMEUSING(String cONSTRUCTNAMEUSING) {
        this.cONSTRUCTNAMEUSING = cONSTRUCTNAMEUSING;
    }

    public String getCONSTRUCTID() {
        return cONSTRUCTID;
    }

    public void setCONSTRUCTID(String cONSTRUCTID) {
        this.cONSTRUCTID = cONSTRUCTID;
    }

    public String getCONSTRUCTWORKERID() {
        return cONSTRUCTWORKERID;
    }

    public void setCONSTRUCTWORKERID(String cONSTRUCTWORKERID) {
        this.cONSTRUCTWORKERID = cONSTRUCTWORKERID;
    }


    @NonNull
    @Override
    public String toString() {
        return getCONSTRUCTNAMEUSING();
    }
}
