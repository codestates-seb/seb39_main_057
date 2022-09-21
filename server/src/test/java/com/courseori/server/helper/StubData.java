package com.courseori.server.helper;

import com.courseori.server.category.entity.Category;
import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubData {

    static LocalDateTime createdAt = LocalDateTime.now();
    static LocalDateTime modifiedAt = LocalDateTime.now();
    static LocalDateTime deadline = LocalDateTime.now();
    static Map<String, Double> latiAndLongi;
    static {
        latiAndLongi = new HashMap<>();
        latiAndLongi.put("Latitude",13.1234);
        latiAndLongi.put("Longitude", 213.1234);
    }


    public static Item getSinglePost() {

        Item item = new Item(  1L,"Title1", Category.ASIAN, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");

        return item;
    }

    public static ItemDto.Response getSingleResponseBody() {

        ItemDto.Response response = new ItemDto.Response(1L, 1L, "Title1", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");

        return response;
    }

    public static List<ItemDto.Response> getMultiResponseBody() {

        ItemDto.Response response1 = new ItemDto.Response(1L, 1L, "Title1", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response2 = new ItemDto.Response(2L, 2L, "Title2", Category.CHICKEN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant2", "http://test-url.com", "Body2", "shorturl.at/CHL08");
        ItemDto.Response response3 = new ItemDto.Response(3L, 3L, "Title3", Category.DOSIRAK, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response4 = new ItemDto.Response(4L, 4L, "Title4", Category.BUNSIK, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response5 = new ItemDto.Response(5L, 5L, "Title5", Category.CUTLETANDJAPANESE, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response6 = new ItemDto.Response(6L, 6L, "Title6", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response7 = new ItemDto.Response(7L, 7L, "Title7", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response8 = new ItemDto.Response(8L, 8L, "Title8", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response9 = new ItemDto.Response(9L, 9L, "Title9", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");
        ItemDto.Response response10 = new ItemDto.Response(10L, 10L, "Title10", Category.ASIAN, createdAt, modifiedAt, deadline, latiAndLongi, "Restaurant1", "http://test-url.com", "Body1", "shorturl.at/CHL08");

        List<ItemDto.Response> responseList = List.of(response1, response2, response3, response4, response5, response6, response7, response8, response9, response10);

        return responseList;

    }
}
