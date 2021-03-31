package com.sh.wm.ministry.featuers.userfile.returningLabor.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ReturningLaborModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_returning_labor")
    @Expose
    private List<ReturningLabor> userReturningLabor = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ReturningLabor> getUserReturningLabor() {
        return userReturningLabor;
    }

    public void setUserReturningLabor(List<ReturningLabor> userReturningLabor) {
        this.userReturningLabor = userReturningLabor;
    }
}
