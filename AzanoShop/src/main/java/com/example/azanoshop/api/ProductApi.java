package com.example.azanoshop.api;

import com.example.azanoshop.repository.ProductRepository;
import com.example.azanoshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/api/v1")
public class ProductApi {

    @Autowired
    ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public ResponseEntity<?> getList(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "name", defaultValue = "", required = false) String name) {
        return ResponseEntity.ok(productService.findAll(
                        PageRequest.of(page - 1, limit), name
                )
        );
    }


//    @Autowired
//    private ProductRepository productRepository;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
//        // tạo ra product từ productdto
//        Product product = new Product();
//        product.setName(productDTO.getName());
//        product.setDescription(product.getDescription());
//        product.setPrice(productDTO.getPrice());
//        product.setSlug(StringHelper.toSlug(productDTO.getName()));
//        product.setStatus(ProductSimpleStatus.ACTIVE);
//        productRepository.save(product);
//        productDTO.setId(product.getId());
//        productDTO.setCreatedAt(product.getCreatedAt() == null ? "" : product.getCreatedAt().toString());
//        productDTO.setUpdatedAt(product.getUpdatedAt() == null ? "" : product.getUpdatedAt().toString());
//        productDTO.setStatus(product.getStatus().name());
//        return new ResponseEntity<>(productDTO, HttpStatus.OK);
//    }
}
