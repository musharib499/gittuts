package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class DateTimeModel implements Serializable {
    @SerializedName("date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
