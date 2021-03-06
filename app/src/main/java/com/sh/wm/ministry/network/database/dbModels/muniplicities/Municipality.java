package com.sh.wm.ministry.network.database.dbModels.muniplicities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "municipalities_table")
public class Municipality {

    @PrimaryKey
    @NonNull
    @SerializedName("MUNICIPALITY_ID")
    @Expose
    private String mUNICIPALITYID;
    @SerializedName("MUNICIPALITY_NAME_AR")
    @Expose
    private String mUNICIPALITYNAMEAR;


    @SerializedName("DIRECTOR_ID")
    @Expose
    private String directorId;


    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }




    public String getMUNICIPALITYID() {
        return mUNICIPALITYID;
    }

    public void setMUNICIPALITYID(String mUNICIPALITYID) {
        this.mUNICIPALITYID = mUNICIPALITYID;
    }

    public String getMUNICIPALITYNAMEAR() {
        return mUNICIPALITYNAMEAR;
    }

    public void setMUNICIPALITYNAMEAR(String mUNICIPALITYNAMEAR) {
        this.mUNICIPALITYNAMEAR = mUNICIPALITYNAMEAR;
    }


    @NonNull
    @Override
    public String toString() {
        return getMUNICIPALITYNAMEAR();
    }

}