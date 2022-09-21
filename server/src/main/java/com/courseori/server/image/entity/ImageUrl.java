package com.courseori.server.image.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class ImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Nullable
    private String url;

    @Size(min = 1)
    private int type;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime modifiedAt = LocalDateTime.now();
}
