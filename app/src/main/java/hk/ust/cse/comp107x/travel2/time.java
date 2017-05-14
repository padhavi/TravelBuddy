package hk.ust.cse.comp107x.travel2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class time extends AppCompatActivity implements
        View.OnClickListener {
    Button submitbtn;

    Button btnDatePicker, btnTimePicker,btnTimePicker1,btntimedifference;
    EditText txtDate, txtTime,txtTime1,timeDifference;
    public int mYear, mMonth, mDay, mHour, mHour1,mMinute1,mMinute,diff,h1,h0;
    String str="",str1="";
    private DatabaseReference mDatabase;
    private FirebaseAuth auth;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        submitbtn=(Button)findViewById(R.id.registerbutton1);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        btnTimePicker1=(Button)findViewById(R.id.btn_time1);
        btntimedifference=(Button)findViewById(R.id.timedifferencebtn);

        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);
        txtTime1=(EditText)findViewById(R.id.in_time1);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnTimePicker1.setOnClickListener(this);
        btntimedifference.setOnClickListener(this);
        timeDifference=(EditText)findViewById(R.id.timedifference);

        mDatabase= FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        uid=auth.getCurrentUser().getUid();

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object

                mDatabase= FirebaseDatabase.getInstance().getReference();



                userchoice form = new userchoice();
                String str1=timeDifference.getText().toString().trim();
                //Adding values

                form.settxt(str1);


                mDatabase.child("Time").setValue(form);

                Intent j = new Intent(time.this, Travel.class);
                j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(j);


            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            h0=hourOfDay;

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, true);
            timePickerDialog.show();
        }
        if (v == btnTimePicker1) {

            // Get Current Time
            Calendar c1 = Calendar.getInstance();
            mHour1 = c1.get(Calendar.HOUR_OF_DAY);
            mMinute1 = c1.get(Calendar.MINUTE);



            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            h1=hourOfDay;
                            txtTime1.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour1, mMinute1, true);
            timePickerDialog.show();
        }
        if (v == btntimedifference) {


            if (h1 >h0) {
                diff = h1 - h0;

            }
            else
                diff = ((24 - h0) + h1);
            // timeDifference.setText((24 - mHour) + mHour1);
            str = Integer.toString(diff);



            timeDifference.setText(str);


        }

    }


}

