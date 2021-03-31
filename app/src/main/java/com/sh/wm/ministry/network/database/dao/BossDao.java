package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.BossModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.QuestionsAnswer;

import java.util.List;

@Dao
public interface BossDao {

    @Query("SELECT * FROM BossModel")
    List<BossModel> getBossModel();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addBossModel(BossModel model);


    @Delete
    int deleteBossModel(BossModel model);


    @Query("SELECT COUNT(*) FROM BossModel ")
    int getDataCount();

}
