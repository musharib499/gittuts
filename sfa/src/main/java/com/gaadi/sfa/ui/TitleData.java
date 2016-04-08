package com.gaadi.sfa.ui;

/**
 * Created by kanishroshan on 10/2/16.
 */
public class TitleData {
    private String title;
    private int iconid;

    public TitleData(String title, int iconid) {
        this.title = title;
        this.iconid = iconid;
    }

    public int getIconid() {
        return iconid;
    }

    public void setIconid(int iconid) {
        this.iconid = iconid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
