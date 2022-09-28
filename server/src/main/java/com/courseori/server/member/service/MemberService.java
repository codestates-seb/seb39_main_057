package com.courseori.server.member.service;

import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member){
        Member saveMember = memberRepository.save(member);

        return saveMember;
    }

    public Member updateMember(Member member){
        Member findMember = findVerifiedMember(member.getMemberId());

        findMember.setUsername(member.getUsername());
        findMember.setPassword(member.getPhoneNumber());
        findMember.setPhoneNumber(member.getProfileImageUrl());
        findMember.setProfileImageUrl(member.getProfileImageUrl());

        return findMember;
    }

    public Member getMember(long memberId){
        return findVerifiedMember(memberId);

    }

    public void deleteMember(long memberId){
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);

    }

    public Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() -> new RuntimeException());
        return findMember;

    }

}
