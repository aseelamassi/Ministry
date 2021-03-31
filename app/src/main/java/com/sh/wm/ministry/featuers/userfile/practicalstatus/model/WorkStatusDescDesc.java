package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkStatusDescDesc {
    @SerializedName("WORK_DESC_DESC_ID")
    @Expose
    private String wORKDESCDESCID;
    @SerializedName("WORK_DESC_DESC_NAME")
    @Expose
    private String wORKDESCDESCNAME;
    @SerializedName("WORK_DESC_ID")
    @Expose
    private String wORKDESCID;

    public String getWORKDESCDESCID() {
        return wORKDESCDESCID;
    }

    public void setWORKDESCDESCID(String wORKDESCDESCID) {
        this.wORKDESCDESCID = wORKDESCDESCID;
    }

    public String getWORKDESCDESCNAME() {
        return wORKDESCDESCNAME;
    }

    public void setWORKDESCDESCNAME(String wORKDESCDESCNAME) {
        this.wORKDESCDESCNAME = wORKDESCDESCNAME;
    }

    public String getWORKDESCID() {
        return wORKDESCID;
    }

    public void setWORKDESCID(String wORKDESCID) {
        this.wORKDESCID = wORKDESCID;
    }


    @NonNull
    @Override
    public String toString() {
        return getWORKDESCDESCNAME();
    }
}
