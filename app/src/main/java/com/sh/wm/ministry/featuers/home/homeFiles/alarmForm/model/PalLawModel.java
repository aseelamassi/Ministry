package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PalLawModel {


    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("law_results")
    @Expose
    private List<PalLaw> palLaws = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PalLaw> getPalLaws() {
        return palLaws;
    }

    public void setPalLaws(List<PalLaw> palLaws) {
        this.palLaws = palLaws;
    }
}
