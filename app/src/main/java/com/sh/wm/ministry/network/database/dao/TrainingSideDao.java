package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;

import java.util.List;

@Dao
public interface TrainingSideDao {

    @Query("SELECT * FROM training_side_table where tRAININGPROGRAMARNAME LIKE :keyword ")
    LiveData<List<TrainingSide>> getAllTrainingSide(String keyword);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrainingSide(TrainingSide trainingSide);

    @Query("SELECT COUNT(*) FROM training_side_table")
    int getDataCount();
}
