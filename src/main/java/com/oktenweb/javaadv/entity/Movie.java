package com.oktenweb.javaadv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
//@JsonIgnoreProperties({"asdsd", "ewrq", ...})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)//не обов’язково
    @NotBlank
    //@JsonProperty("title-of-movie")
    //@JsonIgnore
    private String title;
    @Positive
    private int duration;

    @ManyToOne
    @JsonIgnore
    private Director director;

//    {
//        "title": "Star Wars: New Hope",
//        "duration": 190
//    }

}
