package com.asokure.productmicroserviceapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  List<ProductInfo> productList = new ArrayList<ProductInfo>();
    @GetMapping("/product/details/{productid}")
    public Product getProductInfo(@PathVariable Long productid){
// Get Name and Desc  from product service
        // Get price from  pricing service
        // Get Stock Availability from inventory service
        return new Product(productid, "iphone", "iphone is damn expensive", 999, true);
    }
}
