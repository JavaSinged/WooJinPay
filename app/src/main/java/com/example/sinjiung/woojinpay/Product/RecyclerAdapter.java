package com.example.sinjiung.woojinpay.Product;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sinjiung.woojinpay.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Item> items;
    Context context;
    int item_layout;

    public RecyclerAdapter(Context context,ArrayList<Item> items, int item_layout){
        this.context = context; this.items=items;this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Item item = items.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getUrl())
                .into(holder.image);

        holder.title.setText(item.getTitle());
        holder.price.setText(item.getPrice());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //장바구니에 추가하기
                


                //스낵바
                SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                snackbarText.append("장바구니에 ");
                int boldStart = snackbarText.length();
                snackbarText.append(item.getTitle());
                snackbarText.setSpan(new ForegroundColorSpan(0xFF00FF00), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.append("(이)가 추가되었습니다.");

                Snackbar.make(v, snackbarText, Snackbar.LENGTH_LONG).show();
                 }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

//    public void setItems(ArrayList<Item> items) {
//        this.items = items;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
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
