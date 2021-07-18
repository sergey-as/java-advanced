package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.dto.DirectorListDto;
import com.oktenweb.javaadv.entity.Director;

import java.util.List;

public interface DirectorService {

    List<DirectorListDto> getAllDirectors();

    Director createDirector(Director director);

    Director updateDirector(int id, Director director);

    void deleteDirector(int id);

    Director getDirectorById(int id);

}
