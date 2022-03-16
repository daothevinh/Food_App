package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.food_app.Adapter.CategoriesAdapter;
import com.example.food_app.Domain.Categories;
import com.example.food_app.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CategoriesAdapter categoryAdapter;
    private RecyclerView recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
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
}