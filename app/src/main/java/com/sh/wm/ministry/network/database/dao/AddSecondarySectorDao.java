package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddSecondarySector;

import java.util.List;

@Dao
public interface AddSecondarySectorDao {
    @Query("SELECT * FROM AddSecondarySector")
    List<AddSecondarySector> getSecondarySector();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addSecondarySector(AddSecondarySector model);


    @Delete
    int deleteSecondarySector(AddSecondarySector model);


    @Query("SELECT COUNT(*) FROM AddSecondarySector ")
    int getDataCount();
}
