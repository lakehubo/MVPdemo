package com.lake.mvpdemo.model;

import com.lake.mvpdemo.base.BaseModel;

public interface LoginModel extends BaseModel{

    void login(String name,String password,LoginCallBack mLoginCallBack);//登陆

    interface LoginCallBack{//登陆结果回调
        void onStatus(int status);
    }
}
