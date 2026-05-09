package com.example.AzureDemo.controller;

import com.example.AzureDemo.entity.Product;
import com.example.AzureDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductService productService;


    // CREATE SINGLE PRODUCT
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // CREATE BULK PRODUCTS
    @PostMapping("/bulk")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.createProducts(products);
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }

    // DELETE ALL PRODUCTS
    @DeleteMapping
    public ResponseEntity<Object> deleteAllProducts() {

        productService.deleteAllProducts();
        return ResponseEntity.noContent().build();
    }

}
