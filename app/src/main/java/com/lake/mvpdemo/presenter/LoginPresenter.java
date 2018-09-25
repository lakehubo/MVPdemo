package com.lake.mvpdemo.presenter;

import com.lake.mvpdemo.base.BasePresenter;
import com.lake.mvpdemo.model.LoginModel;
import com.lake.mvpdemo.modelImpl.LoginModelImpl;
import com.lake.mvpdemo.view.ILoginView;

public class LoginPresenter extends BasePresenter<ILoginView>{
    private ILoginView mILoginView;
    private LoginModel mLoginModel;

    public LoginPresenter(ILoginView mILoginView) {
        this.mILoginView = mILoginView;
        this.mLoginModel = new LoginModelImpl();
    }
    //登陆
    public void Login(String name,String pwd){
        mILoginView.showProgress();
        mLoginModel.login(name, pwd, new LoginModel.LoginCallBack() {
            @Override
            public void onStatus(int status) {
                mILoginView.hideProgress();
                if(status == LoginModel.STATUS_SUCCESS){
                    mILoginView.loginSuccess();
                }else{
                    mILoginView.loginFailed();
                }
            }
        });
    }
}
