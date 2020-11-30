package com.example.lybratedummy.di.component;


import android.app.Application;
import android.content.Context;

import com.example.lybratedummy.MvpApp;
import com.example.lybratedummy.data.DataManager;
import com.example.lybratedummy.di.ApplicationContext;
import com.example.lybratedummy.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}