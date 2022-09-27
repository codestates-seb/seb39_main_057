package com.courseori.server.item.controller;


import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import com.courseori.server.item.mapper.ItemMapper;
import com.courseori.server.item.service.ItemService;
import com.courseori.server.member.entity.Member;
import com.courseori.server.member.repository.MemberRepository;
import com.courseori.server.participants.Participants;
import com.courseori.server.participants.service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    //item
    private ItemService itemService;
    private ItemMapper itemMapper;
    //member
    private MemberRepository memberRepository;
    //participants
    private ParticipantsService participantsService;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper, MemberRepository memberRepository, ParticipantsService participantsService) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.memberRepository = memberRepository;
        this.participantsService = participantsService;
    }

    @PostMapping
    public ResponseEntity postItem(@RequestBody ItemDto.Post requestBody){
        Item item = itemMapper.itemPostToItem(requestBody);

        Item createdItem = itemService.createItem(item);
        ItemDto.Response response = itemMapper.itemToItemResponse(createdItem);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @PatchMapping("/{item-id}")
    public ResponseEntity patchItem(@PathVariable("item-id") @Positive long itemId,
                                    @RequestBody ItemDto.Patch requestBody){
        requestBody.setItemId(itemId);
        Item item = itemService.updateItem(itemMapper.itemPatchToItem(requestBody));
        ItemDto.Response response = itemMapper.itemToItemResponse(item);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{item-id}")
    public ResponseEntity getItem(@PathVariable("item-id") @Positive long itemId) {

        Item item = itemService.findItem(itemId);

        ItemDto.Response response = itemMapper.itemToItemResponse(item);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getItems(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size) {

        Page<Item> itemsPage = itemService.findItems(page, size);
        List<Item> items = itemsPage.getContent();

        List<ItemDto.Response> responses = itemMapper.itemsToItemResponses(items);

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{item-id}")
    public ResponseEntity deleteItem(@PathVariable("item-id") @Positive long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /* patch item for adding data inside participant list */
    @PatchMapping("/participants/{item-id}")
    public ResponseEntity addParticipant(@PathVariable("item-id") @Positive long itemId,
                                         @RequestParam long memberId) { //@RequestParam 대신 @RequestBody 인지 확인

        //participants row 생성 (type=2로)
        // Member foundMember =  -> memberService에서 findMember로 조회하여 가져오기
        Member foundMember = memberRepository.findById(memberId).orElseThrow();

        //Item foundItem = -> itemService에서 findItem으로 조회하여 가져오기
        Item foundItem = itemService.findItem(itemId);

        Participants participants1 = new Participants(2, foundMember, foundItem);
        participantsService.createParticipants(participants1);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* post participants and map item and member */
    @PostMapping("/{item-id}")
    public ResponseEntity postParticipants(@PathVariable("item-id") @Positive long itemId,
                                           @RequestParam long memberId) {

        // Member foundMember =  -> memberService에서 findMember로 조회하여 가져오기
        Member foundMember = memberRepository.findById(memberId).orElseThrow();

        //Item foundItem = -> itemService에서 findItem으로 조회하여 가져오기
        Item foundItem = itemService.findItem(itemId);

        Participants participants1 = new Participants(2, foundMember, foundItem);

        participantsService.createParticipants(participants1);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
