package com.unrgo.javaee_1.services;

import com.unrgo.javaee_1.model.Product;

import javax.ejb.Remote;

public interface IProductServiceRemote {
    @Remote
    public interface ViolationService {
        public Product createProduct(String title,int price,String description);
    }
}
