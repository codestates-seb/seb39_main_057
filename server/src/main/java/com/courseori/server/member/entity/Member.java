package com.courseori.server.member.entity;


import com.courseori.server.member.role.ROLE;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;


    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 8, message = "이름을 2자 ~ 8자 사이로 입력해주세요.")
    private String username;


    @Column(updatable = false, unique = true)
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식을 입력해주세요.")
    private String email;

    @Column(length = 200)
    @JsonIgnore
    private String password;

    @Column(length = 200, unique = true)
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호를 입력해주세요.")
    private String phoneNumber;


    private Integer totalOrders;


    private String profileImageUrl;


    private LocalDateTime joinedAt = LocalDateTime.now();

    private LocalDateTime modifiedAt = LocalDateTime.now();



//   private String paymentMethod; <- 차후 추가 예정

    //권한 부여에 대한 엔티티 입니다.

    private ROLE role;

    private String provider;
    private String providerId;

    //jwt
    @Builder(builderClassName = "UserDetailRegister", builderMethodName = "userDetailRegister")
    public Member(String username, String email, String password, String phoneNumber, String profileImageUrl,ROLE role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profileImageUrl = profileImageUrl;
        this.role = role;
    }


    //oauth2
    @Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
    public Member(String username, String email, String password, String phoneNumber, String profileImageUrl, ROLE role, String provider, String providerId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profileImageUrl = profileImageUrl;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    //롤 set
    public void setRole(ROLE role) {
        this.role = role;
        if (role.getMember() != this) {
            role.setMember(this);
        }
    }
}
