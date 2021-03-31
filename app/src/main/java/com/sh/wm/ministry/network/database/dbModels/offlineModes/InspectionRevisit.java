package com.sh.wm.ministry.network.database.dbModels.offlineModes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import retrofit2.http.Field;

@Entity(tableName =  "InspectionRevisit")
public class InspectionRevisit {
    String constructId, violationRemoval ,
    actionId , recommendationId ,
      placmentId , machineName ,
     reason ,  date
     ;

    @NonNull
    @PrimaryKey
    String visitId;

    public InspectionRevisit(String constructId, String violationRemoval, String actionId, String recommendationId, String placmentId, String machineName, String reason, String date, String visitId) {
        this.constructId = constructId;
        this.violationRemoval = violationRemoval;
        this.actionId = actionId;
        this.recommendationId = recommendationId;
        this.placmentId = placmentId;
        this.machineName = machineName;
        this.reason = reason;
        this.date = date;
        this.visitId = visitId;
    }


    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getViolationRemoval() {
        return violationRemoval;
    }

    public void setViolationRemoval(String violationRemoval) {
        this.violationRemoval = violationRemoval;
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

    public String getPlacmentId() {
        return placmentId;
    }

    public void setPlacmentId(String placmentId) {
        this.placmentId = placmentId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }
}
