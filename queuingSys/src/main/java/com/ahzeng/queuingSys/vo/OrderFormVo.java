package com.ahzeng.queuingSys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class OrderFormVo {
    private Integer orderCode;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderTime;

    private String orderStatus;

    private Integer guestId;

    private Integer guestNumber;
}
