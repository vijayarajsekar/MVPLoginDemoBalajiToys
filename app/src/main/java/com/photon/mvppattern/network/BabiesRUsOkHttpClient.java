package com.photon.mvppattern.network;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by dhiman_da on 8/4/2016.
 */
public class BabiesRUsOkHttpClient {

    public static OkHttpClient getInstance() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long CONNECTION_TIMEOUT = 30000;
        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                // try the request
                Response response = chain.proceed(request);

                int tryCount = 0;
                while (!response.isSuccessful() && tryCount < 3) {

                    Log.d("intercept", "Request is not successful - " + tryCount);

                    tryCount++;

                    // retry the request
                    response = chain.proceed(request);
                }

                // otherwise just pass the original response on

                return response;

            }
        });
        OkHttpClient sClient = builder.build();
        return sClient;
    }

    private BabiesRUsOkHttpClient() {

    }
}
