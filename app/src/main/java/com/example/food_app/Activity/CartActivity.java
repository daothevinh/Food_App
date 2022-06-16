
package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_app.Adapter.ProductsAdapter_inCartActivity;
import com.example.food_app.Model.Products;
import com.example.food_app.IChangeData;
import com.example.food_app.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private LinearLayout iconHome;
    private Button btnCheckOut;
    private TextView txtTotal, txtItemsTotal, txtDeliveryServices, txtTax;
    private RecyclerView recyclerViewCart;
    private ProductsAdapter_inCartActivity adapter;
    private List<Products> productsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        connect();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCart.setLayoutManager(linearLayoutManager);
        adapter = new ProductsAdapter_inCartActivity();
        productsList = CartManager.instant().getPopularList();
        recyclerViewCart.setAdapter(adapter);

        producttPayment();
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CartManager.instant().getPopularList() != null) {
                    CartManager.instant().remove();
                    Toast.makeText(CartActivity.this, "Your order has been placed successfully, thank you for your trust", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CartActivity.this, "Cart is empty, please select your item and come back", Toast.LENGTH_SHORT).show();
                }


            }
        });
        iconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    IChangeData iChangeData = new IChangeData() {
        @Override
        public void productPayment() {
            producttPayment();
        }

        @Override
        public void removeProduct(Products products) {
            CartManager.instant().removeProduct(products);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setData(productsList, iChangeData);
    }

    private void producttPayment() {
        float itemsTotal = 0;
        itemsTotal = CartManager.instant().productPayment(productsList);
        txtItemsTotal.setText(itemsTotal + "");

        float tax = (float) (Math.round((itemsTotal * 0.1) * 100.0) / 100.0);
        float total = (float) (Math.round(((itemsTotal + tax + 1) ) * 100.0) / 100.0);
        txtDeliveryServices.setText("1");
        txtTax.setText(tax+"");
        txtTotal.setText(total+"");
    }

    private void connect() {
        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        txtDeliveryServices = (TextView) findViewById(R.id.textViewTransportFee);
        txtTax = (TextView) findViewById(R.id.textViewTax);
        txtItemsTotal = (TextView) findViewById(R.id.textViewTotalProductsCost);
        recyclerViewCart = (RecyclerView) findViewById(R.id.recyclerViewProducts);
        btnCheckOut = (Button) findViewById(R.id.buttonCheckOut);
        iconHome = (LinearLayout) findViewById(R.id.iconHome);
    }


}