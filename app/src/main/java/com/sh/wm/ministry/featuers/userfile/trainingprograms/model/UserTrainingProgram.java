package com.sh.wm.ministry.featuers.userfile.trainingprograms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserTrainingProgram implements Serializable {

    @SerializedName("USER_TRAIN_PROG_USER_ID")
    @Expose
    private String uSERTRAINPROGUSERID;
    @SerializedName("USER_TRAIN_PROG_TRAINING_ID")
    @Expose
    private String uSERTRAINPROGTRAININGID;
    @SerializedName("USER_TRAIN_PROG_COURSE_TYPE")
    @Expose
    private String uSERTRAINPROGCOURSETYPE;
    @SerializedName("USER_TRAIN_PROG_TRAINING_HOURS")
    @Expose
    private String uSERTRAINPROGTRAININGHOURS;
    @SerializedName("USER_TRAIN_PROG_START_DATE")
    @Expose
    private String uSERTRAINPROGSTARTDATE;
    @SerializedName("USER_TRAIN_PROG_END_DATE")
    @Expose
    private String uSERTRAINPROGENDDATE;
    @SerializedName("USER_TRAIN_PROG_INSTITUTION_ID")
    @Expose
    private String uSERTRAINPROGINSTITUTIONID;
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
    @SerializedName("USER_TRAIN_PROG_NOTES")
    @Expose
    private String uSERTRAINPROGNOTES;
    @SerializedName("IS_ACTIVE")
    @Expose
    private Object iSACTIVE;
    @SerializedName("USER_TRAIN_PROG_ID")
    @Expose
    private String uSERTRAINPROGID;
    @SerializedName("USER_TRAIN_PROG_TRAIN_ENTITY")
    @Expose
    private String uSERTRAINPROGTRAINENTITY;
    @SerializedName("USER_TRAIN_PROG_ENTITY_ADDRESS")
    @Expose
    private String uSERTRAINPROGENTITYADDRESS;
    @SerializedName("USER_TRAIN_PROG_TEMP_WORK_ID")
    @Expose
    private String uSERTRAINPROGTEMPWORKID;
    @SerializedName("COURSE_TYPE")
    @Expose
    private String cOURSETYPE;
    @SerializedName("TRAIN_ENTITY")
    @Expose
    private String tRAINENTITY;
    @SerializedName("TRAIN_PROG_NAME")
    @Expose
    private String tRAINPROGNAME;
    @SerializedName("INSTITUTION_ID")
    @Expose
    private String iNSTITUTIONID;

    public String getUSERTRAINPROGUSERID() {
        return uSERTRAINPROGUSERID;
    }

    public void setUSERTRAINPROGUSERID(String uSERTRAINPROGUSERID) {
        this.uSERTRAINPROGUSERID = uSERTRAINPROGUSERID;
    }

    public String getUSERTRAINPROGTRAININGID() {
        return uSERTRAINPROGTRAININGID;
    }

    public void setUSERTRAINPROGTRAININGID(String uSERTRAINPROGTRAININGID) {
        this.uSERTRAINPROGTRAININGID = uSERTRAINPROGTRAININGID;
    }

    public String getUSERTRAINPROGCOURSETYPE() {
        return uSERTRAINPROGCOURSETYPE;
    }

    public void setUSERTRAINPROGCOURSETYPE(String uSERTRAINPROGCOURSETYPE) {
        this.uSERTRAINPROGCOURSETYPE = uSERTRAINPROGCOURSETYPE;
    }

    public String getUSERTRAINPROGTRAININGHOURS() {
        return uSERTRAINPROGTRAININGHOURS;
    }

    public void setUSERTRAINPROGTRAININGHOURS(String uSERTRAINPROGTRAININGHOURS) {
        this.uSERTRAINPROGTRAININGHOURS = uSERTRAINPROGTRAININGHOURS;
    }

    public String getUSERTRAINPROGSTARTDATE() {
        return uSERTRAINPROGSTARTDATE;
    }

    public void setUSERTRAINPROGSTARTDATE(String uSERTRAINPROGSTARTDATE) {
        this.uSERTRAINPROGSTARTDATE = uSERTRAINPROGSTARTDATE;
    }

    public String getUSERTRAINPROGENDDATE() {
        return uSERTRAINPROGENDDATE;
    }

    public void setUSERTRAINPROGENDDATE(String uSERTRAINPROGENDDATE) {
        this.uSERTRAINPROGENDDATE = uSERTRAINPROGENDDATE;
    }

    public String getUSERTRAINPROGINSTITUTIONID() {
        return uSERTRAINPROGINSTITUTIONID;
    }

    public void setUSERTRAINPROGINSTITUTIONID(String uSERTRAINPROGINSTITUTIONID) {
        this.uSERTRAINPROGINSTITUTIONID = uSERTRAINPROGINSTITUTIONID;
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

    public String getUSERTRAINPROGNOTES() {
        return uSERTRAINPROGNOTES;
    }

    public void setUSERTRAINPROGNOTES(String uSERTRAINPROGNOTES) {
        this.uSERTRAINPROGNOTES = uSERTRAINPROGNOTES;
    }

    public Object getISACTIVE() {
        return iSACTIVE;
    }

    public void setISACTIVE(Object iSACTIVE) {
        this.iSACTIVE = iSACTIVE;
    }

    public String getUSERTRAINPROGID() {
        return uSERTRAINPROGID;
    }

    public void setUSERTRAINPROGID(String uSERTRAINPROGID) {
        this.uSERTRAINPROGID = uSERTRAINPROGID;
    }

    public String getUSERTRAINPROGTRAINENTITY() {
        return uSERTRAINPROGTRAINENTITY;
    }

    public void setUSERTRAINPROGTRAINENTITY(String uSERTRAINPROGTRAINENTITY) {
        this.uSERTRAINPROGTRAINENTITY = uSERTRAINPROGTRAINENTITY;
    }

    public String getUSERTRAINPROGENTITYADDRESS() {
        return uSERTRAINPROGENTITYADDRESS;
    }

    public void setUSERTRAINPROGENTITYADDRESS(String uSERTRAINPROGENTITYADDRESS) {
        this.uSERTRAINPROGENTITYADDRESS = uSERTRAINPROGENTITYADDRESS;
    }

    public String getUSERTRAINPROGTEMPWORKID() {
        return uSERTRAINPROGTEMPWORKID;
    }

    public void setUSERTRAINPROGTEMPWORKID(String uSERTRAINPROGTEMPWORKID) {
        this.uSERTRAINPROGTEMPWORKID = uSERTRAINPROGTEMPWORKID;
    }

    public String getCOURSETYPE() {
        return cOURSETYPE;
    }

    public void setCOURSETYPE(String cOURSETYPE) {
        this.cOURSETYPE = cOURSETYPE;
    }

    public String getTRAINENTITY() {
        return tRAINENTITY;
    }

    public void setTRAINENTITY(String tRAINENTITY) {
        this.tRAINENTITY = tRAINENTITY;
    }

    public String getTRAINPROGNAME() {
        return tRAINPROGNAME;
    }

    public void setTRAINPROGNAME(String tRAINPROGNAME) {
        this.tRAINPROGNAME = tRAINPROGNAME;
    }

    public String getINSTITUTIONID() {
        return iNSTITUTIONID;
    }

    public void setINSTITUTIONID(String iNSTITUTIONID) {
        this.iNSTITUTIONID = iNSTITUTIONID;
    }
}
