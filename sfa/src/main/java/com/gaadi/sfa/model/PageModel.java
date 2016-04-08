package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class PageModel implements Serializable {
    @SerializedName("count")
    private String count;

    @SerializedName("recordPerPage")
    private String recordPerPage;

    @SerializedName("hasNext")
    private boolean hasNext;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(String recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
