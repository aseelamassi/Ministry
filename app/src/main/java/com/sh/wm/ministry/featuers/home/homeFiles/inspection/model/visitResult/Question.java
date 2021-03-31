package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.visitResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("PAL_LAW_ARTICAL_CODE")
    @Expose
    private String pALLAWARTICALCODE;

    public String getPALLAWARTICALCODE() {
        return pALLAWARTICALCODE;
    }

    public void setPALLAWARTICALCODE(String pALLAWARTICALCODE) {
        this.pALLAWARTICALCODE = pALLAWARTICALCODE;
    }
}
