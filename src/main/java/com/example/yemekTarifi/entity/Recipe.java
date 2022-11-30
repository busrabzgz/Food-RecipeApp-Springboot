package com.example.yemekTarifi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time_required_to_cook")
    private Double time;

    @Column(name = "type_of_meal")
    private String typeOfMeal;

    @OneToMany(fetch = FetchType.LAZY)// lazy
    private List<Ingredient> ingredients;




}
