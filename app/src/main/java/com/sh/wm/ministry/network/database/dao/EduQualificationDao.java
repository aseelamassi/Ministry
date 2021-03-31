package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;

import java.util.List;

@Dao
public interface EduQualificationDao {
    @Query("SELECT * FROM eduQualification_table where eDUTYPEID = :eduTypeId ")
    LiveData<List<EduQualification>> getAllEduQualification(String eduTypeId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addEduQualification(EduQualification eduQualification);

    @Query("SELECT COUNT(*) FROM eduQualification_table")
    int getDataCount();
}
