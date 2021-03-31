package com.sh.wm.ministry.featuers.userfile.travel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserTravelDataModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_travel_data")
    @Expose
    private List<UserTravelData> userTravelData = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserTravelData> getUserTravelData() {
        return userTravelData;
    }

    public void setUserTravelData(List<UserTravelData> userTravelData) {
        this.userTravelData = userTravelData;
    }
}
