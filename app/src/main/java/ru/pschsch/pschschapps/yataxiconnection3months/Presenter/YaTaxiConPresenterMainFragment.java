package ru.pschsch.pschschapps.yataxiconnection3months.Presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


import ru.pschsch.pschschapps.yataxiconnection3months.View.fragments.YandexButtonsFragmentView;

@InjectViewState()
public class YaTaxiConPresenterMainFragment extends MvpPresenter<YandexButtonsFragmentView>{
    public void onConditionClick(){
        getViewState().onConditionButtonClick();
    }
    public void onCallClick(){
        getViewState().onCallButtonClick();
    }
    public void onShareClick(){
        getViewState().onShareButtonClick();
    }
    public void onRegClick(){
        getViewState().onRegButtonClick();
    }
}
