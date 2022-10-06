package com.courseori.server.location.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "location_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "11"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    private long locationId;

    private String nameOfPlace;

    private String korAddress;

    private String addressDetail;

    private int type;

    private float latitude;

    private float longitude;

    private Long createAt = new Date().getTime();

    private Long modifiedAt = new Date().getTime();

    public Location(String nameOfPlace, String korAddress, String addressDetail, int type, float latitude, float longitude) {
        this.nameOfPlace = nameOfPlace;
        this.korAddress = korAddress;
        this.addressDetail = addressDetail;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
