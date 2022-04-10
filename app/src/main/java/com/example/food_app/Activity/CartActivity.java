
package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_app.Domain.Popular;
import com.example.food_app.IChangeData;
import com.example.food_app.R;

public class CartActivity extends AppCompatActivity {
    TextView txtTotal;

    Popular popular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        txtTotal = (TextView) findViewById(R.id.textViewTotal);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Popular popular = (Popular) bundle.getSerializable("ob_popular");

        txtTotal.setText(popular.getNumberOder()+"");
    }
}