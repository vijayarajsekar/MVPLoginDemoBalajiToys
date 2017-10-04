package com.photon.mvppattern.network;

import com.photon.mvppattern.constants.URLConstants;


import retrofit2.Retrofit;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class BabiesRUsRestClient {
    private static Retrofit sRetrofit;

    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder().
                    baseUrl(URLConstants.BASE_URL_REST).
                    client(BabiesRUsOkHttpClient.getInstance()).
                    addConverterFactory(GsonUtils.buildGsonConverter()).
                    build();
        }

        return sRetrofit;
    }


    private BabiesRUsRestClient() {

    }

}
