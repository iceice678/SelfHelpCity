package com.comenjoysoft.okhttplibrary.util;

//import com.google.gson.Gson;
//import com.google.gson.JsonSyntaxException;
//import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class GsonUtil<T> {

//    private volatile static GsonUtil singleton = null;
//    private static Gson gson = null;
//
//    private GsonUtil() {
//        gson = new Gson();
//    }
//
//    public static Gson getGson() {
//        return gson;
//    }
//
//    public static GsonUtil getInstance() {
//        if (singleton == null) {
//            synchronized (GsonUtil.class) {
//                if (singleton == null) {
//                    singleton = new GsonUtil();
//                }
//            }
//        }
//        return singleton;
//    }
//
//    public <T> T parseObject(String json, Class<T> tClass) {
//        try {
//            return gson.fromJson(json, tClass);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static <T> T parseByType(String json, Type type) {
//        try {
//            return gson.fromJson(json, type);
//        } catch (JsonSyntaxException e) {
//            return null;
//        }
//    }
}
