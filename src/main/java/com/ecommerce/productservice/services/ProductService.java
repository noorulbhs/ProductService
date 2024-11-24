package com.ecommerce.productservice.services;

import com.ecommerce.productservice.models.Product;

import java.util.List;


public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    void updateProduct(Long id, Product product);
    void replaceProduct(Long id, Product product);
    void deleteProduct(Long id);
}
