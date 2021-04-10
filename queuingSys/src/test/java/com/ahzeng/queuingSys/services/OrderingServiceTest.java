package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.OrderingService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderingServiceTest {
@Autowired
OrderingService orderingService;

    @Test
    void orderingSelect() {
        System.out.println(orderingService.OrderingSelect(null));
    }

    @Test
    void orderingSelectByPrimaryKey() {
        Ordering key = new Ordering();
        key.setOrderCode(1);
        System.out.println(orderingService.OrderingSelectByPrimaryKey(key));
    }

    @Test
    void orderingUpdateByPrimaryKeySelective() {
        Ordering record = new Ordering();
        record.setGuestId(2);
        record.setOrderCode(1);
        System.out.println(orderingService.OrderingUpdateByPrimaryKeySelective(record));
    }

    @Test
    void orderingInsertSelective() {
        Ordering record = new Ordering();
        record.setGuestId(1);
        record.setOrderCode(2);
        System.out.println(orderingService.OrderingInsertSelective(record));
    }

    @Test
    void orderingDeleteByPrimaryKey() {
    }
}