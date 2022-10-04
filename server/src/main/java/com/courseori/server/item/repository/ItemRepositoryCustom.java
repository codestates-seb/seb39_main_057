package com.courseori.server.item.repository;

import com.courseori.server.item.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryCustom {

    List<Item> findBySortUsingQuerydsl(String category);
    Page<Item> findBySortQuerydslPagination(String category, Pageable pageable);

}
