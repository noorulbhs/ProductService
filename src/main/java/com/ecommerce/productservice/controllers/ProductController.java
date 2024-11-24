package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //  http://localhost:8080/products/1  => get a single product with id = 1
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
        return productService.getProductById(productId);
    }

    //  http://localhost:8080/products => Get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<Product>();
    }
    //  http://localhost:8080/products  => Create a new Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    //  http://localhost:8080/products/1  => Delete the product with id = 1
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
    }

    //  http://localhost:8080/products/1  => Partial Update the product
    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long productId, @RequestBody Product product){
    }

    //  http://localhost:8080/products/1  => Replace the entire product
    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
    }
}
