package com.courseori.server.item.repository;

import com.courseori.server.item.entity.Item;
import com.courseori.server.item.entity.QItem;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
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

        //category service를 통해서 해당 category가 있는지 확인하는 로직 추가하기

        List<Item> items;
        JPAQuery<Item> query;


        items = jpaQueryFactory.selectFrom(qItem)
                .where(qItem.category.category.eq(category))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        query = jpaQueryFactory.selectFrom(qItem)
                .orderBy(qItem.itemId.desc());


        return PageableExecutionUtils.getPage(items, pageable, query::fetchCount);
    }
}






















