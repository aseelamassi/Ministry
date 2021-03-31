package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AddLegalEntityData")
public class AddLegalEntityData {
    private String action;
    @NonNull
    @PrimaryKey
    private String constructId;

    private String bossIdentify, bossIdentify2,
            type, legalId, constructinType,
            ownerShipId, mainEconomicActivityId,
            mainDsec, sessionId,
            year, workStatusSecId,
            foundationNum, employeeNum,
            startWork, endWork,
            visitId, submitAction;

     public AddLegalEntityData(String action, @NonNull String constructId, String bossIdentify, String bossIdentify2, String type, String legalId, String constructinType, String ownerShipId, String mainEconomicActivityId, String mainDsec, String sessionId, String year, String workStatusSecId, String foundationNum, String employeeNum, String startWork, String endWork, String visitId, String submitAction) {
          this.action = action;
          this.constructId = constructId;
          this.bossIdentify = bossIdentify;
          this.bossIdentify2 = bossIdentify2;
          this.type = type;
          this.legalId = legalId;
          this.constructinType = constructinType;
          this.ownerShipId = ownerShipId;
          this.mainEconomicActivityId = mainEconomicActivityId;
          this.mainDsec = mainDsec;
          this.sessionId = sessionId;
          this.year = year;
          this.workStatusSecId = workStatusSecId;
          this.foundationNum = foundationNum;
          this.employeeNum = employeeNum;
          this.startWork = startWork;
          this.endWork = endWork;
          this.visitId = visitId;
          this.submitAction = submitAction;
     }


     public String getAction() {
          return action;
     }

     public void setAction(String action) {
          this.action = action;
     }

     @NonNull
     public String getConstructId() {
          return constructId;
     }

     public void setConstructId(@NonNull String constructId) {
          this.constructId = constructId;
     }

     public String getBossIdentify() {
          return bossIdentify;
     }

     public void setBossIdentify(String bossIdentify) {
          this.bossIdentify = bossIdentify;
     }

     public String getBossIdentify2() {
          return bossIdentify2;
     }

     public void setBossIdentify2(String bossIdentify2) {
          this.bossIdentify2 = bossIdentify2;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public String getLegalId() {
          return legalId;
     }

     public void setLegalId(String legalId) {
          this.legalId = legalId;
     }

     public String getConstructinType() {
          return constructinType;
     }

     public void setConstructinType(String constructinType) {
          this.constructinType = constructinType;
     }

     public String getOwnerShipId() {
          return ownerShipId;
     }

     public void setOwnerShipId(String ownerShipId) {
          this.ownerShipId = ownerShipId;
     }

     public String getMainEconomicActivityId() {
          return mainEconomicActivityId;
     }

     public void setMainEconomicActivityId(String mainEconomicActivityId) {
          this.mainEconomicActivityId = mainEconomicActivityId;
     }

     public String getMainDsec() {
          return mainDsec;
     }

     public void setMainDsec(String mainDsec) {
          this.mainDsec = mainDsec;
     }

     public String getSessionId() {
          return sessionId;
     }

     public void setSessionId(String sessionId) {
          this.sessionId = sessionId;
     }

     public String getYear() {
          return year;
     }

     public void setYear(String year) {
          this.year = year;
     }

     public String getWorkStatusSecId() {
          return workStatusSecId;
     }

     public void setWorkStatusSecId(String workStatusSecId) {
          this.workStatusSecId = workStatusSecId;
     }

     public String getFoundationNum() {
          return foundationNum;
     }

     public void setFoundationNum(String foundationNum) {
          this.foundationNum = foundationNum;
     }

     public String getEmployeeNum() {
          return employeeNum;
     }

     public void setEmployeeNum(String employeeNum) {
          this.employeeNum = employeeNum;
     }

     public String getStartWork() {
          return startWork;
     }

     public void setStartWork(String startWork) {
          this.startWork = startWork;
     }

     public String getEndWork() {
          return endWork;
     }

     public void setEndWork(String endWork) {
          this.endWork = endWork;
     }

     public String getVisitId() {
          return visitId;
     }

     public void setVisitId(String visitId) {
          this.visitId = visitId;
     }

     public String getSubmitAction() {
          return submitAction;
     }

     public void setSubmitAction(String submitAction) {
          this.submitAction = submitAction;
     }
}
