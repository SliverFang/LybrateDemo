package com.example.lybratedummy.di.module;

import android.app.Application;
import android.content.Context;

import com.example.lybratedummy.data.AppDataManager;
import com.example.lybratedummy.data.DataManager;
import com.example.lybratedummy.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    DataManager provideDatamanger()
    {
        return new AppDataManager();
    }
}
