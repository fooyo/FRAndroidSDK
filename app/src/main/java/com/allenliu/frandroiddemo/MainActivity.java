package com.allenliu.frandroiddemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.blankj.utilcode.util.LogUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sg.fooyo.frandroidsdk.sdk.FooyoFRAndroidSDK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDate();
    }

    DatePickerDialog.OnDateSetListener listener;
    private int year, month, day;
    private Calendar cal;
    long startTime = 1505516827;
    public void onClick(View v) {

        final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, 0, listener, year, month, day);//后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
        datePickerDialog.setButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Date date;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                int y = datePickerDialog.getDatePicker().getYear();
                int m = datePickerDialog.getDatePicker().getMonth();
                int d = datePickerDialog.getDatePicker().getDayOfMonth();
                try {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(y, m, d);
                    startTime = calendar.getTime().getTime();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LogUtils.e("startTime:" + startTime + "\nstartTime:" + System.currentTimeMillis());
                FooyoFRAndroidSDK.createPhotoCollage(MainActivity.this,startTime,"a");
            }
        });
        datePickerDialog.show();


    }

    //获取当前日期
    private void getDate() {
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);       //获取年月日时分秒
        month = cal.get(Calendar.MONTH);   //获取到的月份是从0开始计数
        day = cal.get(Calendar.DAY_OF_MONTH);
        listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker arg0, int year, int month, int day) {
                //将选择的日期显示到TextView中,因为之前获取month直接使用，所以不需要+1，这个地方需要显示，所以+1


            }
        };
    }
}
