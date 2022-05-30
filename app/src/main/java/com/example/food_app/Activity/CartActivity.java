
package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.food_app.Adapter.SelectedProductsAdapter;
import com.example.food_app.Model.Popular;
import com.example.food_app.IChangeData;
import com.example.food_app.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private TextView txtTotal;
    private RecyclerView recyclerViewCart;
    private SelectedProductsAdapter adapter;
    private List<Popular> popularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        connect();

//        DescriptionActivity descriptionActivity = new DescriptionActivity(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CartActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCart.setLayoutManager(linearLayoutManager);
        adapter = new SelectedProductsAdapter();
        popularList=CartManager.instant().getPopularList();
        recyclerViewCart.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setData(popularList);
        Log.d("AAA",popularList.toString());
    }



    private void connect(){
        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        recyclerViewCart = (RecyclerView) findViewById(R.id.recyclerViewProducts);
    }

//    @Override
//    public void changeData(Popular popular) {
//        popularList.add(new Popular(popular.getpTitle(),popular.getpPrice(),popular.getpImage()));
//    }
}