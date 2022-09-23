package com.courseori.server.posts.entity;

import com.courseori.server.category.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    private long id;

    private long memberId = 1L; //나중에 Member로 변경

    private String title;

    private Category category;

    private Date createdAt;

    private Date modifiedAt;

    private Date deadline;

//    private Map<Double, Double> latiAndLongi;

    private String restaurantName;

    private String restaurantUrl;

//    private List<Member> participantsList;

    private String body;

    private String imageUrl;

}
