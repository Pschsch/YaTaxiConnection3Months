package ru.pschsch.pschschapps.yataxiconnection3months.Presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


import java.util.Map;

import javax.inject.Inject;

import ru.pschsch.pschschapps.yataxiconnection3months.DaggerClasses.AppInitializer;
import ru.pschsch.pschschapps.yataxiconnection3months.Model.DriverModel;
import ru.pschsch.pschschapps.yataxiconnection3months.Model.FirebaseDBHelper;
import ru.pschsch.pschschapps.yataxiconnection3months.Model.RealmModel;
import ru.pschsch.pschschapps.yataxiconnection3months.View.activities.RegistrationActivityMethods;

@InjectViewState()
public class RegistrationPresenter extends MvpPresenter<RegistrationActivityMethods> {

    private Map<String, String> driverData;

    @Inject
    DriverModel mDriverModel;
    @Inject
    FirebaseDBHelper mFirebaseDB;
    @Inject
    RealmModel mRealmModel;

    public RegistrationPresenter(){
        AppInitializer.getComponent().injectToPresenter(this);
    }

    public void ViewShowSnackBar(){
        getViewState().showSnackbar();
    }
    public void ViewOnEndRegClick(){

    }
    public void ViewOnGetUserData(){
        getViewState().getUserData();
    }
    public void ViewShowProgress(){
        getViewState().showProgress();
    }
    public void ViewHideProgress(){
        getViewState().hideProgress();
    }
}
