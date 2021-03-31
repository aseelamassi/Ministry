package com.sh.wm.ministry.network.database.dbModels.eduQualification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EduQualificationModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("edu_qualifications")
    @Expose
    private List<EduQualification> eduQualifications = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EduQualification> getEduQualifications() {
        return eduQualifications;
    }

    public void setEduQualifications(List<EduQualification> eduQualifications) {
        this.eduQualifications = eduQualifications;
    }
}
