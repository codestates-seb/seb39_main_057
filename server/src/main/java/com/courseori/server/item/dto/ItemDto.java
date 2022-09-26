package com.courseori.server.item.dto;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.participants.Participants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
        private String restaurantName;
        private String restaurantUrl;


        private String body;
        private ImageUrl imageUrl;

        public Member getMember() {
            Member member = new Member();
            member.setMemberId(memberId);
            return member;
        }

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
        private String restaurantName;
        private String restaurantUrl;

        private List<Member> participantsList;

        private String body;
        private ImageUrl imageUrl;
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
        private String restaurantName;
        private String restaurantUrl;

        private List<Participants> participantsList;

        private String body;
        private ImageUrl imageUrl;

        public void setMember(Member member) {
            this.memberId = member.getMemberId();
        }

    }
}
