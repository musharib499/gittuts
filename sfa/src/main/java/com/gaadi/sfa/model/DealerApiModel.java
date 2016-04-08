package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class DealerApiModel extends GeneralResponseModel{

    @SerializedName("dealers")
    private ArrayList<DealerModel> dealers;

    public ArrayList<DealerModel> getDealers() {
        return dealers;
    }

    public void setDealers(ArrayList<DealerModel> dealers) {
        this.dealers = dealers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DealerApiModel{");
        sb.append("dealers=").append(dealers);
        sb.append('}');
        return sb.toString();
    }
}
