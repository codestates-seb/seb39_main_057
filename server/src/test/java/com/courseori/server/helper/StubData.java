package com.courseori.server.helper;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.image.entity.ImageUrl;
import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.role.ROLE;
import com.courseori.server.participants.Participants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StubData {

    static Date date = new Date();
    static Long createdAt = date.getTime();
    static Long modifiedAt = date.getTime();
    static Long deadline = date.getTime();
    static Location pickupLocation = new Location("더큰내일센터", "제주도 연북로", "2층 우도 회의실", 1, (float)123.1234, (float)123.1234);
    static List<Participants> participantsList = new ArrayList<>();
    static ImageUrl imageUrl = new ImageUrl("http://test.com", 1);
//    static Roles roles = new Roles("ROLE_USER");
    static ROLE roles = ROLE.ROLE_USER;

    static Member member = new Member("User1", "test@email.com", "password", "010-1111-1111", pickupLocation, imageUrl.getUrl(),  "Card", roles );

    static FoodCategory foodCategory = new FoodCategory("Category1");

    /* Single post and response */
    //Post에서 Item으로 메서드명 변경 필요
    public static Item getSinglePost() {

        Item item = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);

        return item;
    }

    public static ItemDto.Response getSingleResponseBody() {

        ItemDto.Response response = new ItemDto.Response(1L, 1L, "Title1", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList, "Body1", imageUrl);

        return response;
    }

    /* Multiple responses */
    public static Page<Item> getMultiItems() {

        Item item1 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item2 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item3 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item4 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item5 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item6 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item7 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item8 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item9 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);
        Item item10 = new Item(member, "Title1", foodCategory, deadline, pickupLocation,  "Restaurant1", "http://test-url.com", "Body1", imageUrl);


        return new PageImpl<>(List.of(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10),
                PageRequest.of(0, 10, Sort.by("itemId").descending()), 2);
    }


    public static List<ItemDto.Response> getMultiResponseBody() {

        ItemDto.Response response1 = new ItemDto.Response(1L, 1L, "Title1", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body1", imageUrl);
        ItemDto.Response response2 = new ItemDto.Response(2L, 2L, "Title2", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant2", "http://test-url.com", participantsList,"Body2", imageUrl);
        ItemDto.Response response3 = new ItemDto.Response(3L, 3L, "Title3", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body3", imageUrl);
        ItemDto.Response response4 = new ItemDto.Response(4L, 4L, "Title4", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body4", imageUrl);
        ItemDto.Response response5 = new ItemDto.Response(5L, 5L, "Title5", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body5", imageUrl);
        ItemDto.Response response6 = new ItemDto.Response(6L, 6L, "Title6", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body6", imageUrl);
        ItemDto.Response response7 = new ItemDto.Response(7L, 7L, "Title7", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body7", imageUrl);
        ItemDto.Response response8 = new ItemDto.Response(8L, 8L, "Title8", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body8", imageUrl);
        ItemDto.Response response9 = new ItemDto.Response(9L, 9L, "Title9", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body9", imageUrl);
        ItemDto.Response response10 = new ItemDto.Response(10L, 10L, "Title10", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", participantsList,"Body10", imageUrl);

        List<ItemDto.Response> responseList = List.of(response1, response2, response3, response4, response5, response6, response7, response8, response9, response10);

        return responseList;

    }


    /* post related */
    public static ItemDto.Post getSinglePostBody(){
        ItemDto.Post post = new ItemDto.Post(1L,"Title1", "Category1", deadline,
                pickupLocation,  "Restaurant1", "http://test-url.com/", "Body1", imageUrl );
        return post;
    }
}
