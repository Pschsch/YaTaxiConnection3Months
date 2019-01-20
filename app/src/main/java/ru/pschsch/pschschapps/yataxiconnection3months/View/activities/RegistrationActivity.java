package ru.pschsch.pschschapps.yataxiconnection3months.View.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import ru.pschsch.pschschapps.yataxiconnection3months.Presenter.RegistrationPresenter;
import ru.pschsch.pschschapps.yataxiconnection3months.R;
import ru.pschsch.pschschapps.yataxiconnection3months.View.adapters.InfoAdapter;

public class RegistrationActivity extends MvpAppCompatActivity implements RegistrationActivityMethods, InfoAdapter.DatePickerListener {

    @InjectPresenter()
    RegistrationPresenter mPresenter;

    @BindView(R.id.recycler_view_with_edit_texts)
    RecyclerView mRecyclerView;
    @BindView(R.id.end_reg)
    Button mButton;
    @BindView(R.id.parent_layout)
    ConstraintLayout mParentLayout;
    @BindView(R.id.progressBar)
    ProgressBar mProgress;

    private LinearLayoutManager mLinearLayoutManager;
    private EditText mEditText;

    private DatePickerDialog mDPDialog;
    private Calendar mCalendar;
    private int day;
    private int month;
    private int year;

    private InfoAdapter mAdapter;

    private final int DL_BEGIN_POSITION = 6;
    private final int DL_END_POSITION = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.reg_title);
        ButterKnife.bind(this);

        mLinearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new InfoAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);

        mButton.setOnClickListener( v -> {
            showProgress();
            new Handler().postDelayed(this::hideProgress, 2500);
        }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onEditTextClick(int position) {
        mCalendar = Calendar.getInstance();
        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        month = mCalendar.get(Calendar.MONTH);
        year = mCalendar.get(Calendar.YEAR);
        DatePickerDialog.OnDateSetListener listener;
        listener = (view, year, month, dayOfMonth) -> {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
            if(position == DL_BEGIN_POSITION){
                mEditText = mLinearLayoutManager.findViewByPosition(position).findViewById(R.id.field_enter);
                mEditText.setText(format.format(mCalendar.getTime()));
            }
            if(position == DL_END_POSITION){
                mEditText = mLinearLayoutManager.findViewByPosition(position).findViewById(R.id.field_enter);
                mEditText.setText(format.format(mCalendar.getTime()));
            }
        };
        mDPDialog = new DatePickerDialog(this, R.style.DatePickerStyle, listener, year, month, day);
            switch(position) {
                case DL_BEGIN_POSITION :
                case DL_END_POSITION:
                    mDPDialog.show();
                    break;
                default: break;
            }
        }

    @Override
    public void showSnackbar() {
       Snackbar.make(mParentLayout, R.string.enter_all_fields, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void getUserData(){

    }

    public boolean checkUserData(){
        return false;
    }

    @Override
    public void showProgress() {
       mProgress.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgress() {
       mProgress.setVisibility(ProgressBar.INVISIBLE);
    }

}
