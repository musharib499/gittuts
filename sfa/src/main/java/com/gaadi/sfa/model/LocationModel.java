package com.gaadi.sfa.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class LocationModel implements Serializable {
    @SerializedName("area")
    private String area;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName ("longitude")
    private String longitude;


    public LatLng getLatLng(){
        if(latitude==null || latitude.isEmpty() || longitude==null || longitude.isEmpty())return null;
        else return new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));
    }

    public String getArea() {
        return area;
    }

    public LocationModel setArea(String area) {
        this.area = area;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public LocationModel setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public LocationModel setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public boolean equalsLocation(LatLng position) {
       return position.equals(getLatLng());
    }
}
