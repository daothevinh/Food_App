package com.example.food_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_app.Model.Popular;
import com.example.food_app.IChangeData;
import com.example.food_app.R;

public class DescriptionActivity extends AppCompatActivity {

    private ImageView imgFoodDescription, imgPlusDescription, imgMinusDescription;
    private TextView txtTitleDescription, txtDollarDescription, txtNumberOderDescription, txtDescription;
    private Button btnAddToCartDescription;
    private int number = 1;
    private float price = 1;

//    public void setAnIChangeData(IChangeData anIChangeData) {
//        this.anIChangeData = anIChangeData;
//    }

    private IChangeData anIChangeData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Popular popular = (Popular) bundle.getSerializable("object_popular");

        connect();



        txtTitleDescription.setText(popular.getpTitle());
        txtDollarDescription.setText(popular.getpPrice() + " $");
        imgFoodDescription.setImageResource(popular.getpImage());
        number = popular.getNumberOder();
        price = Float.parseFloat(popular.getpPrice());

        imgPlusDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                price = Float.parseFloat(popular.getpPrice()) * number;
                popular.setNumberOder(number);
                txtNumberOderDescription.setText(number + "");
                txtDollarDescription.setText(price + " $");
            }
        });
        imgMinusDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number > 1) {
                    number--;
                    popular.setNumberOder(number);
                    price = Float.parseFloat(popular.getpPrice()) * number;
                    txtNumberOderDescription.setText(number + "");
                    txtDollarDescription.setText(price + " $");
                }
            }
        });

        btnAddToCartDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartManager.instant().addNewProduct(popular);
                Toast.makeText(DescriptionActivity.this, "added to cart", Toast.LENGTH_SHORT).show();
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