package ru.pschsch.pschschapps.yataxiconnection3months.View.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.pschsch.pschschapps.yataxiconnection3months.R;

public class PrepareForRegActivity extends MvpAppCompatActivity implements PrepareForRegMethods{

    @BindView(R.id.privacyPolicyCheck)
    CheckBox mCheckbox;
    @BindView(R.id.linktext)
    TextView mPrivacyPolicyLink;
    @BindView(R.id.enter_reg)
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_for_reg);
        ButterKnife.bind(this);
            mPrivacyPolicyLink.setOnClickListener( v -> {
                Intent intent = new Intent(PrepareForRegActivity.this, PrivacyPolicyActivity.class);
                startActivity(intent);
            });
            mButton.setOnClickListener(v->{
                Intent intent = new Intent(PrepareForRegActivity.this, RegistrationActivity.class);
                startActivity(intent);
            });
    }

    @Override
    public void moveToPrivacyPolicy() {

    }

    @Override
    public void showSnackbar() {

    }

    @Override
    public void beginRegistration() {

    }
}
