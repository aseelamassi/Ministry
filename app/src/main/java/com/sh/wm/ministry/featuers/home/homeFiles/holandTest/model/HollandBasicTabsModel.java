package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.UserInfo;

import java.io.Serializable;
import java.util.List;

public class HollandBasicTabsModel implements Serializable {

    @SerializedName("holland_test")
    @Expose
    private HollandTest hollandTest = null;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;
    @SerializedName("has_uncompleted_test")
    @Expose
    private Boolean hasUncompletedTest;

    public HollandTest getHollandTest() {
        return hollandTest;
    }

    public void setHollandTest(HollandTest hollandTest) {
        this.hollandTest = hollandTest;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Boolean getHasUncompletedTest() {
        return hasUncompletedTest;
    }

    public void setHasUncompletedTest(Boolean hasUncompletedTest) {
        this.hasUncompletedTest = hasUncompletedTest;
    }
}
