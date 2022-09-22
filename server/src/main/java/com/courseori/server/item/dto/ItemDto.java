package com.courseori.server.item.dto;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Map;

public class ItemDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        private long memberId;

        private String title;
        private FoodCategory category;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private LocalDateTime deadline;
        private Location restaurantLocation;
        private Location pickupLocation;
        private String restaurantName;
        private String restaurantUrl;

//    private List<Member> participantsList;

        private String body;
        private String imageUrl;


    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Patch {
        private long itemId;
        private long memberId;

        private String title;
        private FoodCategory category;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private LocalDateTime deadline;
        private Location restaurantLocation;
        private Location pickupLocation;
        private String restaurantName;
        private String restaurantUrl;

//    private List<Member> participantsList;

        private String body;
        private String imageUrl;
    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class Response {

        private long itemId;
        private long memberId;

        private String title;
        private FoodCategory category;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private LocalDateTime deadline;
        private Location restaurantLocation;
        private Location pickupLocation;
        private String restaurantName;
        private String restaurantUrl;

//    private List<Member> participantsList;

        private String body;
        private String imageUrl;

//        public void setMember(Member member) {
//            this.memberId = member.getMemberId();
//        }

    }
}
