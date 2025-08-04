package com.sandalliyasarcan.repository;

import com.sandalliyasarcan.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM CATEGORIES WHERE LOWER(CATEGORY_NAME) =LOWER(:categoryName)" , nativeQuery = true)
    Category getCategoryByName(@Param("categoryName")  String categoryName);

}
