package com.example.yemekTarifi.repository;

import com.example.yemekTarifi.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Integer> {



}
