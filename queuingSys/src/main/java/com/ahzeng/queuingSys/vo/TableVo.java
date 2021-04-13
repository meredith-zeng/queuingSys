package com.ahzeng.queuingSys.vo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TableVo {
//    桌子id
    private Integer tableId;
//    桌子类型
    private String tableType;
//    桌子编号
    private String tableIndex;
//    桌子使用状态
    private String usingStatus;

}
