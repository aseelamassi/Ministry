package com.sh.wm.ministry.featuers.home.homeFiles.model;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inspector {

    @SerializedName("USER_ID")
    @Expose
    private String uSERID;
    @SerializedName("USER_SN")
    @Expose
    private String uSERSN;
    @SerializedName("USERNAME")
    @Expose
    private String uSERNAME;

    public String getUSERID() {
        return uSERID;
    }

    public void setUSERID(String uSERID) {
        this.uSERID = uSERID;
    }

    public String getUSERSN() {
        return uSERSN;
    }

    public void setUSERSN(String uSERSN) {
        this.uSERSN = uSERSN;
    }

    public String getUSERNAME() {
        return uSERNAME;
    }

    public void setUSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
    }


    @NonNull
    @Override
    public String toString() {
        return getUSERNAME();
    }
}

