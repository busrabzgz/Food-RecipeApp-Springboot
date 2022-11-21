package com.example.yemekTarifi.repository;

import com.example.yemekTarifi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
