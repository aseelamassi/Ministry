package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SimilarJob implements Serializable {

    @SerializedName("JOB_ID")
    @Expose
    private String jOBID;
    @SerializedName("JOB_AR_NAME")
    @Expose
    private String jOBARNAME;
    @SerializedName("JOB_EN_NAME")
    @Expose
    private String jOBENNAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("JOB_TRI_CODE")
    @Expose
    private String jOBTRICODE;
    @SerializedName("INSERT_USER")
    @Expose
    private String iNSERTUSER;
    @SerializedName("INSERT_DATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("UPDATE_USER")
    @Expose
    private String uPDATEUSER;
    @SerializedName("UPDATE_DATE")
    @Expose
    private Object uPDATEDATE;
    @SerializedName("JOB_ID_OLD")
    @Expose
    private Object jOBIDOLD;

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

    public String getJOBENNAME() {
        return jOBENNAME;
    }

    public void setJOBENNAME(String jOBENNAME) {
        this.jOBENNAME = jOBENNAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getJOBTRICODE() {
        return jOBTRICODE;
    }

    public void setJOBTRICODE(String jOBTRICODE) {
        this.jOBTRICODE = jOBTRICODE;
    }

    public String getINSERTUSER() {
        return iNSERTUSER;
    }

    public void setINSERTUSER(String iNSERTUSER) {
        this.iNSERTUSER = iNSERTUSER;
    }

    public String getINSERTDATE() {
        return iNSERTDATE;
    }

    public void setINSERTDATE(String iNSERTDATE) {
        this.iNSERTDATE = iNSERTDATE;
    }

    public String getUPDATEUSER() {
        return uPDATEUSER;
    }

    public void setUPDATEUSER(String uPDATEUSER) {
        this.uPDATEUSER = uPDATEUSER;
    }

    public Object getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(Object uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public Object getJOBIDOLD() {
        return jOBIDOLD;
    }

    public void setJOBIDOLD(Object jOBIDOLD) {
        this.jOBIDOLD = jOBIDOLD;
    }

}