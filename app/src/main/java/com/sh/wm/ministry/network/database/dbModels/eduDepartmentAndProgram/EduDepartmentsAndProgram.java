package com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EduDepartmentsAndProgram {

    @SerializedName("DEP_CD")
    @Expose
    private String dEPCD;
    @SerializedName("DEP_DESC")
    @Expose
    private String dEPDESC;

    public String getDEPCD() {
        return dEPCD;
    }

    public void setDEPCD(String dEPCD) {
        this.dEPCD = dEPCD;
    }

    public String getDEPDESC() {
        return dEPDESC;
    }

    public void setDEPDESC(String dEPDESC) {
        this.dEPDESC = dEPDESC;
    }

    public EduDepartmentsAndProgram(String dEPCD, String dEPDESC) {
        this.dEPCD = dEPCD;
        this.dEPDESC = dEPDESC;
    }

    @NonNull
    @Override
    public String toString() {
        return getDEPDESC();
    }
}