package com.courseori.server.location.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;


    private String nameOfPlace;

    private String korAddress;

    private String addressDetail;

    private int type;

    private float latitude;

    private float longitude;

    private Date createAt = new Date();

    private Date modifiedAt = new Date();

//    public Location(String nameOfPlace, int type, float latitude, float longitude) {
//        this.nameOfPlace = nameOfPlace;
//        this.type = type;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }
}
