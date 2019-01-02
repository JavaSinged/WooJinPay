package com.example.sinjiung.woojinpay.ShoppingCart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sinjiung.woojinpay.Product.Item;
import com.example.sinjiung.woojinpay.Product.RecyclerAdapter;
import com.example.sinjiung.woojinpay.R;

import java.util.ArrayList;

public class AddRecyclerAdapter extends RecyclerView.Adapter<AddRecyclerAdapter.ViewHolder>{
    ArrayList<Item> items;
    Context context;
    int item_layout;

    public AddRecyclerAdapter(Context context,ArrayList<Item> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView title;
            TextView price;
            CardView cardview;

            public ViewHolder(View itemView) {
                super(itemView);
                image = (ImageView) itemView.findViewById(R.id.image);
                title = (TextView) itemView.findViewById(R.id.title);
                price = (TextView) itemView.findViewById(R.id.price);
                cardview = (CardView) itemView.findViewById(R.id.cardview);
            }
        }
    }