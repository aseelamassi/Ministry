
package com.sh.wm.ministry.network.database.dbModels.trainingprograms;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName =  "training_programs_table")
public class TrainingProgram {

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
