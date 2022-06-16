package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_app.Model.Products;
import com.example.food_app.R;

public class DescriptionActivity extends AppCompatActivity {

    private ImageView imgFoodDescription, imgPlusDescription, imgMinusDescription;
    private TextView txtTitleDescription, txtDollarDescription, txtNumberOderDescription, txtDescription;
    private Button btnAddToCartDescription;
    private int number = 1;
    private float price = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Products products = (Products) bundle.getSerializable("product");

        connect();



        txtTitleDescription.setText(products.getpFoodName());
        txtDollarDescription.setText(products.getpPrice() + " $");
        imgFoodDescription.setImageResource(products.getpImage());
        price = Float.parseFloat(products.getpPrice());
        products.setNumberOder(number);


        imgPlusDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                price = Float.parseFloat(products.getpPrice()) * number;
                products.setNumberOder(number);
                txtNumberOderDescription.setText(number + "");
                txtDollarDescription.setText(price + " $");
            }
        });
        imgMinusDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number > 1) {
                    number--;
                    products.setNumberOder(number);
                    price = Float.parseFloat(products.getpPrice()) * number;
                    txtNumberOderDescription.setText(number + "");
                    txtDollarDescription.setText(price + " $");
                }
            }
        });

        btnAddToCartDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartManager.instant().addNewProduct(products);
                Toast.makeText(DescriptionActivity.this, "added to cart", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void connect() {
        imgPlusDescription = (ImageView) findViewById(R.id.imageViewPlusDescription);
        imgMinusDescription = (ImageView) findViewById(R.id.imageViewMinusDescription);
        imgFoodDescription = (ImageView) findViewById(R.id.imageViewDescription);
        txtTitleDescription = (TextView) findViewById(R.id.textViewTitleDescription);
        txtDollarDescription = (TextView) findViewById(R.id.textViewDollarDescription);
        txtNumberOderDescription = (TextView) findViewById(R.id.textViewNumberOderDescription);
        txtDescription = (TextView) findViewById(R.id.textViewDescription);
        btnAddToCartDescription = (Button) findViewById(R.id.buttonAddToCartDescription);

    }


}