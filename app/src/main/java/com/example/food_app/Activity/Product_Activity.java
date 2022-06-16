package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.food_app.Adapter.Product_Adapter;
import com.example.food_app.Model.Products;
import com.example.food_app.R;

import java.util.ArrayList;
import java.util.List;

public class Product_Activity extends AppCompatActivity {
    private RecyclerView recyclerView_Object;
    private TextView txtNameObject;
    private Product_Adapter product_adapter;
    private List<Products> productsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();
        String key = intent.getStringExtra("name_object");
        init();

        product_adapter = new Product_Adapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_Object.setLayoutManager(linearLayoutManager);

            productsList = getData(key);
            txtNameObject.setText(key);

        product_adapter.setData(productsList);
        recyclerView_Object.setAdapter(product_adapter);
    }

    private List<Products> getData(String key) {
        List<Products> list = new ArrayList<>();
        switch(key){
            case "Pizza":
                list.add(new Products("Pepperoni pizza", "9.76", R.drawable.pizza1));
                list.add(new Products("Vegetable pizza", "8.5", R.drawable.pizza2));
                list.add(new Products("Beef pizza", "10.75", R.drawable.pizza_bo));
                list.add(new Products("Chicken pizza", "10.5", R.drawable.pizza_ga));
                list.add(new Products("Seafood pizza", "11", R.drawable.pizza_haisan));
                list.add(new Products("Chinese sausage  pizza", "10.68", R.drawable.pizza_lapxuong));
                break;
            case "Burger":
                list.add(new Products("Cheese Burger", "7.79", R.drawable.burger));
                list.add(new Products("Cheese Chicken Burger", "8.79", R.drawable.bbq_cheese_chicken_burger));
                list.add(new Products("Potato Burger", "8.89", R.drawable.potato_burger));
                list.add(new Products("Crispy Chicken Burger", "9.26", R.drawable.crispy_chicken_burger));
                list.add(new Products("Beef Burger", "9.53", R.drawable.beef_burger_two_pieces));

                break;
            case "HotDog":
                list.add(new Products("Cheese HotDog", "9.53", R.drawable.hotdog));
                break;
            case "Drink":
                list.add(new Products("Orange Juice", "9.53", R.drawable.orange_juice));
                list.add(new Products("Seven Up", "9.53", R.drawable.seven_up));
                list.add(new Products("Pepsi", "9.53", R.drawable.pepsi));
                list.add(new Products("Coca Cola", "9.53", R.drawable.coca_cola));
                list.add(new Products("Nutriboost", "9.53", R.drawable.nutriboost));
                list.add(new Products("aquafina", "9.53", R.drawable.aquafina));
                break;
            case "Donut":

                break;

        }

        return list;
    }

    private void init() {
        recyclerView_Object = (RecyclerView) findViewById(R.id.recyclerViewNameObject);
        txtNameObject = (TextView) findViewById(R.id.textviewNameObject);

    }
}