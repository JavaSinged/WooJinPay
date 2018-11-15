package com.example.sinjiung.woojinpay;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //화면 inflate
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }
}
