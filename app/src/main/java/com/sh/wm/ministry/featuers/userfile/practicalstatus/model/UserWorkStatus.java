
package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserWorkStatus implements Serializable {
    @SerializedName("USER_WORK_ID")
    @Expose
    private String uSERWORKID;
    @SerializedName("USER_WORK_USER_ID")
    @Expose
    private String uSERWORKUSERID;
    @SerializedName("USER_WORK_STATUS_ID")
    @Expose
    private String uSERWORKSTATUSID;
    @SerializedName("USER_WORK_STATUS_DESC_ID")
    @Expose
    private String uSERWORKSTATUSDESCID;
    @SerializedName("USER_WORK_START_DATE")
    @Expose
    private String uSERWORKSTARTDATE;
    @SerializedName("USER_WORK_END_DATE")
    @Expose
    private String uSERWORKENDDATE;
    @SerializedName("USER_WORK_LEFT_REASON")
    @Expose
    private String uSERWORKLEFTREASON;
    @SerializedName("USER_WORK_JOB_TITLE_ID")
    @Expose
    private String uSERWORKJOBTITLEID;
    @SerializedName("USER_WORK_CONSTRUCTION_ID")
    @Expose
    private String uSERWORKCONSTRUCTIONID;
    @SerializedName("USER_WORK_SALARY")
    @Expose
    private String uSERWORKSALARY;
    @SerializedName("USER_WORK_CURRENCY_TYPE_ID")
    @Expose
    private String uSERWORKCURRENCYTYPEID;
    @SerializedName("USER_WORK_HOURS_TYPE_ID")
    @Expose
    private String uSERWORKHOURSTYPEID;
    @SerializedName("USER_WORK_NATURE_ID")
    @Expose
    private String uSERWORKNATUREID;
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
    private String uPDATEDATE;
    @SerializedName("IS_DELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("USER_WORK_DESC_DESC_ID")
    @Expose
    private String uSERWORKDESCDESCID;
    @SerializedName("USER_WORK_INSTITUTE_ID")
    @Expose
    private Object uSERWORKINSTITUTEID;
    @SerializedName("USER_WORK_ORIGIN")
    @Expose
    private String uSERWORKORIGIN;
    @SerializedName("WORK_STATUS")
    @Expose
    private String wORKSTATUS;
    @SerializedName("WORK_STATUS_DESC")
    @Expose
    private String wORKSTATUSDESC;
    @SerializedName("USER_WORK_JOB_TITLE")
    @Expose
    private String uSERWORKJOBTITLE;
    @SerializedName("USER_WORK_CURRENCY_TYPE")
    @Expose
    private String uSERWORKCURRENCYTYPE;
    @SerializedName("USER_WORK_HOURS_TYPE")
    @Expose
    private String uSERWORKHOURSTYPE;
    @SerializedName("USER_WORK_NATURE")
    @Expose
    private String uSERWORKNATURE;
    @SerializedName("WORK_STATUS_DESC_DESC")
    @Expose
    private String wORKSTATUSDESCDESC;
    @SerializedName("USER_WORK_START_DATE_OUT")
    @Expose
    private String uSERWORKSTARTDATEOUT;
    @SerializedName("USER_WORK_END_DATE_OUT")
    @Expose
    private String uSERWORKENDDATEOUT;
    @SerializedName("USER_WORK_CONSTRUCTION")
    @Expose
    private String uSERWORKCONSTRUCTION;

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

    public String getUSERWORKSTATUSID() {
        return uSERWORKSTATUSID;
    }

    public void setUSERWORKSTATUSID(String uSERWORKSTATUSID) {
        this.uSERWORKSTATUSID = uSERWORKSTATUSID;
    }

    public String getUSERWORKSTATUSDESCID() {
        return uSERWORKSTATUSDESCID;
    }

    public void setUSERWORKSTATUSDESCID(String uSERWORKSTATUSDESCID) {
        this.uSERWORKSTATUSDESCID = uSERWORKSTATUSDESCID;
    }

    public String getUSERWORKSTARTDATE() {
        return uSERWORKSTARTDATE;
    }

    public void setUSERWORKSTARTDATE(String uSERWORKSTARTDATE) {
        this.uSERWORKSTARTDATE = uSERWORKSTARTDATE;
    }

    public String getUSERWORKENDDATE() {
        return uSERWORKENDDATE;
    }

    public void setUSERWORKENDDATE(String uSERWORKENDDATE) {
        this.uSERWORKENDDATE = uSERWORKENDDATE;
    }

    public String getUSERWORKLEFTREASON() {
        return uSERWORKLEFTREASON;
    }

    public void setUSERWORKLEFTREASON(String uSERWORKLEFTREASON) {
        this.uSERWORKLEFTREASON = uSERWORKLEFTREASON;
    }

    public String getUSERWORKJOBTITLEID() {
        return uSERWORKJOBTITLEID;
    }

    public void setUSERWORKJOBTITLEID(String uSERWORKJOBTITLEID) {
        this.uSERWORKJOBTITLEID = uSERWORKJOBTITLEID;
    }

    public String getUSERWORKCONSTRUCTIONID() {
        return uSERWORKCONSTRUCTIONID;
    }

    public void setUSERWORKCONSTRUCTIONID(String uSERWORKCONSTRUCTIONID) {
        this.uSERWORKCONSTRUCTIONID = uSERWORKCONSTRUCTIONID;
    }

    public String getUSERWORKSALARY() {
        return uSERWORKSALARY;
    }

    public void setUSERWORKSALARY(String uSERWORKSALARY) {
        this.uSERWORKSALARY = uSERWORKSALARY;
    }

    public String getUSERWORKCURRENCYTYPEID() {
        return uSERWORKCURRENCYTYPEID;
    }

    public void setUSERWORKCURRENCYTYPEID(String uSERWORKCURRENCYTYPEID) {
        this.uSERWORKCURRENCYTYPEID = uSERWORKCURRENCYTYPEID;
    }

    public String getUSERWORKHOURSTYPEID() {
        return uSERWORKHOURSTYPEID;
    }

    public void setUSERWORKHOURSTYPEID(String uSERWORKHOURSTYPEID) {
        this.uSERWORKHOURSTYPEID = uSERWORKHOURSTYPEID;
    }

    public String getUSERWORKNATUREID() {
        return uSERWORKNATUREID;
    }

    public void setUSERWORKNATUREID(String uSERWORKNATUREID) {
        this.uSERWORKNATUREID = uSERWORKNATUREID;
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

    public String getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(String uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getUSERWORKDESCDESCID() {
        return uSERWORKDESCDESCID;
    }

    public void setUSERWORKDESCDESCID(String uSERWORKDESCDESCID) {
        this.uSERWORKDESCDESCID = uSERWORKDESCDESCID;
    }

    public Object getUSERWORKINSTITUTEID() {
        return uSERWORKINSTITUTEID;
    }

    public void setUSERWORKINSTITUTEID(Object uSERWORKINSTITUTEID) {
        this.uSERWORKINSTITUTEID = uSERWORKINSTITUTEID;
    }

    public String getUSERWORKORIGIN() {
        return uSERWORKORIGIN;
    }

    public void setUSERWORKORIGIN(String uSERWORKORIGIN) {
        this.uSERWORKORIGIN = uSERWORKORIGIN;
    }

    public String getWORKSTATUS() {
        return wORKSTATUS;
    }

    public void setWORKSTATUS(String wORKSTATUS) {
        this.wORKSTATUS = wORKSTATUS;
    }

    public String getWORKSTATUSDESC() {
        return wORKSTATUSDESC;
    }

    public void setWORKSTATUSDESC(String wORKSTATUSDESC) {
        this.wORKSTATUSDESC = wORKSTATUSDESC;
    }

    public String getUSERWORKJOBTITLE() {
        return uSERWORKJOBTITLE;
    }

    public void setUSERWORKJOBTITLE(String uSERWORKJOBTITLE) {
        this.uSERWORKJOBTITLE = uSERWORKJOBTITLE;
    }

    public String getUSERWORKCURRENCYTYPE() {
        return uSERWORKCURRENCYTYPE;
    }

    public void setUSERWORKCURRENCYTYPE(String uSERWORKCURRENCYTYPE) {
        this.uSERWORKCURRENCYTYPE = uSERWORKCURRENCYTYPE;
    }

    public String getUSERWORKHOURSTYPE() {
        return uSERWORKHOURSTYPE;
    }

    public void setUSERWORKHOURSTYPE(String uSERWORKHOURSTYPE) {
        this.uSERWORKHOURSTYPE = uSERWORKHOURSTYPE;
    }

    public String getUSERWORKNATURE() {
        return uSERWORKNATURE;
    }

    public void setUSERWORKNATURE(String uSERWORKNATURE) {
        this.uSERWORKNATURE = uSERWORKNATURE;
    }

    public String getWORKSTATUSDESCDESC() {
        return wORKSTATUSDESCDESC;
    }

    public void setWORKSTATUSDESCDESC(String wORKSTATUSDESCDESC) {
        this.wORKSTATUSDESCDESC = wORKSTATUSDESCDESC;
    }

    public String getUSERWORKSTARTDATEOUT() {
        return uSERWORKSTARTDATEOUT;
    }

    public void setUSERWORKSTARTDATEOUT(String uSERWORKSTARTDATEOUT) {
        this.uSERWORKSTARTDATEOUT = uSERWORKSTARTDATEOUT;
    }

    public String getUSERWORKENDDATEOUT() {
        return uSERWORKENDDATEOUT;
    }

    public void setUSERWORKENDDATEOUT(String uSERWORKENDDATEOUT) {
        this.uSERWORKENDDATEOUT = uSERWORKENDDATEOUT;
    }

    public String getUSERWORKCONSTRUCTION() {
        return uSERWORKCONSTRUCTION;
    }

    public void setUSERWORKCONSTRUCTION(String uSERWORKCONSTRUCTION) {
        this.uSERWORKCONSTRUCTION = uSERWORKCONSTRUCTION;
    }
}
