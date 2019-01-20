package ru.pschsch.pschschapps.yataxiconnection3months.View.activities;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface PrepareForRegMethods extends MvpView {
    void moveToPrivacyPolicy();
    void showSnackbar();
    void beginRegistration();
}
