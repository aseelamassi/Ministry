package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AddOwnerModel")
public class AddOwnerModel {

    private String constructId;
    @NonNull
    @PrimaryKey
    private String userSn;
    private String userId, startDate,
            visitId, type;

    public AddOwnerModel(String constructId, String userSn, String userId, String startDate, String visitId, String type) {
        this.constructId = constructId;
        this.userSn = userSn;
        this.userId = userId;
        this.startDate = startDate;
        this.visitId = visitId;
        this.type = type;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
