package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BossModel")
public class BossModel {

    private String constructId;
    private String constantInformative;
    private String userSn;
    private String informativeType;
    private String description;
    @NonNull
    @PrimaryKey
    private String visitId;
    private String type;
    private String submitAction;


    public BossModel(String constructId, String constantInformative, String userSn, String informativeType, String description, @NonNull String visitId, String type, String submitAction) {
        this.constructId = constructId;
        this.constantInformative = constantInformative;
        this.userSn = userSn;
        this.informativeType = informativeType;
        this.description = description;
        this.visitId = visitId;
        this.type = type;
        this.submitAction = submitAction;
    }


    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getConstantInformative() {
        return constantInformative;
    }

    public void setConstantInformative(String constantInformative) {
        this.constantInformative = constantInformative;
    }

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    public String getInformativeType() {
        return informativeType;
    }

    public void setInformativeType(String informativeType) {
        this.informativeType = informativeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubmitAction() {
        return submitAction;
    }

    public void setSubmitAction(String submitAction) {
        this.submitAction = submitAction;
    }
}

