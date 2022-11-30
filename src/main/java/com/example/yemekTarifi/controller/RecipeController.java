package com.example.yemekTarifi.controller;


import com.example.yemekTarifi.entity.Recipe;
import com.example.yemekTarifi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/food")
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        Recipe addRecipe= recipeService.addRecipe(recipe);
        return new ResponseEntity<Recipe>(addRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe){
        Recipe updateRecipe= recipeService.updateRecipe(recipe);
        return new ResponseEntity<Recipe>(updateRecipe, HttpStatus.OK);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> findAllFood(){
        List<Recipe> findAllRecipe = recipeService.findAllFood();
        return new ResponseEntity<List<Recipe>>(findAllRecipe,HttpStatus.OK);

    }

    /**
     * bu methot ıd ye göre delete yapar
     * @param id
     */
    @PostMapping("/delete")
    public void deleteRecipeById(Integer id){
        recipeService.deleteRecipeById(id);
    }


    /**
     * Burada server sent event yapmaya çalıştık
     * @return
     */
    @GetMapping("/flux")
    public Flux<ServerSentEvent<Integer>> getUsers() {

        AtomicInteger integer = new AtomicInteger(0);
        ArrayList<Integer> data = new ArrayList();

        return Flux
                .interval(Duration.ofSeconds(1))
                .map(sequence -> {
                    data.add(integer.getAndIncrement());
                    return ServerSentEvent.<Integer>builder()
                            .id(String.valueOf(sequence))
                            .event("user-list-event")
                            .data(integer.get())
                            .build();});
    }






}
