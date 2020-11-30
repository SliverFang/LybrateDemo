package com.example.lybratedummy.ui.login;

import com.example.lybratedummy.ui.MvpPresenter;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    public void onLoginClick(String username,String password);

    public void onForgotPasswordClick();
}
