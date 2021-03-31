package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructRegisterInfoModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("construct_register_info")
    @Expose
    private List<ConstructRegisterInfo> constructRegisterInfo = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ConstructRegisterInfo> getConstructRegisterInfo() {
        return constructRegisterInfo;
    }

    public void setConstructRegisterInfo(List<ConstructRegisterInfo> constructRegisterInfo) {
        this.constructRegisterInfo = constructRegisterInfo;
    }
}
