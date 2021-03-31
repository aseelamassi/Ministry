package com.sh.wm.ministry.featuers.userfile.userRealty.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRealty {

    @SerializedName("USER_REALTY_TYPE_ID")
    @Expose
    private String uSERREALTYTYPEID;
    @SerializedName("USER_REALTY_USER_ID")
    @Expose
    private String uSERREALTYUSERID;
    @SerializedName("USER_REALTY_REALTY_NAME")
    @Expose
    private String uSERREALTYREALTYNAME;
    @SerializedName("USER_REALTY_REALTY_ADDRESS")
    @Expose
    private String uSERREALTYREALTYADDRESS;
    @SerializedName("USER_REALTY_CAPITAL_VALUE")
    @Expose
    private String uSERREALTYCAPITALVALUE;
    @SerializedName("INSERT_USER_SN")
    @Expose
    private String iNSERTUSERSN;
    @SerializedName("INSERT_DATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("UPDATE_USER_SN")
    @Expose
    private Object uPDATEUSERSN;
    @SerializedName("UPDATE_DATE")
    @Expose
    private Object uPDATEDATE;
    @SerializedName("IS_DELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("USER_REALTY_ID")
    @Expose
    private String uSERREALTYID;
    @SerializedName("IS_ACTIVE")
    @Expose
    private Object iSACTIVE;
    @SerializedName("USER_REALITY_NO")
    @Expose
    private String uSERREALITYNO;
    @SerializedName("REALTY_TYPE")
    @Expose
    private String rEALTYTYPE;

    public String getUSERREALTYTYPEID() {
        return uSERREALTYTYPEID;
    }

    public void setUSERREALTYTYPEID(String uSERREALTYTYPEID) {
        this.uSERREALTYTYPEID = uSERREALTYTYPEID;
    }

    public String getUSERREALTYUSERID() {
        return uSERREALTYUSERID;
    }

    public void setUSERREALTYUSERID(String uSERREALTYUSERID) {
        this.uSERREALTYUSERID = uSERREALTYUSERID;
    }

    public String getUSERREALTYREALTYNAME() {
        return uSERREALTYREALTYNAME;
    }

    public void setUSERREALTYREALTYNAME(String uSERREALTYREALTYNAME) {
        this.uSERREALTYREALTYNAME = uSERREALTYREALTYNAME;
    }

    public String getUSERREALTYREALTYADDRESS() {
        return uSERREALTYREALTYADDRESS;
    }

    public void setUSERREALTYREALTYADDRESS(String uSERREALTYREALTYADDRESS) {
        this.uSERREALTYREALTYADDRESS = uSERREALTYREALTYADDRESS;
    }

    public String getUSERREALTYCAPITALVALUE() {
        return uSERREALTYCAPITALVALUE;
    }

    public void setUSERREALTYCAPITALVALUE(String uSERREALTYCAPITALVALUE) {
        this.uSERREALTYCAPITALVALUE = uSERREALTYCAPITALVALUE;
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

    public Object getUPDATEUSERSN() {
        return uPDATEUSERSN;
    }

    public void setUPDATEUSERSN(Object uPDATEUSERSN) {
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

    public String getUSERREALTYID() {
        return uSERREALTYID;
    }

    public void setUSERREALTYID(String uSERREALTYID) {
        this.uSERREALTYID = uSERREALTYID;
    }

    public Object getISACTIVE() {
        return iSACTIVE;
    }

    public void setISACTIVE(Object iSACTIVE) {
        this.iSACTIVE = iSACTIVE;
    }

    public String getUSERREALITYNO() {
        return uSERREALITYNO;
    }

    public void setUSERREALITYNO(String uSERREALITYNO) {
        this.uSERREALITYNO = uSERREALITYNO;
    }

    public String getREALTYTYPE() {
        return rEALTYTYPE;
    }

    public void setREALTYTYPE(String rEALTYTYPE) {
        this.rEALTYTYPE = rEALTYTYPE;
    }}
