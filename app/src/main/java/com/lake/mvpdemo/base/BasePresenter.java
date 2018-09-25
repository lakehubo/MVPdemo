package com.lake.mvpdemo.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<T> {
    protected WeakReference<T> mWeakRef;

    public void attchView(T view) {
        mWeakRef = new WeakReference<T>(view);//弱引用
    }

    public void detachView() {
        if (mWeakRef != null)
            mWeakRef.clear();
        mWeakRef = null;
    }
}
