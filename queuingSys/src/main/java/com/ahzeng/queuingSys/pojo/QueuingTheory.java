package com.ahzeng.queuingSys.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "QueuingTheory")
public class QueuingTheory {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer queuingTheoryId;

    @Column
    private Integer n;
    @Column
    private Double lambda;
    @Column
    private Double mu;
    @Column
    private Double Wq;
    @Column
    private Double Lq;
    @Column
    private Double Ws;
    @Column
    private String tableType;

}
