package com.courseori.server.member.role;

import com.courseori.server.member.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @NotBlank
    private String role;

    @OneToOne
    @JoinColumn(name = "id")
    private Member member;

}
