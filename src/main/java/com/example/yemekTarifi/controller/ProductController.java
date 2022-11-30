package com.example.yemekTarifi.controller;


import com.example.yemekTarifi.entity.Ingredient;
import com.example.yemekTarifi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private final IngredientService ingredientService;
    public ProductController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }
    @PostMapping("/save")
    public ResponseEntity<Ingredient> addProduct(Ingredient ingredient){
        Ingredient newIngredient = new Ingredient();
        Ingredient addIngredient = ingredientService.saveProduct(newIngredient);
        return new ResponseEntity<Ingredient>(addIngredient, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Ingredient>> findAllProduct(){
        List<Ingredient> findAllIngredient = ingredientService.findAllProduct();
        return  new ResponseEntity<List<Ingredient>>(findAllIngredient,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public void deleteProductById(Integer id){
        ingredientService.deleteProductById(id);
    }
}
