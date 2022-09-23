package com.courseori.server.member.role;

import com.courseori.server.member.entity.Member;
import lombok.Data;
import lombok.Getter;
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


    @OneToOne
    private Member member;


    @Getter
    public enum ROLE{

        ROLE_NONE(0,"ROLE_NONE"),
        ROLE_USER(1,"ROLE_USER");

        int roleNum;

        String roleName;

        ROLE(int roleNum, String roleName) {
            this.roleNum = roleNum;
            this.roleName = roleName;
        }
    }

}
