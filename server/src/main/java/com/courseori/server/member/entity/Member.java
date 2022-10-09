package com.courseori.server.member.entity;

import com.courseori.server.member.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    // 추가
    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 13, nullable = false, unique = true)
    private String phone;

    // 추가
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "P_LOCATION_ID")
//    private Location location;

    //    @OneToOne
//    private ImageUrl profileImageUrl;
//
//    private Long joinedAt = new Date().getTime();
//
////    private Long modifiedAt = new Date().getTime();

    private String paymentMethod;


    private String provider;
    private String providerId;

    public Member(String email) {
        this.email = email;
    }

    public Member(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

}
