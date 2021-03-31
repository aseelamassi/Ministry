package com.sh.wm.ministry.featuers.userfile.familyMember.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserFamily {

    @SerializedName("USER_FAMILY_ID")
    @Expose
    private String uSERFAMILYID;
    @SerializedName("USER_FAMILY_USER_ID")
    @Expose
    private String uSERFAMILYUSERID;
    @SerializedName("RELATIVE_NAME")
    @Expose
    private String rELATIVENAME;
    @SerializedName("RELATIVE_SN")
    @Expose
    private String rELATIVESN;
    @SerializedName("RELATIVE_AGE")
    @Expose
    private String rELATIVEAGE;
    @SerializedName("RELATION_DESC")
    @Expose
    private String rELATIONDESC;
    @SerializedName("USER_WORK_ID")
    @Expose
    private String uSERWORKID;
    @SerializedName("USER_WORK_USER_ID")
    @Expose
    private String uSERWORKUSERID;
    @SerializedName("RELATIVE_STATUS_NAME")
    @Expose
    private String rELATIVESTATUSNAME;
    @SerializedName("RELATIVE_STATUS_DESC_NAME")
    @Expose
    private String rELATIVESTATUSDESCNAME;
    @SerializedName("RELATIVE_STATUS_DESC_DESC_NAME")
    @Expose
    private String rELATIVESTATUSDESCDESCNAME;
    @SerializedName("USER_FAMILY_RELATION_ID")
    @Expose
    private String uSERFAMILYRELATIONID;
    @SerializedName("REG_STATUS")
    @Expose
    private String rEGSTATUS;
    @SerializedName("SOCIAL_STATUS")
    @Expose
    private String sOCIALSTATUS;

    public String getUSERFAMILYID() {
        return uSERFAMILYID;
    }

    public void setUSERFAMILYID(String uSERFAMILYID) {
        this.uSERFAMILYID = uSERFAMILYID;
    }

    public String getUSERFAMILYUSERID() {
        return uSERFAMILYUSERID;
    }

    public void setUSERFAMILYUSERID(String uSERFAMILYUSERID) {
        this.uSERFAMILYUSERID = uSERFAMILYUSERID;
    }

    public String getRELATIVENAME() {
        return rELATIVENAME;
    }

    public void setRELATIVENAME(String rELATIVENAME) {
        this.rELATIVENAME = rELATIVENAME;
    }

    public String getRELATIVESN() {
        return rELATIVESN;
    }

    public void setRELATIVESN(String rELATIVESN) {
        this.rELATIVESN = rELATIVESN;
    }

    public String getRELATIVEAGE() {
        return rELATIVEAGE;
    }

    public void setRELATIVEAGE(String rELATIVEAGE) {
        this.rELATIVEAGE = rELATIVEAGE;
    }

    public String getRELATIONDESC() {
        return rELATIONDESC;
    }

    public void setRELATIONDESC(String rELATIONDESC) {
        this.rELATIONDESC = rELATIONDESC;
    }

    public String getUSERWORKID() {
        return uSERWORKID;
    }

    public void setUSERWORKID(String uSERWORKID) {
        this.uSERWORKID = uSERWORKID;
    }

    public String getUSERWORKUSERID() {
        return uSERWORKUSERID;
    }

    public void setUSERWORKUSERID(String uSERWORKUSERID) {
        this.uSERWORKUSERID = uSERWORKUSERID;
    }

    public String getRELATIVESTATUSNAME() {
        return rELATIVESTATUSNAME;
    }

    public void setRELATIVESTATUSNAME(String rELATIVESTATUSNAME) {
        this.rELATIVESTATUSNAME = rELATIVESTATUSNAME;
    }

    public String getRELATIVESTATUSDESCNAME() {
        return rELATIVESTATUSDESCNAME;
    }

    public void setRELATIVESTATUSDESCNAME(String rELATIVESTATUSDESCNAME) {
        this.rELATIVESTATUSDESCNAME = rELATIVESTATUSDESCNAME;
    }

    public String getRELATIVESTATUSDESCDESCNAME() {
        return rELATIVESTATUSDESCDESCNAME;
    }

    public void setRELATIVESTATUSDESCDESCNAME(String rELATIVESTATUSDESCDESCNAME) {
        this.rELATIVESTATUSDESCDESCNAME = rELATIVESTATUSDESCDESCNAME;
    }

    public String getUSERFAMILYRELATIONID() {
        return uSERFAMILYRELATIONID;
    }

    public void setUSERFAMILYRELATIONID(String uSERFAMILYRELATIONID) {
        this.uSERFAMILYRELATIONID = uSERFAMILYRELATIONID;
    }

    public String getREGSTATUS() {
        return rEGSTATUS;
    }

    public void setREGSTATUS(String rEGSTATUS) {
        this.rEGSTATUS = rEGSTATUS;
    }

    public String getSOCIALSTATUS() {
        return sOCIALSTATUS;
    }

    public void setSOCIALSTATUS(String sOCIALSTATUS) {
        this.sOCIALSTATUS = sOCIALSTATUS;
    }

}
