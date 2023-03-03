package com.example.assignment3java.controllers;

import com.example.assignment3java.models.Character;
import com.example.assignment3java.models.Franchise;
import com.example.assignment3java.models.Movie;
import com.example.assignment3java.services.franchise.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchises") // Base URL
public class FranchiseController {
    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @Operation(summary = "Get all franchises")
    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<Franchise>> getAll() {
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @Operation(summary = "Get franchise by id")
    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<Franchise> getById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.findById(id));
    }

    @Operation(summary = "Add franchise")
    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity<Franchise> add(@RequestBody Franchise franchise) {
        Franchise addFranchise = franchiseService.add(franchise);
        URI location = URI.create("franchise/" + addFranchise.getId());
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update franchise by id")
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/franchises/1
    public ResponseEntity<Franchise> update(@RequestBody Franchise franchise, @PathVariable int id) {
        // Validates if body is correct
        if(id != franchise.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchise);
        return ResponseEntity.noContent().build();
    }
}
