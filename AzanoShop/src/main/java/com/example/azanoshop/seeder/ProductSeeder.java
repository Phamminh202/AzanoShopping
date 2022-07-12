package com.example.azanoshop.seeder;

import com.example.azanoshop.entity.Category;
import com.example.azanoshop.entity.Product;
import com.example.azanoshop.entity.myenum.ProductStatus;
import com.example.azanoshop.repository.ProductRepository;
import com.example.azanoshop.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class ProductSeeder {

    public static List<Product> products;
    public static final int NUMBER_OF_PRODUCT = 100;

    @Autowired
    ProductRepository productRepository;

    public void generate() {
        log.debug("------------Seeding product-------------");
        products = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            Product product = new Product();

            int randomCategory = NumberUtil.getRandomNumber(0, CategorySeeder.categories.size() - 1);
            Category category = CategorySeeder.categories.get(randomCategory);
            product.setCategory(category);

            product.setId(UUID.randomUUID().toString());
            product.setName(faker.name().name());
            product.setPrice(new BigDecimal(NumberUtil.getRandomNumber(100, 1000) * 1000));
            product.setThumbnails(faker.avatar().image());
            product.setDetail(faker.lorem().sentence());
            product.setStatus(ProductStatus.ACTIVE);
            products.add(product);
        }
        productRepository.saveAll(products);
        log.debug("--------------End of seeding product-------------");
    }
}
