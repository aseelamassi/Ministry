package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import retrofit2.http.Field;

@Entity(tableName = "AddSecondarySector")
public class AddSecondarySector {

    private String constructId;
    @NonNull
    @PrimaryKey
    private String sectorId ;
    private String sectorDescription;


    public AddSecondarySector(String constructId, @NonNull String sectorId, String sectorDescription) {
        this.constructId = constructId;
        this.sectorId = sectorId;
        this.sectorDescription = sectorDescription;
    }


    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    @NonNull
    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(@NonNull String sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorDescription() {
        return sectorDescription;
    }

    public void setSectorDescription(String sectorDescription) {
        this.sectorDescription = sectorDescription;
    }
}
