package com.example.eh.medipha.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.Drug;
import com.example.eh.medipha.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eh on 9/27/2017.
 */

public class MedsAdapter  extends  RecyclerView.Adapter<MedsAdapter.ViewHolder> {

    private final Context recipeContext;
    private DatabaseHandler db;

    private List<Drug> DrugItemObjects;


    public MedsAdapter(Context context, List<Drug> drugItemObjects) {
        this.recipeContext = context;
        DrugItemObjects = drugItemObjects;
        db= new DatabaseHandler(context);

    }

    @Override
    public MedsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.med_item, parent, false);
        MedsAdapter.ViewHolder holder = new MedsAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Drug drug = DrugItemObjects.get(position);
        holder.nameView.setText(drug.getName());
        holder.timeView.setText(drug.getTime());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteDrug(drug);
                notifyItemRemoved(position);
                DrugItemObjects=db.getAllDrugs();
                notifyDataSetChanged();
            }
        });
    }



    @Override
    public int getItemCount() {
        return DrugItemObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.med_name)
        TextView nameView;
        @BindView(R.id.med_time)
        TextView timeView;
        @BindView(R.id.med_delete)
        Button delete;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
