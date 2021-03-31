package com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;


@Entity(tableName = "eduQualificationDetails_table")
public class EduQualificationDetail {

    @PrimaryKey
    @NotNull
    @SerializedName("QUAL_DETAILS_ID")
    @Expose
    public String qUALDETAILSID;
    @SerializedName("QUAL_DETAILS_NAME")
    @Expose
    public String qUALDETAILSNAME;
    @SerializedName("QUAL_DETAILS_EDU_TYPE_ID")
    @Expose
    public String qUALDETAILSEDUTYPEID;
    @SerializedName("QUAL_ID")
    @Expose
    public String qUALID;

    public String getQUALDETAILSID() {
        return qUALDETAILSID;
    }

    public void setQUALDETAILSID(String qUALDETAILSID) {
        this.qUALDETAILSID = qUALDETAILSID;
    }

    public String getQUALDETAILSNAME() {
        return qUALDETAILSNAME;
    }

    public void setQUALDETAILSNAME(String qUALDETAILSNAME) {
        this.qUALDETAILSNAME = qUALDETAILSNAME;
    }

    public String getQUALDETAILSEDUTYPEID() {
        return qUALDETAILSEDUTYPEID;
    }

    public void setQUALDETAILSEDUTYPEID(String qUALDETAILSEDUTYPEID) {
        this.qUALDETAILSEDUTYPEID = qUALDETAILSEDUTYPEID;
    }

    public String getQUALID() {
        return qUALID;
    }

    public void setQUALID(String qUALID) {
        this.qUALID = qUALID;
    }


    @NonNull
    @Override
    public String toString() {
        return getQUALDETAILSNAME();
    }
}
