package com.sh.wm.ministry.featuers.userfile.dependents.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DependentData {
    @SerializedName("USER_DEP_FULL_NAME")
    @Expose
    private String uSERDEPFULLNAME;
    @SerializedName("FNAME_ARB")
    @Expose
    private String fNAMEARB;
    @SerializedName("SNAME_ARB")
    @Expose
    private String sNAMEARB;
    @SerializedName("TNAME_ARB")
    @Expose
    private String tNAMEARB;
    @SerializedName("LNAME_ARB")
    @Expose
    private String lNAMEARB;
    @SerializedName("USER_DEP_BIRTHDATE")
    @Expose
    private String uSERDEPBIRTHDATE;
    @SerializedName("USER_DEP_DOCUMENT_ID")
    @Expose
    private String uSERDEPDOCUMENTID;
    @SerializedName("USER_DEP_WORK_ID")
    @Expose
    private String uSERDEPWORKID;
    @SerializedName("USER_DEP_RELATIONSHIP")
    @Expose
    private Integer uSERDEPRELATIONSHIP;
    @SerializedName("USER_GUID")
    @Expose
    private String uSERGUID;

    public String getUSERDEPFULLNAME() {
        return uSERDEPFULLNAME;
    }

    public void setUSERDEPFULLNAME(String uSERDEPFULLNAME) {
        this.uSERDEPFULLNAME = uSERDEPFULLNAME;
    }

    public String getFNAMEARB() {
        return fNAMEARB;
    }

    public void setFNAMEARB(String fNAMEARB) {
        this.fNAMEARB = fNAMEARB;
    }

    public String getSNAMEARB() {
        return sNAMEARB;
    }

    public void setSNAMEARB(String sNAMEARB) {
        this.sNAMEARB = sNAMEARB;
    }

    public String getTNAMEARB() {
        return tNAMEARB;
    }

    public void setTNAMEARB(String tNAMEARB) {
        this.tNAMEARB = tNAMEARB;
    }

    public String getLNAMEARB() {
        return lNAMEARB;
    }

    public void setLNAMEARB(String lNAMEARB) {
        this.lNAMEARB = lNAMEARB;
    }

    public String getUSERDEPBIRTHDATE() {
        return uSERDEPBIRTHDATE;
    }

    public void setUSERDEPBIRTHDATE(String uSERDEPBIRTHDATE) {
        this.uSERDEPBIRTHDATE = uSERDEPBIRTHDATE;
    }

    public String getUSERDEPDOCUMENTID() {
        return uSERDEPDOCUMENTID;
    }

    public void setUSERDEPDOCUMENTID(String uSERDEPDOCUMENTID) {
        this.uSERDEPDOCUMENTID = uSERDEPDOCUMENTID;
    }

    public String getUSERDEPWORKID() {
        return uSERDEPWORKID;
    }

    public void setUSERDEPWORKID(String uSERDEPWORKID) {
        this.uSERDEPWORKID = uSERDEPWORKID;
    }

    public Integer getUSERDEPRELATIONSHIP() {
        return uSERDEPRELATIONSHIP;
    }

    public void setUSERDEPRELATIONSHIP(Integer uSERDEPRELATIONSHIP) {
        this.uSERDEPRELATIONSHIP = uSERDEPRELATIONSHIP;
    }

    public String getUSERGUID() {
        return uSERGUID;
    }

    public void setUSERGUID(String uSERGUID) {
        this.uSERGUID = uSERGUID;
    }

}
