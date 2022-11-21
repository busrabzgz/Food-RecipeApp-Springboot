package com.example.yemekTarifi.controller;


import com.example.yemekTarifi.entity.Food;
import com.example.yemekTarifi.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

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

    @CrossOrigin
    public SseEmitter subscribe(){

    }




}
