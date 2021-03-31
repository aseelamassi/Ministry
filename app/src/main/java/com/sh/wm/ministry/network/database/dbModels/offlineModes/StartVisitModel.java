package com.sh.wm.ministry.network.database.dbModels.offlineModes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StartVisit")
public class StartVisitModel {

    @PrimaryKey
    @NonNull
    private String visit_id;

    private int isOnline ;


    public StartVisitModel(@NonNull String visit_id, int isOnline) {
        this.visit_id = visit_id;
        this.isOnline = isOnline;
    }

    public StartVisitModel() {
    }

    @NonNull
    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(@NonNull String visit_id) {
        this.visit_id = visit_id;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }
}
