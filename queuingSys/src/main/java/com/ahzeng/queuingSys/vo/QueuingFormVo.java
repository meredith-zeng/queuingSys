package com.ahzeng.queuingSys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueuingFormVo {

    //QueuingForm自有字段
    private Integer queuingOrderId;
    private Integer guestId;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date queuingBeginTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date predictQueuingTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date actualArriveTime;

    private Integer guestNumber;

    private String queuingStatus;


    //guestId查询Guest组装
    private String phoneNumber;

    private String lastName;

    private String gender;


}
