package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.TableOfHall;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class TableOfHallServiceTest {

    @Autowired
    TableOfHallService tableOfHallService;

    @Test
    void tableSelect() {
        TableOfHall record = new TableOfHall();
        //查询失败案列
//        record.setTableType("a");
        //查询成功案例
//        record.setTableType("small");
        System.out.println(tableOfHallService.tableSelect(record));
    }

    @Test
    void tableSelectByPrimaryKey() {
        int id = 1;
        System.out.println(tableOfHallService.tableSelectByPrimaryKey(id));
    }

    @Test
    void tableUpdateByPrimaryKeySelective() {
        TableOfHall record = new TableOfHall();
        //成功
//        record.setTableId(1);
//        record.setTableIndex("A6");
        record.setTableId(1);
        record.setTableIndex("A6");
        System.out.println(tableOfHallService.tableUpdateByPrimaryKeySelective(record));
    }

    @Test
    void tableInsertSelective() {
        TableOfHall record = new TableOfHall();
        record.setTableIndex("A9");
        record.setTableType("small");
        System.out.println(tableOfHallService.tableInsertSelective(record));
    }

    @Test
    void tableDeleteByPrimaryKey() {
        int id = 5;
        System.out.println(tableOfHallService.tableDeleteByPrimaryKey(id));
    }
}