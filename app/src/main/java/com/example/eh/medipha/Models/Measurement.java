package com.example.eh.medipha.Models;

/**
 * Created by Eh on 9/28/2017.
 */

public class Measurement {

    int ID;
    String Name;
    String Value;
    String Time;

    public Measurement(int ID, String name, String time, String value) {
        this.ID = ID;
        Name = name;
        Time = time;
        Value=value;
    }

    public Measurement(String name, String time,String value) {
        Name = name;
        Time = time;
        Value=value;
    }

    public Measurement() {
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
