package com.example.lybratedummy.ui.logout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lybratedummy.MvpApp;
import com.example.lybratedummy.R;
import com.example.lybratedummy.di.component.ActivityComponent;
import com.example.lybratedummy.di.component.DaggerActivityComponent;
import com.example.lybratedummy.di.module.ActivityModule;
import com.example.lybratedummy.ui.login.LoginActivity;
import com.example.lybratedummy.ui.login.LoginMvpPresenter;
import com.example.lybratedummy.ui.login.LoginMvpView;
import com.example.lybratedummy.ui.login.LoginPresenter;
import com.example.lybratedummy.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LogoutActivity extends AppCompatActivity implements LogoutMvpView{

    private ProgressDialog mProgressDialog;
    private Unbinder mUnBinder;
    private ActivityComponent mActivityComponent;

    @Inject
    LogoutMvpPresenter<LogoutMvpView> mPresenter;

    @BindView(R.id.logout_button)
    Button logoutButton;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LogoutActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        mUnBinder=(ButterKnife.bind(this));

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getComponent())
                .build();
        mActivityComponent.inject(this);

        mPresenter.onAttach(this);
        setup();
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setup() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onLogoutClick();
                startActivity(LoginActivity.getStartIntent(LogoutActivity.this));
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

}
