package com.example.yemekTarifi.service;


import com.example.yemekTarifi.entity.Food;
import com.example.yemekTarifi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository){
        this.foodRepository=foodRepository;
    }

    public Food addRecipe(Food food){
        return foodRepository.save(food);
    }

    public List<Food> findAllFood(){
        return foodRepository.findAll();
    }
    public void deleteRecipeById(Integer id){
        foodRepository.deleteById(id);
    }

}
