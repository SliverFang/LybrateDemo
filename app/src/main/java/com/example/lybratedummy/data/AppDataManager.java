package com.example.lybratedummy.data;

import android.app.Application;

import javax.inject.Inject;

public class AppDataManager implements DataManager{

    @Inject
    public AppDataManager()
    {

    }
    @Override
    public boolean isUserLoggedIn() {
        return false;
    }

    @Override
    public void setCurrentUserName() {

    }

    @Override
    public void setCurrentUserPassword() {

    }

    @Override
    public String getCurrentUserName() {
        return "";
    }

    @Override
    public String getCurrentUserPassword() {
        return "";
    }
}
