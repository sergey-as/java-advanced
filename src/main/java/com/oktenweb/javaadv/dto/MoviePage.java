package com.oktenweb.javaadv.dto;

import com.oktenweb.javaadv.entity.Movie;
import lombok.*;

import java.util.List;

//@AllArgsConstructor
//@Data
@NoArgsConstructor
@Getter
@Setter
public class MoviePage {

    private List<Movie> movies;
    private long totalElements;
    private int currentPage;
    private boolean last;

}
