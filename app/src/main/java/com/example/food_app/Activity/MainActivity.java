package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.food_app.Adapter.CategoriesAdapter;
import com.example.food_app.Adapter.PopularAdapter;
import com.example.food_app.Model.Categories;
import com.example.food_app.Model.Popular;
import com.example.food_app.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout iconCart;
    private CategoriesAdapter categoryAdapter;
    private PopularAdapter popularAdapter;
    private RecyclerView recyclerViewCategory,recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();
        recyclerViewCategory();
        recyclerViewPopular();

        iconCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopular = (RecyclerView) findViewById(R.id.recyclerViewPopular);
        recyclerViewPopular.setLayoutManager(linearLayoutManager);
        List<Popular> list = new ArrayList<>();
        list.add(new Popular("Pepperoni pizza","9.76",R.drawable.pizza1));
        list.add(new Popular("Vegetable pizza","8.5",R.drawable.pizza2));
        list.add(new Popular("Cheese Burger","8.79",R.drawable.burger));

        popularAdapter = new PopularAdapter(list,this);
        recyclerViewPopular.setAdapter(popularAdapter);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory = (RecyclerView) findViewById(R.id.recyclerViewCategory);
        categoryAdapter = new CategoriesAdapter(this);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());

        recyclerViewCategory.setAdapter(categoryAdapter);
    }

    private List<Categories> getListCategory() {
        List<Categories> list = new ArrayList<>();
        list.add(new Categories("Pizza", R.drawable.cat_1));
        list.add(new Categories("Burger", R.drawable.cat_2));
        list.add(new Categories("Hotdog", R.drawable.cat_3));
        list.add(new Categories("Drink", R.drawable.cat_4));
        list.add(new Categories("Dount", R.drawable.cat_5));
        return list;
    }
    private void connect(){
        iconCart = (LinearLayout) findViewById(R.id.iconCart);
    }
}