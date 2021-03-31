package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.RemoteKeys;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface RemoteKeysDao {
//    @Query("SELECT * FROM RemoteKeys")
//    Single<RemoteKeys> getRemoteKeys();



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRemoteKeys(RemoteKeys model);


    @Query("Delete from RemoteKeys" )
    int deleteRemoteKeys();





}