package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SafetyQuestionsModel {





    @SerializedName("safty_questions")
    @Expose
    private SafetyQuestionArray safetyQuestions = null;



    public   SafetyQuestionArray getSafetyQuestions() {
        return safetyQuestions;
    }

    public void setSafetyQuestions(SafetyQuestionArray safetyQuestions) {
        this.safetyQuestions = safetyQuestions;
    }


}
