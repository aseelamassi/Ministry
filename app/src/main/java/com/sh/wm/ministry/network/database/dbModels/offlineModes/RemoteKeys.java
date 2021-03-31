package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RemoteKeys")
public class RemoteKeys {

    @NonNull
    @PrimaryKey
    private String visitId;
    private  String  nextKeys;

    public RemoteKeys(String visitId, String nextKeys) {
        this.visitId = visitId;
        this.nextKeys = nextKeys;
    }


    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }



    public String getNextKeys() {
        return nextKeys;
    }

    public void setNextKeys(String nextKeys) {
        this.nextKeys = nextKeys;
    }
}
