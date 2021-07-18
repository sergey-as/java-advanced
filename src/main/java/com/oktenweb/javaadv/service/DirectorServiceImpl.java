package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.dao.DirectorDao;
import com.oktenweb.javaadv.dto.DirectorListDto;
import com.oktenweb.javaadv.entity.Director;
import com.oktenweb.javaadv.entity.Movie;
import com.oktenweb.javaadv.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorDao directorDao;

    public DirectorServiceImpl(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @Override
//    public List<Director> getAllDirectors() {
    public List<DirectorListDto> getAllDirectors() {
        final List<Director> directorDaoAll = directorDao.myFindAll();
        final List<DirectorListDto> collect = directorDaoAll.stream()
                .map(director -> {
                    DirectorListDto directorListDto = new DirectorListDto();
                    directorListDto.setDirectorId(director.getId());
                    directorListDto.setName(director.getName());

                    final List<Integer> ids = director.getMovies().stream()
                            .map(Movie::getId)
                            .collect(Collectors.toList());
                    directorListDto.setMovies(ids);
                    return directorListDto;
                }).collect(Collectors.toList());
        return collect;
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
