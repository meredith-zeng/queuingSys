package com.ahzeng.queuingSys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class QueuingExcelVo {
    //当日日期
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date dataDate;
    //数据id
    private Integer dateId;

    //当日各排队数，List形式
    private List<Integer> todayQueuingNumber;
//    //截止目前为止的所有平均排队数
//    private Integer averageQueuingNumber;


    //当日排队平均时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm:ss")
    private Date todayQueuingTime;
    //截止目前为止所有排队时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm:ss")
    private List<Date> allQueuingTime;
}
