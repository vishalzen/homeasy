package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, String> {
    User findByUsername(String username);
}
