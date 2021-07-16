package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.dto.MovieCreateDto;
import com.oktenweb.javaadv.dto.MoviePage;
import com.oktenweb.javaadv.entity.Movie;

import javax.validation.Valid;

public interface MovieService {

    MoviePage getAllMovies(int page, int size);

//    MovieCreateDto createMovie(@Valid MovieCreateDto movie);
    MovieCreateDto createMovie(MovieCreateDto movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);

    Movie getMovieById(int id);

    Movie getMovieByTitle(String title);
//    String getMovieByTitle(String title);
}
