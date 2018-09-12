package com.example.administrator.funlearndrive;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Administrator on 2018/9/12.
 */

public class Navigation_bespeak_fragment extends Fragment {

    Button select_date = null;
    int mYear;
    int mMonth;
    int mDay;

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String days;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days = String.valueOf(mYear) + "年" + "0" +
                            (mMonth + 1) + "月" + "0" + mDay + "日";
                } else {
                    days = String.valueOf(mYear) + "年" + "0" +
                            (mMonth + 1) + "月" + mDay + "日";
                }

            } else {
                if (mDay < 10) {
                    days = String.valueOf(mYear) + "年" +
                            (mMonth + 1) + "月" + "0" + mDay + "日";
                } else {
                    days = String.valueOf(mYear) + "年" +
                            (mMonth + 1) + "月" + mDay + "日";
                }

            }
            TextView date=getActivity().findViewById(R.id.date);
            date.setText(days);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_bespeak_fragment, null);

        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        select_date = view.findViewById(R.id.select_date);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 调用时间选择器
                new DatePickerDialog(getActivity(), onDateSetListener, mYear, mMonth, mDay).show();
            }
        });
    }
}
