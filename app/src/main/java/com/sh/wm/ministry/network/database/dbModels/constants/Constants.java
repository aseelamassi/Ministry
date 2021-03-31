
package com.sh.wm.ministry.network.database.dbModels.constants;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "constants_table")
public class Constants {

    @PrimaryKey
    @NonNull
    @SerializedName("CONSTANT_ID")
    @Expose
    private String cONSTANTID;
    @SerializedName("CONSTANT_PARENT_ID")
    @Expose
    private String cONSTANTPARENTID;
    @SerializedName("CONSTANT_ARANAME")
    @Expose
    private String cONSTANTARANAME;
    @SerializedName("CONSTANT_ENGNAME")
    @Expose
    private String cONSTANTENGNAME;
    @SerializedName("INSERT_USER_SN")
    @Expose
    private String iNSERTUSERSN;
    @SerializedName("INSERT_DATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("UPDATE_USER_SN")
    @Expose
    private String uPDATEUSERSN;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("OLD_ID")
    @Expose
    private String oLDID;
    @SerializedName("CONSTANT_PARENT_TBL")
    @Expose
    private String cONSTANTPARENTTBL;

    public String getCONSTANTID() {
        return cONSTANTID;
    }

    public void setCONSTANTID(String cONSTANTID) {
        this.cONSTANTID = cONSTANTID;
    }

    public String getCONSTANTPARENTID() {
        return cONSTANTPARENTID;
    }

    public void setCONSTANTPARENTID(String cONSTANTPARENTID) {
        this.cONSTANTPARENTID = cONSTANTPARENTID;
    }

    public String getCONSTANTARANAME() {
        return cONSTANTARANAME;
    }

    public void setCONSTANTARANAME(String cONSTANTARANAME) {
        this.cONSTANTARANAME = cONSTANTARANAME;
    }

    public String getCONSTANTENGNAME() {
        return cONSTANTENGNAME;
    }

    public void setCONSTANTENGNAME(String cONSTANTENGNAME) {
        this.cONSTANTENGNAME = cONSTANTENGNAME;
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



    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getOLDID() {
        return oLDID;
    }

    public void setOLDID(String oLDID) {
        this.oLDID = oLDID;
    }

    public String getCONSTANTPARENTTBL() {
        return cONSTANTPARENTTBL;
    }

    public void setCONSTANTPARENTTBL(String cONSTANTPARENTTBL) {
        this.cONSTANTPARENTTBL = cONSTANTPARENTTBL;
    }

    @Override
    public String toString() {
        return cONSTANTARANAME;
    }
}
