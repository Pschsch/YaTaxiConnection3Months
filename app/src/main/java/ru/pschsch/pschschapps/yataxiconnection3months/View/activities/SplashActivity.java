package ru.pschsch.pschschapps.yataxiconnection3months.View.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.pschsch.pschschapps.yataxiconnection3months.R;
import ru.pschsch.pschschapps.yataxiconnection3months.View.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.yandexlogo)
    ImageView mYandexLogo;
    @BindView(R.id.welcometext)
    TextView mWelcomeTextView;

    private final short SPLASH_DURATION = 5000;
    private final short ANIM_DURATION = 1500;
    private final short SLEEP_BEFORE_ANIM = 400;
    private Handler mHandler;
    private AnimatorSet mAnimatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        mWelcomeTextView.setText(R.string.welcome);
        mWelcomeTextView.setAlpha(0);
        mWelcomeTextView.setTextSize(getResources().getDimensionPixelSize(R.dimen.welcometextsize));

        SystemClock.sleep(SLEEP_BEFORE_ANIM);

        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playSequentially(animateFromAlpha0To1(mYandexLogo),
                animateFromAlpha0To1(mWelcomeTextView));
        mAnimatorSet.start();

        mHandler = new Handler(Looper.getMainLooper());
        mHandler.postDelayed( () -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }, SPLASH_DURATION);
    }

    public ObjectAnimator animateFromAlpha0To1 (View v){
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(v, "alpha", 0 , 1);
        alphaAnimator.setDuration(ANIM_DURATION);
        return alphaAnimator;
    }
}
