package com.bnull.yourreview.models;

import com.bnull.yourreview.R;

import java.io.Serializable;

public class Note implements Serializable {

    private String name;
    private String text;
    private String date;
    private int type;

    public Note(String name, String text, String date, int type) {
        this.name = name;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public int getType() {
        return type;
    }

    public int getColor() {
        switch (type) {
            case 0:
                return R.color.Red;
            case 1:
                return R.color.Orange;
            case 2:
                return R.color.Yellow;
            case 3:
                return R.color.LightGreen;
            default:
                return R.color.Green;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setType(int type) {
        this.type = type;
    }
}
