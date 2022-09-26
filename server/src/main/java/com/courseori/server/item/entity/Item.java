package com.courseori.server.item.entity;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.participants.Participants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long itemId;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    private String title;

    @OneToOne
    private FoodCategory category;

    private Date createdAt;

    private Date modifiedAt;

    private Date deadline;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "R_LOCATION_ID")
    private Location restaurantLocation;


    private String restaurantName;

    private String restaurantUrl;

    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Participants> participantsList = new ArrayList<>();

    private String body;

    @OneToOne
    private ImageUrl imageUrl;

    public Item(Member member, String title, FoodCategory category, Date deadline, Location restaurantLocation, String restaurantName, String restaurantUrl, String body, ImageUrl imageUrl) {
        this.member = member;
        this.title = title;
        this.category = category;
        this.deadline = deadline;
        this.restaurantLocation = restaurantLocation;
        this.restaurantName = restaurantName;
        this.restaurantUrl = restaurantUrl;
        this.body = body;
        this.imageUrl = imageUrl;
    }
}
