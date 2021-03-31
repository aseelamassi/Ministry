package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.ConstructLicenceInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructLicenceInfoModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("construct_licence_info")
    @Expose
    private List<ConstructLicenceInfo> constructLicenceInfo = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ConstructLicenceInfo> getConstructLicenceInfo() {
        return constructLicenceInfo;
    }

    public void setConstructLicenceInfo(List<ConstructLicenceInfo> constructLicenceInfo) {
        this.constructLicenceInfo = constructLicenceInfo;
    }

}
