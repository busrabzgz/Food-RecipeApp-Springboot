package com.example.yemekTarifi.service;

import com.example.yemekTarifi.entity.Food;
import com.example.yemekTarifi.entity.Product;
import com.example.yemekTarifi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService (ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProductById(Integer id){
        productRepository.deleteById(id);
    }





}
