package com.example.sinjiung.woojinpay.Product;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class Item {

    String title;
    String url;

    public Item(String url, String title) {
        this.title = title;
        this.url = url;
    }


    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }
}
