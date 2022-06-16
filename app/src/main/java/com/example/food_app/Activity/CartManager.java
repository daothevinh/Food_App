package com.example.food_app.Activity;

import android.util.Log;

import com.example.food_app.Model.Products;
import com.example.food_app.R;

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


    Hashtable<String, Products> popularList = new Hashtable<>();

    public void addNewProduct(Products products) {
        popularList.put(products.getpFoodName(), products);
    }

    public void removeProduct(Products products) {
        popularList.remove(products.getpFoodName());
    }

    public void remove() {
        popularList.clear();
    }

    public List<Products> getPopularList() {
        if (popularList.isEmpty() || popularList.values() == null) {
            return null;
        }
        return new ArrayList<>(popularList.values());
    }

    public float productPayment(List<Products> productsList) {
        float itemsTotal = 0;
        int sizeProductList = 0;
        if (productsList != null) {
            sizeProductList = productsList.size();
        }

        for (int i = 0; i < sizeProductList; i++) {
            itemsTotal = payPerProduct(productsList, sizeProductList, itemsTotal, i);
        }
        return itemsTotal = (float) (Math.round(itemsTotal * 100.0) / 100.0);
    }

    private float payPerProduct(List<Products> productsList, int sizeProductList, float totalOrderAmount, int i) {
        totalOrderAmount = totalOrderAmount + (productsList.get(i).getNumberOder()) * Float.parseFloat(productsList.get(i).getpPrice());
        return totalOrderAmount;
    }


}
