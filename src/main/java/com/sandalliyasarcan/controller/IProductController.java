package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.dto.product.ProductRequest;
import com.sandalliyasarcan.dto.product.ProductResponse;

import java.util.List;

public interface IProductController {
    ProductResponse saveProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getProductsByCategoryId(Integer categoryId);
    boolean deleteProductById(Long productId);
    List<ProductResponse> getProductWithParams(String productName, String brand);
    List<ProductResponse> saveAllProducts(List<ProductRequest> productRequests);
    ProductResponse getProductById(Long productId);
    ProductResponse updateProductById(Long productId, ProductRequest productRequest);



}
