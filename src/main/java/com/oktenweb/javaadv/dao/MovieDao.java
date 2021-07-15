package com.oktenweb.javaadv.dao;

import com.oktenweb.javaadv.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//public interface MovieDao extends CrudRepository {
public interface MovieDao extends JpaRepository<Movie, Integer> {

    //todo: query
//    @Query("SELECT m.title, m.duration FROM Movie m WHERE m.title LIKE :t")
    @Query("SELECT m FROM Movie m WHERE m.title LIKE :t")
//    Movie findByTitle(String t);
    Optional<Movie> findByTitle(String t);
    //@Query("select title from Movie where title like :t")
    //String findByTitle(String t);

}
