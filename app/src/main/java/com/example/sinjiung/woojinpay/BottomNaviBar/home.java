package com.example.sinjiung.woojinpay.BottomNaviBar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.sinjiung.woojinpay.Product.Item;
import com.example.sinjiung.woojinpay.Product.RecyclerAdapter;
import com.example.sinjiung.woojinpay.R;

import java.util.ArrayList;
import java.util.List;


public class home extends Fragment {

    RecyclerView ProductCase;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //화면 inflate
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);
        ProductCase = (RecyclerView)rootView.findViewById(R.id.productCase);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext().getApplicationContext(), 2);
        ProductCase.setHasFixedSize(true);
        ProductCase.setLayoutManager(layoutManager);

        List<Item> items = new ArrayList<>();
        Item[] item = new Item[3];
        item[0] = new Item(R.drawable.ic_home_black_24dp, "#1");
        item[1] = new Item(R.drawable.ic_launcher_background, "#2");
        item[2] = new Item(R.drawable.ic_power_settings_new_black_24dp, "#3");
        for(int i=0;i<3;i++){
            items.add(item[i]);
        }
        ProductCase.setAdapter(new RecyclerAdapter(getContext().getApplicationContext(), items,R.layout.fragment_home));
        return rootView;
    }
}
