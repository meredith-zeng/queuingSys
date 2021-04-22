package com.ahzeng.queuingSys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer dateId;

    @Column
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date dataDate;
    @Column
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm:ss")
    private Date averageTime;
    @Column
    private Integer smallQueuingNumber;
    @Column
    private Integer middleQueuingNumber;
    @Column
    private Integer bigQueuingNumber;
}