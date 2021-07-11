package com.oktenweb.javaadv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data //Getters,Setters, Constructor, ToString, EqualsAndHashCode,
public class Movie {

    private int id;
    private String title;
    private int duration;

}
