package com.gracjand.deliveryoptimizer.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record UpdateProductRequest(

        @NotBlank
        @Size(max = 100)
        String name,

        @NotNull
        @Positive
        @Digits(integer = 8, fraction = 2)
        BigDecimal price) {
}
