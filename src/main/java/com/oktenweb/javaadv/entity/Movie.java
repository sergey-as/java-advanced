package com.oktenweb.javaadv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getters,Setters, Constructor, ToString, EqualsAndHashCode,
@Entity
//@Table(name = "MOVIE_TABLE")//не обов’язково
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)//не обов’язково
    @NotBlank
    private String title;
    @Positive
    private int duration;

//    {
//        "title": "Star Wars: New Hope",
//        "duration": 190
//    }

}
