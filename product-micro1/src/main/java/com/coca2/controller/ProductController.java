package com.coca2.controller;

import com.coca2.model.Product;
import com.coca2.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    public final IProductService iProductService;

    @PostMapping()
    public String addProduct(@RequestBody String name){
        iProductService.addProduct(name);
        return "Added with success";
    }

    @GetMapping("/")
    public List<Product> getProduct(){
        return iProductService.getAll();
    }
}
