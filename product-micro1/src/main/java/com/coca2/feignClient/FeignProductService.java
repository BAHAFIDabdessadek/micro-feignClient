package com.coca2.feignClient;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-micro")
public interface FeignProductService {

}
