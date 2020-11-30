package com.example.lybratedummy.ui.login;

import com.example.lybratedummy.data.DataManager;
import com.example.lybratedummy.ui.MvpView;

import javax.inject.Inject;

public class LoginPresenter<V extends LoginMvpView> implements LoginMvpPresenter<V> {

    private V MvpView;
    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager)
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
    public void onLoginClick(String username, String password) {
        if(username==null||username.length()==0||password==null||password.length()==0)
        {
            (getMvpView()).onInvalidLogin();
        }
        if(username.equals("9903110553")&&password.equals("password"))
        {
            getMvpView().onValidLogin();
        }
    }

    @Override
    public void onForgotPasswordClick() {
        if(isViewAttached())
        {
            (getMvpView()).onLoginDetailsAvailable("9903110553","password");
        }
    }

    @Override
    public void onAttach(V mvpView) {
        MvpView=mvpView;
    }
}

