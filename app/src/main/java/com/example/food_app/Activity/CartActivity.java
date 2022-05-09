
package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.food_app.Adapter.SelectedProductsAdapter;
import com.example.food_app.Domain.Popular;
import com.example.food_app.IChangeData;
import com.example.food_app.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements IChangeData{
    TextView txtTotal;
    RecyclerView recyclerViewCart;
    SelectedProductsAdapter adapter;
    List<Popular> popularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        connect();
        txtTotal = (TextView) findViewById(R.id.textViewTotal);

//        DescriptionActivity descriptionActivity = new DescriptionActivity(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CartActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCart.setLayoutManager(linearLayoutManager);
        adapter = new SelectedProductsAdapter();
        adapter.setData(setData());
        recyclerViewCart.setAdapter(adapter);

    }

    private List<Popular> setData() {
        return popularList;
    }

    private void connect(){
        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        recyclerViewCart = (RecyclerView) findViewById(R.id.recyclerViewProducts);
    }

    @Override
    public void changeData(Popular popular) {
        popularList.add(new Popular(popular.getpTitle(),popular.getpPrice(),popular.getpImage()));
    }
}