package com.coca2.service;

import com.coca2.model.Product;

import java.util.List;

public interface IProductService {

    void addProduct(String name );

    List<Product> getAll();
}
