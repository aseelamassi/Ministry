package com.sh.wm.ministry.featuers.userfile.vechiels.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserVehicleModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_vehicle")
    @Expose
    private List<UserVehicle> userVehicle = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserVehicle> getUserVehicle() {
        return userVehicle;
    }

    public void setUserVehicle(List<UserVehicle> userVehicle) {
        this.userVehicle = userVehicle;
    }
}
