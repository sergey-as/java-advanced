package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.dao.DirectorDao;
import com.oktenweb.javaadv.entity.Director;
import com.oktenweb.javaadv.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorDao directorDao;

    public DirectorServiceImpl(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorDao.myFindAll();
    }
//    @Override
//    public List<Director> getAllDirectors() {
//        return directorDao.findAll();
//    }

    @Override
    public Director createDirector(Director director) {
        return directorDao.save(director);
    }

    @Override
    public Director updateDirector(int id, Director director) {
        director.setId(id);
        if (!directorDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No director found");
        }
        return directorDao.saveAndFlush(director);
    }

    @Override
    public void deleteDirector(int id) {
        directorDao.deleteById(id);
    }

    @Override
    public Director getDirectorById(int id) {
        return directorDao.findById(id).orElseThrow(() -> new ItemNotFoundException("Director", "id", String.valueOf(id)));
    }

}
