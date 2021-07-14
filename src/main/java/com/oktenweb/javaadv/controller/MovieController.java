package com.oktenweb.javaadv.controller;

import com.oktenweb.javaadv.entity.Movie;
import com.oktenweb.javaadv.service.MovieService;
import com.oktenweb.javaadv.validator.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@Controller
//@Component
//@Repository
//@Service
//@Bean
//@ControllerAdvice
//@RestControllerAdvice
@RequestMapping(value = "/movie")
public class MovieController {

    //    private List<Movie> movies = new ArrayList<>();
//
//    {
//        movies.add(new Movie(1, "Star Wars: New Hope", 190));
//        movies.add(new Movie(2, "LoTR: RoTK", 235));
//    }
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieValidator movieValidator;

    //    //var.1
//    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    //var.2
//    @GetMapping(value = "/movie")
    @GetMapping
    public List<Movie> getMovies() {
//        return movies;
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    //    @PostMapping(value = "/movie")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody @Valid Movie movie) {
//        System.out.println(movie);
//        {
//            "id": 3,
//                "title": "Star Wars: Return of the Jedi",
//                "duration": 193
//        }

//        movies.add(movie);
//        return movie;
        return movieService.createMovie(movie);

    }

    //    @PutMapping(value = "/movie/{id}")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable int id, @RequestBody @Valid Movie movie) {
//        final Optional<Movie> first = movies.stream()
//                .filter(m -> m.getId() == id)
//                .findFirst();
//        final Movie movieInList = first.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found"));
//        final int index = movies.indexOf(movieInList);
//        movie.setId(id);
//        movies.set(index, movie);
//        return movie;
        return movieService.updateMovie(id, movie);
    }

    //    @DeleteMapping(value = "/movie/{id}")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
//        final boolean isRemoved = movies.removeIf(movie -> movie.getId() == id);
//        if (isRemoved) {
//            System.out.println("Movie removed");
//        } else {
//            System.out.println("No movie with such id");
//        }
        movieService.deleteMovie(id);
    }

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder){
////        dataBinder.addValidators(new MovieValidator());
//        dataBinder.addValidators(movieValidator);
//        //dataBinder.addValidators(movieValidator1);
//        //...
//    }

}

//Lesson 1:
//Build tools (Ant, Maven(!), Gradle)
//Spring start (start.spring.io)
//Spring framework intro: modules, what can be done
//RestController and other annotations (RequestMapping, Get(POST…)Mapping, RequestParam, PathVariable)
//Postman
//GET, POST, PUT, DELETE, PATCH - rules

//REST (скор. англ. Representational State Transfer, «передача репрезентативного стану»)

//              MySQL       REST
// 1. create    INSERT      POST
// 2. read      SELECT      GET
// 3. update    UPDATE      PUT / PATCH
// 4. delete    DELETE      DELETE

//http-methods:
//get, post, put, delete, patch, options

//Http Request:
//1. URL / URI      --- /movie
//2. http method    --- GET