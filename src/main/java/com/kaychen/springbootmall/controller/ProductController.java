package com.kaychen.springbootmall.controller;

import com.kaychen.springbootmall.model.product.dto.ProductDto;
import com.kaychen.springbootmall.model.response.ApiResponse;
import com.kaychen.springbootmall.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{productId}/detail")
    public ResponseEntity<ApiResponse> showProduct(@PathVariable("productId") Integer productId){
        ProductDto byProductId = productService.getByProductId(productId);

        var res = new ApiResponse(ApiResponse.Status.SUCCESS, ApiResponse.Status.SUCCESS.getDefaultMessage(), byProductId);
        return ResponseEntity.ok().body(res);
    }
}
