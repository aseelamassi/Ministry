package com.sh.wm.ministry.featuers.userfile.partner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.userfile.partner.model.Partner;

import java.util.List;

public class PartnerModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_partners")
    @Expose
    private List<UserPartner> userPartners = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserPartner> getUserPartners() {
        return userPartners;
    }

    public void setUserPartners(List<UserPartner> userPartners) {
        this.userPartners = userPartners;
    }

}
