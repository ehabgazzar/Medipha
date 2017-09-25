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

import com.example.eh.medipha.R;
import com.example.eh.medipha.Models.Drug;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eh on 9/22/2017.
 */

public class DrugAdapterEvening extends  RecyclerView.Adapter<DrugAdapterEvening.ViewHolder> {

    private final Context recipeContext;




    private List<Drug> DrugItemObjects;


    public DrugAdapterEvening(Context context, List<Drug> drugItemObjects) {
        this.recipeContext = context;
        DrugItemObjects = drugItemObjects;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.drag_item_evening,parent,false);
        ViewHolder holder = new ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       final Drug drug= DrugItemObjects.get(position);
        holder.nameView.setText(drug.getName());
        holder.timeView.setText(drug.getTime());
        holder.statView.setChecked(drug.getState());
        holder.statView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!drug.getState()) {
                    drug.setState(true);
                    drug.setName("Done");
                    holder.nameView.setText(drug.getName());
                    Log.d("Drug state",drug.getState().toString());
                }
                else {
                    drug.setState(false);
                    Log.d("Drug state",drug.getState().toString());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return DrugItemObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


       @BindView(R.id.drag_name)TextView nameView;
       @BindView(R.id.drag_time)TextView timeView;
       @BindView(R.id.drag_stat)CheckBox statView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);


            }
    }
}
