package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SkillsModel {

    @SerializedName("skills_1")
    @Expose
    private List<Activity> skills1 = null;
    @SerializedName("skills_2")
    @Expose
    private List<Activity> skills2 = null;
    @SerializedName("skills_3")
    @Expose
    private List<Activity> skills3 = null;
    @SerializedName("skills_4")
    @Expose
    private List<Activity> skills4 = null;
    @SerializedName("skills_5")
    @Expose
    private List<Activity> skills5 = null;
    @SerializedName("skills_6")
    @Expose
    private List<Activity> skills6 = null;

    public List<Activity> getSkills1() {
        return skills1;
    }

    public void setSkills1(List<Activity> skills1) {
        this.skills1 = skills1;
    }

    public List<Activity> getSkills2() {
        return skills2;
    }

    public void setSkills2(List<Activity> skills2) {
        this.skills2 = skills2;
    }

    public List<Activity> getSkills3() {
        return skills3;
    }

    public void setSkills3(List<Activity> skills3) {
        this.skills3 = skills3;
    }

    public List<Activity> getSkills4() {
        return skills4;
    }

    public void setSkills4(List<Activity> skills4) {
        this.skills4 = skills4;
    }

    public List<Activity> getSkills5() {
        return skills5;
    }

    public void setSkills5(List<Activity> skills5) {
        this.skills5 = skills5;
    }

    public List<Activity> getSkills6() {
        return skills6;
    }

    public void setSkills6(List<Activity> skills6) {
        this.skills6 = skills6;
    }

}
