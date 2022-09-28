package com.courseori.server.item.entity;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.participants.Participants;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    private String title;

    @OneToOne(cascade = CascadeType.PERSIST)
    private FoodCategory category;

    private Long createdAt = new Date().getTime();
    private Long modifiedAt  = new Date().getTime();

    private Long deadline;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "P_LOCATION_ID")
    private Location pickupLocation;

    private String restaurantName;

    private String restaurantUrl;

    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonManagedReference
    private List<Participants> participantsList = new ArrayList<>();

    private String body;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ImageUrl imageUrl;

    public Item(Member member, String title, FoodCategory category, Long deadline, Location restaurantLocation, String restaurantName, String restaurantUrl, String body, ImageUrl imageUrl) {
        this.member = member;
        this.title = title;
        this.category = category;
        this.deadline = deadline;
        this.pickupLocation = restaurantLocation;
        this.restaurantName = restaurantName;
        this.restaurantUrl = restaurantUrl;
        this.body = body;
        this.imageUrl = imageUrl;
    }

    /* 필요여부 확인 후 삭제 */
    public void addParticipants(Participants participants) {
        participantsList.add(participants);
        System.out.println("Participants list from Item entity: ");
        participantsList.stream().forEach(n -> System.out.println(n.toString()));
    }
}
