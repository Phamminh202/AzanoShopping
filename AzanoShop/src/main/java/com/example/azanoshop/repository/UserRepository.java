package com.example.azanoshop.repository;

import com.example.azanoshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String > {

}
