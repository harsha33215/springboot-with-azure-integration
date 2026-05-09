package com.example.AzureDemo.service;


import com.example.AzureDemo.entity.Product;
import com.example.AzureDemo.exception.DuplicateException;
import com.example.AzureDemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE Product
    public Product createProduct(Product product){
        if(productRepository.existsByName(product.getName())){
            throw new DuplicateException("Product already exists with name " + product.getName());
        }
        return productRepository.save(product);
    }
    // GET ALL PRODUCTS
    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }

    // GET PRODUCT BY ID
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }
    // UPDATE PRODUCT
    public Product updateProduct(Long id, Product product){
        Product existing = productRepository.findById(id).get();
        existing.setName(product.getName());
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setQuantity(product.getQuantity());

        return  productRepository.save(existing);
    }

    // DELETE PRODUCT
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    // CREATE BULK PRODUCTS
    public List<Product> createProducts(List<Product> products) {
        for (Product product : products) {

            if (productRepository.existsByName(product.getName())) {
                throw new DuplicateException(
                        "Product already exists with name " + product.getName());
            }
        }
        return productRepository.saveAll(products);
    }

    // DELETE ALL PRODUCTS
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

}
