package com.courseori.server.member.dto;


import com.courseori.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

public class MemberDto {

    @NoArgsConstructor
    @Getter
    @Setter
    public static class Patch{
        private long memberId;
        private String username;
        private String password;
        private String profileImageUrl;
    }


}
