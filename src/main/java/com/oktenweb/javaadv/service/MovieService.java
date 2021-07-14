package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie createMovie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);

    Movie getMovieById(int id);
}
