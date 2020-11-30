package com.example.lybratedummy.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lybratedummy.MvpApp;
import com.example.lybratedummy.R;
import com.example.lybratedummy.di.component.ActivityComponent;
import com.example.lybratedummy.di.component.DaggerActivityComponent;
import com.example.lybratedummy.di.module.ActivityModule;
import com.example.lybratedummy.ui.logout.LogoutActivity;
import com.example.lybratedummy.utils.CommonUtils;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    private ProgressDialog mProgressDialog;

    private Unbinder mUnBinder;

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    @BindView(R.id.login_phone_number_editText)
    TextView phoneTextView;

    @BindView(R.id.login_password_editText)
    TextView passwordTextView;

    @BindView(R.id.login_button)
    Button loginButton;

    @BindView(R.id.forget_password_block)
    RelativeLayout forgotPasswordRelativeLayout;

    private ActivityComponent mActivityComponent;

    public static Intent getStartIntent(Context context)
    {
        return new Intent(context,LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getComponent())
                .build();
        mActivityComponent.inject(this);

        mUnBinder=(ButterKnife.bind(this));
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
    public void onValidLogin() {
        Intent intent=LogoutActivity.getStartIntent(this);
        startActivity(intent);
    }

    @Override
    public void onInvalidLogin() {
        showMessage("Invalid Login Credentials");
    }

    @Override
    public void onLoginDetailsAvailable(String username, String password) {
        new AlertDialog.Builder(this)
                .setTitle("Login Details")
                .setMessage("Username :- "+username+"\n"+"Password :- "+password)
                .setPositiveButton("OK", null)
                .setNegativeButton("cancel", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void setup() {
        forgotPasswordRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onForgotPasswordClick();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onLoginClick(phoneTextView.getText().toString(),passwordTextView.getText().toString());
            }
        });
    }
}
