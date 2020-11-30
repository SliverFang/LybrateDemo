package com.example.lybratedummy.data.prefs;

public interface PreferencesHelper {

    boolean isUserLoggedIn();

    void setCurrentUserName();

    void setCurrentUserPassword();

    String getCurrentUserName();

    String getCurrentUserPassword();

}
