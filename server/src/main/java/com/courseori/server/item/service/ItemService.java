package com.courseori.server.item.service;

import com.courseori.server.item.entity.Item;
import com.courseori.server.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item){
        item.setCreatedAt(new Date().getTime());
        item.setModifiedAt(new Date().getTime());
        Item savedItem = itemRepository.save(item);

        return savedItem;
    }

    public Item updateItem(Item item){
        Item foundItem = findVerifiedItem(item.getItemId());
        Optional.ofNullable(item.getTitle())
                .ifPresent(title -> foundItem.setTitle(title));
        Optional.ofNullable(item.getRecruit())
                .ifPresent(recruit -> foundItem.setRecruit(recruit));
        Optional.ofNullable(item.getCategory())
                .ifPresent(category -> foundItem.setCategory(category));
        Optional.ofNullable(item.getBody())
                .ifPresent(body -> foundItem.setBody(body));
        Optional.ofNullable(item.getDeadline())
                .ifPresent(deadline -> foundItem.setDeadline(deadline));
        Optional.ofNullable(item.getPickupLocation())
                .ifPresent(restaurantLocation -> foundItem.setPickupLocation(restaurantLocation));
        Optional.ofNullable(item.getRestaurantName())
                .ifPresent(restaurantName -> foundItem.setRestaurantName(restaurantName));
        Optional.ofNullable(item.getRestaurantUrl())
                .ifPresent(restaurantUrl -> foundItem.setRestaurantUrl(restaurantUrl));
        Optional.ofNullable(item.getImageUrl())
                .ifPresent(imageUrl -> foundItem.setImageUrl(imageUrl));
        Optional.ofNullable(item.getParticipantsList())
                .ifPresent(participantsList -> foundItem.setParticipantsList(participantsList));
        foundItem.setModifiedAt(new Date().getTime());
        return itemRepository.save(foundItem);
    }


    public void deleteItem(long itemId) {
        Item foundItem = findVerifiedItem(itemId);
        itemRepository.delete(foundItem);
    }

    public Item findItem(long itemId) {
        return findVerifiedItem(itemId); //null 처리 필요할 듯
    }

    public Page<Item> findItems(int page, int size) {
        return itemRepository.findAll(PageRequest.of(page, size, Sort.by("itemId").descending()));
    }

    @Transactional(readOnly = true)
    public Page<Item> search(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Item> foundItemList = itemRepository.findBySortQuerydslPagination(category, pageable);
        return foundItemList;
    }


    public Item findVerifiedItem(long itemId) {
        Optional<Item> optionalItem =
                itemRepository.findById(itemId);
        Item foundItem =
                optionalItem.orElseThrow(() -> new NoSuchElementException());

        return foundItem;
    }

}
