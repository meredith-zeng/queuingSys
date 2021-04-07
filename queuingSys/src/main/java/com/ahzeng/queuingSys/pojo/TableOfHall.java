package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TableOfHall")
public class TableOfHall {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer tableId;

    @Column
    private String tableType;
    @Column
    private String tableIndex;
    @Column
    private Integer usingStatus;

}