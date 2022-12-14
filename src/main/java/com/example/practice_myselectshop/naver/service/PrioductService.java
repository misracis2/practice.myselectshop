package com.example.practice_myselectshop.naver.service;

import com.example.practice_myselectshop.dto.ProductMypriceRequestDto;
import com.example.practice_myselectshop.dto.ProductRequestDto;
import com.example.practice_myselectshop.dto.ProductResponseDto;
import com.example.practice_myselectshop.entity.Product;
import com.example.practice_myselectshop.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class ProductService {

    public ProductResponseDto createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);

        ProductRepository productRepository = new ProductRepository();

        return  productRepository.createProduct(product);
    }

    public List<ProductResponseDto> getProducts() throws SQLException {
        ProductRepository productRepository = new ProductRepository();

        return productRepository.getProducts();
    }

    public Long updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.getProduct(id);

        if(product == null) {
            throw new NullPointerException("해당 상품은 존재하지 않습니다.");
        }

        return productRepository.updateProduct(product.getId(), requestDto);
    }

}