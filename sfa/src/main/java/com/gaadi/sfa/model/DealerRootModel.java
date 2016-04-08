package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vinodtakhar on 18/2/16.
 */
public class DealerRootModel implements Serializable {
    @SerializedName("error")
    private ArrayList<String> errors;

    @SerializedName("successText")
    private String successText="Failed";

    @SerializedName("serverDateTime")
    private String serverDateTime;

    @SerializedName("data")
    private DealerApiModel dealerApiModel;

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public String getSuccessText() {
        return successText;
    }

    public void setSuccessText(String successText) {
        this.successText = successText;
    }

    public String getServerDateTime() {
        return serverDateTime;
    }

    public void setServerDateTime(String serverDateTime) {
        this.serverDateTime = serverDateTime;
    }

    public DealerApiModel getDealerApiModel() {
        return dealerApiModel;
    }

    public void setDealerApiModel(DealerApiModel dealerApiModel) {
        this.dealerApiModel = dealerApiModel;
    }
}
