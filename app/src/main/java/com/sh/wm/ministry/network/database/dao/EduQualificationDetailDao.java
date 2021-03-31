package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail;

import java.util.List;

@Dao
public interface EduQualificationDetailDao {
    @Query("SELECT * FROM eduQualificationDetails_table where qUALDETAILSEDUTYPEID = :eduTypeId")
    LiveData<List<EduQualificationDetail>> getAllEduQualification(String eduTypeId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addEduQualificationDetail(EduQualificationDetail eduQualificationDetail);

    @Query("SELECT COUNT(*) FROM eduQualificationDetails_table")
    int getDataCount();
}
