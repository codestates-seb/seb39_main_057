package com.courseori.server.member.service;

import com.courseori.server.member.entity.Member;
import com.courseori.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final BCryptPasswordEncoder encoder;
    private final MemberRepository memberRepository;

    public Member createMember(Member member){
        member.setPassword(encoder.encode(member.getPassword()));
        Member saveMember = memberRepository.save(member);

        return saveMember;
    }

    public Member updateMember(Member member){
        Member findMember = findVerifiedMember(member.getMemberId());

        findMember.setUsername(member.getUsername());
        findMember.setPassword(encoder.encode(member.getPassword()));
        findMember.setPhoneNumber(member.getProfileImageUrl());
        findMember.setProfileImageUrl(member.getProfileImageUrl());

        return findMember;
    }

    public Member getMember(long memberId){
        return findVerifiedMember(memberId);

    }

    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
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
