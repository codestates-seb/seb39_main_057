package com.courseori.server.member.entity;


import com.courseori.server.location.entity.Location;
import com.courseori.server.member.role.ROLE;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "member_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "13"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    private Long memberId;


//    @NotBlank(message = "이름을 입력해주세요.")
//    @Size(min = 2, max = 8, message = "이름을 2자 ~ 8자 사이로 입력해주세요.")
    private String username;


    @Column(updatable = false, unique = true)
//    @NotBlank(message = "이메일을 입력해주세요.")
//    @Email(message = "올바른 이메일 형식을 입력해주세요.")
    private String email;

    @Column(length = 200)
//    @JsonIgnore
    private String password;

    @Column(length = 200, unique = true)
//    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호를 입력해주세요.")
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "P_LOCATION_ID")
    private Location location;

//    @OneToOne
//    private ImageUrl profileImageUrl;
    private String profileImageUrl;

    private Long joinedAt = new Date().getTime();

    private Long modifiedAt = new Date().getTime();

   private String paymentMethod;

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

    public Member(String username, String email, String password, String phoneNumber, Location location, String profileImageUrl, String paymentMethod, ROLE roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.profileImageUrl = profileImageUrl;
        this.paymentMethod = paymentMethod;
        this.role = roles;
    }

    //롤 set
    public void setRole(ROLE role) {
        this.role = role;
        if (role.getMember() != this) {
            role.setMember(this);
        }
    }
}
