package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructionOwnerModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("construct_owner")
    @Expose
    private List<ConstructionOwner> constructOwner = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ConstructionOwner> getConstructOwner() {
        return constructOwner;
    }

    public void setConstructOwner(List<ConstructionOwner> constructOwner) {
        this.constructOwner = constructOwner;
    }
}
