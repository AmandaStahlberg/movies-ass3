package com.example.assignment3java.controllers;

import com.example.assignment3java.models.Movie;
import com.example.assignment3java.services.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movies") // Base URL
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                description = "Success",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Movie.class)) }),
        @ApiResponse(responseCode = "404",
                description = "Movies does not exist",
                content = @Content)
    })
    @GetMapping // GET: localhost:8080/api/v1/movies
    public ResponseEntity<Collection<Movie>> getAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @Operation(summary = "Get movie by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                description = "Success",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Movie.class)) }),
        @ApiResponse(responseCode = "404",
                description = "Movies does not exist with supplied ID",
                content = @Content)
    })
    @GetMapping("{id}") // GET: localhost:8080/api/v1/movies/1
    public ResponseEntity<Movie> getById(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @Operation(summary = "Add movie")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Movie successfully created",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Movie not found with supplied ID",
                    content = @Content)
    })
    @PostMapping // POST: localhost:8080/api/v1/movies
    public ResponseEntity<Movie> add(@RequestBody Movie movie) {
        Movie addMovie = movieService.add(movie);
        URI location = URI.create("movies/" + addMovie.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update movie by id")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "201",
                    description = "Movie successfully updated",
                    content = @Content),
        @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content)
    })
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/movies/1
    public ResponseEntity<Movie> update(@RequestBody Movie movie, @PathVariable int id) {
        // Validates if body is correct
        if(id != movie.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movie);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Delete movie by id")
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/movies/1
    public ResponseEntity<Movie> delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}