package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.OrderFormVo;

import java.util.List;

public interface OrderFormService {
    //按条件查询预定订单，不传参就是返回全部内容
    Result<List<OrderFormVo>> OrderFormSelect(OrderForm record);
    //根据id查询预定订单
    Result<OrderFormVo> OrderFormSelectByPrimaryKey(int id);
    //根据主键修改指定预定订单的信息
    CodeMsg OrderFormUpdateByPrimaryKeySelective(OrderForm record);
    //新增预定订单
    CodeMsg OrderFormInsertSelective(OrderForm record);
    //根据主键删除预定订单
    CodeMsg OrderFormDeleteByPrimaryKey(Object key);

    Result<List<OrderFormVo>> OrderFormSelectAll();
}
