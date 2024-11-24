package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    //RestTemplate
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);

        //Convert FakeStoreProductDTO object to Product object
        return generateProduct(fakeStoreProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void updateProduct(Long id, Product product) {

    }

    @Override
    public void replaceProduct(Long id, Product product) {

    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product generateProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(new Category());
        product.getCategory().setValue(fakeStoreProductDto.getCategory());
        product.setId(fakeStoreProductDto.getId());
        return product;
    }
}
