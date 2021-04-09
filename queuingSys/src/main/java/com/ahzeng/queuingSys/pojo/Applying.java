package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "Applying")
public class Applying {

    //申请排队的中间表数据，以两个数据作为联合主键
    private String queuingOrderId;

    private Integer guestId;

}