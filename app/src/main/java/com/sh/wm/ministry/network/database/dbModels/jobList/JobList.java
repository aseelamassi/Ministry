package com.sh.wm.ministry.network.database.dbModels.jobList;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "job_lists_table")
public class JobList {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private  String Id ;

    @SerializedName("text")
    @Expose
    private  String text ;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
