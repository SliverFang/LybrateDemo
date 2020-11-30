
package com.example.lybratedummy.ui;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    public boolean isViewAttached();

    public V getMvpView();

}
