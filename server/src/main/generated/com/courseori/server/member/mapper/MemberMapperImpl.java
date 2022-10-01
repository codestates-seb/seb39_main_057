package com.courseori.server.member.mapper;

import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.role.ROLE;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-28T14:50:55+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostToMember(MemberDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setUsername( requestBody.getUsername() );
        member.setEmail( requestBody.getEmail() );
        member.setPassword( requestBody.getPassword() );
        member.setPhoneNumber( requestBody.getPhoneNumber() );
        member.setProfileImageUrl( requestBody.getProfileImageUrl() );

        return member;
    }

    @Override
    public Member memberPatchToMember(MemberDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( requestBody.getMemberId() );
        member.setUsername( requestBody.getUsername() );
        member.setPhoneNumber( requestBody.getPhoneNumber() );
        member.setProfileImageUrl( requestBody.getProfileImageUrl() );

        return member;
    }

    @Override
    public MemberDto.Response memberToMemberResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String username = null;
        String email = null;
        String phoneNumber = null;
        String profileImageUrl = null;
        LocalDateTime modifiedAt = null;
        LocalDateTime joinedAt = null;
        ROLE role = null;

        memberId = member.getMemberId();
        username = member.getUsername();
        email = member.getEmail();
        phoneNumber = member.getPhoneNumber();
        profileImageUrl = member.getProfileImageUrl();
        modifiedAt = member.getModifiedAt();
        joinedAt = member.getJoinedAt();
        role = member.getRole();

        MemberDto.Response response = new MemberDto.Response( memberId, username, email, phoneNumber, profileImageUrl, modifiedAt, joinedAt, role );

        return response;
    }
}
