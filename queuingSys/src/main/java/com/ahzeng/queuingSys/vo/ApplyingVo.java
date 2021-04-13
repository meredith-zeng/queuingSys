package com.ahzeng.queuingSys.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
@Data
public class ApplyingVo {
    private Integer queuingOrderId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date queuingBeginTime;

    private Integer queuingStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")

    private Date predictQueuingTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date actualArriveTime;

    private Integer guestNumber;

    private Integer guestId;

    private String phoneNumber;

    private String lastName;

    private String gender;
}
