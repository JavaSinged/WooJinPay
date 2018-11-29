package com.example.sinjiung.woojinpay.BottomNaviBar;

import android.content.Context;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.sinjiung.woojinpay.Product.Item;
import com.example.sinjiung.woojinpay.Product.ProductImage;
import com.example.sinjiung.woojinpay.Product.RecyclerAdapter;
import com.example.sinjiung.woojinpay.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class home extends Fragment {

    RecyclerView ProductCase;
    RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //화면 inflate
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);
        ProductCase = (RecyclerView)rootView.findViewById(R.id.productCase);


        GridLayoutManager layoutManager = new GridLayoutManager(getContext().getApplicationContext(), 2);
        ProductCase.setHasFixedSize(true);
        ProductCase.setLayoutManager(layoutManager);
        ProductCase.setAdapter(recyclerAdapter);

        recyclerAdapter.setItems(new ProductImage().getItems());

        return rootView;
    }
}
