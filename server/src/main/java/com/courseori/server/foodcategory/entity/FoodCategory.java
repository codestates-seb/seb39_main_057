package com.courseori.server.foodcategory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int foodCategoryId;

    String category;

    Date createdAt = new Date();
    Date modifiedAt = new Date();

    public String setCategory(String category) {
        this.category = category;
        return category;
    }
}
