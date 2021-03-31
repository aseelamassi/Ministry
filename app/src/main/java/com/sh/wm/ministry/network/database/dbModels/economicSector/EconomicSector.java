package com.sh.wm.ministry.network.database.dbModels.economicSector;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "EconomicSector")
public class EconomicSector {

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


    @NonNull
    @Override
    public String toString() {
        return getText();
    }
}
