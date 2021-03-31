package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("constructs")
    @Expose
    private List<Construct> constructs = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Construct> getConstructs() {
        return constructs;
    }

    public void setConstructs(List<Construct> constructs) {
        this.constructs = constructs;
    }


}

