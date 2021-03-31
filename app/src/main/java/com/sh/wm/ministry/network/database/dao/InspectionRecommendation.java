package com.sh.wm.ministry.network.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRecommendationModel;

import java.util.List;

@Dao
public interface InspectionRecommendation {

    @Query("SELECT * FROM Recommendation ")
    List<InspectionRecommendationModel> getRecommendations();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVisit(InspectionRecommendationModel model);


    @Delete
    int deleteRecommendation(InspectionRecommendationModel model);


    @Query("SELECT COUNT(*) FROM Recommendation ")
    int getDataCount();
}
