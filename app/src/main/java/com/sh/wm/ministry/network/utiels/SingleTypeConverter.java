package com.sh.wm.ministry.network.utiels;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.rxjava3.core.Single;
import kotlin.jvm.JvmStatic;

public class SingleTypeConverter {

    @TypeConverter
    @JvmStatic
    public static Single fromString(String value) {
        Type mapType = new TypeToken<Single>() {
        }.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    @JvmStatic
    public static String fromStringMap(Single map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
