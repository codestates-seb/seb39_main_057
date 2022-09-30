package com.courseori.server.item.controller;

import com.courseori.server.helper.StubData;
import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import com.courseori.server.item.mapper.ItemMapper;
import com.courseori.server.item.service.ItemService;
import com.courseori.server.member.repository.MemberRepository;
import com.courseori.server.participants.service.ParticipantsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@WithMockUser
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson = new GsonBuilder().serializeNulls().create();

    @MockBean
    private ItemService itemService;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private ParticipantsService participantsService;

    @MockBean
    private ItemMapper itemMapper;

    @Test
    public void getItemTest() throws Exception {

        //given
        long itemId = 1L;
        ItemDto.Response response = StubData.getSingleResponseBody();

        given(itemService.findItem(Mockito.anyLong())).willReturn(new Item());
        given(itemMapper.itemToItemResponse(Mockito.any(Item.class))).willReturn(response);

        //when
        ResultActions actions = mockMvc.perform(
                get("/items/{item-id}", itemId)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemId").value(itemId))
                .andExpect(jsonPath("$.memberId").value(response.getMemberId()))
                .andExpect(jsonPath("$.title").value(response.getTitle()))
                .andExpect(jsonPath("$.category.category").value(response.getCategory().getCategory()))
                .andExpect(jsonPath("$.pickupLocation.nameOfPlace").value(response.getPickupLocation().getNameOfPlace()))
                .andExpect(jsonPath("$.restaurantName").value(response.getRestaurantName()))
                .andExpect(jsonPath("$.restaurantUrl").value(response.getRestaurantUrl()))
                .andExpect(jsonPath("$.participantsList").value(response.getParticipantsList()))
                .andExpect(jsonPath("$.body").value(response.getBody()))
                .andExpect(jsonPath("$.imageUrl.url").value(response.getImageUrl().getUrl()))

                .andDo(
                        document(
                                "get-item",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("item-id").description("게시글 식별자"))
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("itemId").type(JsonFieldType.NUMBER).description("게시글 식별자"),
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("title").type(JsonFieldType.STRING).description("타이틀"),
                                                fieldWithPath("category.foodCategoryId").type(JsonFieldType.NUMBER).description("카테고리 식별자"),
                                                fieldWithPath("category.category").type(JsonFieldType.STRING).description("카테고리"),
                                                fieldWithPath("category.createdAt").type(JsonFieldType.NUMBER).description("카테고리 생성 일자"),
                                                fieldWithPath("category.modifiedAt").type(JsonFieldType.NUMBER).description("카테고리 수정 일자"),
                                                fieldWithPath("createdAt").type(JsonFieldType.NUMBER).description("생성 일자"),
                                                fieldWithPath("modifiedAt").type(JsonFieldType.NUMBER).description("수정 일자"),
                                                fieldWithPath("deadline").type(JsonFieldType.NUMBER).description("마감 일자"),
                                                fieldWithPath("pickupLocation.locationId").type(JsonFieldType.NUMBER).description("픽업 장소"),
                                                fieldWithPath("pickupLocation.nameOfPlace").type(JsonFieldType.STRING).description("픽업 장소 이름"),
                                                fieldWithPath("pickupLocation.korAddress").type(JsonFieldType.STRING).description("픽업 장소 기본 주소"),
                                                fieldWithPath("pickupLocation.addressDetail").type(JsonFieldType.STRING).description("픽업 장소 상세 주소"),
                                                fieldWithPath("pickupLocation.type").type(JsonFieldType.NUMBER).description("픽업 장소 타입"),
                                                fieldWithPath("pickupLocation.latitude").type(JsonFieldType.NUMBER).description("픽업 장소 위도"),
                                                fieldWithPath("pickupLocation.longitude").type(JsonFieldType.NUMBER).description("픽업 장소 경도"),
                                                fieldWithPath("pickupLocation.createAt").type(JsonFieldType.NUMBER).description("픽업 장소 생성 일자"),
                                                fieldWithPath("pickupLocation.modifiedAt").type(JsonFieldType.NUMBER).description("픽업 장소 수정 일자"),
                                                fieldWithPath("restaurantName").type(JsonFieldType.STRING).description("식당 이름"),
                                                fieldWithPath("restaurantUrl").type(JsonFieldType.STRING).description("식당 URL"),
                                                fieldWithPath("participantsList").type(JsonFieldType.ARRAY).description("참여자 리스트"),
                                                fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("imageUrl.imageUrlId").type(JsonFieldType.NUMBER).description("이미지 URL 식별자"),
                                                fieldWithPath("imageUrl.url").type(JsonFieldType.STRING).description("이미지 URL"),
                                                fieldWithPath("imageUrl.type").type(JsonFieldType.NUMBER).description("이미지 URL 타입"),
                                                fieldWithPath("imageUrl.createdAt").type(JsonFieldType.NUMBER).description("이미지 URL 생성 일자"),
                                                fieldWithPath("imageUrl.modifiedAt").type(JsonFieldType.NUMBER).description("이미지 URL 수정 일자")

                                        )
                                )
                        )
                );

    }

    @Test
    public void getItemsTest() throws Exception {

        //given
        String page = "1";
        String size = "10";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        Page<Item> itemPage = StubData.getMultiItems();
        List<ItemDto.Response> responseList = StubData.getMultiResponseBody();

        given(itemService.findItems(Mockito.anyInt(), Mockito.anyInt())).willReturn(itemPage);
        given(itemMapper.itemsToItemResponses(Mockito.anyList())).willReturn(responseList);

        //when
        ResultActions actions = mockMvc.perform(
          get("/items")
                  .params(queryParams)
                  .accept(MediaType.APPLICATION_JSON)
        );

        //then
        MvcResult result =
                actions
                        .andExpect(status().isOk())
                        .andDo(
                                document(
                                        "get-items",
                                        preprocessRequest(prettyPrint()),
                                        preprocessResponse(prettyPrint()),
                                        requestParameters(
                                                List.of(
                                                        parameterWithName("page").description("Page 번호"),
                                                        parameterWithName("size").description("Page 사이즈")
                                                )
                                        ),
                                        responseFields(
                                                List.of(
                                                    fieldWithPath("[].itemId").type(JsonFieldType.NUMBER).description("게시글 식별자"),
                                                    fieldWithPath("[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("타이틀"),
                                                        fieldWithPath("[].category.foodCategoryId").type(JsonFieldType.NUMBER).description("카테고리 식별자"),
                                                        fieldWithPath("[].category.category").type(JsonFieldType.STRING).description("카테고리"),
                                                        fieldWithPath("[].category.createdAt").type(JsonFieldType.NUMBER).description("카테고리 생성 일자"),
                                                        fieldWithPath("[].category.modifiedAt").type(JsonFieldType.NUMBER).description("카테고리 수정 일자"),
                                                        fieldWithPath("[].createdAt").type(JsonFieldType.NUMBER).description("카테고리 생성 일자"),
                                                        fieldWithPath("[].modifiedAt").type(JsonFieldType.NUMBER).description("카테고리 수정 일자"),
                                                        fieldWithPath("[].deadline").type(JsonFieldType.NUMBER).description("마감 시간"),
                                                        fieldWithPath("[].pickupLocation.locationId").type(JsonFieldType.NUMBER).description("픽업 장소"),
                                                        fieldWithPath("[].pickupLocation.nameOfPlace").type(JsonFieldType.STRING).description("픽업 장소 이름"),
                                                        fieldWithPath("[].pickupLocation.korAddress").type(JsonFieldType.STRING).description("픽업 장소 기본 주소"),
                                                        fieldWithPath("[].pickupLocation.addressDetail").type(JsonFieldType.STRING).description("픽업 장소 상세 주소"),
                                                        fieldWithPath("[].pickupLocation.type").type(JsonFieldType.NUMBER).description("픽업 장소 타입"),
                                                        fieldWithPath("[].pickupLocation.latitude").type(JsonFieldType.NUMBER).description("픽업 장소 위도"),
                                                        fieldWithPath("[].pickupLocation.longitude").type(JsonFieldType.NUMBER).description("픽업 장소 경도"),
                                                        fieldWithPath("[].pickupLocation.createAt").type(JsonFieldType.NUMBER).description("픽업 장소 생성 일자"),
                                                        fieldWithPath("[].pickupLocation.modifiedAt").type(JsonFieldType.NUMBER).description("픽업 장소 수정 일자"),
                                                        fieldWithPath("[].restaurantName").type(JsonFieldType.STRING).description("식당 이름"),
                                                        fieldWithPath("[].restaurantUrl").type(JsonFieldType.STRING).description("식당 URL"),
                                                        fieldWithPath("[].participantsList").type(JsonFieldType.ARRAY).description("참여자 리스트"),
                                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
                                                        fieldWithPath("[].imageUrl.imageUrlId").type(JsonFieldType.NUMBER).description("이미지 URL 식별자"),
                                                        fieldWithPath("[].imageUrl.url").type(JsonFieldType.STRING).description("이미지 URL"),
                                                        fieldWithPath("[].imageUrl.type").type(JsonFieldType.NUMBER).description("이미지 URL 타입"),
                                                        fieldWithPath("[].imageUrl.createdAt").type(JsonFieldType.NUMBER).description("이미지 URL 생성 일자"),
                                                        fieldWithPath("[].imageUrl.modifiedAt").type(JsonFieldType.NUMBER).description("이미지 URL 수정 일자")
                                                )
                                        )
                                )
                        ).andReturn();
    }

    @Test
    public void postItemTest() throws Exception{


        //given
        ItemDto.Post post = StubData.getSinglePostBody();

        String content = gson.toJson(post);

        ItemDto.Response response = StubData.getSingleResponseBody();

        given(itemMapper.itemPostToItem(Mockito.any(ItemDto.Post.class))).willReturn(new Item());
        given(itemService.createItem(Mockito.any(Item.class))).willReturn(new Item());
        given(itemMapper.itemToItemResponse(Mockito.any(Item.class))).willReturn(response);

        //when
        ResultActions actions =
                mockMvc.perform(

                        RestDocumentationRequestBuilders.post("/items")
                                .with(csrf())
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
        //then
        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.memberId").value(response.getMemberId()))
                .andExpect(jsonPath("$.title").value(response.getTitle()))
//                .andExpect(jsonPath("$.category").value(response.getCategory().getCategory()))
                .andExpect(jsonPath("$.pickupLocation.nameOfPlace").value(response.getPickupLocation().getNameOfPlace()))
                .andExpect(jsonPath("$.restaurantName").value(response.getRestaurantName()))
                .andExpect(jsonPath("$.restaurantUrl").value(response.getRestaurantUrl()))
                .andExpect(jsonPath("$.participantsList").value(response.getParticipantsList()))
                .andExpect(jsonPath("$.body").value(response.getBody()))
                .andExpect(jsonPath("$.imageUrl.url").value(response.getImageUrl().getUrl()))
                .andDo(document("post-item",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("title").type(JsonFieldType.STRING).description("타이틀"),
                                                fieldWithPath("category").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("deadline").type(JsonFieldType.NUMBER).description("마감 시간"),
                                                fieldWithPath("pickupLocation.locationId").type(JsonFieldType.NUMBER).description("픽업 장소"),
                                                fieldWithPath("pickupLocation.nameOfPlace").type(JsonFieldType.STRING).description("픽업 장소 이름"),
                                                fieldWithPath("pickupLocation.korAddress").type(JsonFieldType.STRING).description("픽업 장소 기본 주소"),
                                                fieldWithPath("pickupLocation.addressDetail").type(JsonFieldType.STRING).description("픽업 장소 상세 주소"),
                                                fieldWithPath("pickupLocation.type").type(JsonFieldType.NUMBER).description("픽업 장소 타입"),
                                                fieldWithPath("pickupLocation.latitude").type(JsonFieldType.NUMBER).description("픽업 장소 위도"),
                                                fieldWithPath("pickupLocation.longitude").type(JsonFieldType.NUMBER).description("픽업 장소 경도"),
                                                fieldWithPath("pickupLocation.createAt").type(JsonFieldType.NUMBER).description("픽업 장소 생성 일자"),
                                                fieldWithPath("pickupLocation.modifiedAt").type(JsonFieldType.NUMBER).description("픽업 장소 수정 일자"),
                                                fieldWithPath("restaurantName").type(JsonFieldType.STRING).description("식당 이름"),
                                                fieldWithPath("restaurantUrl").type(JsonFieldType.STRING).description("식당 URL"),
                                                fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("imageUrl.imageUrlId").type(JsonFieldType.NUMBER).description("이미지 URL 식별자"),
                                                fieldWithPath("imageUrl.url").type(JsonFieldType.STRING).description("이미지 URL"),
                                                fieldWithPath("imageUrl.type").type(JsonFieldType.NUMBER).description("이미지 URL 타입"),
                                                fieldWithPath("imageUrl.createdAt").type(JsonFieldType.NUMBER).description("이미지 URL 생성 일자"),
                                                fieldWithPath("imageUrl.modifiedAt").type(JsonFieldType.NUMBER).description("이미지 URL 수정 일자")
                                        )
                                )
                        )
                );
    }

    @Test
    public void patchItemTest() throws Exception{
        //given
        long itemId = 1L;
        ItemDto.Post patch = StubData.getSinglePostBody();

        String content = gson.toJson(patch);

        ItemDto.Response response = StubData.getSingleResponseBody();

        given(itemMapper.itemPatchToItem(Mockito.any(ItemDto.Patch.class))).willReturn(new Item());
        given(itemService.updateItem(Mockito.any(Item.class))).willReturn(new Item());
        given(itemMapper.itemToItemResponse(Mockito.any(Item.class))).willReturn(response);

        //when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders
                        .patch("/items/{item-id}", itemId).with(csrf())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemId").value(itemId))
                .andExpect(jsonPath("$.memberId").value(response.getMemberId()))
                .andExpect(jsonPath("$.title").value(response.getTitle()))
//                .andExpect(jsonPath("$.category.category").value(response.getCategory().getCategory()))
                .andExpect(jsonPath("$.pickupLocation.nameOfPlace").value(response.getPickupLocation().getNameOfPlace()))
                .andExpect(jsonPath("$.restaurantName").value(response.getRestaurantName()))
                .andExpect(jsonPath("$.restaurantUrl").value(response.getRestaurantUrl()))
                .andExpect(jsonPath("$.participantsList").value(response.getParticipantsList()))
                .andExpect(jsonPath("$.body").value(response.getBody()))
                .andExpect(jsonPath("$.imageUrl.url").value(response.getImageUrl().getUrl()))
                .andDo(
                        document("patch-item",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("item-id").description("게시글 식별자"))
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("title").type(JsonFieldType.STRING).description("타이틀"),
                                                fieldWithPath("category").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("deadline").type(JsonFieldType.NUMBER).description("마감 시간"),
                                                fieldWithPath("pickupLocation.locationId").type(JsonFieldType.NUMBER).description("픽업 장소"),
                                                fieldWithPath("pickupLocation.nameOfPlace").type(JsonFieldType.STRING).description("픽업 장소 이름"),
                                                fieldWithPath("pickupLocation.korAddress").type(JsonFieldType.STRING).description("픽업 장소 기본 주소"),
                                                fieldWithPath("pickupLocation.addressDetail").type(JsonFieldType.STRING).description("픽업 장소 상세 주소"),
                                                fieldWithPath("pickupLocation.type").type(JsonFieldType.NUMBER).description("픽업 장소 타입"),
                                                fieldWithPath("pickupLocation.latitude").type(JsonFieldType.NUMBER).description("픽업 장소 위도"),
                                                fieldWithPath("pickupLocation.longitude").type(JsonFieldType.NUMBER).description("픽업 장소 경도"),
                                                fieldWithPath("pickupLocation.createAt").type(JsonFieldType.NUMBER).description("픽업 장소 생성 일자"),
                                                fieldWithPath("pickupLocation.modifiedAt").type(JsonFieldType.NUMBER).description("픽업 장소 수정 일자"),
                                                fieldWithPath("restaurantName").type(JsonFieldType.STRING).description("식당 이름"),
                                                fieldWithPath("restaurantUrl").type(JsonFieldType.STRING).description("식당 URL"),
                                                fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("imageUrl.imageUrlId").type(JsonFieldType.NUMBER).description("이미지 URL 식별자"),
                                                fieldWithPath("imageUrl.url").type(JsonFieldType.STRING).description("이미지 URL"),
                                                fieldWithPath("imageUrl.type").type(JsonFieldType.NUMBER).description("이미지 URL 타입"),
                                                fieldWithPath("imageUrl.createdAt").type(JsonFieldType.NUMBER).description("이미지 URL 생성 일자"),
                                                fieldWithPath("imageUrl.modifiedAt").type(JsonFieldType.NUMBER).description("이미지 URL 수정 일자")
                                        )
                                ),
                                responseFields(
                                        Arrays.asList(
                                                fieldWithPath("itemId").type(JsonFieldType.NUMBER).description("게시글 식별자"),
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("title").type(JsonFieldType.STRING).description("타이틀"),
                                                fieldWithPath("category.foodCategoryId").type(JsonFieldType.NUMBER).description("내용"),
                                                fieldWithPath("category.category").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("category.createdAt").type(JsonFieldType.NUMBER).description("내용"),
                                                fieldWithPath("category.modifiedAt").type(JsonFieldType.NUMBER).description("내용"),
                                                fieldWithPath("createdAt").type(JsonFieldType.NUMBER).description("생성 일자"),
                                                fieldWithPath("modifiedAt").type(JsonFieldType.NUMBER).description("수정 일자"),
                                                fieldWithPath("deadline").type(JsonFieldType.NUMBER).description("마감 시간"),
                                                fieldWithPath("pickupLocation.locationId").type(JsonFieldType.NUMBER).description("픽업 장소"),
                                                fieldWithPath("pickupLocation.nameOfPlace").type(JsonFieldType.STRING).description("픽업 장소 이름"),
                                                fieldWithPath("pickupLocation.korAddress").type(JsonFieldType.STRING).description("픽업 장소 기본 주소"),
                                                fieldWithPath("pickupLocation.addressDetail").type(JsonFieldType.STRING).description("픽업 장소 상세 주소"),
                                                fieldWithPath("pickupLocation.type").type(JsonFieldType.NUMBER).description("픽업 장소 타입"),
                                                fieldWithPath("pickupLocation.latitude").type(JsonFieldType.NUMBER).description("픽업 장소 위도"),
                                                fieldWithPath("pickupLocation.longitude").type(JsonFieldType.NUMBER).description("픽업 장소 경도"),
                                                fieldWithPath("pickupLocation.createAt").type(JsonFieldType.NUMBER).description("픽업 장소 생성 일자"),
                                                fieldWithPath("pickupLocation.modifiedAt").type(JsonFieldType.NUMBER).description("픽업 장소 수정 일자"),
                                                fieldWithPath("restaurantName").type(JsonFieldType.STRING).description("식당 이름"),
                                                fieldWithPath("restaurantUrl").type(JsonFieldType.STRING).description("식당 URL"),
                                                fieldWithPath("participantsList").type(JsonFieldType.ARRAY).description("참여자 리스트"),
                                                fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("imageUrl.imageUrlId").type(JsonFieldType.NUMBER).description("이미지 URL 식별자"),
                                                fieldWithPath("imageUrl.url").type(JsonFieldType.STRING).description("이미지 URL"),
                                                fieldWithPath("imageUrl.type").type(JsonFieldType.NUMBER).description("이미지 URL 타입"),
                                                fieldWithPath("imageUrl.createdAt").type(JsonFieldType.NUMBER).description("이미지 URL 생성 일자"),
                                                fieldWithPath("imageUrl.modifiedAt").type(JsonFieldType.NUMBER).description("이미지 URL 수정 일자")
                                        )
                                )
                        ));
    }

    @Test
    public void deleteItemTest() throws Exception {

        //given
        long itemId = 1L;
        doNothing().when(itemService).deleteItem(Mockito.anyLong());

        //when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders
                        .delete("/items/{item-id}", itemId).with(csrf()));

        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-item",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("item-id").description("게시글 식별자"))
                                )
                        )
                );
    }

}
