package com.ahzeng.queuingSys.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderingVo {
    private Integer orderCode;

    private Date orderTime;

    private String orderStatus;

    private Integer guestId;

    //需要调用GuestVo的service
    private String phoneNumber;

    private String lastName;

    private String gender;
}
