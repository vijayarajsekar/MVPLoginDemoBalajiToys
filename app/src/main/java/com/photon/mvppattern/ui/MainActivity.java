package com.photon.mvppattern.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.photon.mvppattern.R;
import com.photon.mvppattern.models.error.APIError;
import com.photon.mvppattern.models.login.LoginResponse;
import com.photon.mvppattern.presenter.LoginPresenter;
import com.photon.mvppattern.presenter.LoginPresenterImpl;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class MainActivity extends AppCompatActivity implements LoginPresenter.LoginView{

    private LoginPresenterImpl mLoginPresenter;
    TextView mTextView;
    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.activity_textView);
        mProgress = (ProgressBar)findViewById(R.id.activity_progress_bar);
        mLoginPresenter = new LoginPresenterImpl();
    }

    public void testApi(View view){
        mLoginPresenter.login("weeks@gmail.com", "password");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLoginPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLoginPresenter.detachView();
    }

    @Override
    public void onLoginSuccessful(LoginResponse response) {
        mTextView.setText("Api Called Successfully");
    }

    @Override
    public void onLoginFailed(APIError apiError) {
        mTextView.setText("Api Call is not Successful : "+apiError.message());
    }

    @Override
    public void onLoginFailed(Throwable throwable) {
        mTextView.setText("Api Call is not Successful : "+throwable.getMessage());
    }

    @Override
    public void showHideProgress(boolean show) {
        mProgress.setVisibility(show?View.VISIBLE:View.GONE);
    }
}
