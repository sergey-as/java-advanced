package com.oktenweb.javaadv.dao;

import com.oktenweb.javaadv.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface MovieDao extends CrudRepository {
public interface MovieDao extends JpaRepository<Movie, Integer> {
}
