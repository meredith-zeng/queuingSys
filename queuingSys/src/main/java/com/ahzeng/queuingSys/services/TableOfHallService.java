package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.TableOfHall;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;

public interface TableOfHallService {
    //按条件查询桌子，不传参就是返回全部内容
    Result tableSelect(TableOfHall record);
    //根据id查询桌子
    Result tableSelectByPrimaryKey(int id);
    //根据主键修改指定桌子的信息
    CodeMsg tableUpdateByPrimaryKeySelective(TableOfHall record);
    //新增桌子
    CodeMsg tableInsertSelective(TableOfHall record);
    //根据主键删除桌子
    CodeMsg tableDeleteByPrimaryKey(Object key);

}
