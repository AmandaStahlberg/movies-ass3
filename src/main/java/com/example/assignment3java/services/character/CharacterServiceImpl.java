package com.example.assignment3java.services.character;

import com.example.assignment3java.models.Character;
import com.example.assignment3java.models.Movie;
import com.example.assignment3java.repositories.CharacterRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }


    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character update(Character character) {
        return characterRepository.save(character);
    }

    
    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (characterRepository.existsById(id)){
            Character character = characterRepository.findById(id).get();
            Set<Movie> movies = character.getMovies();
            movies.forEach(mov ->
                    mov.getCharacters()
                            .removeIf(r -> r.getId() == character.getId()));
            movies.clear();
            characterRepository.delete(character);
        }
        else
            logger.warn("No professor exists with ID: " + id);
    }

    @Override
    public Set<Character> findAllCharactersByFranchise(Integer id) {
        return null;
    }
}