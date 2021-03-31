package com.sh.wm.ministry.featuers.userfile.socialAid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAid;

import java.util.List;

public class SocialAidModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_social_aid")
    @Expose
    private List<SocialAid> userRealty = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SocialAid> getUserRealty() {
        return userRealty;
    }

    public void setUserRealty(List<SocialAid> userRealty) {
        this.userRealty = userRealty;
    }


}

