package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.QueuingExcel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class QueuingExcelServiceTest {

@Autowired
QueuingExcelService queuingExcelService;

    @Test
    void queuingExcelQueuingNumber() {
        QueuingExcel queuingExcel = new QueuingExcel();
        queuingExcel.setDateId(1);
        System.out.println(queuingExcelService.QueuingExcelQueuingNumber(queuingExcel));
    }

    @Test
    void queuingExcelQueuingTime() {
        QueuingExcel queuingExcel = new QueuingExcel();
        queuingExcel.setDateId(1);
        System.out.println(queuingExcelService.QueuingExcelQueuingTime(queuingExcel));
    }
}