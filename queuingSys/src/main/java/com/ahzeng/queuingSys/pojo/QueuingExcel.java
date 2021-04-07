package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "QueuingExcel")
public class QueuingExcel {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer dataId;

    @Column
    private Date dataDate;
    @Column
    private Date averageTime;
    @Column
    private Integer queuingNumber;
}