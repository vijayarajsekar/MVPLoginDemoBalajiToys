package com.photon.mvppattern.presenter;


import com.photon.mvppattern.models.error.APIError;
import com.photon.mvppattern.models.login.LoginResponse;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public interface LoginPresenter {
    void attachView(LoginView view);

    void detachView();

    void login(String email, String password);

    interface LoginView extends BasePresenter.BaseView {
        void onLoginSuccessful(LoginResponse response);

        void onLoginFailed(APIError apiError);

        void onLoginFailed(Throwable throwable);

        void showHideProgress(boolean show);
    }
}
