package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.QueuingForm;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.QueuingFormVo;

import java.text.ParseException;
import java.util.List;

public interface QueuingFormService {
    //按条件查询排队订单
    Result<List<QueuingFormVo>> QueuingFormSelect(QueuingForm record);
    //查询所有排队订单
    Result<List<QueuingFormVo>> QueuingFormSelectAll();
    //根据id查询排队订单
    Result<QueuingFormVo> QueuingFormSelectByPrimaryKey(int id);
    //根据主键修改指定排队订单
    CodeMsg QueuingFormUpdateByPrimaryKeySelective(QueuingForm record);
    //新增排队订单
    CodeMsg QueuingFormInsertSelective(QueuingForm record);
    //根据主键删除排队订单
    CodeMsg QueuingFormDeleteByPrimaryKey(QueuingForm record);

    Result<Integer> countQueuingGuestNumber();

    Result<QueuingFormVo> QueuingFormNewOne(QueuingFormVo record) throws ParseException;
}
