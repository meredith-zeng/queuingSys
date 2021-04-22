package com.ahzeng.queuingSys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "OrderForm")
public class OrderForm {
    @Id
    @KeySql(useGeneratedKeys = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderCode;

    @Column
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
    @Column
    private String orderStatus;
    @Column
    private Integer guestId;
    @Column
    private Integer guestNumber;
    @Column
    private String phoneNumber;

}