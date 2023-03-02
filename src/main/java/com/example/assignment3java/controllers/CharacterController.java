package com.example.assignment3java.controllers;

import com.example.assignment3java.models.Character;
import com.example.assignment3java.services.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/characters") // Base URL
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping // GET: localhost:8080/api/v1/characters
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/characters/1
    public ResponseEntity<Character> getById(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findById(id));
    }
}
