package com.courseori.server.foodcategory.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class FoodCategory {

    @Id
    int foodCategoryId;

    String category;

    LocalDateTime createdAt;
    LocalDateTime modifiedAt;

}
