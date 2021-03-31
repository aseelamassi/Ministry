package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.network.utiels.ModelConverter;

import java.util.List;


@Dao
public interface SafetyQuestionsArrayDao {

    @Query("SELECT * FROM SafetyQuestions  ")
    LiveData<SafetyQuestionArray>getSafetyQuestions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addSafetyQuestions(SafetyQuestionArray safetyQuestionArray);

}
