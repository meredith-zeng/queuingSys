package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.QueuingExcel;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.QueuingExcelVo;

import java.util.List;

public interface QueuingExcelService {
    //按条件查询排队报表内容
    Result<QueuingExcelVo> QueuingExcelQueuingNumber(QueuingExcel record);
//    //根据id查询排队论数据
//    Result<QueuingExcelVo> QueuingExcelSelectByPrimaryKey(QueuingExcel key);
    Result<QueuingExcelVo> QueuingExcelQueuingTime(QueuingExcel record);

    //根据主键修改指定日期的排队论数据
    CodeMsg QueuingExcelUpdateByPrimaryKeySelective(QueuingExcel record);
    //新增排队论数据
    CodeMsg QueuingExcelInsertSelective(QueuingExcel record);
    //根据主键删除排队论数据
    CodeMsg QueuingExcelDeleteByPrimaryKey(QueuingExcel key);

}
