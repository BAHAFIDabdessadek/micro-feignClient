package com.coca2.controller;

import com.coca2.feignToOtherMicro.ProductMicroFeign;
import com.coca2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class orderController {

    public final ProductMicroFeign productMicroFeign;

    @GetMapping()
    public List<Product> allProduct(){
        return productMicroFeign.getProduct();
    }

    @PostMapping()
    public String addProduct(@RequestBody String name){
        productMicroFeign.addProduct(name);
        return "added with success";
    }

}
