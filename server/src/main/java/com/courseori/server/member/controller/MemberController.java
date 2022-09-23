package com.courseori.server.member.controller;

import com.courseori.server.member.aouth.PrincipalDetails;
import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


//@RestController
@Controller
@RequestMapping("/v1/members")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;


    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody Member member){

        member.setPassword(encoder.encode(member.getPassword()));

        memberRepository.save(member);

        return new ResponseEntity(member, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(
            @PathVariable("member-id") @Positive long memberId,
            @Valid @RequestBody MemberDto.Patch requestBody){

        Member foundMember = memberRepository.findById(memberId).orElseThrow();

        foundMember.setUsername(requestBody.getUsername());
        foundMember.setPassword(encoder.encode(requestBody.getPassword()));
        foundMember.setPhoneNumber(requestBody.getPhoneNumber());
        foundMember.setProfileImageUrl(requestBody.getProfileImageUrl());

        memberRepository.save(foundMember);


        System.out.println("Todo 패치 완료");


        return new ResponseEntity(foundMember,HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(
            @PathVariable("member-id") @Positive long memberId){

                //멤버 찾기용
                Member findMember = memberRepository.findById(memberId).orElseThrow();

        System.out.println("멤버 가져오기");

                return new ResponseEntity(findMember,HttpStatus.OK);
    }


    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(
            @PathVariable("member-id") @Positive long memberId){

        memberRepository.deleteById(memberId);

        System.out.println("멤버 삭제 : " + memberId + "번 멤버");


        return new ResponseEntity<>( "OK",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

   @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/manager")
    @ResponseBody
    public String manager(){
        return "manager";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }


}
