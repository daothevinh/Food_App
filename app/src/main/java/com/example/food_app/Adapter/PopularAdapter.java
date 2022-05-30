package com.example.food_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.Activity.DescriptionActivity;
import com.example.food_app.Model.Popular;
import com.example.food_app.R;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.popularViewHolder> {
    List<Popular> popularList;
    Context context;

    public PopularAdapter(List<Popular> popularList, Context context) {
        this.popularList = popularList;
        this.context = context;
    }

    @NonNull
    @Override
    public popularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_adapter, parent, false);
        return new popularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull popularViewHolder holder, int position) {
        Popular popular = popularList.get(position);

        holder.txtTitle.setText(popular.getpTitle());
        holder.txtPrice.setText(popular.getpPrice());
        holder.imgPopular.setImageResource(popular.getpImage());
        holder.clickAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_popular", popular);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (popularList != null) {
            return popularList.size();
        }
        return 0;
    }

    public class popularViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtPrice;
        ImageView imgPopular;
        ConstraintLayout clickAdd;

        public popularViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.textViewTitleDescription);
            txtPrice = (TextView) itemView.findViewById(R.id.textViewPricePopular);
            imgPopular = (ImageView) itemView.findViewById(R.id.imageViewPopular);
            clickAdd = (ConstraintLayout) itemView.findViewById(R.id.clickAddPopular);
        }
    }
}
