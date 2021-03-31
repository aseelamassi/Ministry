package com.sh.wm.ministry.featuers.userfile.familyMember.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserFamilyModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_family")
    @Expose
    private List<UserFamily> userFamily = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserFamily> getUserFamily() {
        return userFamily;
    }

    public void setUserFamily(List<UserFamily> userFamily) {
        this.userFamily = userFamily;
    }
}
