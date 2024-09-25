package com.coca2.feignToOtherMicro;

import com.coca2.model.Product;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class FallBackFactory implements FallbackFactory<ProductMicroFeign> {

    @Override
    public ProductMicroFeign create(Throwable cause) {
        return new ProductMicroFeign() {

            @Override
            public List<Product> getProduct() {
                if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
                    log.info("Error 404: No data found!");
                    return new ArrayList<>();
                } else if (cause instanceof TimeoutException) {
                    log.info("Error: Request timed out!");
                    return new ArrayList<>();
                } else {
                    log.info("Error: Something went wrong, please try later.");
                    return new ArrayList<>();
                }
            }

            @Override
            public String addProduct(String name) {
                return null;
            }

            @Override
            public String dr() {
                return null;
            }


        };
    }
}
