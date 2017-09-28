package com.example.eh.medipha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.eh.medipha.Adapters.BloodAdapter;
import com.example.eh.medipha.Adapters.MedsAdapter;
import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.BloodMeasurement;
import com.example.eh.medipha.Models.Drug;

import java.util.ArrayList;
import java.util.List;

public class BloodMeasureActivity extends AppCompatActivity {
    private ArrayList<BloodMeasurement> mDrugList = null;
    private RecyclerView recycler_measures;
    private BloodAdapter mBloodAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        recycler_measures.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHandler db = new DatabaseHandler(this);
        List<BloodMeasurement> drugs =db.getAllBloodMeasurements();
        mBloodAdapter = new BloodAdapter(this,drugs);
        recycler_measures.setAdapter(mBloodAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_measure);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mo();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recycler_measures = (RecyclerView) findViewById(R.id.blood_recy);


    }

    void mo()
    {
        Intent intent= new Intent(this,AddBlood.class);
        startActivity(intent);
    }

}
