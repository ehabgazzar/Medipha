package com.example.eh.medipha.Models;

/**
 * Created by Eh on 9/28/2017.
 */

public class WeightMeasurement {
    int ID;
    String Value;

    String Notes;
    String Time;

    public WeightMeasurement(int ID,String time, String value, String notes) {
        this.ID = ID;

        Time = time;
        Value =value;
            Notes=notes;
    }

    public WeightMeasurement( String time, String value, String notes) {

        Time = time;
        Value =value;
        Notes=notes;
    }

    public WeightMeasurement() {
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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


    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}

