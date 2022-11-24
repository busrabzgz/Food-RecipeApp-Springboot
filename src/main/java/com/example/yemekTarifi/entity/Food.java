package com.example.yemekTarifi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.text.html.StyleSheet;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id")
    private Integer id;

    @Column(name = "food_name")
    private String name;

    @Column(name = "food_description")
    private String description;

    @Column(name = "time_required_to_cook")
    private Double time;

    @Column(name = "type_of_meal")
    private String typeOfMeal;

    @OneToMany(mappedBy = "food")// lazy

    private List<Product> products;




}
