package com.example.azanoshop.seeder;

import com.example.azanoshop.entity.Account;
import com.example.azanoshop.entity.myenum.AccountStatus;
import com.example.azanoshop.repository.AccountRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class AccountSeeder {
    public static List<Account> accountList;
    public static final int NUMBER_OF_ACCOUNT = 30;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void generate() {
        log.debug("------------Seeding account-------------");
        Faker faker = new Faker();
        accountList = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_ACCOUNT; i++){
            Account account = new Account();
            account.setId(UUID.randomUUID().toString());
            account.setAddress(faker.address().fullAddress());
            account.setRole(faker.random().nextInt(0,1));
            account.setDetail(faker.lorem().sentence());
            account.setEmail(faker.internet().emailAddress());
            account.setFullname(faker.name().fullName());
            account.setUsername(faker.leagueOfLegends().champion());
            account.setPassword(passwordEncoder.encode(faker.artist().name()));
            account.setPhone(faker.phoneNumber().cellPhone());
            account.setThumbnail(faker.avatar().image());
            account.setStatus(AccountStatus.ACTIVE);
            accountList.add(account);
        }
        accountRepository.saveAll(accountList);
        log.debug("--------------End of seeding account-------------");
    }
}
