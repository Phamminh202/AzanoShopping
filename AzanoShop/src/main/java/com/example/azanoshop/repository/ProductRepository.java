package com.example.azanoshop.repository;

import com.example.azanoshop.entity.Product;
import com.example.azanoshop.entity.myenum.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
@Repository
public interface ProductRepository extends JpaRepository<Product, String >, JpaSpecificationExecutor<Product> {
    Page<Product> findAllByStatusEquals(ProductStatus status, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from products")
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByNameContains(String search, Pageable pageable);

    Page<Product> findAllByPriceEquals(BigDecimal price, Pageable pageable);

    Page<Product> findAllByCategory_Name(String search, Pageable pageable);
    Page<Product> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
}
