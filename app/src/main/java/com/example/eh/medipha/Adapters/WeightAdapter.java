package com.example.eh.medipha.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.BloodMeasurement;
import com.example.eh.medipha.Models.WeightMeasurement;
import com.example.eh.medipha.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eh on 9/28/2017.
 */

public class WeightAdapter extends  RecyclerView.Adapter<WeightAdapter.ViewHolder> {

    private final Context mContext;
    private DatabaseHandler db;



    private List<WeightMeasurement> DrugItemObjects;


    public WeightAdapter(Context context, List<WeightMeasurement> drugItemObjects) {
        this.mContext = context;
        DrugItemObjects = drugItemObjects;
        db= new DatabaseHandler(context);


    }

    @Override
    public WeightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.weight_item,parent,false);
        WeightAdapter.ViewHolder holder = new WeightAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(final WeightAdapter.ViewHolder holder, int position) {
        final WeightMeasurement drug= DrugItemObjects.get(position);
        holder.nameView.setText(drug.getValue()+" Kg");
        holder.timeView.setText(drug.getTime());


    }

    @Override
    public int getItemCount() {
        return DrugItemObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.wht_value)TextView nameView;
        @BindView(R.id.wht_date)TextView timeView;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);


        }
    }
}


