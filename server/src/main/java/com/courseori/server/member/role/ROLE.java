package com.courseori.server.member.role;

import com.courseori.server.member.entity.Member;
import lombok.*;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public enum ROLE {

        ROLE_USER(0,"ROLE_USER"),
        ROLE_ADMIN(1,"ROLE_ADMIN");

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long roleId;


        @JoinColumn(name = "memberId")
        @ManyToOne
        private Member member;

        int roleNum;

        String roleName;


        ROLE(int roleNum, String roleName) {
            this.roleNum = roleNum;
            this.roleName = roleName;
        }

        public void setMember(Member member) {
                this.member = member;
                if(member.getRole() != this){
                        member.setRole(this);
                }
        }
}
