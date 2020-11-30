
package com.example.lybratedummy.ui;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void showMessage(String message);

    void setup();
}
