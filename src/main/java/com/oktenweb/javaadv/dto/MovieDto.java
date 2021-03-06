package com.oktenweb.javaadv.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieDto {

    private int movieId;
    private String title;
    private int duration;
    private int directorId;
}
