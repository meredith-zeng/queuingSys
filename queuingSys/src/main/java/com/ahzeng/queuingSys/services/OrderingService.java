package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.OrderFormVo;
import com.ahzeng.queuingSys.vo.OrderingVo;

import java.util.List;

public interface OrderingService {
    //按条件查询预定中间表表项，不传参就是返回全部内容
    Result<List<OrderingVo>> OrderingSelect(Ordering record);
    //根据id查询预定中间表表项
    Result<OrderingVo> OrderingSelectByPrimaryKey(Ordering key);
    //根据主键修改指定预定中间表表项
    CodeMsg OrderingUpdateByPrimaryKeySelective(Ordering record);
    //新增预定中间表表项
    CodeMsg OrderingInsertSelective(Ordering record);
    //根据主键删除预定中间表表项
    CodeMsg OrderingDeleteByPrimaryKey(Object key);
}
