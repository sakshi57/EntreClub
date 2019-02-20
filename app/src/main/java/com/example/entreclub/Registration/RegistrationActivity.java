package com.example.entreclub.Registration;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.entreclub.R;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {

    private TextView t1;
    private DatePickerDialog datePicker;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_personal_info);
        t1= ( TextView) findViewById(R.id.editText10);
        b=(Button)findViewById(R.id.btnNext);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegistrationActivity.this, businessInfo.class);
                startActivity(i);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mont=cal.get(Calendar.MONTH);
                int date=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog d=new DatePickerDialog(
                        RegistrationActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,mont,date
                );
                d.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                d.show();
            }
        });

        mDateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;

                String date=dayOfMonth+"/"+month+"/"+year;
                t1.setText(date);
            }
        };

    }
}