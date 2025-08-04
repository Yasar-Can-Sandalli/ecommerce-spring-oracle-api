package com.sandalliyasarcan.repository;
import com.sandalliyasarcan.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM PRODUCTS WHERE LOWER(PRODUCT_NAME) = LOWER(:productName) OR LOWER(BRAND) = LOWER(:brand)", nativeQuery = true)
    List<Product> getProductWithParams(@Param("productName") String productName, @Param("brand") String brand);

}