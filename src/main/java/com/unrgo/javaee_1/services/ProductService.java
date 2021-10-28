package com.unrgo.javaee_1.services;

import com.unrgo.javaee_1.helpers.EvenID;
import com.unrgo.javaee_1.helpers.IdGenerator;
import com.unrgo.javaee_1.model.Product;

import javax.inject.Inject;

public class ProductService {
    @Inject @EvenID
    private IdGenerator idGenerator;

    public Product createProduct(String title,int price){
        int product_id = idGenerator.generate();

        return new Product(product_id,title,price);

    }


}
