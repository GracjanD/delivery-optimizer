package com.gracjand.deliveryoptimizer.controller;

import com.gracjand.deliveryoptimizer.entity.Product;
import com.gracjand.deliveryoptimizer.exception.ProductNotFoundException;
import com.gracjand.deliveryoptimizer.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        try {
            Product product = productService.getById(id);
            return ResponseEntity.ok(product);
        } catch(ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product created = productService.create(product.getName(), product.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/api/products/" + created.getId())
                .body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ProductNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
