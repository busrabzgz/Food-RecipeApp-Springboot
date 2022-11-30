package com.example.yemekTarifi.service;

import com.example.yemekTarifi.entity.Ingredient;
import com.example.yemekTarifi.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    public Ingredient saveProduct(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findAllProduct(){
        return ingredientRepository.findAll();
    }

    public void deleteProductById(Integer id){
        ingredientRepository.deleteById(id);
    }





}
