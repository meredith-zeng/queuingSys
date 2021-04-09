package com.ahzeng.queuingSys.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class OrderFormVo {
    private Integer orderCode;

    private Date orderTime;

    private String orderStatus;

    private Integer guestId;
}
