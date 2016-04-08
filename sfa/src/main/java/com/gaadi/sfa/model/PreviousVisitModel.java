package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class PreviousVisitModel extends DateTimeModel {
    @SerializedName("comments")
    private String comments;

    @SerializedName("checkin")
    private String checkin;

    @SerializedName("checkout")
    private String checkout;


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
