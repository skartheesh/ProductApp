package com.sample.com.hello.controller;


import com.sample.com.hello.entity.Product;
import com.sample.com.hello.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setProductName("bat");
        product.setProductCategory("sports");
        productList.add(product);
        Product product1 = new Product();
        product1.setProductName("maggi");
        product1.setProductCategory("groceries");
        productList.add(product1);
        Product product2 = new Product();
        product2.setProductName("chocolates");
        product2.setProductCategory("Edibles");

        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2);
        productList.add(product2);

       return productList;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productRepository.findById(id).get();
    }

}
