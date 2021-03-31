package com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EduQualificationDetailModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("edu_qualification_details")
    @Expose
    private List<EduQualificationDetail> eduQualificationDetails = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EduQualificationDetail> getEduQualificationDetails() {
        return eduQualificationDetails;
    }

    public void setEduQualificationDetails(List<EduQualificationDetail> eduQualificationDetails) {
        this.eduQualificationDetails = eduQualificationDetails;
    }

}
