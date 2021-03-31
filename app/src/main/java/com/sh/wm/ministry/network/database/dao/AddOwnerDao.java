package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddOwnerModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;

import java.util.List;

@Dao
public interface AddOwnerDao {

    @Query("SELECT * FROM AddOwnerModel")
    List<AddOwnerModel> getAddOwner();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAddOwnerModel(AddOwnerModel model);


    @Delete
    int deleteOwnerModel(AddOwnerModel model);


    @Query("SELECT COUNT(*) FROM AddOwnerModel ")
    int getDataCount();
}
