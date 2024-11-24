package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FakeStoreProductService implements ProductService{
    //RestTemplate
    private RestTemplate restTemplate;
    private Logger logger;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        logger = Logger.getLogger(this.getClass().getName());
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
        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProduct : fakeStoreProducts){
            products.add(generateProduct(fakeStoreProduct));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void updateProduct(Long productId, Product product) {
        logger.info("Updating product with id: " + productId);
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto.class
        );
        Product productFromAPI = generateProduct(fakeStoreProduct);
        updateProduct(productFromAPI,product);
        logger.info("Update Successfully new Product : "+productFromAPI);
    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }

    @Override
    public void deleteProduct(Long productId) {

    }

    private Product updateProduct(Product oldProduct, Product newProduct ) {
        if(newProduct.getCategory().getId() != null){
            oldProduct.setCategory(newProduct.getCategory());
        }
        if(newProduct.getPrice() != null){
            oldProduct.setPrice(newProduct.getPrice());
        }
        if(newProduct.getTitle() != null){
            oldProduct.setTitle(newProduct.getTitle());
        }
        if(newProduct.getDescription() != null){
            oldProduct.setDescription(newProduct.getDescription());
        }
        if(newProduct.getImage() != null){
            oldProduct.setImage(newProduct.getImage());
        }
        return oldProduct;
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
