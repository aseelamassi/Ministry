package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRevisit;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionVisitResult;

import java.util.List;

@Dao
public interface InspectionRevisitDao {

    @Query("SELECT * FROM InspectionRevisit")
    List<InspectionRevisit> getRevisits();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRevisit(InspectionRevisit model);


    @Delete
    int deleteRevisit(InspectionRevisit model);


    @Query("SELECT COUNT(*) FROM InspectionRevisit ")
    int getDataCount();
}
