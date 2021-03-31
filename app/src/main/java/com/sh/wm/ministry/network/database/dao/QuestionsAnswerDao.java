package com.sh.wm.ministry.network.database.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRevisit;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.QuestionsAnswer;

import java.util.List;

@Dao
public interface QuestionsAnswerDao {
    @Query("SELECT * FROM QuestionsAnswer")
    List<QuestionsAnswer> getQuestionsAnswer();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addQuestionsAnswer(QuestionsAnswer model);


    @Delete
    int deleteQuestionsAnswer(QuestionsAnswer model);


    @Query("SELECT COUNT(*) FROM QuestionsAnswer ")
    int getDataCount();
}
