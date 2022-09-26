//package com.courseori.server.helper;
//
//import com.courseori.server.foodcategory.entity.FoodCategory;
//import com.courseori.server.image.entity.ImageUrl;
//import com.courseori.server.item.dto.ItemDto;
//import com.courseori.server.item.entity.Item;
//import com.courseori.server.location.entity.Location;
//import com.courseori.server.member.entity.Member;
//import com.courseori.server.member.role.Roles;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class StubData {
//
//    static LocalDateTime createdAt = LocalDateTime.now();
//    static LocalDateTime modifiedAt = LocalDateTime.now();
//    static LocalDateTime deadline = LocalDateTime.now();
//    static Location pickupLocation = new Location("LocationName1", 1, (float) 123.123, (float) 123.123);
//    static Location restaurantLocation = new Location("LocationName2", 2, (float) 234.123, (float) 234.123);
//    static ImageUrl imageUrl = new ImageUrl("http://teset.com", 1);
//    static Roles roles = new Roles("ROLE_USER");
//    static Member member = new Member("User1", "test@email.com", "password", "010-1111-1111", pickupLocation, imageUrl, "Card", roles);
//
//    static FoodCategory foodCategory = new FoodCategory();
//
//    public static Item getSinglePost() {
//
//        Item item = new Item(member, "Title1", foodCategory, deadline, pickupLocation, restaurantLocation, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//
//        return item;
//    }
//
//    public static ItemDto.Response getSingleResponseBody() {
//
//        ItemDto.Response response = new ItemDto.Response(1L, 1L, "Title1", foodCategory, createdAt, modifiedAt, deadline, pickupLocation, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//
//        return response;
//    }
//
//    public static List<ItemDto.Response> getMultiResponseBody() {
//
//        ItemDto.Response response1 = new ItemDto.Response(1L, 1L, "Title1", FoodCategory.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response2 = new ItemDto.Response(2L, 2L, "Title2", FoodCategory.CHICKEN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant2", "http://test-url.com", "Body2", "shorturl.at/CHL08");
//        ItemDto.Response response3 = new ItemDto.Response(3L, 3L, "Title3", FoodCategory.DOSIRAK, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response4 = new ItemDto.Response(4L, 4L, "Title4", FoodCategory.BUNSIK, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response5 = new ItemDto.Response(5L, 5L, "Title5", FoodCategory.CUTLETANDJAPANESE, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response6 = new ItemDto.Response(6L, 6L, "Title6", FoodCategory.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response7 = new ItemDto.Response(7L, 7L, "Title7", FoodCategory.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response8 = new ItemDto.Response(8L, 8L, "Title8", FoodCategory.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response9 = new ItemDto.Response(9L, 9L, "Title9", FoodCategory.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//        ItemDto.Response response10 = new ItemDto.Response(10L, 10L, "Title10", FoodCategory.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
//
//        List<ItemDto.Response> responseList = List.of(response1, response2, response3, response4, response5, response6, response7, response8, response9, response10);
//
//        return responseList;
//
//    }
//}
