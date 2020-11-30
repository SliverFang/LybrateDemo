package com.example.lybratedummy;

import android.app.Application;

import com.example.lybratedummy.data.DataManager;
import com.example.lybratedummy.di.component.ApplicationComponent;
import com.example.lybratedummy.di.component.DaggerApplicationComponent;
import com.example.lybratedummy.di.module.ApplicationModule;

import javax.inject.Inject;

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
