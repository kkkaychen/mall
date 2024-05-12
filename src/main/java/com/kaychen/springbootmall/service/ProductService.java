package com.kaychen.springbootmall.service;

import com.kaychen.springbootmall.model.product.dto.ProductDto;

public interface ProductService {
    ProductDto getByProductId(Integer productId);
}
