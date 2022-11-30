package com.example.yemekTarifi.controller;


import com.example.yemekTarifi.entity.Ingredient;
import com.example.yemekTarifi.entity.Recipe;
import com.example.yemekTarifi.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;
    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }
    @PostMapping("/add")
    public ResponseEntity<Ingredient> addProduct(Ingredient ingredient){
        Ingredient addIngredient = ingredientService.addIngredient(ingredient);
        return new ResponseEntity<Ingredient>(addIngredient, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient){
        Ingredient updateIngredient= ingredientService.updateIngredient(ingredient);
        return new ResponseEntity<Ingredient>(updateIngredient, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ingredient>> findAllProduct(){
        List<Ingredient> findAllIngredient = ingredientService.findAllIngredient();
        return  new ResponseEntity<List<Ingredient>>(findAllIngredient,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public void deleteProductById(Long id){
        ingredientService.deleteIngredientById(id);
    }
}
