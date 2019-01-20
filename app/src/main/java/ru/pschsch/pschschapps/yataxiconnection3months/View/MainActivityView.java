package ru.pschsch.pschschapps.yataxiconnection3months.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainActivityView extends MvpView {
    void showProgress();
    void hideProgress();
}
