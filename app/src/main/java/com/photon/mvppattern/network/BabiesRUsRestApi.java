package com.photon.mvppattern.network;

import com.photon.mvppattern.models.login.LoginRequest;
import com.photon.mvppattern.models.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public interface BabiesRUsRestApi {

    /**
     * Login Api
     **/
    @POST("/registry/login")
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);

}
