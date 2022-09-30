package com.courseori.server.member.controller;


import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.mapper.MemberMapper;
import com.courseori.server.member.role.ROLE;
import com.courseori.server.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


//@RestController
@Controller
@RequestMapping("/v1/members")
@RequiredArgsConstructor
public class MemberController {


    private final MemberMapper mapper;
    private final MemberService memberService;


    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post responseBody){

        Member member = mapper.memberPostToMember(responseBody);
        member.setRole(ROLE.ROLE_USER);

        Member createMember = memberService.createMember(member);


        return new ResponseEntity(mapper.memberToMemberResponse(member), HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(
            @PathVariable("member-id") @Positive long memberId,
            @Valid @RequestBody MemberDto.Patch responseBody){
        responseBody.setMemberId(memberId);

        Member updateMember = memberService.updateMember(mapper.memberPatchToMember(responseBody));

        return new ResponseEntity(mapper.memberToMemberResponse(updateMember),HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(
            @PathVariable("member-id") @Positive long memberId){

                //멤버 찾기용
                Member findMember = memberService.getMember(memberId);

        System.out.println("멤버 가져오기");

                return new ResponseEntity(mapper.memberToMemberResponse(findMember),HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(
            @PathVariable("member-id") @Positive long memberId){

        memberService.deleteMember(memberId);

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
