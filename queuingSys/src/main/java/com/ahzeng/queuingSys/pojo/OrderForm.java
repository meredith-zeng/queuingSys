package com.ahzeng.queuingSys.pojo;

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
    private Date orderTime;
    @Column
    private String orderStatus;
    @Column
    private Integer guestId;

}