package com.guyi.project.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Gson 工具类
 *
 * @author 孤诣
 */
public class GsonUtil<D> {
    private final Gson gson;

    private GsonUtil() {
        this.gson = new Gson();
    }

    public static <D> GsonUtil<D> getInstance() {
        return new GsonUtil<>();
    }

    public static <D> GsonUtil<D> getInstance(D dataType) {
        return new GsonUtil<>();
    }

    public D fromJson(String json) {
        Type typeOfD = new TypeToken<D>() {
        }.getType();
        return gson.fromJson(json, typeOfD);
    }

    public D fromJson(String json, Class<D> typeOfD) {
        return gson.fromJson(json, typeOfD);
    }

    public String toJson(D data) {
        return gson.toJson(data);
    }
}
