package com.courseori.server.image.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class ImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageUrlId;

    private String url;

    @Size(min = 1)
    private int type;

    private Date createAt = new Date();
    private Date modifiedAt = new Date();

    public ImageUrl(String url, int type) {
        this.url = url;
        this.type = type;
    }
}
