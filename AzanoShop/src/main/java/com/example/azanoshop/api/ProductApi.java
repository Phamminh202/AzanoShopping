package com.example.azanoshop.api;

import com.example.azanoshop.entity.Category;
import com.example.azanoshop.entity.Product;
import com.example.azanoshop.entity.seach.FilterParameter;
import com.example.azanoshop.service.CategoryService;
import com.example.azanoshop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin("*")
public class ProductApi {
    final ProductService productService;
    final CategoryService categoryService;

    public ProductApi(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/seach")
    public ResponseEntity<?> findAllByOneObject(
            @RequestBody FilterParameter param) {
        Page<Product> result = this.productService.findAll(param);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product products,@PathVariable String cateId) {
        Optional<Product> optionalProduct = productService.findById(id);
        Optional<Category> optionalCategory = categoryService.findById(cateId);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        if (!optionalCategory.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existProduct = optionalProduct.get();
        existProduct.setId(products.getId());
        existProduct.setName(products.getName());
        existProduct.setPrice(products.getPrice());
        existProduct.setDetail(products.getDetail());
        existProduct.setStatus(products.getStatus());
        existProduct.setCategory(optionalCategory.get());
        return ResponseEntity.ok(productService.save(existProduct));
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }
}
