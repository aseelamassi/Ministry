package com.sh.wm.ministry.network.database.dbModels.eduQualification;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "eduQualification_table")
public class EduQualification {
   @PrimaryKey
   @NotNull
   @SerializedName("QUALIFICATION_ID")
    @Expose
   public String qUALIFICATIONID;
    @SerializedName("QUALIFICATION_NAME")
    @Expose
    public String qUALIFICATIONNAME;
    @SerializedName("QUALIFICATION_DESC")
    @Expose
    public String qUALIFICATIONDESC;
    @SerializedName("EDU_TYPE_ID")
    @Expose
    public String eDUTYPEID;
    @SerializedName("FLAG_QUAL_TYPE")
    @Expose
    public String fLAGQUALTYPE;


    public String getqUALIFICATIONID() {
        return qUALIFICATIONID;
    }

    public void setqUALIFICATIONID(String qUALIFICATIONID) {
        this.qUALIFICATIONID = qUALIFICATIONID;
    }

    public String getqUALIFICATIONNAME() {
        return qUALIFICATIONNAME;
    }

    public void setqUALIFICATIONNAME(String qUALIFICATIONNAME) {
        this.qUALIFICATIONNAME = qUALIFICATIONNAME;
    }

    public String getqUALIFICATIONDESC() {
        return qUALIFICATIONDESC;
    }

    public void setqUALIFICATIONDESC(String qUALIFICATIONDESC) {
        this.qUALIFICATIONDESC = qUALIFICATIONDESC;
    }

    public String geteDUTYPEID() {
        return eDUTYPEID;
    }

    public void seteDUTYPEID(String eDUTYPEID) {
        this.eDUTYPEID = eDUTYPEID;
    }

    public String getfLAGQUALTYPE() {
        return fLAGQUALTYPE;
    }

    public void setfLAGQUALTYPE(String fLAGQUALTYPE) {
        this.fLAGQUALTYPE = fLAGQUALTYPE;
    }

    @NonNull
    @Override
    public String toString() {
        return getqUALIFICATIONNAME();
    }
}
