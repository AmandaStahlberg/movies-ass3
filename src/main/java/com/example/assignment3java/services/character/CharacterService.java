package com.example.assignment3java.services.character;

import com.example.assignment3java.models.Character;
import com.example.assignment3java.services.CrudService;

import java.util.Set;

public interface CharacterService extends CrudService<Character, Integer> {
    // Extra business logic
    public Set<Character> findAllCharactersByFranchise(Integer id);
}