package com.oktenweb.javaadv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao extends JpaRepository {
    UserDetails fiByUsername(String username);
}
