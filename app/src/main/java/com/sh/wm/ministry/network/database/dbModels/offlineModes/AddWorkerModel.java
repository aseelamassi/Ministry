package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AddWorker")
public class AddWorkerModel {
    private String constructId;

    @NonNull
    @PrimaryKey
    private String workerSn;
    private String perExam, primExam,
            haveCertificate, workTypeId,
            workTypeDescId, workTypeDescDescId,
            startDate, endDate,
            leaveDate, leaveReason,
            currencyId, salary,
            payId, jobId,
             skillLevelId,
            contractId, visitId;

    public AddWorkerModel(String constructId, @NonNull String workerSn, String perExam, String primExam, String haveCertificate, String workTypeId, String workTypeDescId, String workTypeDescDescId, String startDate, String endDate, String leaveDate, String leaveReason, String currencyId, String salary, String payId, String jobId, String skillLevelId, String contractId, String visitId) {
        this.constructId = constructId;
        this.workerSn = workerSn;
        this.perExam = perExam;
        this.primExam = primExam;
        this.haveCertificate = haveCertificate;
        this.workTypeId = workTypeId;
        this.workTypeDescId = workTypeDescId;
        this.workTypeDescDescId = workTypeDescDescId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveDate = leaveDate;
        this.leaveReason = leaveReason;
        this.currencyId = currencyId;
        this.salary = salary;
        this.payId = payId;
        this.jobId = jobId;

        this.skillLevelId = skillLevelId;
        this.contractId = contractId;
        this.visitId = visitId;
    }


    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    @NonNull
    public String getWorkerSn() {
        return workerSn;
    }

    public void setWorkerSn(@NonNull String workerSn) {
        this.workerSn = workerSn;
    }

    public String getPerExam() {
        return perExam;
    }

    public void setPerExam(String perExam) {
        this.perExam = perExam;
    }

    public String getPrimExam() {
        return primExam;
    }

    public void setPrimExam(String primExam) {
        this.primExam = primExam;
    }

    public String getHaveCertificate() {
        return haveCertificate;
    }

    public void setHaveCertificate(String haveCertificate) {
        this.haveCertificate = haveCertificate;
    }

    public String getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(String workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getWorkTypeDescId() {
        return workTypeDescId;
    }

    public void setWorkTypeDescId(String workTypeDescId) {
        this.workTypeDescId = workTypeDescId;
    }

    public String getWorkTypeDescDescId() {
        return workTypeDescDescId;
    }

    public void setWorkTypeDescDescId(String workTypeDescDescId) {
        this.workTypeDescDescId = workTypeDescDescId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }


    public String getSkillLevelId() {
        return skillLevelId;
    }

    public void setSkillLevelId(String skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
}
