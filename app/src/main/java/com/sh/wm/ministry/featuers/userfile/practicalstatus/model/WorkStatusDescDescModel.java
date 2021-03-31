package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkStatusDescDescModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("work_status_desc_desc")
    @Expose
    private List<WorkStatusDescDesc> workStatusDescDesc = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<WorkStatusDescDesc> getWorkStatusDescDesc() {
        return workStatusDescDesc;
    }

    public void setWorkStatusDescDesc(List<WorkStatusDescDesc> workStatusDescDesc) {
        this.workStatusDescDesc = workStatusDescDesc;
    }

}
