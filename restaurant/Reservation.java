package com.example.restaurant;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;
import android.widget.Toast;
//import java.text.DateFormat;
import java.util.Calendar;


public class Reservation extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{



    Button DateandTime;
    TextView Reserveresult;
    Button Confirm,Cancel;

    int day, month, year,hour,minute;
    int dayResult, monthResult, yearResult, hourResult, minuteResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);


        DateandTime = (Button) findViewById(R.id.DateandTime);
        Reserveresult = (TextView) findViewById(R.id.datetimeresult);
        Confirm = (Button) findViewById(R.id.confirmation);
        Cancel = (Button) findViewById(R.id.cancelation);

        DateandTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Reservation.this, Reservation.this, year, month, day);
                datePickerDialog.show();
            }
        });


        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm = new Intent(Reservation.this, Category.class);
                Toast.makeText(Reservation.this, "Reservation Complete!", Toast.LENGTH_SHORT).show();
                startActivity(confirm);
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(Reservation.this, Reservation.class);
                startActivity(cancel);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int j, int k) {
        yearResult = i;
        monthResult = j+1;
        dayResult = k;

        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(Reservation.this, Reservation.this,
                hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int j) {
        hourResult = i;
        minuteResult = j;

        Reserveresult.setText(
                "Date Reservation"+ "\n\n"+
                        "Date: "+dayResult+"\t/"+ monthResult+"\t/"+ yearResult+ "\n"+
                        "Time: " + hourResult+"." + minuteResult + "minutes "
        );
    }


}
