package com.sh.wm.ministry.network.database.dbModels.offlineModes;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName =  "InspectionVisitRemoteKeys")
public class InspectionVisitRemoteKeys implements Serializable {

    @PrimaryKey
    String visitId ;

    int prevPage , nextPage ;

    public InspectionVisitRemoteKeys(String visitId, int prevPage, int nextPage) {
        this.visitId = visitId;
        this.prevPage = prevPage;
        this.nextPage = nextPage;
    }
}
