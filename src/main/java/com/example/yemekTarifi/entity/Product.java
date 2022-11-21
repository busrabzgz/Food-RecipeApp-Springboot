package com.example.yemekTarifi.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "producy_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name="food_id")
    private Food food;


}
