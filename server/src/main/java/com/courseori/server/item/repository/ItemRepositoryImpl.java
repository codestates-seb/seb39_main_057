package com.courseori.server.item.repository;

import com.courseori.server.item.entity.Item;
import com.courseori.server.item.entity.QItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public ItemRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    QItem qItem = QItem.item;


    @Override
    public List<Item> findBySortUsingQuerydsl(String category) {
        return null;
    }

    @Override
    public Page<Item> findBySortQuerydslPagination(String category, Pageable pageable) {
        return null;
    }
}
