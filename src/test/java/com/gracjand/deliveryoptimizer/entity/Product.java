package com.gracjand.deliveryoptimizer.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Comparable<Product> {
    private final Long id;
    private String name;
    private BigDecimal price;
    private static long nextId = 1;

    public Product(String name, BigDecimal price){
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Product other = (Product) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


    @Override
    public int compareTo(Product other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}