package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLegalEntityData;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseData;

import java.util.List;

@Dao
public interface AddLicenseDao {

    @Query("SELECT * FROM AddLicenseData where type like :type")
    List<AddLicenseData> getAddLicenseData(String type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLicenseModel(AddLicenseData model);


    @Delete
    int deleteLicense(AddLicenseData model);


    @Query("SELECT COUNT(*) FROM AddLicenseData ")
    int getDataCount();
}
