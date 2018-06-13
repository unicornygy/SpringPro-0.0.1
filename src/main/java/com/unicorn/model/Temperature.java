package com.unicorn.model;

import java.util.Date;

public class Temperature {

    private String from;
    private int val;
    private Date date;

    public Temperature(String from, int val, Date date) {
        this.from = from;
        this.val = val;
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
