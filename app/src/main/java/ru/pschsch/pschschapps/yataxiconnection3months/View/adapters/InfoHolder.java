package ru.pschsch.pschschapps.yataxiconnection3months.View.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.pschsch.pschschapps.yataxiconnection3months.R;

public class InfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    CardView cv;
    TextView tv;
    EditText et;
    InfoAdapter.DatePickerListener listener;
    public InfoHolder(@NonNull View itemView, InfoAdapter.DatePickerListener listener) {
        super(itemView);
        cv = itemView.findViewById(R.id.card_view_container);
        tv = itemView.findViewById(R.id.field_name);
        et = itemView.findViewById(R.id.field_enter);
        this.listener = listener;
        et.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        listener.onEditTextClick(getAdapterPosition());
    }


}
