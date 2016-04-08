package com.gaadi.sfa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public class DataModel implements Serializable {
    @SerializedName("empId")
    private String emailId;

    @SerializedName("visitId")
    private String visitId;

    @SerializedName("otp")
    private String otp;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("data{");
        sb.append("empId='").append(emailId).append('\'');
        sb.append("visitId='").append(visitId).append('\'');
        sb.append(", otp='").append(otp).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
