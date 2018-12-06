package com.example.sinjiung.woojinpay.BottomNaviBar;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sinjiung.woojinpay.Product.Item;
import com.example.sinjiung.woojinpay.Product.RecyclerAdapter;
import com.example.sinjiung.woojinpay.R;

import java.util.ArrayList;
import java.util.List;


public class home extends Fragment {
    RecyclerView ProductCase;
    RecyclerAdapter recyclerAdapter = new RecyclerAdapter();



    ArrayList<Item> items = new ArrayList<>();
    boolean view = true;boolean on = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //화면 inflate
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);

        if(view==true){
            setView(rootView, on);
            view= false;
            on=false;
        }
        view=true;
        return rootView;


    }

    public void setView(ViewGroup view, boolean off){

        ProductCase = (RecyclerView)view.findViewById(R.id.productCase);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext().getApplicationContext(), 2);
        ProductCase.setHasFixedSize(true);
        ProductCase.setLayoutManager(layoutManager);

        String[] url = getResources().getStringArray(R.array.productImage);
        String[] name = getResources().getStringArray(R.array.productName);
        String[] setA = new String[url.length];
        Item[] list = new Item[url.length];

        if(off==true){
            for(int i =0;i<url.length;i++){
                list[i]=new Item(url[i], name[i]);
                items.add(list[i]);
            }
        }


        ProductCase.setAdapter(recyclerAdapter);


            recyclerAdapter.setItems(items);

    }
}
