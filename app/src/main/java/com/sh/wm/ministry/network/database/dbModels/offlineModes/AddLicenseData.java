package com.sh.wm.ministry.network.database.dbModels.offlineModes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName =  "AddLicenseData")
public class AddLicenseData {

    private String constructId ;

    @NonNull
    @PrimaryKey
    private String licenseId;

    private String licenseNumber ;

    private String visitId ;

    private String type;


    public AddLicenseData(String constructId, @NonNull String licenseId, String licenseNumber, String visitId , String type) {
        this.constructId = constructId;
        this.licenseId = licenseId;
        this.licenseNumber = licenseNumber;
        this.visitId = visitId;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    @NonNull
    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(@NonNull String licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
}
