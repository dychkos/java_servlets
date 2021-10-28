package com.unrgo.javaee_1.model;

import com.unrgo.javaee_1.helpers.IdGenerator;

import javax.inject.Inject;

public class Product {
    private int id;
    private String title;
    private int price;

    public Product(int id, String title, int price) {
        this.title = title;
        this.price = price;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
