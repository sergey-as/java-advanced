package com.oktenweb.javaadv.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
//@Getter
//@Setter
public class MoviePage {

    private List<MovieDto> movies;
    private long totalElements;
    private int currentPage;
    private boolean last;

}
