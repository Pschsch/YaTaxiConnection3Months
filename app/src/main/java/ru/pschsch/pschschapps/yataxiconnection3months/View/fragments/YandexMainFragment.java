package ru.pschsch.pschschapps.yataxiconnection3months.View.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.pschsch.pschschapps.yataxiconnection3months.R;

public class YandexMainFragment extends Fragment {

    public final String TAG = "YandexMainFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.yandexmainfragment, null);
    }
}
