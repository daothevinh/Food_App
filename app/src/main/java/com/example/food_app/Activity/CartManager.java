package com.example.food_app.Activity;

import com.example.food_app.Model.Popular;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class CartManager {
    private static CartManager cartManager;

    private CartManager() {
    }

    public static CartManager instant() {
        if (cartManager == null) {
            cartManager = new CartManager();
        }
        return cartManager;
    }

    Hashtable<String,Popular> popularList = new Hashtable<>();

    public void addNewProduct(Popular popular) {
        popularList.put(popular.getpTitle(),popular);
    }

    public void removeProduct(Popular popular) {
        popularList.remove(popular.getpTitle());
    }

    public void remove() {
        popularList.clear();
    }

    public List<Popular> getPopularList() {
        return new ArrayList<>(popularList.values());
    }
}
