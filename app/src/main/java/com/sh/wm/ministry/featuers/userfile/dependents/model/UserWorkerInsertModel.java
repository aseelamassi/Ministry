package com.sh.wm.ministry.featuers.userfile.dependents.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWorkerInsertModel {

    @SerializedName("message_text")
    @Expose
    private String messageText;
    @SerializedName("status")
    @Expose
    private int status;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @SerializedName("accepted")
    @Expose
    private boolean accepted;


    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}