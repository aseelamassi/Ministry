package com.sh.wm.ministry.featuers.userfile.vechiels.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserVehicle {

    @SerializedName("USER_VEHICLE_ID")
    @Expose
    private String uSERVEHICLEID;
    @SerializedName("USER_VEHICLE_USER_SN")
    @Expose
    private String uSERVEHICLEUSERSN;
    @SerializedName("USER_VEHICLE_VEHICLE_NUMBER")
    @Expose
    private String uSERVEHICLEVEHICLENUMBER;
    @SerializedName("USER_VEHICLE_VEHICLE_TYPE")
    @Expose
    private String uSERVEHICLEVEHICLETYPE;
    @SerializedName("USER_VEHICLE_MANUFACTURE_COMP")
    @Expose
    private String uSERVEHICLEMANUFACTURECOMP;
    @SerializedName("USER_VEHICLE_PRODUCTION_YEAR")
    @Expose
    private String uSERVEHICLEPRODUCTIONYEAR;
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
    @SerializedName("IS_ACTIVE")
    @Expose
    private String iSACTIVE;

    public String getUSERVEHICLEID() {
        return uSERVEHICLEID;
    }

    public void setUSERVEHICLEID(String uSERVEHICLEID) {
        this.uSERVEHICLEID = uSERVEHICLEID;
    }

    public String getUSERVEHICLEUSERSN() {
        return uSERVEHICLEUSERSN;
    }

    public void setUSERVEHICLEUSERSN(String uSERVEHICLEUSERSN) {
        this.uSERVEHICLEUSERSN = uSERVEHICLEUSERSN;
    }

    public String getUSERVEHICLEVEHICLENUMBER() {
        return uSERVEHICLEVEHICLENUMBER;
    }

    public void setUSERVEHICLEVEHICLENUMBER(String uSERVEHICLEVEHICLENUMBER) {
        this.uSERVEHICLEVEHICLENUMBER = uSERVEHICLEVEHICLENUMBER;
    }

    public String getUSERVEHICLEVEHICLETYPE() {
        return uSERVEHICLEVEHICLETYPE;
    }

    public void setUSERVEHICLEVEHICLETYPE(String uSERVEHICLEVEHICLETYPE) {
        this.uSERVEHICLEVEHICLETYPE = uSERVEHICLEVEHICLETYPE;
    }

    public String getUSERVEHICLEMANUFACTURECOMP() {
        return uSERVEHICLEMANUFACTURECOMP;
    }

    public void setUSERVEHICLEMANUFACTURECOMP(String uSERVEHICLEMANUFACTURECOMP) {
        this.uSERVEHICLEMANUFACTURECOMP = uSERVEHICLEMANUFACTURECOMP;
    }

    public String getUSERVEHICLEPRODUCTIONYEAR() {
        return uSERVEHICLEPRODUCTIONYEAR;
    }

    public void setUSERVEHICLEPRODUCTIONYEAR(String uSERVEHICLEPRODUCTIONYEAR) {
        this.uSERVEHICLEPRODUCTIONYEAR = uSERVEHICLEPRODUCTIONYEAR;
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

    public String getISACTIVE() {
        return iSACTIVE;
    }

    public void setISACTIVE(String iSACTIVE) {
        this.iSACTIVE = iSACTIVE;
    }

}