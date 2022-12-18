package com.example.mymarket.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mymarket.ProductDetails;
import com.example.mymarket.R;
import com.example.mymarket.productDBHelper;

import java.util.List;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.UserViewHolder>{
    List<ProductDetails> productDetailsList;
    Context context;
    productDBHelper dbHelper;
    SQLiteDatabase db;
    public ProductDetailsAdapter(List<ProductDetails> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View iteView = inflater.inflate(R.layout.activity_panier, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(iteView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        ProductDetails productDetails = productDetailsList.get(position);
        holder.tvName.setText(productDetails.getName());
        holder.tvPrice.setText(productDetails.getPrice());
        holder.tvQuantite.setText(productDetails.getQuantite());


    }
    @Override
    public int getItemCount() {
        return productDetailsList.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvQuantite;
        ImageView tvImage;
        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvQuantite = (TextView) itemView.findViewById(R.id.tv_quantite);

        }
    }
}
