package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Applying;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.ApplyingVo;

import java.util.List;

public interface ApplyingService {
    //按条件查询排队中间表
    Result<List<ApplyingVo>> ApplyingSelect(Applying record);
    //查询所有排队中间表
    Result<List<ApplyingVo>> ApplyingSelectAll();
    //根据id查询排队中间表
    Result<ApplyingVo> ApplyingSelectByPrimaryKey(int id);
    //根据主键修改指定排队中间表
    CodeMsg ApplyingUpdateByPrimaryKey(Applying record);
    //新增排队中间表
    CodeMsg ApplyingInsertSelective(Applying record);
    //根据主键删除排队中间表
    CodeMsg ApplyingDeleteByPrimaryKey(Object key);
}
