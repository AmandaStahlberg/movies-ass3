package com.example.assignment3java.services.franchise;

import com.example.assignment3java.models.Franchise;
import com.example.assignment3java.repositories.FranchiseRepository;
import com.example.assignment3java.services.character.CharacterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService{

    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public Franchise update(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public void deleteById(Integer id) {
        if (franchiseRepository.existsById(id)) {
            Franchise franchise = franchiseRepository.findById(id).get();
            franchise.getMovies().forEach(m -> m.setFranchise(null));
            franchiseRepository.delete(franchise);
        } else
            logger.warn("No franchise exists with ID: " + id);
    }

    @Override
    public void updateFrachisesMoviesById(int franchise_id, ArrayList<Integer> movieIDs) {

    }
}