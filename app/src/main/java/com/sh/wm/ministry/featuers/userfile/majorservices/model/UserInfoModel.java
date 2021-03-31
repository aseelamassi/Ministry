
package com.sh.wm.ministry.featuers.userfile.majorservices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContact;

public class UserInfoModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_work_info")
    @Expose
    private UserWorkInfo userWorkInfo;

    @SerializedName("user_contact_info")
    @Expose
    private UserWorkContact userWorkContact ;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserWorkInfo getUserWorkInfo() {
        return userWorkInfo;
    }

    public void setUserWorkInfo(UserWorkInfo userWorkInfo) {
        this.userWorkInfo = userWorkInfo;
    }

    public UserWorkContact getUserWorkContact() {
        return userWorkContact;
    }

    public void setUserWorkContact(UserWorkContact userWorkContact) {
        this.userWorkContact = userWorkContact;
    }
}
