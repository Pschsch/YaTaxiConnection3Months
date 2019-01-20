package ru.pschsch.pschschapps.yataxiconnection3months.MvpViewsForExtending;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arellomobile.mvp.MvpDelegate;

public class MvpAppCompatActivity extends AppCompatActivity {
    private MvpDelegate<? extends MvpAppCompatActivity> mMvpDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
        getMvpDelegate().onDetach();
    }
    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onDetach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroyView();
        if(isFinishing()) getMvpDelegate().onDestroy();
    }

    public MvpDelegate getMvpDelegate() {
        if(mMvpDelegate==null) return new MvpDelegate<>(this);
        return mMvpDelegate;
    }
}
