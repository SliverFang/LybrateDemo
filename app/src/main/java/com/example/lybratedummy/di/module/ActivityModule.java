package com.example.lybratedummy.di.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lybratedummy.di.ActivityContext;
import com.example.lybratedummy.di.PerActivity;
import com.example.lybratedummy.ui.login.LoginMvpPresenter;
import com.example.lybratedummy.ui.login.LoginMvpView;
import com.example.lybratedummy.ui.login.LoginPresenter;
import com.example.lybratedummy.ui.logout.LogoutMvpPresenter;
import com.example.lybratedummy.ui.logout.LogoutMvpView;
import com.example.lybratedummy.ui.logout.LogoutPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @PerActivity
    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @PerActivity
    @Provides
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter)
    {
        return presenter;
    }

    @PerActivity
    @Provides
    LogoutMvpPresenter<LogoutMvpView> provideLogoutPresenter(LogoutPresenter<LogoutMvpView> presenter)
    {
        return presenter;
    }

}
