package ru.pschsch.pschschapps.yataxiconnection3months.View.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.pschsch.pschschapps.yataxiconnection3months.R;

public class PrivacyPolicyActivity extends AppCompatActivity {
    @BindView(R.id.privacy_policy_view)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        ButterKnife.bind(this);
        mWebView.loadUrl("file:///android_asset/privacy_policy.html");
    }
}
