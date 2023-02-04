package com.ahmetdayi.patikaorderapp.repository;

import com.ahmetdayi.patikaorderapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findByFullNameContainsIgnoreCase(String letter);
    List<User> findByBills_PriceLessThan(double price);
}
