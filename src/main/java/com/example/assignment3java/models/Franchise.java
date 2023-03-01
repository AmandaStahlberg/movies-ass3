package com.example.assignment3java.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;

}
