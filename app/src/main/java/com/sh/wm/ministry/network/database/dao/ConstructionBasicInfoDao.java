package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.BossModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.ConstructionBasicInfo;

import java.util.List;

@Dao
public interface ConstructionBasicInfoDao {


    @Query("SELECT * FROM ConstructionBasicInfo")
    List<ConstructionBasicInfo> getConstructionBasicInfo();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addConstructionBasicInfo(ConstructionBasicInfo model);


    @Delete
    int deleteConstructionBasicInfo(ConstructionBasicInfo model);


    @Query("SELECT COUNT(*) FROM ConstructionBasicInfo ")
    int getDataCount();



}
