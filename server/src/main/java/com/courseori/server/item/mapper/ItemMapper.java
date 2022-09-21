package com.courseori.server.item.mapper;

import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto.Response itemToItemResponse(Item item);
    List<ItemDto.Response> itemsToItemResponses(List<Item> itemList);

}
