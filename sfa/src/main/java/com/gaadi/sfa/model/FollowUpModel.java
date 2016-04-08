package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class FollowUpModel extends DateTimeModel{
    @SerializedName("comments")
    private String comments;

    @SerializedName ("overdue")
    private boolean overdue;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }
}
