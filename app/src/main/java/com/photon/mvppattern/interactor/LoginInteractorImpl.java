package com.photon.mvppattern.interactor;

import com.photon.mvppattern.interactor.LoginInteractor;
import com.photon.mvppattern.models.error.APIError;
import com.photon.mvppattern.models.login.LoginRequest;
import com.photon.mvppattern.models.login.LoginResponse;

import com.photon.mvppattern.network.BabiesRUsRestApi;
import com.photon.mvppattern.network.BabiesRUsRestClient;
import com.photon.mvppattern.utils.ErrorUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String email, final String password, final LoginListener listener) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        final Retrofit retrofit = BabiesRUsRestClient.getRetrofit();
        final BabiesRUsRestApi api = retrofit.create(BabiesRUsRestApi.class);

        final Call<LoginResponse> call = api.getLogin(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    listener.onLoginSuccessful(response.body());
                } else {
                    final APIError apiError = ErrorUtils.parseError(response);
                    listener.onLoginFailed(apiError);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                listener.onLoginFailed(t);
            }
        });
    }
}
