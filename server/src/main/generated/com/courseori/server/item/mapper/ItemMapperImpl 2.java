package com.courseori.server.item.mapper;

import com.courseori.server.foodcategory.entity.FoodCategory;
import com.courseori.server.item.dto.ItemDto;
import com.courseori.server.item.entity.Item;
import com.courseori.server.location.entity.Location;
import com.courseori.server.member.entity.Member;
import com.courseori.server.participants.Participants;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-26T15:09:20+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item itemPostToItem(ItemDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Item item = new Item();

        item.setTitle( requestBody.getTitle() );
        item.setCategory( requestBody.getCategory() );
        if ( requestBody.getCreatedAt() != null ) {
            item.setCreatedAt( Date.from( requestBody.getCreatedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        if ( requestBody.getModifiedAt() != null ) {
            item.setModifiedAt( Date.from( requestBody.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        if ( requestBody.getDeadline() != null ) {
            item.setDeadline( Date.from( requestBody.getDeadline().toInstant( ZoneOffset.UTC ) ) );
        }
        item.setRestaurantLocation( requestBody.getRestaurantLocation() );
        item.setRestaurantName( requestBody.getRestaurantName() );
        item.setRestaurantUrl( requestBody.getRestaurantUrl() );
        item.setBody( requestBody.getBody() );
        item.setImageUrl( requestBody.getImageUrl() );

        return item;
    }

    @Override
    public Item itemPatchToItem(ItemDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemId( requestBody.getItemId() );
        item.setTitle( requestBody.getTitle() );
        item.setCategory( requestBody.getCategory() );
        if ( requestBody.getCreatedAt() != null ) {
            item.setCreatedAt( Date.from( requestBody.getCreatedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        if ( requestBody.getModifiedAt() != null ) {
            item.setModifiedAt( Date.from( requestBody.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        if ( requestBody.getDeadline() != null ) {
            item.setDeadline( Date.from( requestBody.getDeadline().toInstant( ZoneOffset.UTC ) ) );
        }
        item.setRestaurantLocation( requestBody.getRestaurantLocation() );
        item.setRestaurantName( requestBody.getRestaurantName() );
        item.setRestaurantUrl( requestBody.getRestaurantUrl() );
        item.setParticipantsList( memberListToParticipantsList( requestBody.getParticipantsList() ) );
        item.setBody( requestBody.getBody() );
        item.setImageUrl( requestBody.getImageUrl() );

        return item;
    }

    @Override
    public ItemDto.Response itemToItemResponse(Item item) {
        if ( item == null ) {
            return null;
        }

        long itemId = 0L;
        String title = null;
        FoodCategory category = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;
        LocalDateTime deadline = null;
        Location restaurantLocation = null;
        String restaurantName = null;
        String restaurantUrl = null;
        List<Member> participantsList = null;
        String body = null;
        String imageUrl = null;

        itemId = item.getItemId();
        title = item.getTitle();
        category = item.getCategory();
        if ( item.getCreatedAt() != null ) {
            createdAt = LocalDateTime.ofInstant( item.getCreatedAt().toInstant(), ZoneId.of( "UTC" ) );
        }
        if ( item.getModifiedAt() != null ) {
            modifiedAt = LocalDateTime.ofInstant( item.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) );
        }
        if ( item.getDeadline() != null ) {
            deadline = LocalDateTime.ofInstant( item.getDeadline().toInstant(), ZoneId.of( "UTC" ) );
        }
        restaurantLocation = item.getRestaurantLocation();
        restaurantName = item.getRestaurantName();
        restaurantUrl = item.getRestaurantUrl();
        participantsList = participantsListToMemberList( item.getParticipantsList() );
        body = item.getBody();
        imageUrl = item.getImageUrl();

        long memberId = 0L;

        ItemDto.Response response = new ItemDto.Response( itemId, memberId, title, category, createdAt, modifiedAt, deadline, restaurantLocation, restaurantName, restaurantUrl, participantsList, body, imageUrl );

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

    protected Participants memberToParticipants(Member member) {
        if ( member == null ) {
            return null;
        }

        Participants participants = new Participants();

        if ( member.getModifiedAt() != null ) {
            participants.setModifiedAt( Date.from( member.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }

        return participants;
    }

    protected List<Participants> memberListToParticipantsList(List<Member> list) {
        if ( list == null ) {
            return null;
        }

        List<Participants> list1 = new ArrayList<Participants>( list.size() );
        for ( Member member : list ) {
            list1.add( memberToParticipants( member ) );
        }

        return list1;
    }

    protected Member participantsToMember(Participants participants) {
        if ( participants == null ) {
            return null;
        }

        Member member = new Member();

        if ( participants.getModifiedAt() != null ) {
            member.setModifiedAt( LocalDateTime.ofInstant( participants.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return member;
    }

    protected List<Member> participantsListToMemberList(List<Participants> list) {
        if ( list == null ) {
            return null;
        }

        List<Member> list1 = new ArrayList<Member>( list.size() );
        for ( Participants participants : list ) {
            list1.add( participantsToMember( participants ) );
        }

        return list1;
    }
}
