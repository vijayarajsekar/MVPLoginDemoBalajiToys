package com.photon.mvppattern.presenter;


import com.photon.mvppattern.interactor.LoginInteractor;
import com.photon.mvppattern.interactor.LoginInteractorImpl;
import com.photon.mvppattern.models.error.APIError;
import com.photon.mvppattern.models.login.LoginResponse;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.LoginListener {
    private LoginView mLoginView;
    private LoginInteractorImpl mLoginInterceptor;

    public LoginPresenterImpl() {
        mLoginInterceptor = new LoginInteractorImpl();
    }

    @Override
    public void attachView(LoginView view) {
        mLoginView = view;
    }

    @Override
    public void detachView() {
        mLoginView = null;
    }

    @Override
    public void login(String email, String password) {
        mLoginInterceptor.login(email, password, this);

        if (mLoginView != null) {
            mLoginView.showHideProgress(true);
        }
    }

    @Override
    public void onLoginSuccessful(LoginResponse response) {
        if (mLoginView != null) {
            mLoginView.showHideProgress(false);
            mLoginView.onLoginSuccessful(response);
        }
    }

    @Override
    public void onLoginFailed(APIError apiError) {
        if (mLoginView != null) {
            mLoginView.showHideProgress(false);
            mLoginView.onLoginFailed(apiError);
        }
    }

    @Override
    public void onLoginFailed(Throwable throwable) {
        if (mLoginView != null) {
            mLoginView.showHideProgress(false);
            mLoginView.onLoginFailed(throwable);
        }
    }
}
