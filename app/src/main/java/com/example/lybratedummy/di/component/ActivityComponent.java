package com.example.lybratedummy.di.component;


import com.example.lybratedummy.di.PerActivity;
import com.example.lybratedummy.di.module.ActivityModule;
import com.example.lybratedummy.ui.login.LoginActivity;
import com.example.lybratedummy.ui.login.LoginMvpPresenter;
import com.example.lybratedummy.ui.login.LoginMvpView;
import com.example.lybratedummy.ui.login.LoginPresenter;
import com.example.lybratedummy.ui.logout.LogoutActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(LogoutActivity activity);
}
