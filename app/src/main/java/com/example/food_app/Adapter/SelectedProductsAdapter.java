package com.example.food_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.Model.Popular;
import com.example.food_app.R;

import java.util.List;

public class SelectedProductsAdapter extends RecyclerView.Adapter<SelectedProductsAdapter.SelectedProductsViewHolder>{
    private Context context;
    private List<Popular> popularList;

    public void setData(List<Popular> list){
        this.popularList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SelectedProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(context==null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.selected_products_adapter,parent,false);
        return new SelectedProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedProductsViewHolder holder, int position) {
        Popular popular = popularList.get(position);
        if (popular == null ){
            return;
        }
        holder.imgSelectProduct.setImageResource(popular.getpImage());
        String holderString = popular.getNumberOder()+"";
        holder.txtNumber.setText(holderString);
    }

    @Override
    public int getItemCount() {
        if(popularList != null){
            return popularList.size();
        }
        return 0;
    }

    public class SelectedProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSelectProduct,imgPlus,imgMinus;
        TextView txtNumber;

        public SelectedProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSelectProduct = (ImageView) itemView.findViewById(R.id.imageSelectProduct);
            imgPlus = (ImageView) itemView.findViewById(R.id.imageViewPlusSelectProduct);
            imgMinus = (ImageView) itemView.findViewById(R.id.imageViewMinusSelectProduct);
            txtNumber = (TextView) itemView.findViewById(R.id.textViewNumberOderSelectProduct);

        }
    }
}
