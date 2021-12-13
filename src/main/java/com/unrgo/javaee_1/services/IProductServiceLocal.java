package com.unrgo.javaee_1.services;

import com.unrgo.javaee_1.model.Product;

import javax.ejb.Local;

public interface IProductServiceLocal {
    @Local
    public interface ViolationService {
        public Product createProduct(String title,int price,String description);
    }
}
