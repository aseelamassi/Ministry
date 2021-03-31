package com.sh.wm.ministry.network.database.dbModels.offlineModes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.sh.wm.ministry.network.utiels.StringTypeConverter;

import java.util.ArrayList;
import java.util.HashMap;

@Entity(tableName = "QuestionsAnswer")
public class QuestionsAnswer {

    private String constructId;

    @NonNull
    @PrimaryKey
    private String visitId;


    private String  answers;
    private String userId;

    public QuestionsAnswer(String constructId, @NonNull String visitId, String answers, String userId) {
        this.constructId = constructId;
        this.visitId = visitId;
        this.answers = answers;
        this.userId = userId;
    }


    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
