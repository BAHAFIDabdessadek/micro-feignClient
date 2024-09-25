package com.coca2.service;

import com.coca2.dao.ProductRepository;
import com.coca2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService{

    public final ProductRepository productRepository;
    @Override
    public void addProduct(String name) {
        Product product =  Product.builder().name(name).build();
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {return productRepository.findAll();}
}
