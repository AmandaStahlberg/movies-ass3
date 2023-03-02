package com.example.assignment3java.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 10)
    private int release;
    @Column(length = 50)
    private String genre;
    @Column(length = 50)
    private String director;
    @Column(length = 2083)
    private String picture;
    @Column(length = 2083)
    private String trailer;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;
    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;
}
