package com.example.lybratedummy.ui.logout;

import com.example.lybratedummy.ui.MvpPresenter;

public interface LogoutMvpPresenter<V extends LogoutMvpView> extends MvpPresenter<V> {

    public void onLogoutClick();
}
