package com.courseori.server.item.dto;

import com.courseori.server.category.entity.Category;
import com.courseori.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

public class ItemDto {

    @AllArgsConstructor
    @Getter
    public static class Post {



    }

    @AllArgsConstructor
    @Getter
    public static class Patch {

    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class Response {

        private long itemId;
        private long memberId;

        private String title;
        private Category category;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private LocalDateTime deadline;
        private Map<String, Double> latiAndLongi;
        private String restaurantName;
        private String restaurantUrl;

//    private List<Member> participantsList;

        private String body;
        private String imageUrl;

        public void setMember(Member member) {
            this.memberId = member.getId();
        }

    }
}
