package com.dchung.cuisine.data.repo;

import com.dchung.cuisine.data.Cuisine;
import org.springframework.data.repository.CrudRepository;

public interface CuisineRepository
    extends CrudRepository<Cuisine, Long> {
}
