package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel;

import java.util.List;

@Dao
public interface StartVisitDao {
//0 is indicate false
    @Query("SELECT * FROM startvisit where isOnline = 0")
    List<StartVisitModel> getStartedVisits();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVisit(StartVisitModel model);


    @Delete
    int deleteVisit(StartVisitModel model);


    @Query("SELECT COUNT(*) FROM startvisit ")
    int getDataCount();

}
