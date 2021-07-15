package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.dao.MovieDao;
import com.oktenweb.javaadv.dto.MoviePage;
import com.oktenweb.javaadv.entity.Movie;
import com.oktenweb.javaadv.exceptions.ItemNotFoundException;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public MoviePage getAllMovies(int page, int size) {
        final Page<Movie> movies = movieDao.findAll(PageRequest.of(page, size));
        final MoviePage moviePage = new MoviePage();
        moviePage.setMovies(movies.getContent());
        moviePage.setCurrentPage(movies.getNumber());
        moviePage.setLast(movies.isLast());
        moviePage.setTotalElements(movies.getTotalElements());
        return moviePage;
    }

    @Override
    public Movie createMovie(Movie movie) {
        if (!CharUtils.isAsciiAlphaUpper(movie.getTitle().charAt(0))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie title should start with capital letter!");
        }
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        movie.setId(id);
        if (!movieDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(int id) {
        if (!movieDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        movieDao.deleteById(id);
    }

    @Override
    public Movie getMovieById(int id) {
        return movieDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No movie with id: " + id));
    }

    @Override
    public Movie getMovieByTitle(String title) {
        final Optional<Movie> movie = movieDao.findByTitle(title);
        return movie.orElseThrow(() -> new ItemNotFoundException("Movie", "title", title));
    }
//   public String getMovieByTitle(String title) {
//        return movieDao.findByTitle(title);
//    }

}
