package com.example.azanoshop.repository;

import com.example.azanoshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String >, JpaSpecificationExecutor<Product> {

}
