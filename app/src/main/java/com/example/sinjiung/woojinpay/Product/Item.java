package com.example.sinjiung.woojinpay.Product;

public class Item {

    String title;
    String url;
    String price;

    public Item(String url, String title, String price) {
        this.title = title;
        this.url = url;
        this.price=price;
    }


    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }

}
