package com.oktenweb.javaadv.dao;

import com.oktenweb.javaadv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    Optional<User> findByVerificationCode(String code);
}
