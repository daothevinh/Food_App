package com.example.food_app.Model;

import java.io.Serializable;

public class Products implements Serializable {
    private String pFoodName;
    private String pPrice;
    private int pImage;
    private int numberOder;


    public Products(String pFoodName, String pPrice, int pImage) {
        this.pFoodName = pFoodName;
        this.pPrice = pPrice;
        this.pImage = pImage;
    }

    public int getNumberOder() {
        return numberOder;
    }

    public void setNumberOder(int numberOder) {
        this.numberOder = numberOder;
    }


    public String getpFoodName() {
        return pFoodName;
    }

    public void setpFoodName(String pFoodName) {
        this.pFoodName = pFoodName;
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
