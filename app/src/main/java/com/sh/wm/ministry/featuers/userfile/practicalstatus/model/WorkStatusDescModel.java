package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkStatusDescModel {

    @SerializedName("status")
    @Expose
    private int status ;


    @SerializedName("work_status_des")
    @Expose
    private List<WorkStatusDesc> workStatusDescList ;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<WorkStatusDesc> getWorkStatusDescList() {
        return workStatusDescList;
    }

    public void setWorkStatusDescList(List<WorkStatusDesc> workStatusDescList) {
        this.workStatusDescList = workStatusDescList;
    }
}
