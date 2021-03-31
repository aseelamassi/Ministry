package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import retrofit2.http.Field;

@Entity(tableName = "Recommendation")
public class InspectionRecommendationModel {

     String constructId ;
    String recommendationId , adptedId , actionId ,  machineName ,
     actionDate ,   userId;
    @NonNull
    @PrimaryKey
    String visitId;

    public InspectionRecommendationModel(String constructId, String recommendationId, String adptedId, String actionId, String machineName, String actionDate, String visitId, String userId) {
        this.constructId = constructId;
        this.recommendationId = recommendationId;
        this.adptedId = adptedId;
        this.actionId = actionId;
        this.machineName = machineName;
        this.actionDate = actionDate;
        this.visitId = visitId;
        this.userId = userId;
    }


    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getAdptedId() {
        return adptedId;
    }

    public void setAdptedId(String adptedId) {
        this.adptedId = adptedId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
