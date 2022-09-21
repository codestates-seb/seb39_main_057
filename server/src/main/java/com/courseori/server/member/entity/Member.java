package com.courseori.server.member.entity;


import com.courseori.server.member.role.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 8, message = "이름을 2자 ~ 8자 사이로 입력해주세요.")
    private String username;


    @Column(updatable = false, unique = true)
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식을 입력해주세요.")
    private String email;

    @Column(length = 200)
    private String password;

    @Column(length = 200, unique = true)
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호를 입력해주세요.")
    private String phoneNumber;


    private Integer totalOrders;


    private String profileImageUrl;


    private LocalDateTime joinedAt = LocalDateTime.now();


//    private List<Orders> ordersList;


//    private Map<Double,Double> latiAndLongi;


//    private String paymentMethod; <- 차후 추가 예정

    //권한 부여에 대한 엔티티 입니다.

    @OneToOne
    private Roles roles;

    public List<String> getRoleList() {
        if(this.roles.getRole().length()> 0) {
            return Arrays.asList(this.roles.getRole());
        }
        return new ArrayList<>();
    }
}
