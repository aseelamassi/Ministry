package com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SupportingInstituteModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_benefiting_loans")
    @Expose
    private List<SupportingInstitute> userBenefitingLoans = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SupportingInstitute> getUserBenefitingLoans() {
        return userBenefitingLoans;
    }

    public void setUserBenefitingLoans(List<SupportingInstitute> userBenefitingLoans) {
        this.userBenefitingLoans = userBenefitingLoans;
    }
}
