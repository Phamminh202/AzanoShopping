package com.example.azanoshop.service;

import com.example.azanoshop.entity.Category;
import com.example.azanoshop.entity.Product;
import com.example.azanoshop.entity.seach.FilterParameter;
import com.example.azanoshop.entity.seach.ProductSpecification;
import com.example.azanoshop.entity.seach.SearchCriteria;
import com.example.azanoshop.entity.seach.SearchCriteriaOperator;
import com.example.azanoshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(FilterParameter param) {
        Specification<Product> specification = Specification.where(null);
        if (param.getKeyword() != null && param.getKeyword().length() > 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("keyword", SearchCriteriaOperator.JOIN, param.getKeyword());
            ProductSpecification filter = new ProductSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getStatus() != 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, param.getStatus());
            ProductSpecification filter = new ProductSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getUserId() != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("category_id", SearchCriteriaOperator.EQUALS, param.getUserId());
            ProductSpecification filter = new ProductSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        return productRepository.findAll(specification, PageRequest.of(param.getPage() - 1, param.getLimit()));
    }
    public Optional<Product> findById(String id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }
}
