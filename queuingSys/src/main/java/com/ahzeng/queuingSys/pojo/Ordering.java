package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "Ordering")
public class Ordering {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer orderCode;

    @Column
    private Integer guestId;
}