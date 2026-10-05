package com.gracjand.deliveryoptimizer.repository;

import com.gracjand.deliveryoptimizer.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {

    private final Map<Long, Product> data = new HashMap<>();

    public Product save(Product product){
        data.put(product.getId(), product);
        return product;
    }

    public List<Product> findAll(){
        return new ArrayList<>(data.values());
    }

    public Optional<Product> findById(Long id){
        return Optional.ofNullable(data.get(id));
    }

    public void deleteById(Long id){
        data.remove(id);
    }
}
