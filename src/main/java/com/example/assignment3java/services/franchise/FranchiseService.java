package com.example.assignment3java.services.franchise;

import com.example.assignment3java.models.Franchise;
import com.example.assignment3java.services.CrudService;

import java.util.ArrayList;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    void updateFrachisesMoviesById(int franchise_id, ArrayList<Integer> movieIDs);
}
