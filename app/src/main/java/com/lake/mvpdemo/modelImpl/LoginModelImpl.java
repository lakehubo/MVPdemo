package com.lake.mvpdemo.modelImpl;

import android.os.AsyncTask;
import com.lake.mvpdemo.model.LoginModel;

public class LoginModelImpl implements LoginModel {
    public int status = LoginModel.STATUS_NORMAL;    //记录登陆状态
    @Override
    public void login(final String name,final String password,final LoginCallBack mLoginCallBack) {
        if (status == LoginModel.STATUS_VERIFY_ING) {
            return;
        }
        new AsyncTask<Void,Void,LoginCallBack>(){
            @Override
            protected void onPreExecute() {
                status = LoginModel.STATUS_VERIFY_ING;
                super.onPreExecute();
            }

            @Override
            protected LoginCallBack doInBackground(Void... voids) {
                if (name.equals("123") && password.equals("123")) {
                    status = LoginModel.STATUS_SUCCESS;
                } else {
                    status = LoginModel.STATUS_FAIL;
                }
                return mLoginCallBack;
            }

            @Override
            protected void onPostExecute(LoginCallBack loginCallBack) {
                loginCallBack.onStatus(status);
                super.onPostExecute(loginCallBack);
            }
        }.execute();
    }
}
