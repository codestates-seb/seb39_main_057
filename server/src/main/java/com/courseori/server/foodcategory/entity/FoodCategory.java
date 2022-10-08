package com.courseori.server.foodcategory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int foodCategoryId;

    String category;

    public String setCategory(String category) {
        this.category = category;
        return category;
    }

    public FoodCategory(String category) {
        this.category = category;
    }
}
