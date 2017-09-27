package com.example.eh.medipha;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eh.medipha.Adapters.DrugAdapter;
import com.example.eh.medipha.Adapters.DrugAdapterEvening;
import com.example.eh.medipha.Adapters.DrugAdapterNight;
import com.example.eh.medipha.Adapters.DrugAdapterNon;
import com.example.eh.medipha.DB.DatabaseHandler;
import com.example.eh.medipha.Models.Drug;

import java.util.ArrayList;
import java.util.List;

public class HomeFragement extends Fragment {
     DrugAdapter mDrugAdapter;
    DrugAdapterNon mDrugAdapter_non;
    DrugAdapterEvening mDrugAdapter_evening;
    DrugAdapterNight mDrugAdapter_night;
    private ArrayList<Drug> mDrugList = null;
    private RecyclerView recycler_morning;
    private RecyclerView recycler_afternon;
    private RecyclerView recycler_evening;
    private RecyclerView recycler_night;
    Context mContext;

    public HomeFragement() {
    }

    @Override
    public void onStart() {
        super.onStart();
        recycler_morning.setLayoutManager(new LinearLayoutManager(mContext));
        DatabaseHandler db = new DatabaseHandler(this.getActivity());
        List<Drug> drugs =db.getAllDrugs();
        mDrugAdapter = new DrugAdapter(mContext,drugs);
        recycler_morning.setAdapter(mDrugAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        DatabaseHandler db = new DatabaseHandler(this.getActivity());
        mContext=this.getActivity();

        recycler_morning = (RecyclerView) view.findViewById(R.id.recy_moring);
//        recycler_morning.setLayoutManager(new LinearLayoutManager(mContext));
//        List<Drug> drugs =db.getAllDrugs();
//        for (Drug cn : drugs) {
//            String log = "Id: "+cn.get_id()+" ,Name: " + cn.getName() + " ,Time: " + cn.getTime()+", Stat: "+ String.valueOf(cn.getState());
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }
   /* Drug a = new Drug();
        a.setName("ABCA AN");
        a.setState(false);
        a.setTime("11:24 AM");
        Drug b = new Drug();
        b.setName("ABCA AN");
        b.setState(false);
        b.setTime("11:24 AM");
        Drug c = new Drug();
        c.setName("ABCA AN");
        c.setState(false);
        c.setTime("11:24 AM");
        drugs.add(a);
        drugs.add(b);
        drugs.add(c);
*/
//        mDrugAdapter = new DrugAdapter(mContext,drugs);
//        recycler_morning.setAdapter(mDrugAdapter);

       /* recycler_afternon = (RecyclerView) view.findViewById(R.id.recy_afternon);
        recycler_afternon.setLayoutManager(new LinearLayoutManager(mContext));
        mDrugAdapter_non = new DrugAdapterNon(mContext,drugs);
        recycler_afternon.setAdapter(mDrugAdapter_non);

        recycler_night = (RecyclerView) view.findViewById(R.id.recy_night);
        recycler_night.setLayoutManager(new LinearLayoutManager(mContext));
        mDrugAdapter_night = new DrugAdapterNight(mContext,drugs);
        recycler_night.setAdapter(mDrugAdapter_night);

        recycler_evening = (RecyclerView) view.findViewById(R.id.recy_evening);
        recycler_evening.setLayoutManager(new LinearLayoutManager(mContext));
        mDrugAdapter_evening = new DrugAdapterEvening(mContext,drugs);
        recycler_evening.setAdapter(mDrugAdapter_evening);

*/

        return view;
    }
}
