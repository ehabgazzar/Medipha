package com.example.eh.medipha;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.eh.medipha.Adapters.MedsAdapter;
import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.Drug;

import java.util.ArrayList;
import java.util.List;

public class MedicationsActivity extends AppCompatActivity {
    private ArrayList<Drug> mDrugList = null;
    private RecyclerView recycler_meds;
    Context mContext;

    private MedsAdapter mDrugAdapter;
    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recycler_meds = (RecyclerView) findViewById(R.id.med_recy);
        mContext=this.getApplicationContext();
        recycler_meds.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHandler db = new DatabaseHandler(this);
        List<Drug> drugs =db.getAllDrugs();
        mDrugAdapter = new MedsAdapter(this,drugs);
        recycler_meds.setAdapter(mDrugAdapter);

//        recycler_meds = (RecyclerView) findViewById(R.id.medication_recy);
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

}
