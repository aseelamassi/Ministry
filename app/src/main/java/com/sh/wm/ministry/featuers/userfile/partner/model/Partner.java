package com.sh.wm.ministry.featuers.userfile.partner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Partner {

    @SerializedName("USER_ID")
    @Expose
    private String uSERID;
    @SerializedName("USER_SN")
    @Expose
    private String uSERSN;
    @SerializedName("USER_F_NAME_AR")
    @Expose
    private String uSERFNAMEAR;
    @SerializedName("USER_S_NAME_AR")
    @Expose
    private String uSERSNAMEAR;
    @SerializedName("USER_T_NAME_AR")
    @Expose
    private String uSERTNAMEAR;
    @SerializedName("USER_L_NAME_AR")
    @Expose
    private String uSERLNAMEAR;
    @SerializedName("USER_FULL_NAME_EN")
    @Expose
    private Object uSERFULLNAMEEN;
    @SerializedName("USER_REG_STATUS_ID")
    @Expose
    private String uSERREGSTATUSID;
    @SerializedName("USER_SEX_ID")
    @Expose
    private String uSERSEXID;
    @SerializedName("USER_SOCIAL_STATUS_ID")
    @Expose
    private String uSERSOCIALSTATUSID;
    @SerializedName("USER_BRITH_DATE")
    @Expose
    private String uSERBRITHDATE;
    @SerializedName("USER_DEATH_DATE")
    @Expose
    private Object uSERDEATHDATE;
    @SerializedName("USER_BIRTH_PLACE_ID")
    @Expose
    private String uSERBIRTHPLACEID;
    @SerializedName("USER_NATIONALITY_ID")
    @Expose
    private Object uSERNATIONALITYID;
    @SerializedName("USER_NATIONALITY_OTHER_ID")
    @Expose
    private String uSERNATIONALITYOTHERID;
    @SerializedName("USER_RELIGION_ID")
    @Expose
    private Object uSERRELIGIONID;
    @SerializedName("USER_CHIDED_NUM")
    @Expose
    private String uSERCHIDEDNUM;
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
    @SerializedName("IS_ACTIVE")
    @Expose
    private String iSACTIVE;
    @SerializedName("USER_DOCS_TYPE_ID")
    @Expose
    private String uSERDOCSTYPEID;
    @SerializedName("USER_MOTHER_NAME")
    @Expose
    private String uSERMOTHERNAME;
    @SerializedName("USER_ROLE")
    @Expose
    private String uSERROLE;
    @SerializedName("USER_IMAGE")
    @Expose
    private Object uSERIMAGE;
    @SerializedName("USER_INSERT_TYPE")
    @Expose
    private String uSERINSERTTYPE;
    @SerializedName("USER_DIRECTORATE")
    @Expose
    private String uSERDIRECTORATE;
    @SerializedName("USER_GUID")
    @Expose
    private String uSERGUID;
    @SerializedName("USER_IMG")
    @Expose
    private Object uSERIMG;
    @SerializedName("USER_GOV_LAST_UPATE_DATE")
    @Expose
    private String uSERGOVLASTUPATEDATE;
    @SerializedName("BRITH_DATE")
    @Expose
    private String bRITHDATE;
    @SerializedName("DEATH_DATE")
    @Expose
    private Object dEATHDATE;
    @SerializedName("USER_AGE")
    @Expose
    private String uSERAGE;
    @SerializedName("WORKER_NAME")
    @Expose
    private String wORKERNAME;
    @SerializedName("BIRTH_PLACE")
    @Expose
    private String bIRTHPLACE;
    @SerializedName("NATIONALITY_NAME")
    @Expose
    private Object nATIONALITYNAME;
    @SerializedName("SOCIAL_STATUS")
    @Expose
    private String sOCIALSTATUS;
    @SerializedName("USER_SEX")
    @Expose
    private String uSERSEX;
    @SerializedName("USER_REG_STATUS")
    @Expose
    private String uSERREGSTATUS;
    @SerializedName("DIRECTORATE_NAME")
    @Expose
    private String dIRECTORATENAME;

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

    public String getUSERFNAMEAR() {
        return uSERFNAMEAR;
    }

    public void setUSERFNAMEAR(String uSERFNAMEAR) {
        this.uSERFNAMEAR = uSERFNAMEAR;
    }

    public String getUSERSNAMEAR() {
        return uSERSNAMEAR;
    }

    public void setUSERSNAMEAR(String uSERSNAMEAR) {
        this.uSERSNAMEAR = uSERSNAMEAR;
    }

    public String getUSERTNAMEAR() {
        return uSERTNAMEAR;
    }

    public void setUSERTNAMEAR(String uSERTNAMEAR) {
        this.uSERTNAMEAR = uSERTNAMEAR;
    }

    public String getUSERLNAMEAR() {
        return uSERLNAMEAR;
    }

    public void setUSERLNAMEAR(String uSERLNAMEAR) {
        this.uSERLNAMEAR = uSERLNAMEAR;
    }

    public Object getUSERFULLNAMEEN() {
        return uSERFULLNAMEEN;
    }

    public void setUSERFULLNAMEEN(Object uSERFULLNAMEEN) {
        this.uSERFULLNAMEEN = uSERFULLNAMEEN;
    }

    public String getUSERREGSTATUSID() {
        return uSERREGSTATUSID;
    }

    public void setUSERREGSTATUSID(String uSERREGSTATUSID) {
        this.uSERREGSTATUSID = uSERREGSTATUSID;
    }

    public String getUSERSEXID() {
        return uSERSEXID;
    }

    public void setUSERSEXID(String uSERSEXID) {
        this.uSERSEXID = uSERSEXID;
    }

    public String getUSERSOCIALSTATUSID() {
        return uSERSOCIALSTATUSID;
    }

    public void setUSERSOCIALSTATUSID(String uSERSOCIALSTATUSID) {
        this.uSERSOCIALSTATUSID = uSERSOCIALSTATUSID;
    }

    public String getUSERBRITHDATE() {
        return uSERBRITHDATE;
    }

    public void setUSERBRITHDATE(String uSERBRITHDATE) {
        this.uSERBRITHDATE = uSERBRITHDATE;
    }

    public Object getUSERDEATHDATE() {
        return uSERDEATHDATE;
    }

    public void setUSERDEATHDATE(Object uSERDEATHDATE) {
        this.uSERDEATHDATE = uSERDEATHDATE;
    }

    public String getUSERBIRTHPLACEID() {
        return uSERBIRTHPLACEID;
    }

    public void setUSERBIRTHPLACEID(String uSERBIRTHPLACEID) {
        this.uSERBIRTHPLACEID = uSERBIRTHPLACEID;
    }

    public Object getUSERNATIONALITYID() {
        return uSERNATIONALITYID;
    }

    public void setUSERNATIONALITYID(Object uSERNATIONALITYID) {
        this.uSERNATIONALITYID = uSERNATIONALITYID;
    }

    public String getUSERNATIONALITYOTHERID() {
        return uSERNATIONALITYOTHERID;
    }

    public void setUSERNATIONALITYOTHERID(String uSERNATIONALITYOTHERID) {
        this.uSERNATIONALITYOTHERID = uSERNATIONALITYOTHERID;
    }

    public Object getUSERRELIGIONID() {
        return uSERRELIGIONID;
    }

    public void setUSERRELIGIONID(Object uSERRELIGIONID) {
        this.uSERRELIGIONID = uSERRELIGIONID;
    }

    public String getUSERCHIDEDNUM() {
        return uSERCHIDEDNUM;
    }

    public void setUSERCHIDEDNUM(String uSERCHIDEDNUM) {
        this.uSERCHIDEDNUM = uSERCHIDEDNUM;
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

    public String getISACTIVE() {
        return iSACTIVE;
    }

    public void setISACTIVE(String iSACTIVE) {
        this.iSACTIVE = iSACTIVE;
    }

    public String getUSERDOCSTYPEID() {
        return uSERDOCSTYPEID;
    }

    public void setUSERDOCSTYPEID(String uSERDOCSTYPEID) {
        this.uSERDOCSTYPEID = uSERDOCSTYPEID;
    }

    public String getUSERMOTHERNAME() {
        return uSERMOTHERNAME;
    }

    public void setUSERMOTHERNAME(String uSERMOTHERNAME) {
        this.uSERMOTHERNAME = uSERMOTHERNAME;
    }

    public String getUSERROLE() {
        return uSERROLE;
    }

    public void setUSERROLE(String uSERROLE) {
        this.uSERROLE = uSERROLE;
    }

    public Object getUSERIMAGE() {
        return uSERIMAGE;
    }

    public void setUSERIMAGE(Object uSERIMAGE) {
        this.uSERIMAGE = uSERIMAGE;
    }

    public String getUSERINSERTTYPE() {
        return uSERINSERTTYPE;
    }

    public void setUSERINSERTTYPE(String uSERINSERTTYPE) {
        this.uSERINSERTTYPE = uSERINSERTTYPE;
    }

    public String getUSERDIRECTORATE() {
        return uSERDIRECTORATE;
    }

    public void setUSERDIRECTORATE(String uSERDIRECTORATE) {
        this.uSERDIRECTORATE = uSERDIRECTORATE;
    }

    public String getUSERGUID() {
        return uSERGUID;
    }

    public void setUSERGUID(String uSERGUID) {
        this.uSERGUID = uSERGUID;
    }

    public Object getUSERIMG() {
        return uSERIMG;
    }

    public void setUSERIMG(Object uSERIMG) {
        this.uSERIMG = uSERIMG;
    }

    public String getUSERGOVLASTUPATEDATE() {
        return uSERGOVLASTUPATEDATE;
    }

    public void setUSERGOVLASTUPATEDATE(String uSERGOVLASTUPATEDATE) {
        this.uSERGOVLASTUPATEDATE = uSERGOVLASTUPATEDATE;
    }

    public String getBRITHDATE() {
        return bRITHDATE;
    }

    public void setBRITHDATE(String bRITHDATE) {
        this.bRITHDATE = bRITHDATE;
    }

    public Object getDEATHDATE() {
        return dEATHDATE;
    }

    public void setDEATHDATE(Object dEATHDATE) {
        this.dEATHDATE = dEATHDATE;
    }

    public String getUSERAGE() {
        return uSERAGE;
    }

    public void setUSERAGE(String uSERAGE) {
        this.uSERAGE = uSERAGE;
    }

    public String getWORKERNAME() {
        return wORKERNAME;
    }

    public void setWORKERNAME(String wORKERNAME) {
        this.wORKERNAME = wORKERNAME;
    }

    public String getBIRTHPLACE() {
        return bIRTHPLACE;
    }

    public void setBIRTHPLACE(String bIRTHPLACE) {
        this.bIRTHPLACE = bIRTHPLACE;
    }

    public Object getNATIONALITYNAME() {
        return nATIONALITYNAME;
    }

    public void setNATIONALITYNAME(Object nATIONALITYNAME) {
        this.nATIONALITYNAME = nATIONALITYNAME;
    }

    public String getSOCIALSTATUS() {
        return sOCIALSTATUS;
    }

    public void setSOCIALSTATUS(String sOCIALSTATUS) {
        this.sOCIALSTATUS = sOCIALSTATUS;
    }

    public String getUSERSEX() {
        return uSERSEX;
    }

    public void setUSERSEX(String uSERSEX) {
        this.uSERSEX = uSERSEX;
    }

    public String getUSERREGSTATUS() {
        return uSERREGSTATUS;
    }

    public void setUSERREGSTATUS(String uSERREGSTATUS) {
        this.uSERREGSTATUS = uSERREGSTATUS;
    }

    public String getDIRECTORATENAME() {
        return dIRECTORATENAME;
    }

    public void setDIRECTORATENAME(String dIRECTORATENAME) {
        this.dIRECTORATENAME = dIRECTORATENAME;
    }

}
