package com.kaychen.springbootmall.service.impl;

import com.kaychen.springbootmall.model.product.Product;
import com.kaychen.springbootmall.model.product.dto.ProductDto;
import com.kaychen.springbootmall.repository.ProductRepository;
import com.kaychen.springbootmall.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getByProductId(Integer productId) {
        Optional<Product> byProductId = productRepository.findByProductId(productId);
        return convertToProductDto(byProductId);
    }

    private ProductDto convertToProductDto(Optional<Product> byProductId) {
        return ProductDto.builder()
                .productName(byProductId.get().getProductName())
                .category(byProductId.get().getCategory())
                .price(byProductId.get().getPrice())
                .stock(byProductId.get().getStock())
                .description(byProductId.get().getDescription())
                .build();
    }
}
