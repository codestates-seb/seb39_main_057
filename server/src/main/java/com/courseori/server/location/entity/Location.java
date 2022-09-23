package com.courseori.server.location.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;


    private String nameOfPlace;

    private int type;

    private float latitude;

    private float longitude;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime modifiedAt = LocalDateTime.now();

//    public Location(String nameOfPlace, int type, float latitude, float longitude) {
//        this.nameOfPlace = nameOfPlace;
//        this.type = type;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }
}
