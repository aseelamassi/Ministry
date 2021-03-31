package com.sh.wm.ministry.featuers.userfile.userRealty.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserRealtyModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_realty")
    @Expose
    private List<UserRealty> userRealty = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserRealty> getUserRealty() {
        return userRealty;
    }

    public void setUserRealty(List<UserRealty> userRealty) {
        this.userRealty = userRealty;
    }
}

