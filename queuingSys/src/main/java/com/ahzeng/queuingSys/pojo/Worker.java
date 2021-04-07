package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "Worker")
public class Worker {
    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    @Column
    private String account;
    @Column
    private String password;
}