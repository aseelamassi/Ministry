package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionVisitResult;


import java.util.List;

@Dao
public interface InspectionVisitResultDao {

    @Query("SELECT * FROM InspectionVisitResult")
    List<InspectionVisitResult> getResults();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResult(InspectionVisitResult model);


    @Delete
    int deleteResult(InspectionVisitResult model);


    @Query("SELECT COUNT(*) FROM InspectionVisitResult ")
    int getDataCount();
}
