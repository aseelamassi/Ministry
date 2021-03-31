
package com.sh.wm.ministry.network.database.dbModels.regions;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "regions_table")
public class Region {


    @SerializedName("REGION_ID")
    @Expose
    private String rEGIONID;
    @PrimaryKey
    @NonNull
    @SerializedName("REGION_NAME_AR")
    @Expose
    private String rEGIONNAMEAR;

    @SerializedName("DIRECTORATE_ID")
    @Expose
    private String directorateId;

    public String getDirectorateId() {
        return directorateId;
    }

    public void setDirectorateId(String directorateId) {
        this.directorateId = directorateId;
    }

    public String getREGIONID() {
        return rEGIONID;
    }

    public void setREGIONID(String rEGIONID) {
        this.rEGIONID = rEGIONID;
    }

    public String getREGIONNAMEAR() {
        return rEGIONNAMEAR;
    }

    public void setREGIONNAMEAR(String rEGIONNAMEAR) {
        this.rEGIONNAMEAR = rEGIONNAMEAR;
    }


    @NonNull
    @Override
    public String toString() {
        return getREGIONNAMEAR();
    }
}
