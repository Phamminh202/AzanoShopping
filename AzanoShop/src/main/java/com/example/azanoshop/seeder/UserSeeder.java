package com.example.azanoshop.seeder;

import com.example.azanoshop.entity.User;
import com.example.azanoshop.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class UserSeeder {
    public static List<User> users;
    public static final int NUMBER_OF_USER = 30;

    @Autowired
    UserRepository userRepository;

    public void generate() {
        log.debug("------------Seeding user-------------");
        Faker faker = new Faker();
        users = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_USER; i++) {
            users.add(User.builder()
                    .id(UUID.randomUUID().toString())
                    .username(faker.name().username())
                    .build());
        }
        userRepository.saveAll(users);
        log.debug("--------------End of seeding user-------------");
    }
}
