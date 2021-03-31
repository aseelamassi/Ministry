package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLegalEntityData;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseInfo;

import java.util.List;

@Dao
public interface AddLicenseInfoDao {

    @Query("SELECT * FROM AddLicenseInfo")
    List<AddLicenseInfo> getAddLicenseInfo();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLicenseInfo (AddLicenseInfo model);


    @Delete
    int deleteLicenseInfo(AddLicenseInfo model);


    @Query("SELECT COUNT(*) FROM AddLicenseInfo ")
    int getDataCount();
}
