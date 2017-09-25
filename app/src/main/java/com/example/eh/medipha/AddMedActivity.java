package com.example.eh.medipha;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.Drug;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMedActivity extends AppCompatActivity {

    @BindView(R.id.add_drug_name) EditText name;
    @BindView(R.id.add_drug_time) EditText time;
    @BindView(R.id.add_drug) Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);
        ButterKnife.bind(this);
        time.setInputType(InputType.TYPE_NULL);
      //  time.requestFocus();




        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddMedActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(name.getText().toString(),time.getText().toString());
                Toast.makeText(AddMedActivity.this, "Add", Toast.LENGTH_SHORT).show();
            }
        });


    }


    void add(String name, String time)
    {
        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");

        db.addDrug(new Drug(name,time,false));

        Log.d("Reading: ", "Reading all contacts..");
        List<Drug> contacts = db.getAllDrugs();

        for (Drug cn : contacts) {
            String log = "Id: "+cn.get_id()+" ,Name: " + cn.getName() + " ,Time: " + cn.getTime()+", Stat: "+ String.valueOf(cn.getState());
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
