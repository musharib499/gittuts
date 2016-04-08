package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class BaseResponseModel implements Serializable{
    @SerializedName("error")
    private ArrayList<String> errors;

    @SerializedName("successText")
    private String successText="Failed";

    @SerializedName("serverDateTime")
    private String serverDateTime;

    @SerializedName("data")
    private DataModel dataModel;

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

    public DataModel getLoginData() {
        return dataModel;
    }

    public void setLoginData(DataModel loginData) {
        this.dataModel = loginData;
    }

    public boolean isResultSuccess() {
        return successText!=null && successText.equals("Success");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseResponseModel{");
        sb.append("error='").append(errors).append('\'');
        sb.append(", successText='").append(successText).append('\'');
        sb.append(", serverDateTime='").append(serverDateTime).append('\'');
        sb.append(", data='").append(dataModel == null ? "" : dataModel.toString()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
