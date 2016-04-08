package com.gaadi.sfa.model;

/**
 * Created by kanishroshan on 17/2/16.
 */
public class MyVisitsModel {
    String organizationname, organizationaddress, checkintime, chheckouttime, workleft;

    public String getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(String checkintime) {
        this.checkintime = checkintime;
    }

    public String getChheckouttime() {
        return chheckouttime;
    }

    public void setChheckouttime(String chheckouttime) {
        this.chheckouttime = chheckouttime;
    }

    public String getOrganizationaddress() {
        return organizationaddress;
    }

    public void setOrganizationaddress(String organizationaddress) {
        this.organizationaddress = organizationaddress;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public String getWorkleft() {
        return workleft;
    }

    public void setWorkleft(String workleft) {
        this.workleft = workleft;
    }
}
