package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}


