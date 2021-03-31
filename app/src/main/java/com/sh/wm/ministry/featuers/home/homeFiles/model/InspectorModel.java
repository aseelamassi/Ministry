package com.sh.wm.ministry.featuers.home.homeFiles.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InspectorModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("inspectors")
    @Expose
    private List<Inspector> inspectors = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Inspector> getInspectors() {
        return inspectors;
    }

    public void setInspectors(List<Inspector> inspectors) {
        this.inspectors = inspectors;
    }


}
