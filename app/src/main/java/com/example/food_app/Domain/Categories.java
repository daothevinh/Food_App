package com.example.food_app.Domain;

public class Categories {
    String cTitle;
    int cImage;

    public Categories(String cTitle, int cImage) {
        this.cTitle = cTitle;
        this.cImage = cImage;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public int getcImage() {
        return cImage;
    }

    public void setcImage(int cImage) {
        this.cImage = cImage;
    }
}
