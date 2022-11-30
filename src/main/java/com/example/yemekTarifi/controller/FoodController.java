package com.example.yemekTarifi.controller;


import com.example.yemekTarifi.entity.Food;
import com.example.yemekTarifi.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    private final FoodService foodService;
    public FoodController(FoodService foodService){
        this.foodService=foodService;
    }

    @PostMapping("/save")
    public ResponseEntity<Food> addRecipe(@RequestBody Food food){
        Food addRecipe=foodService.addRecipe(food);
        return new ResponseEntity<Food>(addRecipe, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Food> updateRecipe(@RequestBody Food food){
        Food updatedRecipe=foodRepository.getById(food.getId());
        Food updateRecipe=foodService.updateRecipe(updatedRecipe);
        return new ResponseEntity<Food>(updateRecipe, HttpStatus.CREATED);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Food>> findAllFood(){
        List<Food> findAllFood = foodService.findAllFood();
        return new ResponseEntity<List<Food>>(findAllFood,HttpStatus.OK);

    }

    /**
     * bu methot ıd ye göre delete yapar
     * @param id
     */
    @PostMapping("/delete")
    public void deleteRecipeById(Integer id){
        foodService.deleteRecipeById(id);
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
