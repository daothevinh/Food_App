package com.example.food_app.Activity;

import androidx.room.Insert;

import com.example.food_app.Model.Products;

public interface DAO {

    @Insert
    void insertProduct(Products products);
}
