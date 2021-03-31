package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserInfo implements Serializable {

    @SerializedName("USER_SN")
    @Expose
    private String uSERSN;
    @SerializedName("USER_ID")
    @Expose
    private String uSERID;
    @SerializedName("WORKER_NAME")
    @Expose
    private String wORKERNAME;
    @SerializedName("SOCIAL_STATUS")
    @Expose
    private String sOCIALSTATUS;
    @SerializedName("BRITH_DATE")
    @Expose
    private String bRITHDATE;
    @SerializedName("USER_MOBILE_1")
    @Expose
    private String uSERMOBILE1;
    @SerializedName("USER_BUILDING")
    @Expose
    private String uSERBUILDING;


    @SerializedName("USER_FULL_NAME")
    @Expose
    private String uSERFULLNAME;
    @SerializedName("USER_BIRTHDAY")
    @Expose
    private String uSERBIRTHDAY;

    @SerializedName("USER_SEX")
    @Expose
    private String userSex ;

    @SerializedName("USER_AGE")
    @Expose
    private String userAge ;


    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getuSERFULLNAME() {
        return uSERFULLNAME;
    }

    public void setuSERFULLNAME(String uSERFULLNAME) {
        this.uSERFULLNAME = uSERFULLNAME;
    }

    public String getuSERBIRTHDAY() {
        return uSERBIRTHDAY;
    }

    public void setuSERBIRTHDAY(String uSERBIRTHDAY) {
        this.uSERBIRTHDAY = uSERBIRTHDAY;
    }

    public String getUSERSN() {
        return uSERSN;
    }

    public void setUSERSN(String uSERSN) {
        this.uSERSN = uSERSN;
    }

    public String getUSERID() {
        return uSERID;
    }

    public void setUSERID(String uSERID) {
        this.uSERID = uSERID;
    }

    public String getWORKERNAME() {
        return wORKERNAME;
    }

    public void setWORKERNAME(String wORKERNAME) {
        this.wORKERNAME = wORKERNAME;
    }

    public String getSOCIALSTATUS() {
        return sOCIALSTATUS;
    }

    public void setSOCIALSTATUS(String sOCIALSTATUS) {
        this.sOCIALSTATUS = sOCIALSTATUS;
    }

    public String getBRITHDATE() {
        return bRITHDATE;
    }

    public void setBRITHDATE(String bRITHDATE) {
        this.bRITHDATE = bRITHDATE;
    }

    public String getUSERMOBILE1() {
        return uSERMOBILE1;
    }

    public void setUSERMOBILE1(String uSERMOBILE1) {
        this.uSERMOBILE1 = uSERMOBILE1;
    }

    public String getUSERBUILDING() {
        return uSERBUILDING;
    }

    public void setUSERBUILDING(String uSERBUILDING) {
        this.uSERBUILDING = uSERBUILDING;
    }

}
