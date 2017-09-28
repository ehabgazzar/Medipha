package com.example.eh.medipha.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.BloodMeasurement;
import com.example.eh.medipha.Models.Drug;
import com.example.eh.medipha.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eh on 9/28/2017.
 */

public class BloodAdapter extends  RecyclerView.Adapter<BloodAdapter.ViewHolder> {

    private final Context mContext;
    private DatabaseHandler db;



    private List<BloodMeasurement> DrugItemObjects;


    public BloodAdapter(Context context, List<BloodMeasurement> drugItemObjects) {
        this.mContext = context;
        DrugItemObjects = drugItemObjects;
        db= new DatabaseHandler(context);


    }

    @Override
    public BloodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.blood_item,parent,false);
        BloodAdapter.ViewHolder holder = new BloodAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(final BloodAdapter.ViewHolder holder, int position) {
        final BloodMeasurement drug= DrugItemObjects.get(position);
        holder.nameView.setText(drug.getValue_HIGH()+"/"+drug.getValue_LOW());
        holder.timeView.setText(drug.getTime());


    }

    @Override
    public int getItemCount() {
        return DrugItemObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.bld_value)TextView nameView;
        @BindView(R.id.bld_date)TextView timeView;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);


        }
    }
}

