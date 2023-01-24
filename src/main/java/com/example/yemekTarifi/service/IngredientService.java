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

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public Ingredient updateIngredient(Ingredient ingredient){
        Ingredient updatedIngredient= ingredientRepository.getReferenceById((ingredient.getId()));
        updatedIngredient.setName(ingredient.getName());
        updatedIngredient.setAmount(ingredient.getAmount());

        return ingredientRepository.save(updatedIngredient);
    }

    public List<Ingredient> findAllIngredient(){
        return ingredientRepository.findAll();
    }

    public void deleteIngredientById(Long id){
       ingredientRepository.deleteById(id);
    }





}
