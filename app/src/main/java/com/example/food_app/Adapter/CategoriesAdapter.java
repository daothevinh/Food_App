package com.example.food_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.Model.Categories;
import com.example.food_app.R;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.categoriesViewHolder> {
    private Context cContext;
    private List<Categories> categoriesList;

    public CategoriesAdapter(Context cContext) {
        this.cContext = cContext;
    }

    public void setData(List<Categories> list) {
        this.categoriesList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public categoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_adapter, parent, false);
        return new categoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoriesViewHolder holder, int position) {
        Categories category = categoriesList.get(position);
        holder.txtCategory.setText(category.getcTitle());
        holder.imgCategory.setImageResource(category.getcImage());
    }

    @Override
    public int getItemCount() {
        if (categoriesList != null) {
            return categoriesList.size();
        }
        return 0;
    }

    public class categoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        TextView txtCategory;

        public categoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = (ImageView) itemView.findViewById(R.id.imageCategory);
            txtCategory = (TextView) itemView.findViewById(R.id.textViewCategory);
        }
    }
}
