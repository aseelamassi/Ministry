package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ConstructionBasicInfo")
public class ConstructionBasicInfo {

    private String action, constructId, addressId, constructionNumber, visitDate, nameUsing, nameOfficial, municipapiityId, regionId, streetId,
            streetDetails, buldingNo,
            addressDesc, xDirection, yDirections, telephone,
            mobile, fax,
            box, url,
            email, riskLevelId;

    @NonNull
    @PrimaryKey
    private String visitId;
    private String submitAction;

    public ConstructionBasicInfo(String action, String constructId, String addressId, String constructionNumber, String visitDate, String nameUsing, String nameOfficial, String municipapiityId, String regionId, String streetId, String streetDetails, String buldingNo, String addressDesc, String xDirection, String yDirections, String telephone, String mobile, String fax, String box, String url, String email, String riskLevelId, @NonNull String visitId, String submitAction) {
        this.action = action;
        this.constructId = constructId;
        this.addressId = addressId;
        this.constructionNumber = constructionNumber;
        this.visitDate = visitDate;
        this.nameUsing = nameUsing;
        this.nameOfficial = nameOfficial;
        this.municipapiityId = municipapiityId;
        this.regionId = regionId;
        this.streetId = streetId;
        this.streetDetails = streetDetails;
        this.buldingNo = buldingNo;
        this.addressDesc = addressDesc;
        this.xDirection = xDirection;
        this.yDirections = yDirections;
        this.telephone = telephone;
        this.mobile = mobile;
        this.fax = fax;
        this.box = box;
        this.url = url;
        this.email = email;
        this.riskLevelId = riskLevelId;
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getConstructionNumber() {
        return constructionNumber;
    }

    public void setConstructionNumber(String constructionNumber) {
        this.constructionNumber = constructionNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getNameUsing() {
        return nameUsing;
    }

    public void setNameUsing(String nameUsing) {
        this.nameUsing = nameUsing;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial = nameOfficial;
    }

    public String getMunicipapiityId() {
        return municipapiityId;
    }

    public void setMunicipapiityId(String municipapiityId) {
        this.municipapiityId = municipapiityId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getStreetDetails() {
        return streetDetails;
    }

    public void setStreetDetails(String streetDetails) {
        this.streetDetails = streetDetails;
    }

    public String getBuldingNo() {
        return buldingNo;
    }

    public void setBuldingNo(String buldingNo) {
        this.buldingNo = buldingNo;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getXDirection() {
        return xDirection;
    }

    public void setxDirection(String xDirection) {
        this.xDirection = xDirection;
    }

    public String getYDirections() {
        return yDirections;
    }

    public void setyDirections(String yDirections) {
        this.yDirections = yDirections;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRiskLevelId() {
        return riskLevelId;
    }

    public void setRiskLevelId(String riskLevelId) {
        this.riskLevelId = riskLevelId;
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
