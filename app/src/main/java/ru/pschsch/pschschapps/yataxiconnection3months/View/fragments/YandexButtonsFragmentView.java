package ru.pschsch.pschschapps.yataxiconnection3months.View.fragments;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface YandexButtonsFragmentView extends MvpView {
    void onConditionButtonClick();
    void onCallButtonClick();
    void onShareButtonClick();
    void onRegButtonClick();
}
