package ru.pschsch.pschschapps.yataxiconnection3months.Presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.pschsch.pschschapps.yataxiconnection3months.View.MainActivityView;



@InjectViewState()
public class YaTaxiConPresenter extends MvpPresenter<MainActivityView> {

    public void showProgressDialog(){
        getViewState().showProgress();
    }
    public void hideProgressDialog(){
        getViewState().hideProgress();
    }
}
