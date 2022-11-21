package com.example.yemekTarifi.controller;


import com.example.yemekTarifi.entity.Product;
import com.example.yemekTarifi.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/save")
    public ResponseEntity<Product> addProduct(Product product){
        Product addProduct=productService.addProduct(product);
        return new ResponseEntity<Product>(addProduct, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct(){
        List<Product>  findAllProduct=productService.findAllProduct();
        return  new ResponseEntity<List<Product>>(findAllProduct,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public void deleteProductById(Integer id){
        productService.deleteProductById(id);
    }
}
