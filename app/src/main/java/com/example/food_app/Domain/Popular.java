package com.example.food_app.Domain;

import java.io.Serializable;

public class Popular implements Serializable {
    private String pTitle;
    private String pPrice;
    private int pImage;
    private int numberOder;


    public Popular(String pTitle, String pPrice, int pImage) {
        this.pTitle = pTitle;
        this.pPrice = pPrice;
        this.pImage = pImage;
    }

    public int getNumberOder() {
        return numberOder;
    }

    public void setNumberOder(int numberOder) {
        this.numberOder = numberOder;
    }


    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public int getpImage() {
        return pImage;
    }

    public void setpImage(int pImage) {
        this.pImage = pImage;
    }
}
