package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import retrofit2.http.Field;

@Entity(tableName = "InspectionVisitResult")
public class InspectionVisitResult {


   private String constructId;
   private String actionId ;
   private String recommendationId ;
   private String placementId ;
   private String date ;
   private String reason ;
   private String machineName;
    @PrimaryKey
    @NonNull
   private String visitId;
   private String userId;


    public InspectionVisitResult(String constructId, String actionId, String recommendationId, String placementId, String date, String reason, String machineName, @NonNull String visitId, String userId) {
        this.constructId = constructId;
        this.actionId = actionId;
        this.recommendationId = recommendationId;
        this.placementId = placementId;
        this.date = date;
        this.reason = reason;
        this.machineName = machineName;
        this.visitId = visitId;
        this.userId = userId;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getPlacementId() {
        return placementId;
    }

    public void setPlacementId(String placementId) {
        this.placementId = placementId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
