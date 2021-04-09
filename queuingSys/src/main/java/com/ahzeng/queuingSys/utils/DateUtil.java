package com.ahzeng.queuingSys.utils;

//日期转换工具类
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtil {
    /**
     * 获取当前的日期时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public static Timestamp getCurrentDate(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static String getCurrentDateString(){
        //当前日期
        LocalDate now = LocalDate.now();
        //创建一个DateTimeFormatter对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //通过LocalDate的format方法
        return now.format(formatter);
    }

}