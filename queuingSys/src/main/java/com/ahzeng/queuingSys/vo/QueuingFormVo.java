package com.ahzeng.queuingSys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName QueuingFormVo
 * @Description TODO
 * @Author lenovo
 * @Date 2021/4/13 12:39
 * @Version 1.0
 */
public class QueuingFormVo {

    private Integer queuingOrderId;
    private Integer guestId;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date queuingBeginTime;

    private Integer queuingStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")

    private Date predictQueuingTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date actualArriveTime;



}
