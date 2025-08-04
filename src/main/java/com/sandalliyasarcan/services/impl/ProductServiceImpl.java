package com.sandalliyasarcan.services.impl;

import com.sandalliyasarcan.dto.product.ProductRequest;
import com.sandalliyasarcan.dto.product.ProductResponse;
import com.sandalliyasarcan.entities.Category;
import com.sandalliyasarcan.entities.Product;
import com.sandalliyasarcan.repository.CategoryRepository;
import com.sandalliyasarcan.repository.ProductRepository;
import com.sandalliyasarcan.services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());

        if (category.isPresent()) {
            product.setCategory(category.get());
            productRepository.save(product);
        }else{
            throw new RuntimeException("Category not found with id: " + productRequest.getCategoryId()); //Buraya hata yonetiminde Categori Bulunamadu Hatasi kodlanip yazilacak
        }



        ProductResponse response = new ProductResponse();
        response.setCategoryName(product.getCategory().getCategoryName());
        BeanUtils.copyProperties(product, response);
        return response;

        //Burasi daha kisa kodlanabilir mi ?
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product dBproduct : productRepository.findAll()) {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(dBproduct, productResponse);

            productResponse.setCategoryName(dBproduct.getCategory().getCategoryName());

            productResponses.add(productResponse);
        }

        return productResponses;
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(Integer categoryId) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product dBProduct : productRepository.findAll()){
            if (dBProduct.getCategory().getCategoryId().equals(categoryId)){
                ProductResponse productResponse = new ProductResponse();
                BeanUtils.copyProperties(dBProduct, productResponse);
                productResponse.setCategoryName(dBProduct.getCategory().getCategoryName());
                productResponses.add(productResponse);
            }
        }


        return productResponses;
    }

    @Override
    public boolean deleteProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            productRepository.delete(optionalProduct.get());
            return true;
        }else{
            System.out.println("Product not found with id: " + productId);
            return false;
        }


    }

    @Override
    public List<ProductResponse> getProductWithParams(String productName, String brand) {
        if (productName == null && brand == null){
            return getAllProducts();
        }else {
            List<ProductResponse> productResponses = new ArrayList<>();
            for (Product dBProduct : productRepository.getProductWithParams(productName,brand)){
                ProductResponse productResponse = new ProductResponse();
                BeanUtils.copyProperties(dBProduct, productResponse);
                productResponse.setCategoryName(dBProduct.getCategory().getCategoryName());
                productResponses.add(productResponse);
            }
            return productResponses;
        }
    }

    @Override
    public List<ProductResponse> saveAllProducts(List<ProductRequest> productRequests) {
        List<Product> products = new ArrayList<>();
        for (ProductRequest productRequest : productRequests){
            Product product = new Product();
            Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());
            BeanUtils.copyProperties(productRequest, product);
            if (category.isPresent()){
                product.setCategory(category.get());
                products.add(product);
            }else{
                throw new RuntimeException("Category not found with id: " + productRequest.getCategoryId());//Burasi icinde Categori Bulunamadi Hatasi kodlanacak
            }
        }

        productRepository.saveAll(products);

       List<ProductResponse> productResponses = new ArrayList<>();
       for (Product p : products){
           ProductResponse pR = new ProductResponse();
           BeanUtils.copyProperties(p, pR);
           pR.setCategoryName(p.getCategory().getCategoryName());
           productResponses.add(pR);

       }

       return productResponses;


    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(optionalProduct.get(), productResponse);
            productResponse.setCategoryName(optionalProduct.get().getCategory().getCategoryName());
            return productResponse;
        }else{
            throw new RuntimeException("Product not found with id: " + productId);//Buraya Urun Bulunamadi hatasi  kodlanip yazilacak
        }
    }

    @Override
    public ProductResponse updateProductById(Long productId, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            Product dBproduct = optionalProduct.get();
            BeanUtils.copyProperties(productRequest, dBproduct);
            dBproduct.setCategory(categoryRepository.findById(productRequest.getCategoryId()).get());
            Product updatedProduct = productRepository.save(dBproduct);
            return getProductById(updatedProduct.getProductId());
        }
        return null;
    }


}
