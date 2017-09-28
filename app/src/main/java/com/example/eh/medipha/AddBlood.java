package com.example.eh.medipha;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.BloodMeasurement;
import com.example.eh.medipha.Models.Drug;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBlood extends AppCompatActivity {
    @BindView(R.id.bl_add)
    Button add;
    @BindView(R.id.bl_dt)
    EditText dt;
    @BindView(R.id.bl_val_hi)
    EditText high;

    @BindView(R.id.bl_val_lw)
    EditText low;

    @BindView(R.id.bl_notes)
    EditText notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blood);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dt.setInputType(InputType.TYPE_NULL);
        dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "yyyy-MM-dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        dt.setText(sdf.format(myCalendar.getTime()));
                    }

                };


                new DatePickerDialog(AddBlood.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(dt.getText().toString(),high.getText().toString(),low.getText().toString(),notes.getText().toString());
                Toast.makeText(AddBlood.this, "Add", Toast.LENGTH_SHORT).show();
            }
        });


    }


    void add(String dt, String high, String low , String notes)
    {
        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");

        db.addBloodMeasure(new BloodMeasurement(dt,high,low,notes));

        Log.d("Reading: ", "Reading all contacts..");
        List<BloodMeasurement> contacts = db.getAllBloodMeasurements();

        for (BloodMeasurement cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Notes: " + cn.getNotes() + " ,Time: " + cn.getTime()+", HIGH: "+ cn.getValue_HIGH() +", LOW: "+ cn.getValue_LOW() ;
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }

}
