package com.example.lybratedummy.ui.logout;

import com.example.lybratedummy.data.DataManager;
import com.example.lybratedummy.ui.MvpView;

import javax.inject.Inject;

public class LogoutPresenter<V extends LogoutMvpView> implements LogoutMvpPresenter<V> {

    private V MvpView;
    private DataManager mDataManager;

    @Inject
    public LogoutPresenter(DataManager dataManager)
    {
        this.mDataManager=dataManager;
    }

    @Override
    public void onDetach() {
        MvpView=null;
    }

    @Override
    public boolean isViewAttached() {
        return (getMvpView()!=null);
    }

    @Override
    public V getMvpView() {
        return MvpView;
    }

    @Override
    public void onLogoutClick() {

    }

    @Override
    public void onAttach(V mvpView) {
        MvpView=mvpView;
    }
}

