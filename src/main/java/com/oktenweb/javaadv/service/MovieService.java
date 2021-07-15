package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.dto.MoviePage;
import com.oktenweb.javaadv.entity.Movie;

public interface MovieService {

    MoviePage getAllMovies(int page, int size);

    Movie createMovie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);

    Movie getMovieById(int id);

    Movie getMovieByTitle(String title);
//    String getMovieByTitle(String title);
}
