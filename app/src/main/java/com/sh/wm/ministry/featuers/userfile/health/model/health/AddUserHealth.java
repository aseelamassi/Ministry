package com.sh.wm.ministry.featuers.userfile.health.model.health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddUserHealth {
    @SerializedName("status")
    @Expose
    private String status ;

    @SerializedName("message_text")
    @Expose
    private String messageText;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
