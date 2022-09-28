package com.courseori.server.member.dto;


import com.courseori.server.member.entity.Member;
import com.courseori.server.member.role.ROLE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class MemberDto {


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post{
        private String username;
        private String email;
        private String password;
        private String phoneNumber;
        private String profileImageUrl;
    }

    //patch 만을 위한 DTO입니다.
    //참고할 게 있다면 Service에 Update와
    //Controller에 Update 로직을 참고하세요
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Patch{
        private long memberId;
        private String username;
        private String phoneNumber;
        private String profileImageUrl;
    }


    @Getter
    @AllArgsConstructor
    public static class Response{

        private long memberId;
        private String username;
        private String email;
        private String phoneNumber;
        private String profileImageUrl;
        private LocalDateTime modifiedAt = LocalDateTime.now();
        private LocalDateTime joinedAt = LocalDateTime.now();
//   private String paymentMethod; <- 차후 추가 예정

        //권한 부여에 대한 엔티티 입니다.

        private ROLE role;
    }


}
