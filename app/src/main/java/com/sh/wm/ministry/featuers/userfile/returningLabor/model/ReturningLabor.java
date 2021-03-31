package com.sh.wm.ministry.featuers.userfile.returningLabor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReturningLabor implements Serializable {

    @SerializedName("USER_RE_LABOR_ID")
    @Expose
    private String uSERRELABORID;
    @SerializedName("USER_RE_LABOR_USER_ID")
    @Expose
    private String uSERRELABORUSERID;
    @SerializedName("USER_RE_LABOR_COUNTRY_ID")
    @Expose
    private String uSERRELABORCOUNTRYID;
    @SerializedName("USER_RE_LABOR_START_DATE")
    @Expose
    private String uSERRELABORSTARTDATE;
    @SerializedName("USER_RE_LABOR_END_DATE")
    @Expose
    private String uSERRELABORENDDATE;
    @SerializedName("USER_RE_LABOR_LAST_JOB")
    @Expose
    private String uSERRELABORLASTJOB;
    @SerializedName("USER_RE_LABOR_SKILL_LEVEL")
    @Expose
    private String uSERRELABORSKILLLEVEL;
    @SerializedName("INSERT_USER_SN")
    @Expose
    private String iNSERTUSERSN;
    @SerializedName("INSERT_DATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("UPDATE_USER_SN")
    @Expose
    private String uPDATEUSERSN;
    @SerializedName("UPDATE_DATE")
    @Expose
    private Object uPDATEDATE;
    @SerializedName("IS_DELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("USER_RE_LABOR_REASON")
    @Expose
    private String uSERRELABORREASON;
    @SerializedName("COUNTRY_NAME")
    @Expose
    private String cOUNTRYNAME;
    @SerializedName("LAST_JOB")
    @Expose
    private String lASTJOB;
    @SerializedName("TIME_YEARS")
    @Expose
    private Integer tIMEYEARS;

    public String getUSERRELABORID() {
        return uSERRELABORID;
    }

    public void setUSERRELABORID(String uSERRELABORID) {
        this.uSERRELABORID = uSERRELABORID;
    }

    public String getUSERRELABORUSERID() {
        return uSERRELABORUSERID;
    }

    public void setUSERRELABORUSERID(String uSERRELABORUSERID) {
        this.uSERRELABORUSERID = uSERRELABORUSERID;
    }

    public String getUSERRELABORCOUNTRYID() {
        return uSERRELABORCOUNTRYID;
    }

    public void setUSERRELABORCOUNTRYID(String uSERRELABORCOUNTRYID) {
        this.uSERRELABORCOUNTRYID = uSERRELABORCOUNTRYID;
    }

    public String getUSERRELABORSTARTDATE() {
        return uSERRELABORSTARTDATE;
    }

    public void setUSERRELABORSTARTDATE(String uSERRELABORSTARTDATE) {
        this.uSERRELABORSTARTDATE = uSERRELABORSTARTDATE;
    }

    public String getUSERRELABORENDDATE() {
        return uSERRELABORENDDATE;
    }

    public void setUSERRELABORENDDATE(String uSERRELABORENDDATE) {
        this.uSERRELABORENDDATE = uSERRELABORENDDATE;
    }

    public String getUSERRELABORLASTJOB() {
        return uSERRELABORLASTJOB;
    }

    public void setUSERRELABORLASTJOB(String uSERRELABORLASTJOB) {
        this.uSERRELABORLASTJOB = uSERRELABORLASTJOB;
    }

    public String getUSERRELABORSKILLLEVEL() {
        return uSERRELABORSKILLLEVEL;
    }

    public void setUSERRELABORSKILLLEVEL(String uSERRELABORSKILLLEVEL) {
        this.uSERRELABORSKILLLEVEL = uSERRELABORSKILLLEVEL;
    }

    public String getINSERTUSERSN() {
        return iNSERTUSERSN;
    }

    public void setINSERTUSERSN(String iNSERTUSERSN) {
        this.iNSERTUSERSN = iNSERTUSERSN;
    }

    public String getINSERTDATE() {
        return iNSERTDATE;
    }

    public void setINSERTDATE(String iNSERTDATE) {
        this.iNSERTDATE = iNSERTDATE;
    }

    public String getUPDATEUSERSN() {
        return uPDATEUSERSN;
    }

    public void setUPDATEUSERSN(String uPDATEUSERSN) {
        this.uPDATEUSERSN = uPDATEUSERSN;
    }

    public Object getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(Object uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getUSERRELABORREASON() {
        return uSERRELABORREASON;
    }

    public void setUSERRELABORREASON(String uSERRELABORREASON) {
        this.uSERRELABORREASON = uSERRELABORREASON;
    }

    public String getCOUNTRYNAME() {
        return cOUNTRYNAME;
    }

    public void setCOUNTRYNAME(String cOUNTRYNAME) {
        this.cOUNTRYNAME = cOUNTRYNAME;
    }

    public String getLASTJOB() {
        return lASTJOB;
    }

    public void setLASTJOB(String lASTJOB) {
        this.lASTJOB = lASTJOB;
    }

    public Integer getTIMEYEARS() {
        return tIMEYEARS;
    }

    public void setTIMEYEARS(Integer tIMEYEARS) {
        this.tIMEYEARS = tIMEYEARS;
    }
}
