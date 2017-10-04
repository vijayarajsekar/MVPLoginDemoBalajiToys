package com.photon.mvppattern.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class GsonUtils {
    public  static GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();//GsonConverterFactory.create()
        return GsonConverterFactory.create(gson);
    }
}
