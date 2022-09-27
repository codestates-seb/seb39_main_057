package com.courseori.server.member.dto;

import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.member.role.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class MemberDto {


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Post{

        @NotBlank(message = "이름을 입력해주세요.")
        @Size(min = 2, max = 8, message = "이름을 2자 ~ 8자 사이로 입력해주세요.")
        private String username;

        @Column(length = 200)
        private String password;

        @Column(updatable = false, unique = true)
        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "올바른 이메일 형식을 입력해주세요.")
        private String email;

        @Column(length = 200, unique = true)
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호를 입력해주세요.")
        private String phoneNumber;

        private Roles roles;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch{

        long memberId;

        @NotBlank(message = "이름을 입력해주세요.")
        @Size(min = 2, max = 8, message = "이름을 2자 ~ 8자 사이로 입력해주세요.")
        private String username;

        @Column(length = 200)
        private String password;

        @Column(length = 200, unique = true)
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호를 입력해주세요.")
        private String phoneNumber;

        private ImageUrl profileImageUrl;

    }

    @Getter
    @AllArgsConstructor
    public class Response{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long memberId;

        private String username;

        private String email;

        private String password;

        private String phoneNumber;

        private ImageUrl profileImageUrl;

        private Date joinedAt;

        private String paymentMethod;

        //권한 부여에 대한 엔티티 입니다.
        private Roles roles; // User, MANAGER, ADMIN

    }
}
