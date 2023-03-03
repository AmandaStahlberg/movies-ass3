package com.example.assignment3java.controllers;

import com.example.assignment3java.models.Character;
import com.example.assignment3java.models.Franchise;
import com.example.assignment3java.services.character.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/characters") // Base URL
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Get all characters")
    @GetMapping // GET: localhost:8080/api/v1/characters
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @Operation(summary = "Get all character by id")
    @GetMapping("{id}") // GET: localhost:8080/api/v1/characters/1
    public ResponseEntity<Character> getById(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findById(id));
    }
    @Operation(summary = "Add character")
    @PostMapping // POST: localhost:8080/api/v1/characters
    public ResponseEntity<Character> add(@RequestBody Character character) {
        Character addCharacter = characterService.add(character);
        URI location = URI.create("characters/" + addCharacter.getId());
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update character by id")
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/characters/1
    public ResponseEntity<Character> update(@RequestBody Character character, @PathVariable int id) {
        // Validates if body is correct
        if(id != character.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(character);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/characters/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
