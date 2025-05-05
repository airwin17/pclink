package com.infomega.pclink.model;

public class BusinessDay {
    private String days;
    private String mornig;
    private String evening;
    public BusinessDay(String day, String mornig, String evening) {
        this.days = day;
        this.mornig = mornig;
        this.evening = evening;
    }
    public BusinessDay() {
    }
    public String getDay() {
        return days;
    }
    public void setDay(String day) {
        this.days = day;
    }
    public String getMornig() {
        return mornig;
    }
    public void setMornig(String mornig) {
        this.mornig = mornig;
    }
    public String getEvening() {
        return evening;
    }
    public void setEvening(String evening) {
        this.evening = evening;
    }
    @Override
    public String toString() {
        return "BusinessDay [days=" + days + ", evening=" + evening + ", mornig=" + mornig
                + "]";
    }
}
