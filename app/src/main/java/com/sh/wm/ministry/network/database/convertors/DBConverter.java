package com.sh.wm.ministry.network.database.convertors;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestion;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class DBConverter {
    @androidx.room.TypeConverter
    public Object fromJson(String jsonString) {
        Type type = new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(jsonString, type);
    }

    @androidx.room.TypeConverter
    public String toJson(Object object) {
        Type type = new TypeToken<Object>() {
        }.getType();
        return new Gson().toJson(object, type);
    }




}
