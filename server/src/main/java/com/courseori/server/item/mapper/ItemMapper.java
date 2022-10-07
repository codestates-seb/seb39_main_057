package com.courseori.server.item.mapper;

import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import com.courseori.server.participants.Participants;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    default Item itemPostToItem(ItemDto.Post requestBody) {
        Item item = new Item();

        item.setMember(requestBody.getMember());
        item.setTitle(requestBody.getTitle());
        item.setRecruit(requestBody.getRecruit());
        item.setCategory(requestBody.getCategory());

        item.setDeadline(requestBody.getDeadline());
        item.setPickupLocation(requestBody.getPickupLocation());
        item.setRestaurantName(requestBody.getRestaurantName());
        item.setRestaurantUrl(requestBody.getRestaurantUrl());
        item.setBody(requestBody.getBody());
        item.setImageUrl(requestBody.getImageUrl());

        return item;

    }

    default Item itemPatchToItem(ItemDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemId( requestBody.getItemId() );
        item.setTitle( requestBody.getTitle() );
        item.setRecruit(requestBody.getRecruit());

        item.setCategory(requestBody.getCategory());

        item.setDeadline( requestBody.getDeadline() );
        item.setPickupLocation( requestBody.getPickupLocation() );
        item.setRestaurantName( requestBody.getRestaurantName() );
        item.setRestaurantUrl( requestBody.getRestaurantUrl() );
        List<Participants> list = requestBody.getParticipantsList();
        if ( list != null ) {
            item.setParticipantsList( new ArrayList<Participants>( list ) );
        }
        item.setBody( requestBody.getBody() );
        item.setImageUrl( requestBody.getImageUrl() );

        return item;
    }

    ItemDto.Response itemToItemResponse(Item item);

    List<ItemDto.Response> itemsToItemResponses(List<Item> itemList);

}
