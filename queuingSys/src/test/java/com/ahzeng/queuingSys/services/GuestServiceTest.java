package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Guest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class GuestServiceTest {
@Autowired
GuestService guestService;

    @Test
    void guestSelect() {
        Guest record = new Guest();
        //单性别查询
//        record.setGender("female");
        //单手机号查询
//        record.setPhoneNumber("13883950171");
        record.setGuestId(7);
        System.out.println(guestService.GuestSelect(record));
    }

    @Test
    void guestSelectByPrimaryKey() {
        int id = 1;
        System.out.println(guestService.GuestSelectByPrimaryKey(id));
    }

    @Test
    void guestUpdateByPrimaryKeySelective() {
        Guest record = new Guest();
        record.setGender("male");
        record.setGuestId(1);
        System.out.println(guestService.GuestUpdateByPrimaryKeySelective(record));
    }

    @Test
    void guestInsertSelective() {
        Guest record = new Guest();
        //自增主键不可直接指定
        record.setGender("female");
        record.setPhoneNumber("13098663096");
        //无法将中文写入数据？
        //将application后的数据源加上utf-8就可以了
        record.setLastName("林");
        System.out.println(guestService.GuestInsertSelective(record));
    }

    @Test
    void guestDeleteByPrimaryKey() {
        System.out.println(guestService.GuestDeleteByPrimaryKey(7));
    }

    @Test
    void GuestLoginVerify(){
        Guest guest = new Guest();
        guest.setPhoneNumber("13883950171");
        System.out.println(guestService.GuestLoginVerify(guest));
    }
}