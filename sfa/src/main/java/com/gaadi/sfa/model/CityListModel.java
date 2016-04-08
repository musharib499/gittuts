package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ashish123 on 28/6/15.
 */
public class CityListModel implements Serializable {

    private int id;

    @SerializedName ("city_id")
    private String city_Id;

    @SerializedName ("cityname")
    private String city_Name;

    @SerializedName ("state_name")
    private String state_name;

    @SerializedName ("state_code")
    private String state_code;

    @SerializedName ("is_booking")
    private String is_booking;


    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public String getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(String city_Id) {
        this.city_Id = city_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getIs_booking() {
        return is_booking;
    }

    public void setIs_booking(String is_booking) {
        this.is_booking = is_booking;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CityListModel{");
        sb.append("id='").append(id).append('\'');
        sb.append(", city_Id='").append(city_Id).append('\'');
        sb.append(", city_Name='").append(city_Name).append('\'');
        sb.append(", state_name='").append(state_name).append('\'');
        sb.append(", state_code='").append(state_code).append('\'');
        sb.append(", is_booking='").append(is_booking).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
