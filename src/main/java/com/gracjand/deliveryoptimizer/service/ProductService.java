package com.gracjand.deliveryoptimizer.service;

import com.gracjand.deliveryoptimizer.dto.ProductResponse;
import com.gracjand.deliveryoptimizer.entity.Product;
import com.gracjand.deliveryoptimizer.exception.ProductNotFoundException;
import com.gracjand.deliveryoptimizer.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse create(String name, BigDecimal price){
        Product product = new Product(name, price);
        return toProductResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAll(){
        return productRepository.findAll().stream()
                .map(this::toProductResponse)
                .toList();
    }

    public ProductResponse getById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return toProductResponse(product);
    }

    @Transactional
    public ProductResponse update(Long id, String name, BigDecimal price){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        product.setName(name);
        product.setPrice(price);
        return toProductResponse(product);
    }

    @Transactional
    public ProductResponse patch(Long id, String name, BigDecimal price){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        if(name != null) product.setName(name);
        if(price != null) product.setPrice(price);
        return toProductResponse(product);
    }

    @Transactional
    public void deleteById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);
    }

    private ProductResponse toProductResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}