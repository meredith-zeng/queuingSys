package com.ahzeng.queuingSys.pojo;

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
    private Date queuingBeginTime;
    @Column
    private Integer queuingStatus;
    @Column
    private Date predictQueuingTime;
    @Column
    private Date actualArriveTime;
    @Column
    private Integer guestNumber;


}