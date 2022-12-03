package com.example.practice_myselectshop.controller;

import com.example.practice_myselectshop.dto.ProductMypriceRequestDto;
import com.example.practice_myselectshop.dto.ProductRequestDto;
import com.example.practice_myselectshop.dto.ProductResponseDto;
import com.example.practice_myselectshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    ProductS

    // 관심 상품 등록하기
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
        ProductService productService = new ProductService();
        // 응답 보내기
        return productService.createProduct(requestDto);
    }

    // 관심 상품 조회하기
    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() throws SQLException {
        ProductService productService = new ProductService();
        // 응답 보내기
        return productService.getProducts();
    }

    // 관심 상품 최저가 등록하기
    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
        ProductService productService = new ProductService();
        // 응답 보내기 (업데이트된 상품 id)
        return productService.updateProduct(id, requestDto);
    }

}
