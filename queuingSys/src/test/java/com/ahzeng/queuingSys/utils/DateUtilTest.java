package com.ahzeng.queuingSys.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DateUtilTest {

    @Test
    void addTime() {
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.set(2021, Calendar.MAY,10,11, 0);
        Date time = timeCalendar.getTime();
        System.out.println(time);
    }

    @Test
    void belongCalendar() {
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.set(2021, Calendar.MAY,10,11, 0);
        Date time = timeCalendar.getTime();
        System.out.println(time);

        Calendar beginTimeCalendar = Calendar.getInstance();
        beginTimeCalendar.set(2021, Calendar.MAY,22,11,30);
        Date beginTime = beginTimeCalendar.getTime();
        System.out.println(beginTime);

        Calendar endTimeCalendar = Calendar.getInstance();
        endTimeCalendar.set(2021, Calendar.MAY,22,14, 0);
        Date endTime = endTimeCalendar.getTime();
        System.out.println(endTime);

        boolean belongCalendar = DateUtil.belongCalendar(time,beginTime,endTime);
        System.out.println(belongCalendar);


        System.out.println(timeCalendar.get(Calendar.YEAR));
        System.out.println(timeCalendar.get(Calendar.MONTH));//月份是从0开始计算的，January一月为int0
        System.out.println(timeCalendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(timeCalendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(timeCalendar.get(Calendar.MINUTE));
    }

    @Test
    void switchBusyCalendar(){
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.set(2021, Calendar.APRIL,22,14, 9);
        Date time = timeCalendar.getTime();
        System.out.println("传入时间："+ time);

        List<Date> dateList  = DateUtil.switchBusyCalendar(time);
        for (Date date : dateList) {
            System.out.println(date);
        }
    }
}