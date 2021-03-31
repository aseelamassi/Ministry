package com.sh.wm.ministry.network.utiels;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kotlin.jvm.JvmStatic;

public class StringTypeConverter {

        @TypeConverter
        @JvmStatic
        public static ArrayList fromString(String value) {
            Type mapType = new TypeToken<HashMap<String, String>>() {
            }.getType();
            return new Gson().fromJson(value, mapType);
        }

        @TypeConverter
        @JvmStatic
        public static String fromStringMap(ArrayList map) {
            Gson gson = new Gson();
            return gson.toJson(map);
        }
    }


