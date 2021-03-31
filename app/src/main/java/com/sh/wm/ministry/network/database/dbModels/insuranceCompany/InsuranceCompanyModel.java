package com.sh.wm.ministry.network.database.dbModels.insuranceCompany;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class InsuranceCompanyModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("insurance_companies")
    @Expose
    private List<InsuranceCompany> insuranceCompanies = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<InsuranceCompany> getInsuranceCompanies() {
        return insuranceCompanies;
    }

    public void setInsuranceCompanies(List<InsuranceCompany> insuranceCompanies) {
        this.insuranceCompanies = insuranceCompanies;
    }
}
