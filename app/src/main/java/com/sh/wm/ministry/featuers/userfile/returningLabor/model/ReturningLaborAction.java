package com.sh.wm.ministry.featuers.userfile.returningLabor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReturningLaborAction {
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
