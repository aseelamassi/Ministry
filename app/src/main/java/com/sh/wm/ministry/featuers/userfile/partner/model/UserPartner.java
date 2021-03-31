package com.sh.wm.ministry.featuers.userfile.partner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.UserEducationalStatus;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.UserWorkStatus;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;

import java.util.List;

public class UserPartner {

    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("partner_work_status")
    @Expose
    private List<UserWorkStatus> partnerWorkStatus = null;
    @SerializedName("partner_edu_status")
    @Expose
    private List<UserEducationalStatus> partnerEduStatus = null;

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<UserWorkStatus> getPartnerWorkStatus() {
        return partnerWorkStatus;
    }

    public void setPartnerWorkStatus(List<UserWorkStatus> partnerWorkStatus) {
        this.partnerWorkStatus = partnerWorkStatus;
    }

    public List<UserEducationalStatus> getPartnerEduStatus() {
        return partnerEduStatus;
    }

    public void setPartnerEduStatus(List<UserEducationalStatus> partnerEduStatus) {
        this.partnerEduStatus = partnerEduStatus;
    }
}
