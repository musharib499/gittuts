package com.gaadi.sfa.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class DealerModel extends LocationModel{
    @SerializedName("dealerId")
    private String dealerId;

    @SerializedName("dealerName")
    private String dealerName;

    @SerializedName("previousVisits")
    private ArrayList<PreviousVisitModel> lastVisitModel;

    @SerializedName("followUps")
    private ArrayList<FollowUpModel> followUpModel;

    @SerializedName("assigned")
    private boolean assigned;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("gcloudToken")
    private String loginToken;

    public String getLoginToken() {
        return loginToken;
    }

    public DealerModel setLoginToken(String loginToken) {
        this.loginToken = loginToken;
        return this;
    }

    public String getDealerId() {
        return dealerId;
    }

    public DealerModel setDealerId(String dealerId) {
        this.dealerId = dealerId;
        return this;
    }

    public String getDealerName() {
        return dealerName;
    }

    public DealerModel setDealerName(String dealerName) {
        this.dealerName = dealerName;
        return this;
    }

    public ArrayList<PreviousVisitModel> getLastVisitModel() {
        return lastVisitModel;
    }

    public DealerModel setLastVisitModel(ArrayList<PreviousVisitModel>lastVisitModel) {
        this.lastVisitModel = lastVisitModel;
        return this;
    }

    public ArrayList<FollowUpModel> getFollowUpModel() {
        return followUpModel;
    }

    public DealerModel setFollowUpModel(ArrayList<FollowUpModel> followUpModel) {
        this.followUpModel = followUpModel;
        return this;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public DealerModel setAssigned(boolean assigned) {
        this.assigned = assigned;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public DealerModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
