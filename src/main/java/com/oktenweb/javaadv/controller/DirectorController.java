package com.oktenweb.javaadv.controller;

import com.oktenweb.javaadv.dto.DirectorListDto;
import com.oktenweb.javaadv.entity.Director;
import com.oktenweb.javaadv.service.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/director")
@RequiredArgsConstructor
@Slf4j
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
//    public List<Director> getDirectors() {
//        return directorService.getAllDirectors();
//    }
    public List<DirectorListDto> getDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable int id) {
        return directorService.getDirectorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Director insertDirector(@RequestBody @Valid Director director) {
        log.info("Handling POST request for object {}", director);
        return directorService.createDirector(director);

    }

    //    @PutMapping(value = "/director/{id}")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Director updateDirector(@PathVariable int id, @RequestBody @Valid Director director) {
        return directorService.updateDirector(id, director);
    }

    //    @DeleteMapping(value = "/director/{id}")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirector(@PathVariable int id) {
        directorService.deleteDirector(id);
    }

}
