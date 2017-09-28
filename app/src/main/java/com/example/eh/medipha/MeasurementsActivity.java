package com.example.eh.medipha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.eh.medipha.Models.WeightMeasurement;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeasurementsActivity extends AppCompatActivity {
    @BindView(R.id.bt_weight)
    Button weight;
    @BindView(R.id.bt_blood)
    Button blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                as();
            }
        });


        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mo();
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void mo()
    {
        Intent intent= new Intent(this,BloodMeasureActivity.class);
        startActivity(intent);
    }

    void as()
    {
        Intent intent= new Intent(this,WeightMeasureActivity.class);
        startActivity(intent);
    }

}
