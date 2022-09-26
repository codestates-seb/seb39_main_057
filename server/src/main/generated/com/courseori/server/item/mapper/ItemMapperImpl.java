package com.courseori.server.item.mapper;

import com.courseori.server.category.entity.Category;
import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-26T13:26:54+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDto.Response itemToItemResponse(Item item) {
        if ( item == null ) {
            return null;
        }

        long itemId = 0L;
        long memberId = 0L;
        String title = null;
        Category category = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;
        LocalDateTime deadline = null;
        Map<String, Double> latiAndLongi = null;
        String restaurantName = null;
        String restaurantUrl = null;
        String body = null;
        String imageUrl = null;

        itemId = item.getItemId();
        memberId = item.getMemberId();
        title = item.getTitle();
        category = item.getCategory();
        createdAt = item.getCreatedAt();
        modifiedAt = item.getModifiedAt();
        deadline = item.getDeadline();
        Map<String, Double> map = item.getLatiAndLongi();
        if ( map != null ) {
            latiAndLongi = new LinkedHashMap<String, Double>( map );
        }
        restaurantName = item.getRestaurantName();
        restaurantUrl = item.getRestaurantUrl();
        body = item.getBody();
        imageUrl = item.getImageUrl();

        ItemDto.Response response = new ItemDto.Response( itemId, memberId, title, category, createdAt, modifiedAt, deadline, latiAndLongi, restaurantName, restaurantUrl, body, imageUrl );

        return response;
    }

    @Override
    public List<ItemDto.Response> itemsToItemResponses(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemDto.Response> list = new ArrayList<ItemDto.Response>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( itemToItemResponse( item ) );
        }

        return list;
    }
}
