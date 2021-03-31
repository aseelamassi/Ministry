package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLegalEntityData;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddOwnerModel;

import java.util.List;

@Dao
public interface AddLegalDataDao {

    @Query("SELECT * FROM AddLegalEntityData")
    List<AddLegalEntityData> getAddLegalData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLegalModel(AddLegalEntityData model);


    @Delete
    int deleteLegalData(AddLegalEntityData model);


    @Query("SELECT COUNT(*) FROM AddLegalEntityData ")
    int getDataCount();
}
