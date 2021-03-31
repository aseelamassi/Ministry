package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkStatusDesc {

    @SerializedName("WORK_DESC_ID")
    @Expose
    private String workDescId ;

    @SerializedName("WORK_DESC_NAME")
    @Expose
    private String workDescName ;

    @SerializedName("WORK_STATUS_ID")
    @Expose
    private String workStatusName ;

    @SerializedName("ISDELETE")
    @Expose
    private String isDelete ;


    public String getWorkDescId() {
        return workDescId;
    }

    public void setWorkDescId(String workDescId) {
        this.workDescId = workDescId;
    }

    public String getWorkDescName() {
        return workDescName;
    }

    public void setWorkDescName(String workDescName) {
        this.workDescName = workDescName;
    }

    public String getWorkStatusName() {
        return workStatusName;
    }

    public void setWorkStatusName(String workStatusName) {
        this.workStatusName = workStatusName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @NonNull
    @Override
    public String toString() {
        return getWorkDescName();
    }
}
