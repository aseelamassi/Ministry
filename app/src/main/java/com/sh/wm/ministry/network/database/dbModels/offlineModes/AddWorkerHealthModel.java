package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import retrofit2.http.Field;

@Entity(tableName =  "AddWorkerHealth")
public class AddWorkerHealthModel {

    private String userId ,userHealthId,
    details,  disabilityId,
     disabilityPlace,  disabilitySize,
    reason;

    @NonNull
    @PrimaryKey
    private String userSn ;


    public AddWorkerHealthModel(String userId, String userHealthId, String details, String disabilityId, String disabilityPlace, String disabilitySize, String reason, @NonNull String userSn) {
        this.userId = userId;
        this.userHealthId = userHealthId;
        this.details = details;
        this.disabilityId = disabilityId;
        this.disabilityPlace = disabilityPlace;
        this.disabilitySize = disabilitySize;
        this.reason = reason;
        this.userSn = userSn;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHealthId() {
        return userHealthId;
    }

    public void setUserHealthId(String userHealthId) {
        this.userHealthId = userHealthId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDisabilityId() {
        return disabilityId;
    }

    public void setDisabilityId(String disabilityId) {
        this.disabilityId = disabilityId;
    }

    public String getDisabilityPlace() {
        return disabilityPlace;
    }

    public void setDisabilityPlace(String disabilityPlace) {
        this.disabilityPlace = disabilityPlace;
    }

    public String getDisabilitySize() {
        return disabilitySize;
    }

    public void setDisabilitySize(String disabilitySize) {
        this.disabilitySize = disabilitySize;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @NonNull
    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(@NonNull String userSn) {
        this.userSn = userSn;
    }
}
