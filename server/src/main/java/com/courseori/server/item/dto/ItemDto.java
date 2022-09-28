package com.courseori.server.item.dto;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.participants.Participants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ItemDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        private long memberId;

        private String title;
        private String category;

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
//        private Date deadline;
        private Long deadline;
        private Location pickupLocation;

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

//        private Date deadline;
        private Long deadline;
        private Location pickupLocation;

        private String restaurantName;
        private String restaurantUrl;

        private List<Participants> participantsList;

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
//        private Date createdAt;
//        private Date modifiedAt;

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
//        private Date deadline;

        private Long createdAt;
        private Long modifiedAt;
        private Long deadline;

        private Location pickupLocation;

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
