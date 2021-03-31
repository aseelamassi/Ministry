package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerHealthModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;

import java.util.List;

@Dao
public interface  AddWorkerHealthDao {
    //AddWorkerHealthModel

    @Query("SELECT * FROM AddWorkerHealth")
    List<AddWorkerHealthModel> getAddWorkerHealth();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAddWorkerHealthModel(AddWorkerHealthModel model);


    @Delete
    int deleteAddWorkerHealthModel(AddWorkerHealthModel model);


    @Query("SELECT COUNT(*) FROM AddWorkerHealth ")
    int getDataCount();
}
