package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector;


import java.util.List;

@Dao
public interface EconomicSectorDao {


    @Query("SELECT * FROM EconomicSector where text like :keyword ")
    LiveData<List<EconomicSector>> getEconomicSector(String keyword);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addEconomicSector(EconomicSector job);

    @Query("SELECT COUNT(*) FROM EconomicSector")
    int getDataCount();
}
