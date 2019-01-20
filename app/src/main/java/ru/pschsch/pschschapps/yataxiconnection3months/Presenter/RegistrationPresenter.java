package ru.pschsch.pschschapps.yataxiconnection3months.Presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


import ru.pschsch.pschschapps.yataxiconnection3months.View.activities.RegistrationActivityMethods;

@InjectViewState()
public class RegistrationPresenter extends MvpPresenter<RegistrationActivityMethods> {
    public void ViewShowSnackBar(){
        getViewState().showSnackbar();
    }
}
