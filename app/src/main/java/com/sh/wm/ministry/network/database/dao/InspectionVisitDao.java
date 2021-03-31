package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisitModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface InspectionVisitDao {

    @Query("SELECT * FROM InspectionVisit ")
   Single<List<InspectionVisit >>getInspectionVisit();


    @Query("SELECT * FROM InspectionVisit where cONSTRUCTID like :constructId ")
    Single<List<InspectionVisit >>getInspectionVisitByConstructId(String constructId);
//
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<InspectionVisit> inspectionVisitList);
//

    @Query("SELECT COUNT(*) FROM InspectionVisit")
    int getDataCount();
//    @Query("Delete from InspectionVisit")
//    int clearData();




}
