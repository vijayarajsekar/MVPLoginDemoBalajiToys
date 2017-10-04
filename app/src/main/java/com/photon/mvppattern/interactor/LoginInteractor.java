package com.photon.mvppattern.interactor;


import com.photon.mvppattern.models.error.APIError;
import com.photon.mvppattern.models.login.LoginResponse;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public interface LoginInteractor {
    void login(String email, String Password, LoginListener listener);

    interface LoginListener {
        void onLoginSuccessful(LoginResponse response);

        void onLoginFailed(APIError apiError);

        void onLoginFailed(Throwable throwable);
    }
}
