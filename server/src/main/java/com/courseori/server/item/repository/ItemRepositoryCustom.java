package com.courseori.server.item.repository;

import com.courseori.server.item.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemRepositoryCustom {

    List<Item> findBySortUsingQuerydsl(String category);
    Page<Item> findBySortQuerydslPagination(String category, Pageable pageable);

}
