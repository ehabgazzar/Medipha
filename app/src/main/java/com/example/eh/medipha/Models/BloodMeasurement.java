package com.example.eh.medipha.Models;

/**
 * Created by Eh on 9/28/2017.
 */

public class BloodMeasurement {

    int ID;
        String Value_HIGH;
    String Value_LOW;
    String Notes;
    String Time;

    public BloodMeasurement(int ID,String time, String value, String low, String notes) {
        this.ID = ID;

        Time = time;
        Value_HIGH=value;
        Value_LOW=low;
        Notes=notes;
    }

    public BloodMeasurement( String time, String value, String low, String notes) {

        Time = time;
        Value_HIGH=value;
        Value_LOW=low;
        Notes=notes;
    }

    public BloodMeasurement() {
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


    public String getValue_HIGH() {
        return Value_HIGH;
    }

    public void setValue_HIGH(String value_HIGH) {
        Value_HIGH = value_HIGH;
    }

    public String getValue_LOW() {
        return Value_LOW;
    }

    public void setValue_LOW(String value_LOW) {
        Value_LOW = value_LOW;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
