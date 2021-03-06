package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Guest;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.GuestVo;

import java.util.List;

public interface GuestService {
    //按条件查询顾客，不传参就是返回全部内容
    Result<List<GuestVo>> GuestSelect(Guest record);
    //根据id查询顾客
    Result<GuestVo> GuestSelectByPrimaryKey(int id);
    //根据主键修改指定顾客的信息
    CodeMsg GuestUpdateByPrimaryKeySelective(Guest record);
    //新增顾客
    CodeMsg GuestInsertSelective(Guest record);
    //根据主键删除顾客
    CodeMsg GuestDeleteByPrimaryKey(Object key);
    //顾客登录验证
    Result<GuestVo>  GuestLoginVerify(Guest record);
}
