package com.courseori.server.item.mapper;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    default Item itemPostToItem(ItemDto.Post requestBody) {
        Item item = new Item();

        item.setMember(requestBody.getMember());
        item.setTitle(requestBody.getTitle());

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setCategory(requestBody.getCategory());
        item.setCategory(foodCategory);

        item.setDeadline(requestBody.getDeadline());
        item.setPickupLocation(requestBody.getPickupLocation());
        item.setRestaurantName(requestBody.getRestaurantName());
        item.setRestaurantUrl(requestBody.getRestaurantUrl());
        item.setBody(requestBody.getBody());
        item.setImageUrl(requestBody.getImageUrl());

        return item;

    }

    Item itemPatchToItem(ItemDto.Patch requestBody);

    ItemDto.Response itemToItemResponse(Item item);


    List<ItemDto.Response> itemsToItemResponses(List<Item> itemList);

}
