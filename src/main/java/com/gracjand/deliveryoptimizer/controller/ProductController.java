package com.gracjand.deliveryoptimizer.controller;

import com.gracjand.deliveryoptimizer.dto.CreateProductRequest;
import com.gracjand.deliveryoptimizer.dto.PatchProductRequest;
import com.gracjand.deliveryoptimizer.dto.ProductResponse;
import com.gracjand.deliveryoptimizer.dto.UpdateProductRequest;
import com.gracjand.deliveryoptimizer.service.ProductService;
import jakarta.validation.Valid;
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
    public List<ProductResponse> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request){
        ProductResponse created = productService.create(request.name(), request.price());
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/api/products/" + created.id())
                .body(created);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id,
                                  @Valid @RequestBody UpdateProductRequest request){
        return productService.update(id, request.name(), request.price());
    }

    @PatchMapping("/{id}")
    public ProductResponse patch(@PathVariable Long id,
                                  @Valid @RequestBody PatchProductRequest request){
        return productService.patch(id, request.name(), request.price());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
