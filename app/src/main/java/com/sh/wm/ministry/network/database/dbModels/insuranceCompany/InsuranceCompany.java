package com.sh.wm.ministry.network.database.dbModels.insuranceCompany;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "InsuranceCompany")
public class InsuranceCompany {

    @NonNull
    @PrimaryKey
    @SerializedName("POLICY_CD")
    @Expose
    private String pOLICYCD;
    @SerializedName("POLICY_DESC")
    @Expose
    private String pOLICYDESC;
    @SerializedName("FLAG")
    @Expose
    private Object fLAG;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getPOLICYCD() {
        return pOLICYCD;
    }

    public void setPOLICYCD(String pOLICYCD) {
        this.pOLICYCD = pOLICYCD;
    }

    public String getPOLICYDESC() {
        return pOLICYDESC;
    }

    public void setPOLICYDESC(String pOLICYDESC) {
        this.pOLICYDESC = pOLICYDESC;
    }

    public Object getFLAG() {
        return fLAG;
    }

    public void setFLAG(Object fLAG) {
        this.fLAG = fLAG;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }


    @NonNull
    @Override
    public String toString() {
        return getPOLICYDESC();
    }
}