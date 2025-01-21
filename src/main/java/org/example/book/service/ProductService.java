package org.example.book.service;

import lombok.RequiredArgsConstructor;
import org.example.book.dao.entity.ProductEntity;
import org.example.book.dao.repository.ProductRepository;
import org.example.book.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(@RequestBody ProductEntity product, Long id) {
        ProductEntity existingProduct = productRepository.findById(id).get(); //detect aldiq

        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice()); //updateler hazir

        return productRepository.save(existingProduct);

    }





}
