package com.oktenweb.javaadv.controller;

import com.oktenweb.javaadv.entity.Director;
import com.oktenweb.javaadv.entity.Movie;
import com.oktenweb.javaadv.service.MovieService;
import com.oktenweb.javaadv.validator.MovieValidator;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MovieController.class)
@ExtendWith(SpringExtension.class)
public class MovieControllerTest {

    @MockBean
    private MovieService movieService;
    @MockBean
    private MovieValidator movieValidator;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenTitleWhenGettingMovieThenReturnMovie() throws Exception {
        Mockito.when(movieService.getMovieByTitle(ArgumentMatchers.anyString()))
                .thenReturn(new Movie(1, "Avengers", 150, new Director()));

        mockMvc.perform(MockMvcRequestBuilders.get("/movie/title/Avengers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is("Avengers")));
    }
}
