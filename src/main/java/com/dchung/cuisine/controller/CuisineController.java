package com.dchung.cuisine.controller;

import com.dchung.cuisine.data.Cuisine;
import com.dchung.cuisine.data.repo.CuisineRepository;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("cuisines")
public class CuisineController {

  @Autowired
  private CuisineRepository cuisineRepository;

  @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Cuisine> getCuisine(@PathVariable("id") Long id) {
    System.out.println("Cusine Service: getCuisine("+id+")");
    Optional<Cuisine> cusineWrapper = cuisineRepository.findById(id);
    if(!cusineWrapper.isPresent()) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(cusineWrapper.get(),HttpStatus.OK);
  }

  @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllCuisines() {
    System.out.println("Cusine Service: getAllCuisines()");
    Iterable<Cuisine> cuisines = cuisineRepository.findAll();
    if( Iterables.size(cuisines) == 0 ) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(cuisines,HttpStatus.OK);
  }

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Void> insertCuisine(
      @RequestBody Cuisine cuisine,
      UriComponentsBuilder builder) {
    System.out.println("Cusine Service: insertCuisine("+cuisine.getName()+")");
    Cuisine c = cuisineRepository.save(cuisine);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/cuisines/{id}").
        buildAndExpand(c.getCuisine_id()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

}
