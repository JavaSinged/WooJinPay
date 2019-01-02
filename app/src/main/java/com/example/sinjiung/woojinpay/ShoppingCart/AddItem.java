package com.example.sinjiung.woojinpay.ShoppingCart;

public class AddItem {

    String title;
    String url;
    String price;

    public AddItem(String url, String title, String price) {
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
