package org.example.book.controller;

import lombok.RequiredArgsConstructor;
import org.example.book.dao.entity.ProductEntity;
import org.example.book.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping("list")
    public List<ProductEntity> getProduct(){
        return productService.getAllProducts();
    }

    @PostMapping("create")
    public ProductEntity createProduct(@RequestBody ProductEntity product){
        return productService.createProduct(product);
    }

    @PostMapping("update/{id}")
    public ProductEntity updateProduct(@RequestBody ProductEntity product, @PathVariable Long id){
        return productService.updateProduct(product,id);
    }

}

