package com.gracjand.deliveryoptimizer.dto;

import java.math.BigDecimal;

public record CreateProductRequest(String name, BigDecimal price) {
}
