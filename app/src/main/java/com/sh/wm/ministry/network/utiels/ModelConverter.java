package com.sh.wm.ministry.network.utiels;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestion;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class ModelConverter {

    @TypeConverter
    public String fromCountryLangList(List<SafetyQuestion> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<SafetyQuestion>>() {}.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public List<SafetyQuestion> toCountryLangList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<SafetyQuestion>>() {}.getType();
        List<SafetyQuestion> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }





}
