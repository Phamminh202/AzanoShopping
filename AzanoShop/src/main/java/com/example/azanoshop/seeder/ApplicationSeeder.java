package com.example.azanoshop.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ApplicationSeeder  implements CommandLineRunner {

    private boolean createNewSeed = true;
    private static Logger logger = Logger.getLogger(ApplicationSeeder.class .getSimpleName());

    @Autowired
    CategorySeeder categorySeeder;
    @Autowired
    ProductSeeder productSeeder;
    @Autowired
    UserSeeder userSeeder;
    @Autowired
    OrderSeeder orderSeeder;

    @Override
    public void run(String... args) throws Exception {
        if (createNewSeed) {
            logger.log(Level.SEVERE, "Start seeding");
            categorySeeder.generate();
            productSeeder.generate();
            userSeeder.generate();
            orderSeeder.generate();
        }
    }
}
