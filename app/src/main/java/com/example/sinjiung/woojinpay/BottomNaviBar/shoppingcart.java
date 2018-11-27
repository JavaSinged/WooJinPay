package com.example.sinjiung.woojinpay.BottomNaviBar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sinjiung.woojinpay.R;


public class shoppingcart extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //화면 inflate
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_shoppingcart, container, false);

        return rootView;
    }
}
