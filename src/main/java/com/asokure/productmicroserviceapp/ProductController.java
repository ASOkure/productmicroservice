package com.asokure.productmicroserviceapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    List<ProductInfo> productList = new ArrayList<ProductInfo>();

    @GetMapping("/product/details/{productid}")
    public Product getProductDetails(@PathVariable Long productid) {

        ProductInfo productInfo = getProductInfo(productid);

        return new Product(productInfo.getProductID(), productInfo.getProductName(), productInfo.getProductDesc(), 999, true);
    }

    private ProductInfo getProductInfo(Long productid) {
        populateProductList();

        for(ProductInfo p : productList){

            if(productid.equals(p.getProductID())){

                return p;
            }
        }

        return null;
    }

    private void populateProductList() {
        productList.add(new ProductInfo(101L, "iphone", "iphone is damn expensive"));
        productList.add(new ProductInfo(102L, "Book", "The Book is great"));
        productList.add(new ProductInfo(103L, "Washing Machine", "washing machine is necessary"));

    }

}