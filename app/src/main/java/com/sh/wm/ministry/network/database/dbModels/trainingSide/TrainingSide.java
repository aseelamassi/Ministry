package com.sh.wm.ministry.network.database.dbModels.trainingSide;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName =  "training_side_table")
public class TrainingSide {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String tRAININGPROGRAMID;
    @SerializedName("text")
    @Expose
    private String tRAININGPROGRAMARNAME;


    public String getTRAININGPROGRAMID() {
        return tRAININGPROGRAMID;
    }

    public void setTRAININGPROGRAMID(String tRAININGPROGRAMID) {
        this.tRAININGPROGRAMID = tRAININGPROGRAMID;
    }

    public String getTRAININGPROGRAMARNAME() {
        return tRAININGPROGRAMARNAME;
    }

    public void setTRAININGPROGRAMARNAME(String tRAININGPROGRAMARNAME) {
        this.tRAININGPROGRAMARNAME = tRAININGPROGRAMARNAME;
    }

}
