package com.example.eh.medipha.Models;

/**
 * Created by Eh on 9/22/2017.
 */

public class Drug {



    int ID;
    String Name;
    String Time;
    Boolean State;

    public Drug() {
    }
    public Drug(String name, String time, Boolean state) {
        this.Name=name;
        this.Time=time;
        this.State=state;
    }
        public Drug(int id, String name, String time, Boolean state) {
        this.ID=id;
        this.Name=name;
        this.Time=time;
        this.State=state;
    }

    public int get_id() {
        return ID;
    }

    public void set_id(int id) {
        this.ID = id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Boolean getState() {
        return State;
    }

    public void setState(Boolean State) {
        this.State = State;
    }
}
