package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Applying;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class ApplyingServiceTest {
@Autowired
ApplyingService applyingService;

    @Test
    void applyingSelect() {
        Applying applying = new Applying();
//        applying.setGuestId(1);
        applying.setQueuingOrderId(1);
        System.out.println(applyingService.ApplyingSelect(applying));
    }

    @Test
    void applyingSelectAll() {
        System.out.println(applyingService.ApplyingSelectAll());
    }

    @Test
    void applyingSelectByPrimaryKey() {

        System.out.println(applyingService.ApplyingSelectByPrimaryKey(1));
    }

    @Test
    void applyingUpdateByPrimaryKey() {
        Applying applying = new Applying();
        applying.setGuestId(3);
        applying.setQueuingOrderId(1);
        System.out.println(applyingService.ApplyingUpdateByPrimaryKey(applying));
    }

    @Test
    void applyingInsertSelective() {
        Applying applying = new Applying();
        applying.setGuestId(1);
        applying.setQueuingOrderId(4);
        System.out.println(applyingService.ApplyingInsertSelective(applying));
    }

    @Test
    void applyingDeleteByPrimaryKey() {
        Applying applying = new Applying();
        applying.setQueuingOrderId(4);
        System.out.println(applyingService.ApplyingDeleteByPrimaryKey(applying));
    }
}