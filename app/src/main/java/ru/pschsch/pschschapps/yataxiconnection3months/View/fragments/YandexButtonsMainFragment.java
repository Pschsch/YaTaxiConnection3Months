package ru.pschsch.pschschapps.yataxiconnection3months.View.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.pschsch.pschschapps.yataxiconnection3months.Presenter.YaTaxiConPresenterMainFragment;
import ru.pschsch.pschschapps.yataxiconnection3months.R;
import ru.pschsch.pschschapps.yataxiconnection3months.View.activities.PrepareForRegActivity;

public class YandexButtonsMainFragment extends MvpAppCompatFragment implements YandexButtonsFragmentView{

    @InjectPresenter()
    YaTaxiConPresenterMainFragment mPresenter;

    public final String TAG = "YandexWithButtonsFragment";

    @BindView(R.id.start_registration)
    Button mRegistrationButton;
    @BindView(R.id.condition_button)
    Button mConditionButton;
    @BindView(R.id.start_call)
    ImageButton mCall;
    @BindView(R.id.share_app)
    ImageButton mShareApp;

    private ConditionFragment mConditionFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yandexmainbuttonsfragment, null);
        ButterKnife.bind(YandexButtonsMainFragment.this, view);

        listenerSetter(mRegistrationButton);
        listenerSetter(mConditionButton);
        listenerSetter(mCall);
        listenerSetter(mShareApp);


        return view;
    }

    public void listenerSetter(View v){
        v.setOnClickListener(listenerToAllButtons());
    }

    public View.OnClickListener listenerToAllButtons(){
        View.OnClickListener listener;
        listener = (v) -> {
            switch (v.getId()){
                case R.id.start_registration: mPresenter.onRegClick(); break;
                case R.id.condition_button: mPresenter.onConditionClick(); break;
                case R.id.start_call: mPresenter.onCallClick(); break;
                case R.id.share_app: mPresenter.onShareClick(); break;
            }
        };
        return listener;
    }

    @Override
    public void onConditionButtonClick() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment frag = getActivity().getSupportFragmentManager().findFragmentByTag("Condition Fragment");
        if(frag != null) {
            transaction.remove(frag);
        }
        transaction.addToBackStack(null);
        mConditionFragment = new ConditionFragment();
        mConditionFragment.show(transaction, "Condition Fragment");
    }

    @Override
    public void onCallButtonClick() {
        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.CALL_PHONE}, 0);
        }
        else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+
                    getResources().getString(R.string.telephonenumber)));
            startActivity(intent);
        }
    }

    @Override
    public void onShareButtonClick() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.sharingtext));
        intent.setType("text/plain");
        startActivity(intent);
    }

    @Override
    public void onRegButtonClick() {
        Intent intent = new Intent(getContext(), PrepareForRegActivity.class);
        startActivity(intent);
    }
}
