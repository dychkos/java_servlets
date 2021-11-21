package com.unrgo.javaee_1.model;

import com.unrgo.javaee_1.validation.CheckURL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Product {
    @NotNull
    private int id;
    @Pattern.List({@Pattern(regexp = "[A-Z][a-z]") , @Pattern(regexp = "[_A-z]")})
    private String title;
    @NotNull
    @Min(100)
    private int price;
    @Size(max=2000,min=15,message = "Name must contain from {min} to {max} letters")
    private String description;
    @CheckURL(protocol = "http",port = 1000,host = "localhost")
    private String imageURL;

    public Product(int id, String title, int price, String description, String imageURL) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.id = id;
        this.imageURL = imageURL;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Pattern(regexp = "[A-Z][a-z]") String title) {
        this.title = title;
    }

    @NotNull
    public int getPrice() {
        return price;
    }

    public void setPrice(@Min(150) int price) {
        this.price = price;
    }
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@Size(max=2000) String description) {
        this.description = description;
    }
}
