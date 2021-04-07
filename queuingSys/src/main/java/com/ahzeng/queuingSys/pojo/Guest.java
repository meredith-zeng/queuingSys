package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "Guest")
public class Guest {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer guestId;

    @Column
    private String phoneNumber;
    @Column
    private String lastName;
    @Column
    private String gender;

}