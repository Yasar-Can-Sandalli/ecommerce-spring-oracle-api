package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.IProductController;
import com.sandalliyasarcan.dto.product.ProductRequest;
import com.sandalliyasarcan.dto.product.ProductResponse;
import com.sandalliyasarcan.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/product/")
public class ProductControllerImpl implements IProductController {

    @Autowired
    private IProductService productService;

    @Override
    @PostMapping(path = "/save")
    public ProductResponse saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @Override
    @GetMapping(path = "/list")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    @GetMapping(path = "/list/{id}")
    public List<ProductResponse> getProductsByCategoryId(@PathVariable(name = "id") Integer categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteProductById(@PathVariable(name = "id") Long productId) {
        return productService.deleteProductById(productId);
    }

    @Override
    @GetMapping(path = "/params")
    public List<ProductResponse> getProductWithParams(@RequestParam(name = "productName",required = false) String productName, @RequestParam(name = "brand" , required = false) String brand) {
        return productService.getProductWithParams(productName,brand);
    }

    @Override
    @PostMapping(path = "/saveAll")
    public List<ProductResponse> saveAllProducts(@RequestBody List<ProductRequest> productRequests) {
        return productService.saveAllProducts(productRequests);
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public ProductResponse getProductById(@PathVariable(name = "id") Long productId) {
        return productService.getProductById(productId);
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public ProductResponse updateProductById(@PathVariable(name = "id", required = false) Long productId, @RequestBody ProductRequest productRequest) {
        return productService.updateProductById(productId,productRequest);
    }
}
