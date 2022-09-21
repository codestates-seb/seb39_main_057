package com.courseori.server.item.entity;

import com.courseori.server.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long itemId;

    private long memberId = 1L; //나중에 Member로 변경

    private String title;

    private Category category;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime modifiedAt = LocalDateTime.now();

    private LocalDateTime deadline;

    @ElementCollection(targetClass = String.class)
    private Map<String, Double> latiAndLongi;

    private String restaurantName;

    private String restaurantUrl;

//    private List<Member> participantsList;

    private String body;

    private String imageUrl;

    public Item(long memberId, String title, Category category, LocalDateTime deadline, Map<String, Double> latiAndLongi, String restaurantName, String restaurantUrl, String body, String imageUrl) {
        this.memberId = memberId;
        this.title = title;
        this.category = category;
        this.deadline = deadline;
        this.latiAndLongi = latiAndLongi;
        this.restaurantName = restaurantName;
        this.restaurantUrl = restaurantUrl;
        this.body = body;
        this.imageUrl = imageUrl;
    }
}
