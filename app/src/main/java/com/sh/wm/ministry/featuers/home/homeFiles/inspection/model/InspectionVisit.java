package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "InspectionVisit")
public class InspectionVisit  implements Serializable {

    @SerializedName("COUNT_ROW")
    @Expose
    private String cOUNTROW;

    @NonNull
    @PrimaryKey
    @SerializedName("INSPECT_V_ID")
    @Expose

    private String iNSPECTVID;
    @SerializedName("CONSTRUCT_ID")
    @Expose
    private String cONSTRUCTID;
    @SerializedName("INSPECT_V_VISITOR_ID")
    @Expose
    private String iNSPECTVVISITORID;
    @SerializedName("INSPECT_V_VISITOR_ID_2")
    @Expose
    private String iNSPECTVVISITORID2;
    @SerializedName("INSPECT_V_VISITOR_ID_3")
    @Expose
    private String iNSPECTVVISITORID3;
    @SerializedName("INSPET_VISIT_STATUS")
    @Expose
    private String iNSPETVISITSTATUS;
    @SerializedName("VISIT_DATE")
    @Expose
    private String vISITDATE;
    @SerializedName("INSPECT_V_VISIT_EVALUAT_PER")
    @Expose
    private String iNSPECTVVISITEVALUATPER;
    @SerializedName("INSPECT_V_VISIT_CRITE_A_PER")
    @Expose
    private String iNSPECTVVISITCRITEAPER;
    @SerializedName("INSPECT_V_VISIT_CRITE_B_PER")
    @Expose
    private String iNSPECTVVISITCRITEBPER;
    @SerializedName("INSPECT_V_VISIT_CRITE_E_PER")
    @Expose
    private String iNSPECTVVISITCRITEEPER;
    @SerializedName("INSPECT_PLAN_ID")
    @Expose
    private String iNSPECTPLANID;
    @SerializedName("CONSTRUCT_GUID")
    @Expose
    private String cONSTRUCTGUID;
    @SerializedName("CONSTRUCT_NAME_USING")
    @Expose
    private String cONSTRUCTNAMEUSING;
    @SerializedName("CONSTRUCT_ADDRESS_ID")
    @Expose
    private String cONSTRUCTADDRESSID;
    @SerializedName("CONSTRUCT_NUM")
    @Expose
    private String cONSTRUCTNUM;
    @SerializedName("DIRECTORATE_NAME")
    @Expose
    private String dIRECTORATENAME;
    @SerializedName("INSPECTORE_NAME")
    @Expose
    private String iNSPECTORENAME;

    public String getCOUNTROW() {
        return cOUNTROW;
    }

    public void setCOUNTROW(String cOUNTROW) {
        this.cOUNTROW = cOUNTROW;
    }

    public String getINSPECTVID() {
        return iNSPECTVID;
    }

    public void setINSPECTVID(String iNSPECTVID) {
        this.iNSPECTVID = iNSPECTVID;
    }

    public String getCONSTRUCTID() {
        return cONSTRUCTID;
    }

    public void setCONSTRUCTID(String cONSTRUCTID) {
        this.cONSTRUCTID = cONSTRUCTID;
    }

    public String getINSPECTVVISITORID() {
        return iNSPECTVVISITORID;
    }

    public void setINSPECTVVISITORID(String iNSPECTVVISITORID) {
        this.iNSPECTVVISITORID = iNSPECTVVISITORID;
    }

    public String getINSPECTVVISITORID2() {
        return iNSPECTVVISITORID2;
    }

    public void setINSPECTVVISITORID2(String iNSPECTVVISITORID2) {
        this.iNSPECTVVISITORID2 = iNSPECTVVISITORID2;
    }

    public String getINSPECTVVISITORID3() {
        return iNSPECTVVISITORID3;
    }

    public void setINSPECTVVISITORID3(String iNSPECTVVISITORID3) {
        this.iNSPECTVVISITORID3 = iNSPECTVVISITORID3;
    }

    public String getINSPETVISITSTATUS() {
        return iNSPETVISITSTATUS;
    }

    public void setINSPETVISITSTATUS(String iNSPETVISITSTATUS) {
        this.iNSPETVISITSTATUS = iNSPETVISITSTATUS;
    }

    public String getVISITDATE() {
        return vISITDATE;
    }

    public void setVISITDATE(String vISITDATE) {
        this.vISITDATE = vISITDATE;
    }

    public String getINSPECTVVISITEVALUATPER() {
        return iNSPECTVVISITEVALUATPER;
    }

    public void setINSPECTVVISITEVALUATPER(String iNSPECTVVISITEVALUATPER) {
        this.iNSPECTVVISITEVALUATPER = iNSPECTVVISITEVALUATPER;
    }

    public String getINSPECTVVISITCRITEAPER() {
        return iNSPECTVVISITCRITEAPER;
    }

    public void setINSPECTVVISITCRITEAPER(String iNSPECTVVISITCRITEAPER) {
        this.iNSPECTVVISITCRITEAPER = iNSPECTVVISITCRITEAPER;
    }

    public String getINSPECTVVISITCRITEBPER() {
        return iNSPECTVVISITCRITEBPER;
    }

    public void setINSPECTVVISITCRITEBPER(String iNSPECTVVISITCRITEBPER) {
        this.iNSPECTVVISITCRITEBPER = iNSPECTVVISITCRITEBPER;
    }

    public String getINSPECTVVISITCRITEEPER() {
        return iNSPECTVVISITCRITEEPER;
    }

    public void setINSPECTVVISITCRITEEPER(String iNSPECTVVISITCRITEEPER) {
        this.iNSPECTVVISITCRITEEPER = iNSPECTVVISITCRITEEPER;
    }

    public String getINSPECTPLANID() {
        return iNSPECTPLANID;
    }

    public void setINSPECTPLANID(String iNSPECTPLANID) {
        this.iNSPECTPLANID = iNSPECTPLANID;
    }

    public String getCONSTRUCTGUID() {
        return cONSTRUCTGUID;
    }

    public void setCONSTRUCTGUID(String cONSTRUCTGUID) {
        this.cONSTRUCTGUID = cONSTRUCTGUID;
    }

    public String getCONSTRUCTNAMEUSING() {
        return cONSTRUCTNAMEUSING;
    }

    public void setCONSTRUCTNAMEUSING(String cONSTRUCTNAMEUSING) {
        this.cONSTRUCTNAMEUSING = cONSTRUCTNAMEUSING;
    }

    public String getCONSTRUCTADDRESSID() {
        return cONSTRUCTADDRESSID;
    }

    public void setCONSTRUCTADDRESSID(String cONSTRUCTADDRESSID) {
        this.cONSTRUCTADDRESSID = cONSTRUCTADDRESSID;
    }

    public String getCONSTRUCTNUM() {
        return cONSTRUCTNUM;
    }

    public void setCONSTRUCTNUM(String cONSTRUCTNUM) {
        this.cONSTRUCTNUM = cONSTRUCTNUM;
    }

    public String getDIRECTORATENAME() {
        return dIRECTORATENAME;
    }

    public void setDIRECTORATENAME(String dIRECTORATENAME) {
        this.dIRECTORATENAME = dIRECTORATENAME;
    }

    public String getINSPECTORENAME() {
        return iNSPECTORENAME;
    }

    public void setINSPECTORENAME(String iNSPECTORENAME) {
        this.iNSPECTORENAME = iNSPECTORENAME;
    }

}