package com.example.lybratedummy.ui.login;

import com.example.lybratedummy.ui.MvpView;

public interface LoginMvpView extends MvpView {
    public void onValidLogin();
    public void onInvalidLogin();
    public void onLoginDetailsAvailable(String username,String password);
}
