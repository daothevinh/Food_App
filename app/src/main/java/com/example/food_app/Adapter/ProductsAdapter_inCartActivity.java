package com.example.food_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.IChangeData;
import com.example.food_app.Model.Products;
import com.example.food_app.R;

import java.util.List;

public class ProductsAdapter_inCartActivity extends RecyclerView.Adapter<ProductsAdapter_inCartActivity.SelectedProductsViewHolder> {
    private Context context;
    private List<Products> productsList;
    private IChangeData iChangeData;

    public void setData(List<Products> list, IChangeData iChangeData) {
        this.iChangeData = iChangeData;
        this.productsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SelectedProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.products_adapter_incartactivity, parent, false);
        return new SelectedProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedProductsViewHolder holder, int position) {
        Products products = productsList.get(position);
        if (products == null) {
            return;
        }
        holder.imgSelectProduct.setImageResource(products.getpImage());
        String holderString = products.getNumberOder() + "";
        holder.txtNumber.setText(holderString);

        holder.imgMinusNumberOrderProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (products.getNumberOder() > 0) {
                    products.setNumberOder(products.getNumberOder() - 1);
                    iChangeData.productPayment();
                } else {
                    productsList.remove(position);
                    iChangeData.removeProduct(products);
                }
                notifyDataSetChanged();
            }
        });
        holder.imgPlusNumberOrderProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products.setNumberOder(products.getNumberOder() + 1);
                iChangeData.productPayment();
                notifyDataSetChanged();
            }
        });
        holder.txtFoodName.setText(products.getpFoodName());
        holder.txtPrice.setText(products.getpPrice());

        float totalAmountOfEachProduct = (products.getNumberOder()) * Float.parseFloat(products.getpPrice());
        totalAmountOfEachProduct = (float) (Math.round(totalAmountOfEachProduct * 100.0) / 100.0);
        holder.txtTotalAmountOfEachProduct.setText(totalAmountOfEachProduct + "");

    }
//    private void removeProduct(Popular popular){
//        CartManager.instant().removeProduct(popular);
//        notifyDataSetChanged();
//    }

    @Override
    public int getItemCount() {
        if (productsList != null) {
            return productsList.size();
        }
        return 0;
    }

    public class SelectedProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSelectProduct, imgPlusNumberOrderProduct, imgMinusNumberOrderProduct;
        TextView txtNumber, txtTotalAmountOfEachProduct, txtFoodName, txtPrice;

        public SelectedProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSelectProduct = (ImageView) itemView.findViewById(R.id.imageSelectProduct);
            imgPlusNumberOrderProduct = (ImageView) itemView.findViewById(R.id.imageViewPlusSelectProduct);
            imgMinusNumberOrderProduct = (ImageView) itemView.findViewById(R.id.imageViewMinusSelectProduct);
            txtNumber = (TextView) itemView.findViewById(R.id.textViewNumberOderSelectProduct);
            txtTotalAmountOfEachProduct = (TextView) itemView.findViewById(R.id.textViewTotalAmountOfEachProduct);
            txtFoodName = (TextView) itemView.findViewById(R.id.textViewFoodName);
            txtPrice = (TextView) itemView.findViewById(R.id.textViewPrice_SelectProduct);
        }
    }
}
