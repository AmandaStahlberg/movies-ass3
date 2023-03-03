package com.example.assignment3java.services.movie;


import com.example.assignment3java.models.Movie;
import com.example.assignment3java.repositories.MoviesRepository;
import com.example.assignment3java.services.character.CharacterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService{

    public MovieServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    private final MoviesRepository moviesRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    @Override
    public Movie findById(Integer id) {
        return moviesRepository.findById(id).get();
    }

    @Override
    public Collection findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Movie add(Movie movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        moviesRepository.deleteById(id);
    }
    @Override
    public void delete(Movie entity) {

    }
}
