package com.kaychen.springbootmall.model.product.dto;

import lombok.Builder;

@Builder
public record ProductDto(String productName,
                         String category,
                         String imageUrl,
                         Integer price,
                         Integer stock,
                         String description) {

}
