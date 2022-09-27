package com.courseori.server.member.dto;


import com.courseori.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

public class MemberDto {
    //patch 만을 위한 DTO입니다.
    //참고할 게 있다면 Service에 Update와
    //Controller에 Update 로직을 참고하세요
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
