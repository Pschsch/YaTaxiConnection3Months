package ru.pschsch.pschschapps.yataxiconnection3months.View.activities;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface RegistrationActivityMethods extends MvpView {
    void showSnackbar();
    void getUserData();
    void showProgress();
    void hideProgress();
}
