package com.photon.mvppattern.utils;


import android.util.Log;

import com.photon.mvppattern.models.error.APIError;
import com.photon.mvppattern.network.BabiesRUsRestClient;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class ErrorUtils {
    private ErrorUtils() {

    }
    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                BabiesRUsRestClient.getRetrofit()
                        .responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            Log.e(ErrorUtils.class.getName(), e.getMessage());
            error = new APIError(-1, "Not defined");
        }

        return error;
    }
}
