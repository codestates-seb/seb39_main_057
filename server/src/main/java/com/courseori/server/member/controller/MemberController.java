package com.courseori.server.member.controller;


import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.mapper.MemberMapper;
import com.courseori.server.member.role.ROLE;
import com.courseori.server.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;


@Controller
@RequestMapping("/v1/members")
@RequiredArgsConstructor
@CrossOrigin("*")
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

    @GetMapping()
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {

        Page<Member> membersPage = memberService.findMembers(page, size);
        List<Member> members = membersPage.getContent();

        List<MemberDto.Response> responses = mapper.membersToMemberResponses(members);

        return new ResponseEntity(responses,HttpStatus.OK);
    }

//    @GetMapping()
//    public ResponseEntity getMembers() {
//
//        List<Member> members = memberService.findMembers();
//
//        List<MemberDto.Response> responses = mapper.membersToMemberResponses(members);
//
//        return new ResponseEntity(responses,HttpStatus.OK);
//    }


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

    @PostMapping("/login")
    public ResponseEntity loginPost() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
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
