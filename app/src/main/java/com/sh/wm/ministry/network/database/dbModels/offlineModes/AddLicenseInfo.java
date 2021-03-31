package com.sh.wm.ministry.network.database.dbModels.offlineModes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AddLicenseInfo")
public class AddLicenseInfo {
    private String action, constructId,
            isPolicy, isReg,
            isLicensed, insuranceEndDate,
            capital, type,
            insuranceId, insuranceNum,
            isInternalSys, isCertificateYN,
            workHoursSum, workTime,
            incomeId;
    @NonNull
    @PrimaryKey
    private String visitId;
    private String submitAction;

    public AddLicenseInfo(String action, String constructId, String isPolicy, String isReg, String isLicensed, String insuranceEndDate, String capital, String type, String insuranceId, String insuranceNum, String isInternalSys, String isCertificateYN, String workHoursSum, String workTime, String incomeId, @NonNull String visitId, String submitAction) {
        this.action = action;
        this.constructId = constructId;
        this.isPolicy = isPolicy;
        this.isReg = isReg;
        this.isLicensed = isLicensed;
        this.insuranceEndDate = insuranceEndDate;
        this.capital = capital;
        this.type = type;
        this.insuranceId = insuranceId;
        this.insuranceNum = insuranceNum;
        this.isInternalSys = isInternalSys;
        this.isCertificateYN = isCertificateYN;
        this.workHoursSum = workHoursSum;
        this.workTime = workTime;
        this.incomeId = incomeId;
        this.visitId = visitId;
        this.submitAction = submitAction;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getIsPolicy() {
        return isPolicy;
    }

    public void setIsPolicy(String isPolicy) {
        this.isPolicy = isPolicy;
    }

    public String getIsReg() {
        return isReg;
    }

    public void setIsReg(String isReg) {
        this.isReg = isReg;
    }

    public String getIsLicensed() {
        return isLicensed;
    }

    public void setIsLicensed(String isLicensed) {
        this.isLicensed = isLicensed;
    }

    public String getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(String insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(String insuranceNum) {
        this.insuranceNum = insuranceNum;
    }

    public String getIsInternalSys() {
        return isInternalSys;
    }

    public void setIsInternalSys(String isInternalSys) {
        this.isInternalSys = isInternalSys;
    }

    public String getIsCertificateYN() {
        return isCertificateYN;
    }

    public void setIsCertificateYN(String isCertificateYN) {
        this.isCertificateYN = isCertificateYN;
    }

    public String getWorkHoursSum() {
        return workHoursSum;
    }

    public void setWorkHoursSum(String workHoursSum) {
        this.workHoursSum = workHoursSum;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(String incomeId) {
        this.incomeId = incomeId;
    }

    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getSubmitAction() {
        return submitAction;
    }

    public void setSubmitAction(String submitAction) {
        this.submitAction = submitAction;
    }
}
