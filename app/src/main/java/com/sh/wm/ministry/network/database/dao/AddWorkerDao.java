package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.BossModel;

import java.util.List;

@Dao
public interface AddWorkerDao {

    @Query("SELECT * FROM AddWorker")
    List<AddWorkerModel> getAddWorker();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAddWorkerModel(AddWorkerModel model);


    @Delete
    int deleteAddWorkerModel(AddWorkerModel model);


    @Query("SELECT COUNT(*) FROM AddWorker ")
    int getDataCount();
}
