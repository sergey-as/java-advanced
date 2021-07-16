package com.oktenweb.javaadv.dao;

import com.oktenweb.javaadv.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorDao  extends JpaRepository<Director, Integer> {
    @Query("select d from Director d")
    List<Director> myFindAll();

//    @Query("select d from Director d")
//    List<Director> myFindAll();

}
