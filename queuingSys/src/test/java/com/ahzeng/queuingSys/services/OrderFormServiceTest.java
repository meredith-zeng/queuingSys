package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.OrderForm;
import java.util.Date;

import com.ahzeng.queuingSys.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderFormServiceTest {
@Autowired
OrderFormService orderFormService;

    @Test
    void orderFormSelect() {
        //查询存在的所有订单
        System.out.println(orderFormService.OrderFormSelect(null));
    }

    @Test
    void orderFormSelectByPrimaryKey() {
        System.out.println(orderFormService.OrderFormSelectByPrimaryKey(1));
    }

    @Test
    void orderFormUpdateByPrimaryKeySelective() {
        OrderForm record = new OrderForm();
        record.setOrderCode(1);
        record.setOrderTime(DateUtil.getCurrentDate());
        record.setOrderStatus("未处理");
        record.setGuestId(3);
        System.out.println(orderFormService.OrderFormUpdateByPrimaryKeySelective(record));
    }

    @Test
    void orderFormInsertSelective(){
        OrderForm record = new OrderForm();
        record.setGuestId(3);
        record.setOrderStatus("待处理");
        record.setOrderTime(DateUtil.getCurrentDate());
        System.out.println(orderFormService.OrderFormInsertSelective(record));
    }

    @Test
    void orderFormDeleteByPrimaryKey() {
        OrderForm record = new OrderForm();
        record.setOrderCode(6);
        System.out.println(orderFormService.OrderFormDeleteByPrimaryKey(record));
    }
}