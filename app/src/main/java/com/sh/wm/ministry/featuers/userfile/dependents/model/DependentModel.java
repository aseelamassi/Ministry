package com.sh.wm.ministry.featuers.userfile.dependents.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DependentModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message_text")
    @Expose
    private String messageText;
    @SerializedName("dependent_data")
    @Expose
    private List<DependentData> dependentData = null;
    @SerializedName("accepted")
    @Expose
    private Boolean accepted;


    @SerializedName("msg")
    @Expose
    private   String msg ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public List<DependentData> getDependentData() {
        return dependentData;
    }

    public void setDependentData(List<DependentData> dependentData) {
        this.dependentData = dependentData;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

}
