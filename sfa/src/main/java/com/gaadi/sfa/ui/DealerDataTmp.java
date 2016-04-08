package com.gaadi.sfa.ui;

/**
 * Created by kanishroshan on 12/2/16.
 */
public class DealerDataTmp {
    String dealer_name,dealer_address,last_visit,lv_date,lv_time,follow_up,fu_date,fu_time;



    public String getDealer_name() {
        return dealer_name;
    }

    public void setDealer_name(String dealer_name) {
        this.dealer_name = dealer_name;
    }
    public String getDealer_address() {
        return dealer_address;
    }

    public void setDealer_address(String dealer_address) {
        this.dealer_address = dealer_address;
    }

    public String getFollow_up() {
        return follow_up;
    }

    public void setFollow_up(String follow_up) {
        this.follow_up = follow_up;
    }

    public String getFu_date() {
        return fu_date;
    }

    public void setFu_date(String fu_date) {
        this.fu_date = fu_date;
    }

    public String getFu_time() {
        return fu_time;
    }

    public void setFu_time(String fu_time) {
        this.fu_time = fu_time;
    }

    public String getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(String last_visit) {
        this.last_visit = last_visit;
    }

    public String getLv_date() {
        return lv_date;
    }

    public void setLv_date(String lv_date) {
        this.lv_date = lv_date;
    }

    public String getLv_time() {
        return lv_time;
    }

    public void setLv_time(String lv_time) {
        this.lv_time = lv_time;
    }

    public DealerDataTmp(String dealer_name, String dealer_address, String follow_up, String fu_date,
                         String fu_time, String last_visit, String lv_date, String lv_time) {

        this.dealer_name = dealer_name;
        this.dealer_address = dealer_address;
        this.follow_up = follow_up;
        this.fu_date = fu_date;
        this.fu_time = fu_time;
        this.last_visit = last_visit;
        this.lv_date = lv_date;
        this.lv_time = lv_time;
    }

}
