package com.courseori.server.member.controller;

import com.courseori.server.member.dto.MemberDto;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.mapper.MemberMapper;
import com.courseori.server.member.role.ROLE;
import com.courseori.server.member.service.MemberService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MemberController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebMvcConfigurer.class)})
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@ExtendWith(SpringExtension.class)
@WithMockUser
class MemberControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Autowired
    private Gson gson;




    Long modifiedAt = new Date().getTime();
    Long joinedAt = new Date().getTime();


    @Test
    @DisplayName("회원가입 로직 테스트 ")
    void postMember() throws Exception{

        //given
        String password = "1234";

        MemberDto.Post post = new MemberDto.Post("김코딩","test@naver.com",
                password,"010-1111-1111",
                "www.test.com");

        String content = gson.toJson(post);

        MemberDto.Response responseDto =
                new MemberDto.Response(1L,"김코딩","test@naver.com",
                "010-1111-1111","www.test.com", modifiedAt,joinedAt,ROLE.ROLE_USER);

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        //when
        ResultActions actions =
                mockMvc.perform(
                        post("/v1/members")
                                .with(csrf())
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );


        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value(post.getUsername()))
                .andExpect(jsonPath("$.email").value(post.getEmail()))
//                .andExpect(jsonPath("$.password").value(post.getPassword()))
                .andExpect(jsonPath("$.phoneNumber").value(post.getPhoneNumber()))
                .andExpect(jsonPath("$.profileImageUrl").value(post.getProfileImageUrl()))
                .andDo(document("post-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("휴대폰"),
                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 사진")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 사진"),
                                        fieldWithPath("joinedAt").type(JsonFieldType.NUMBER).description("가입 시간"),
                                        fieldWithPath("modifiedAt").type(JsonFieldType.NUMBER).description("수정 시간"),
                                        fieldWithPath("role").type(JsonFieldType.STRING).description("role")
                                )
                        )
                ));
    }

    @Test
    @DisplayName("회원 정보수정 로직 테스트 ")
    void patchMember() throws Exception {

        String password ="1234";
        //given
        long memberId = 1L;
        MemberDto.Patch patch =
                new MemberDto.Patch(memberId, "김바꿈","010-1111-1111",password,"www.change.com");
        String content = gson.toJson(patch);


        MemberDto.Response responseDto =
                new MemberDto.Response(memberId,"김바꿈","test@naver.com",
                        "010-1111-1111","www.change.com", modifiedAt, joinedAt, ROLE.ROLE_USER);

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        // when
        ResultActions actions =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.patch("/v1/members/{member-id}", memberId).with(csrf())
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(patch.getUsername()))
                .andExpect(jsonPath("$.phoneNumber").value(patch.getPhoneNumber()))
//                .andExpect(jsonPath("$.password").value(patch.getPassword()))
                .andExpect(jsonPath("$.profileImageUrl").value(patch.getProfileImageUrl()))
                .andDo(document("patch-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("휴대폰"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 사진")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 사진"),
                                        fieldWithPath("joinedAt").type(JsonFieldType.NUMBER).description("가입 시간"),
                                        fieldWithPath("modifiedAt").type(JsonFieldType.NUMBER).description("수정 시간"),
                                        fieldWithPath("role").type(JsonFieldType.STRING).description("role")
                                )
                        )
                ));

    }

    @Test
    @DisplayName("회원 정보 불러오기 로직 테스트 ")
    void getMember() throws Exception {
        long memberId = 1L;

        MemberDto.Response responseDto =
                new MemberDto.Response(1L,"김코딩","test@naver.com",
                        "010-1111-1111","www.test.com", modifiedAt, joinedAt,ROLE.ROLE_USER);

        given(memberService.getMember(Mockito.anyLong())).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/v1/members/{member-id}", memberId).with(csrf())
                        .accept(MediaType.APPLICATION_JSON));

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(memberId))
                .andDo(
                        document("get-member",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                                ),
                                responseFields(
                                        Arrays.asList(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("username").type(JsonFieldType.STRING).description("이메일"),
                                                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                                fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                                fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 사진"),
                                                fieldWithPath("joinedAt").type(JsonFieldType.NUMBER).description("가입 시간"),
                                                fieldWithPath("modifiedAt").type(JsonFieldType.NUMBER).description("수정 시간"),
                                                fieldWithPath("role").type(JsonFieldType.STRING).description("role")
                                        )
                                )
                        ));
    }

    @Test
    @DisplayName("회원 정보삭제 로직 테스트 ")
    void deleteMember() throws Exception {

        long memberId = 1L;
        doNothing().when(memberService).deleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.delete("/v1/members/{member-id}", memberId).with(csrf())
                        .accept(MediaType.APPLICATION_JSON));

        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-member",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                                )
                        )
                );
    }
}