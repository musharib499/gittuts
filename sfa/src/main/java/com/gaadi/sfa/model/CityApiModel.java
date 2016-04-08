package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ankitgarg on 04/07/15.
 */
public class CityApiModel extends GeneralResponseModel {

    @SerializedName("data")
    private ArrayList<CityListModel> cities;

    public ArrayList<CityListModel> getCities() {
        return cities;
    }

    public void setCities(ArrayList<CityListModel> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CityApiModel{");
        sb.append("cities=").append(cities);
        sb.append('}');
        return sb.toString();
    }
}
