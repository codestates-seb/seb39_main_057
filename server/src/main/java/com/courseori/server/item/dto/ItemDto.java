package com.courseori.server.item.dto;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.participants.Participants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ItemDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Post {

        private long memberId;


        private String title;

        @Min(2)
        private int recruit;

        @NotBlank(message = "카테고리를 설정해주세요.")
        private String category;

        @NotNull(message = "모집 마감시간을 설정해주세요")
        private Long deadline;

        @NotNull(message = "음식을 픽업할 장소를 설정해주세요")
        private Location pickupLocation;

        @NotBlank(message = " 문할 식당을 입력해주세요.")
        private String restaurantName;

        private String restaurantUrl;

        @NotBlank(message = "상세한 주문 내용을 입력해주세요")
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

        private String title;

        @Min(2)
        private int recruit;

        @NotBlank(message = "카테고리를 설정해주세요.")
        private String category;

        @NotNull(message = "모집 마감시간을 설정해주세요")
        private Long deadline;

        @NotNull(message = "음식을 픽업할 장소를 설정해주세요")
        private Location pickupLocation;

        @NotBlank(message = " 문할 식당을 입력해주세요.")
        private String restaurantName;

        private String restaurantUrl;

        private List<Participants> participantsList;

        @NotBlank(message = "상세한 주문 내용을 입력해주세요")
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

        private int recruit;

        private FoodCategory category;

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
