package com.example.yemekTarifi.service;


import com.example.yemekTarifi.entity.Recipe;
import com.example.yemekTarifi.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe){
        Recipe updatedRecipe= recipeRepository.getReferenceById(Math.toIntExact((recipe.getId())));
        updatedRecipe.setName(recipe.getName());
        updatedRecipe.setDescription(recipe.getDescription());
        updatedRecipe.setTime(recipe.getTime());
        updatedRecipe.setTypeOfMeal(recipe.getTypeOfMeal());
        return recipeRepository.save(updatedRecipe);
    }

    public List<Recipe> findAllFood(){
        return recipeRepository.findAll();
    }
    public void deleteRecipeById(Long id){
        recipeRepository.deleteById(Math.toIntExact(id));
    }

}
