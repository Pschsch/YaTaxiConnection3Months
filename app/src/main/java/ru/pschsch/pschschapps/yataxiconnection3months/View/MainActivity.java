package ru.pschsch.pschschapps.yataxiconnection3months.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.pschsch.pschschapps.yataxiconnection3months.Presenter.YaTaxiConPresenter;
import ru.pschsch.pschschapps.yataxiconnection3months.R;
import ru.pschsch.pschschapps.yataxiconnection3months.View.fragments.YandexButtonsMainFragment;
import ru.pschsch.pschschapps.yataxiconnection3months.View.fragments.YandexMainFragment;


public class MainActivity extends MvpAppCompatActivity implements MainActivityView{

    private YandexMainFragment mYandexMainFragment;
    private YandexButtonsMainFragment mYandexButtonsMainFragment;
    private FragmentTransaction mFragmentTransaction;
    private ProgressDialog mDialog;

    @InjectPresenter(presenterId = "MyFirstPresenter")
    YaTaxiConPresenter mYaTaxiConPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYandexMainFragment = new YandexMainFragment();
        mYandexButtonsMainFragment = new YandexButtonsMainFragment();
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.container, mYandexMainFragment);
        mFragmentTransaction.add(R.id.container2, mYandexButtonsMainFragment);
        mFragmentTransaction.commit();
    }

    @Override
    public void showProgress() {
        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.show();
    }

    @Override
    public void hideProgress() {
        if(mDialog !=null) mDialog.dismiss();
    }
}


