package com.gracjand.deliveryoptimizer.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record PatchProductRequest(

        @Pattern(regexp = ".*\\S.*", message = "must not be blank")
        @Size(max = 100)
        String name,

        @Positive
        @Digits(integer = 8, fraction = 2)
        BigDecimal price) {
}