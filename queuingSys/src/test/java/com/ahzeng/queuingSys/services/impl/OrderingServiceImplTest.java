package com.ahzeng.queuingSys.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderingServiceImplTest {
@Autowired
OrderingServiceImpl orderingService;

    @Test
    void orderingSelect() {
        System.out.println(orderingService.OrderingSelect(null));
    }

    @Test
    void orderingSelectByPrimaryKey() {
    }

    @Test
    void orderingUpdateByPrimaryKeySelective() {
    }

    @Test
    void orderingInsertSelective() {
    }

    @Test
    void orderingDeleteByPrimaryKey() {
    }
}