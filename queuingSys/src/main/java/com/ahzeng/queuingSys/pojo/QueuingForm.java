package com.ahzeng.queuingSys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "QueuingForm")
public class QueuingForm {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer queuingOrderId;

    @Column
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date queuingBeginTime;
    @Column
    private Integer queuingStatus;
    @Column
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date predictQueuingTime;
    @Column
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date actualArriveTime;
    @Column
    private Integer guestNumber;


}