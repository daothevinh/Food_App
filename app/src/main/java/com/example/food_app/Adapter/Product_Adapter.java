package com.example.food_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.Activity.DescriptionActivity;
import com.example.food_app.Model.Products;
import com.example.food_app.R;

import java.util.List;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.ViewHolderProduct> {
    private List<Products> productsList;
    private Context context;

    public void setData(List<Products> list) {
        this.productsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_adapter, parent, false);

        return new ViewHolderProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct holder, int position) {
        Products product = productsList.get(position);
        if (product == null) {
            return;
        }
        holder.imgProduct.setImageResource(product.getpImage());
        holder.txtNameProduct.setText(product.getpFoodName());
        holder.txtPriceProduct.setText(product.getpPrice());

        holder.itemProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (productsList != null) {
            return productsList.size();
        }
        return 0;
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtNameProduct, txtPriceProduct;
        CardView itemProduct;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);
            imgProduct = (ImageView) itemView.findViewById(R.id.imageViewProduct_ProductAdapter);
            txtNameProduct = (TextView) itemView.findViewById(R.id.textViewNameProduct_ProductAdapter);
            txtPriceProduct = (TextView) itemView.findViewById(R.id.textViewPriceProduct_ProductAdapter);
            itemProduct = (CardView) itemView.findViewById(R.id.itemProduct_ProductAdapter);
        }
    }
}
