package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.QueuingForm;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class QueuingFormServiceTest {
@Autowired
QueuingFormService queuingFormService;

    @Test
    void queuingFormSelect() {
        QueuingForm record = new QueuingForm();
        record.setQueuingOrderId(1);
        System.out.println(queuingFormService.QueuingFormSelect(record));
    }


    @Test
    void queuingFormSelectAll() {
        System.out.println(queuingFormService.QueuingFormSelectAll());
    }

    @Test
    void queuingFormSelectByPrimaryKey() {
        int queuingOrderId = 1;
        System.out.println(queuingFormService.QueuingFormSelectByPrimaryKey(queuingOrderId));
    }

    @Test
    void queuingFormUpdateByPrimaryKeySelective() {
        QueuingForm record = new QueuingForm();
        record.setQueuingOrderId(2);
        record.setQueuingStatus("测试");
        record.setGuestId(4);
        System.out.println(queuingFormService.QueuingFormUpdateByPrimaryKeySelective(record));
    }

    @Test
    void queuingFormInsertSelective() {
        QueuingForm queuingForm = new QueuingForm();
        queuingForm.setQueuingStatus("已到号");
        queuingForm.setGuestNumber(3);
        System.out.println(queuingFormService.QueuingFormInsertSelective(queuingForm));
    }

    @Test
    void queuingFormDeleteByPrimaryKey() {
        QueuingForm queuingForm = new QueuingForm();
        queuingForm.setQueuingOrderId(2);
        System.out.println(queuingFormService.QueuingFormDeleteByPrimaryKey(queuingForm));
    }

    @Test
    void countQueuingGuestNumber(){
        System.out.println(queuingFormService.countQueuingGuestNumber());
    }
}