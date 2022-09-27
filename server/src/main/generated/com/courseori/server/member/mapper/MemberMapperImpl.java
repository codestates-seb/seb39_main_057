package com.courseori.server.member.mapper;

import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-27T15:14:15+0900",
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
        member.setPassword( requestBody.getPassword() );
        member.setProfileImageUrl( requestBody.getProfileImageUrl() );

        return member;
    }

    @Override
    public MemberDto.Response memberToMemberResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto.Response response = new MemberDto.Response();

        return response;
    }
}
