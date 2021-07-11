package com.oktenweb.javaadv.controller;

import com.oktenweb.javaadv.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie(1, "Star Wars: New Hope", 190));
        movies.add(new Movie(2, "LoTR: RoTK", 235));
    }

    //    //var.1
//    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    //var.2
    @GetMapping(value = "/movie")
    public List<Movie> getMovies() {
        return movies;
    }

    @PostMapping(value = "/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody Movie movie) {
//        System.out.println(movie);
//        1:18:00
//        {
//            "id": 3,
//                "title": "Star Wars: Return of the Jedi",
//                "duration": 193
//        }
        movies.add(movie);
        return movie;
    }

    @PutMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        final Optional<Movie> first = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        final Movie movieInList = first.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found"));
        final int index = movies.indexOf(movieInList);
        movie.setId(id);
        movies.set(index, movie);
        return movie;
    }

    @DeleteMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
        final boolean isRemoved = movies.removeIf(movie -> movie.getId() == id);
        if(isRemoved){
            System.out.println("Movie removed");
        }else {
            System.out.println("No movie with such id");
        }
    }

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