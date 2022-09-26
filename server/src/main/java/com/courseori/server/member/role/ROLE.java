package com.courseori.server.member.role;

import com.courseori.server.member.entity.Member;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public enum ROLE {

        ROLE_USER(1,"ROLE_USER"),
        ROLE_ADMIN(2,"ROLE_ADMIN");

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long RoleId;

        @OneToOne
        @JoinColumn(name = "MEMBER_ID")
        private Member member;

        int roleNum;

        String roleName;

        ROLE(int roleNum, String roleName) {
            this.roleNum = roleNum;
            this.roleName = roleName;
        }
}
