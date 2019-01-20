package ru.pschsch.pschschapps.yataxiconnection3months.View.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.pschsch.pschschapps.yataxiconnection3months.R;

public class InfoAdapter extends RecyclerView.Adapter<InfoHolder>{

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private DatePickerListener mListener;

    public InfoAdapter(Context c, DatePickerListener listener){
        this.mContext = c;
        this.mLayoutInflater = LayoutInflater.from(c);
        this.mListener = listener;
    }

    @NonNull
    @Override
    public InfoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.edtext_item_for_rv,  viewGroup, false);
        return new InfoHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoHolder infoHolder, int i) {
        InputFilter[] dateFilter = {new InputFilter.LengthFilter(Filters.DATE.length)};
        switch(i){
            case 0:
                infoHolder.tv.setText(getStringResource(R.string.firstName));
                break;
            case 1:
                infoHolder.tv.setText(getStringResource(R.string.name)); break;
            case 2:
                infoHolder.tv.setText(getStringResource(R.string.fatherName)); break;
            case 3:
                infoHolder.tv.setText(getStringResource(R.string.telephone));
                infoHolder.et.setInputType(InputType.TYPE_CLASS_NUMBER);
                infoHolder.et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Filters.TELEPHONE.length)});
                infoHolder.et.setText(R.string.tel_begin);
                break;
            case 4:
                infoHolder.tv.setText(getStringResource(R.string.serialDL));
                infoHolder.et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Filters.SERIAL.length)});
                break;
            case 5:
                infoHolder.tv.setText(getStringResource(R.string.numberDL));
                infoHolder.et.setInputType(InputType.TYPE_CLASS_NUMBER);
                infoHolder.et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Filters.NUMBER.length)});
                break;
            case 6:
                infoHolder.tv.setText(getStringResource(R.string.beginsInDL));
                infoHolder.et.setFocusable(false);
                infoHolder.et.setFilters(dateFilter);
                break;
            case 7:
                infoHolder.tv.setText(getStringResource(R.string.endsInDL));
                infoHolder.et.setFocusable(false);
                infoHolder.et.setFilters(dateFilter);
                break;
            case 8:
                infoHolder.tv.setText(getStringResource(R.string.autoMark)); break;
            case 9:
                infoHolder.tv.setText(getStringResource(R.string.autoModel)); break;
            case 10:
                infoHolder.tv.setText(getStringResource(R.string.autoYear));
                infoHolder.et.setInputType(InputType.TYPE_CLASS_NUMBER);
                infoHolder.et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Filters.YEAR.length)});
                break;
            case 11:
                infoHolder.tv.setText(getStringResource(R.string.autoColor)); break;
            case 12:
                infoHolder.tv.setText(getStringResource(R.string.autoGovNumber));
                infoHolder.et.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                infoHolder.et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Filters.GOV_NUMBER.length)});
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 13;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    private String getStringResource(int resId){
        return mContext.getResources().getString(resId);
    }

    public interface DatePickerListener{
        void onEditTextClick(int position);
    }

    public enum Filters{
        TELEPHONE(12), SERIAL(4), NUMBER(6), DATE(10), YEAR(4), GOV_NUMBER(9);
        private int length;
        Filters(int length){
            this.length = length;
        }
    }

}

