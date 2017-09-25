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
import com.example.eh.medipha.R;
import com.example.eh.medipha.Models.Drug;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eh on 9/22/2017.
 */

public class DrugAdapter extends  RecyclerView.Adapter<DrugAdapter.ViewHolder> {

    private final Context mContext;
    private DatabaseHandler db;



    private List<Drug> DrugItemObjects;


    public DrugAdapter(Context context, List<Drug> drugItemObjects) {
        this.mContext = context;
        DrugItemObjects = drugItemObjects;
      db= new DatabaseHandler(context);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.drag_item,parent,false);
        ViewHolder holder = new ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       final Drug drug= DrugItemObjects.get(position);
        holder.nameView.setText(drug.getName());
        holder.timeView.setText(drug.getTime());
        holder.statView.setChecked(drug.getState());
        if(drug.getState())
            holder.statView.setText("Taken");
        else
            holder.statView.setText("Not taken");
        holder.statView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!drug.getState()) {
                    drug.setState(true);
                    holder.statView.setText("Taken");
                    db.updateDrug(drug);
                    Log.d("Drug stateChane",drug.getState().toString());
                    List<Drug> drugs =db.getAllDrugs();
                    for (Drug cn : drugs) {
                        String log = "Id: "+cn.get_id()+" ,Name: " + cn.getName() + " ,Time: " + cn.getTime()+", Stat: "+ String.valueOf(cn.getState());
                        // Writing Contacts to log
                        Log.d("Name: ", log);
                    }
                }
                else {
                    drug.setState(false);
                    holder.statView.setText("Not taken");
                    db.updateDrug(drug);
                    Log.d("Drug stateChane",drug.getState().toString());
                    List<Drug> drugs =db.getAllDrugs();
                    for (Drug cn : drugs) {
                        String log = "Id: "+cn.get_id()+" ,Name: " + cn.getName() + " ,Time: " + cn.getTime()+", Stat: "+ String.valueOf(cn.getState());
                        // Writing Contacts to log
                        Log.d("Name: ", log);
                    }
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
