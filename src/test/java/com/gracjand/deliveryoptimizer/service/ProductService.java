package com.gracjand.deliveryoptimizer.service;

import com.gracjand.deliveryoptimizer.entity.Product;
import com.gracjand.deliveryoptimizer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product create(String name, BigDecimal price){
        Product product = new Product(name, price);
        return productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}