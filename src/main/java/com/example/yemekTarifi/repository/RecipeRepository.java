package com.example.yemekTarifi.repository;

import com.example.yemekTarifi.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {



}
