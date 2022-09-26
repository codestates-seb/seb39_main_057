//package com.courseori.server.item.controller;
//
//import com.courseori.server.helper.StubData;
//import com.courseori.server.item.dto.ItemDto;
//import com.courseori.server.item.entity.Item;
//import com.courseori.server.item.mapper.ItemMapper;
//import com.courseori.server.item.service.ItemService;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
//import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
//import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ItemController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//@WithMockUser
//public class ItemControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson = new GsonBuilder().serializeNulls().create();
//
//    @MockBean
//    private ItemService itemService;
//
//    @MockBean
//    private ItemMapper itemMapper;
//
//    @Test
//    public void getItemTest() throws Exception {
//
//        //given
//        long itemId = 1L;
//        ItemDto.Response response = StubData.getSingleResponseBody();
//
//        given(itemService.findItem(Mockito.anyLong())).willReturn(new Item());
//        given(itemMapper.itemToItemResponse(Mockito.any(Item.class))).willReturn(response);
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                RestDocumentationRequestBuilders.get("/items/{item-id}", itemId)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        //then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.itemId").value(itemId))
//                .andExpect(jsonPath("$.memberId").value(response.getMemberId()))
//                .andExpect(jsonPath("$.title").value(response.getTitle()))
//                .andExpect(jsonPath("$.category").value(response.getCategory().toString()))
//                .andExpect(jsonPath("$.latiAndLongi").value(response.getLatiAndLongi()))
//                .andExpect(jsonPath("$.restaurantName").value(response.getRestaurantName()))
//                .andExpect(jsonPath("$.restaurantUrl").value(response.getRestaurantUrl()))
//                .andExpect(jsonPath("$.body").value(response.getBody()))
//                .andExpect(jsonPath("$.imageUrl").value(response.getImageUrl()))
//
//                .andDo(
//                        document(
//                                "get-item",
//                                preprocessRequest(prettyPrint()),
//                                preprocessResponse(prettyPrint()),
//                                pathParameters(
//                                        Arrays.asList(parameterWithName("item-id").description("게시글 식별자"))
//                                ),
//                                responseFields(
//                                        List.of(
//                                                fieldWithPath("itemId").type(JsonFieldType.NUMBER).description("게시글 식별자"),
//                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                                fieldWithPath("title").type(JsonFieldType.STRING).description("타이틀"),
//                                                fieldWithPath("category").type(JsonFieldType.STRING).description("내용"),
//                                                fieldWithPath("createdAt").type(JsonFieldType.STRING).description("생성 일자"),
//                                                fieldWithPath("modifiedAt").type(JsonFieldType.STRING).description("수정 일자"),
//                                                fieldWithPath("deadline").type(JsonFieldType.STRING).description("마감 시간"),
//                                                fieldWithPath("latiAndLongi.Latitude").type(JsonFieldType.NUMBER).description("위치 위도"),
//                                                fieldWithPath("latiAndLongi.Longitude").type(JsonFieldType.NUMBER).description("위치 경도"),
//                                                fieldWithPath("restaurantName").type(JsonFieldType.STRING).description("식당 이름"),
//                                                fieldWithPath("restaurantUrl").type(JsonFieldType.STRING).description("식당 URL"),
//                                                fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("이미지 URL")
//
//                                        )
//                                )
//                        )
//                );
//
//    }
//
//    @Test
//    public void getItemsTest() throws Exception {
//
//        //given
//        String page = "1";
//        String size = "10";
//
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", page);
//        queryParams.add("size", size);
//
////        Page<Item> itemPage =
//
//        /*
//         @GetMapping
//    public ResponseEntity getItems(@Positive @RequestParam int page,
//                                   @Positive @RequestParam int size) {
//
//        Page<Item> itemsPage = itemService.findItems(page, size);
//        List<Item> items = itemsPage.getContent();
//
//        List<ItemDto.Response> responses = itemMapper.itemsToItemResponses(items);
//
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//         */
//
//    }
//}
