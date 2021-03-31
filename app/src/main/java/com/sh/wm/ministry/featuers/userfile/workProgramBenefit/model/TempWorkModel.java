package com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TempWorkModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("temp_work")
    @Expose
    private List<TempWork> tempWork = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TempWork> getTempWork() {
        return tempWork;
    }

    public void setTempWork(List<TempWork> tempWork) {
        this.tempWork = tempWork;
    }
}
