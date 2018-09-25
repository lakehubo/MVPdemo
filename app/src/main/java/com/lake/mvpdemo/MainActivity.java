package com.lake.mvpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lake.mvpdemo.base.BaseActivity;
import com.lake.mvpdemo.presenter.LoginPresenter;
import com.lake.mvpdemo.view.ILoginView;

public class MainActivity extends BaseActivity implements ILoginView {
    public static final String TAG = MainActivity.class.getSimpleName();
    private LoginPresenter mLoginPresenter;
    private Button mLoginBtn;
    private TextView mText;
    private ProgressBar mProgressBar;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mLoginBtn = findViewById(R.id.login);
        mText = findViewById(R.id.text);
        mProgressBar = findViewById(R.id.progress);
    }

    @Override
    protected void initData() {
        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.attchView(this);
    }

    @Override
    protected void setListener() {
        setListener(mLoginBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                mLoginPresenter.Login("123","123");
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        mText.setText("Success!");
    }

    @Override
    public void loginFailed() {
        mText.setText("Failed!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoginPresenter != null) {
            mLoginPresenter.detachView();
            mLoginPresenter = null;
            System.gc();
        }
    }
}
