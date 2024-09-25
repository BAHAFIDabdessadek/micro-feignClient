package com.coca2.feignToOtherMicro;

import com.coca2.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-micro",fallbackFactory = FallBackFactory.class )
public interface ProductMicroFeign {

  //  @CircuitBreaker(name ="productCircuitBreaker" , fallbackMethod = "fallback" )
    @GetMapping("api/product/")
    List<Product> getProduct();

    @PostMapping("/api/product")
    public String addProduct( String name);

    /*  default List<Product> fallback(Throwable throwable) {
        System.out.println("Fallback triggered due to: " + throwable.getMessage());
        return Collections.emptyList(); // Return an empty list or some default response
    }*/

    public String dr();
}



