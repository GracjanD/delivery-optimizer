package com.gracjand.deliveryoptimizer.repository;

import com.gracjand.deliveryoptimizer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}