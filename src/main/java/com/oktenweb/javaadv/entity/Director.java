package com.oktenweb.javaadv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIgnoreProperties("movies, cinemaStudio, ...")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @OneToMany(targetEntity = Movie.class)
    @JoinColumn(name = "director_id")
    @JsonIgnore
    private List<Movie> movies;
}
