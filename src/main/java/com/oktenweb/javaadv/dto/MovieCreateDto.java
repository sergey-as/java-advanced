package com.oktenweb.javaadv.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieCreateDto {

    private int id;
    private String title;
    private int duration;
    private int directorId;

}
