package com.example.azanoshop.seeder;

import com.example.azanoshop.entity.Category;
import com.example.azanoshop.entity.Product;
import com.example.azanoshop.entity.myenum.ProductStatus;
import com.example.azanoshop.repository.CategoryRepository;
import com.example.azanoshop.repository.ProductRepository;
import com.example.azanoshop.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class CategorySeeder {
    public static List<Category> categories;
    public static final int NUMBER_OF_CATEGORY = 10;

    @Autowired
    CategoryRepository categoryRepository;

    public void generate() {
        log.debug("------------Seeding categories-------------");
        Faker faker = new Faker();
        categories = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CATEGORY; i++) {
            categories.add(Category.builder()
                    .id(UUID.randomUUID().toString())
                    .name(faker.name().name())
                    .build());
        }
        categoryRepository.saveAll(categories);
        log.debug("--------------End of seeding categories-------------");
    }
}
